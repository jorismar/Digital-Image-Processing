/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.device.manager;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Core;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Jorismar
 */
public class Source {
    private final VideoCapture device;
    private final Mat frame;
    private final MatOfByte buffer;
    
    /**
     * 
     */
    public Source() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.device = new VideoCapture(0);
        this.frame = new Mat();
        this.buffer = new MatOfByte();
    }
    
    /**
     * 
     * @param filename 
     */
    public Source(String filename) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.device = new VideoCapture(filename);
        this.frame = new Mat();
        this.buffer = new MatOfByte();
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public BufferedImage getFrame() throws IOException {
        if(!this.device.grab())
            return null;
        
        this.device.retrieve(this.frame);
        Imgcodecs.imencode(".bmp", this.frame, this.buffer);
        
        return (BufferedImage) ImageIO.read(new ByteArrayInputStream(this.buffer.toArray()));
    }
    
    /**
     * 
     */
    public void releaseDevice() {
        this.device.release();
    }
}
