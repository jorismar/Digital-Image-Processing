/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.motion.detector;

import app.motion.tracker.BoundBox;
import java.awt.image.BufferedImage;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorismar
 */
public class MotionDetection {
    private int concurrent_partitions;
    private byte bb_selector;
    private boolean has_motion;
    private final int threshold;
    private final BoundBox bb_img_0;
    private final BoundBox bb_img_1;
    private final Semaphore[] semaphores;

    /**
     * 
     * @param threshold 
     */
    public MotionDetection(int threshold) {
        this.threshold = threshold;
        this.concurrent_partitions = 1;
        this.has_motion = false;
        this.bb_selector = 0;
        this.bb_img_0 = new BoundBox();
        this.bb_img_1 = new BoundBox();
        this.semaphores = new Semaphore[this.concurrent_partitions];
        this.semaphores[0] = new Semaphore(1);
    }
    
    /**
     * 
     * @param threshold
     * @param concurrent_partitions 
     */
    public MotionDetection(int threshold, int concurrent_partitions) {
        this.threshold = threshold;
        this.concurrent_partitions = concurrent_partitions;
        this.has_motion = false;
        this.bb_selector = 0;
        this.bb_img_0 = new BoundBox();
        this.bb_img_1 = new BoundBox();
        this.semaphores = new Semaphore[this.concurrent_partitions];
        
        // Init semaphores for concurrent
        for(int i = 0; i < this.concurrent_partitions; i++)
            this.semaphores[i] = new Semaphore(0);
    }
    
    public boolean optimizedCheckMotion(BufferedImage last, BufferedImage current, int x1, int y1, int x2, int y2) {
        if(this.concurrent_partitions % 2 != 0)
            this.concurrent_partitions++;
        
        this.has_motion = false;
        
        int current_x = x1;
        int current_y = y1;
        
        // Number of vertical partitions
        int num_vertical_partitions = this.concurrent_partitions / 2;
        
        // Amount of pixels for area
        int partition_width = (x2 - x1) / num_vertical_partitions;
        int partition_height = (y2 - y1) / 2;
        
        // Start a thread for each partition
        for(int partition = 0; partition < this.concurrent_partitions; partition++) {
            if(partition == num_vertical_partitions - 1) {
                current_x = x1;
                current_y += partition_height;
            }
            
            final int x = current_x;
            final int y = current_y;
            final int current_partition = partition;
            
            new Thread(
                () -> {
                    checkMotion(last, current, x, y, partition_width, partition_height);
                    semaphores[current_partition].release();
                }
            ).start();
            
            current_x += partition_width;
        }
        
        // Wait all threads finish
        for(int i = 0; i < this.concurrent_partitions; i++)
            try {
                this.semaphores[i].acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(MotionDetection.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return this.has_motion;
    }
    
    public boolean checkMotion(BufferedImage last, BufferedImage current, int x1, int y1, int x2, int y2) {
        boolean motion = false;
        BoundBox bb_selected;
        
        if(this.bb_selector == 0 && this.bb_img_0.start.x != 0 && this.bb_img_1.start.x == 0)
            this.switchBoundBox();
        
        // Get boundbox to store new motion
        if(this.bb_selector == 0)
            bb_selected = this.bb_img_0;
        else
            bb_selected = this.bb_img_1;

        // Apply operation to image
        for(int y = y1; y < y2; y++) {
            for(int x = x1; x < x2; x++) {
                
                // Get current image pixel color
                int curr_px = current.getRGB(x, y);
                int curr_r = (curr_px & 0xff0000) >> 16;
                int curr_g = (curr_px & 0xff00) >> 8;
                int curr_b = curr_px & 0xff;

                // Get last image pixel color
                int last_px = last.getRGB(x, y);
                int last_r = (last_px & 0xff0000) >> 16;
                int last_g = (last_px & 0xff00) >> 8;
                int last_b = last_px & 0xff;

                // Convert to gray scale
                int curr_gray = Math.round((curr_r + curr_g + curr_b) / 3.0f);
                int last_gray = Math.round((last_r + last_g + last_b) / 3.0f);
                
                if((curr_gray - last_gray) >= this.threshold) {
                    this.has_motion = true;
                    
                    // Update Bound Box
                    if(!motion) {
                        bb_selected.start.x = x;
                        bb_selected.start.y = y;
                        bb_selected.end.x = -1;
                        bb_selected.end.y = -1;
                    } else {
                        bb_selected.start.x = x < bb_selected.start.x ? x : bb_selected.start.x;
                        bb_selected.start.y = y < bb_selected.start.y ? y : bb_selected.start.y;
                        bb_selected.end.x = x > bb_selected.end.x ? x : bb_selected.end.x;
                        bb_selected.end.y = y > bb_selected.end.y ? y : bb_selected.end.y;
                    }
                    
                    motion = true;
                }
            }
        }
         
        return motion;
    }
    
    /**
     * 
     * @return 
     */
    public BoundBox getInitialMotionBoundBox() {
        if(this.bb_selector == 1)
            return this.bb_img_0;
        
        return this.bb_img_1;
    }

    /**
     * 
     * @return 
     */
    public BoundBox getFinalMotionBoundBox() {
        if(this.bb_selector == 0)
            return this.bb_img_0;
        
        return this.bb_img_1;
    }
    
    /**
     * 
     */
    public void switchBoundBox() {
        if(this.bb_selector == 0)
            this.bb_selector = 1;
        else
            this.bb_selector = 0;
    }
}
