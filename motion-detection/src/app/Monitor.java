/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.device.manager.Source;
import app.image.Image;
import app.motion.detector.MotionDetection;
import app.ui.HomeLayout;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorismar
 */
public class Monitor {
    public static Source source = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creates window
        HomeLayout screen = new HomeLayout();

        // Show window
        screen.setVisible(true);

        // Waits for source selection
        while(Monitor.source == null)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        // Threshold
        int threshold = 100;
        
        // Start motion detection manager
        MotionDetection detector = new MotionDetection(threshold);
        
        BufferedImage frame = null;
        BufferedImage reference_frame = null;
        int[][] selected_area;
        int[][] motion_vector = new int[][]{{0, 0}, {0, 0}};
        int count = 0;
        int frame_count = 0;
        int num_ignored_frames = 0;
        
        // Capture first frame to get dimensions
        try {
            while(frame == null)
                frame = Monitor.source.getFrame();
            screen.resizeWindow(frame.getWidth(), frame.getHeight());
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        while(true) {
            try {
                // Gets reference frame
                if(reference_frame == null)
                    reference_frame = Image.clone(frame);
                
                // Checks motion
                if(frame_count >= num_ignored_frames) {
                    frame_count = 0;
                    
                    // Gets selected area
                    selected_area = screen.getSelectedArea();
                    
                    // Checks motion detection
                    boolean status = detector.checkMotion(reference_frame, frame, selected_area[0][0], selected_area[0][1], selected_area[1][0], selected_area[1][1]);
                    
                    // Update states to a new detection
                    if(status) {
                        count = 0;
                        motion_vector = null;
                        reference_frame = null;
                        screen.updateStatus(status);
                    } else if(motion_vector == null) {
                        count++;
                    
                        if(count >= 25) {
                            // Sets vector of the diretion movement
                            motion_vector = new int[][]{
                                { 
                                    detector.getInitialMotionBoundBox().start.x,
                                    detector.getInitialMotionBoundBox().start.y
                                }, {
                                    detector.getFinalMotionBoundBox().start.x,
                                    detector.getFinalMotionBoundBox().start.y
                                }
                            };

                            // Switch initial/final bound box
                            detector.switchBoundBox();
                            
                            // Update detection state
                            screen.updateStatus(status);
                        }
                    }
                }

                // Draw frame
                screen.showFrame(frame, motion_vector);
                
                // Gets frame from camera
                frame = Monitor.source.getFrame();
                
                // Finish application
                if(frame == null) {
                    screen.dispatchEvent(new WindowEvent(screen, WindowEvent.WINDOW_CLOSING));
                    return;
                }
                
                frame_count++;
            } catch (IOException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
