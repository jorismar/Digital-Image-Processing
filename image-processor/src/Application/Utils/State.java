/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.Utils;

import java.awt.image.BufferedImage;
import javax.swing.JRadioButton;
import DigitalImageProcess.DigitalProcess;
import DigitalImageProcess.Colors.ColorSpace;
import DigitalImageProcess.Tools.Image;

/**
 *
 * @author Jorismar
 */
public class State {
    private int color_space;
    private JRadioButton band_selected;
    private int add_brightness_value;
    private float mult_brightness_value;
    private int thresholding_M_value;
    private int average_filter_value;
    private int median_filter_value;
    private BufferedImage image;
    private DigitalProcess last_process;
    private int[] color_balance;

    public State() {
        this.color_space = ColorSpace.RGB;
        this.band_selected = null;
        this.add_brightness_value = 0;
        this.mult_brightness_value = 1.0f;
        this.thresholding_M_value = 0;
        this.average_filter_value = 3;
        this.median_filter_value = 3;
        this.image = null;
        this.last_process = null;
        this.color_balance = new int[]{0, 0, 0};
    }
    
    public State(
            int color_space, 
            JRadioButton band_selected, 
            int add_brightness_value, 
            int mult_brightness_value, 
            int thresholding_M_value, 
            int average_filter_value, 
            int median_filter_value, 
            BufferedImage image,
            DigitalProcess last_process,
            int[] color_balance
    ) {
        this.color_space = color_space;
        this.band_selected = band_selected;
        this.add_brightness_value = add_brightness_value;
        this.mult_brightness_value = mult_brightness_value;
        this.thresholding_M_value = thresholding_M_value;
        this.average_filter_value = average_filter_value;
        this.median_filter_value = median_filter_value;
        this.image = image;
        this.last_process = last_process;
        this.color_balance = color_balance;
    }

    public int[] getColorBalance() {
        return color_balance;
    }

    public void setColorBalance(int[] color_balance) {
        this.color_balance = new int[]{
            color_balance[0],
            color_balance[1],
            color_balance[2]
        };
    }

    public DigitalProcess getLastProcess() {
        return last_process;
    }

    public void setLastProcess(DigitalProcess current_transf_owner) {
        this.last_process = current_transf_owner;
    }
    
    public int getColorSpace() {
        return color_space;
    }

    public void setColorSpace(int color_space) {
        this.color_space = color_space;
    }

    public JRadioButton getBandSelector() {
        return band_selected;
    }

    public void setBandSelector(JRadioButton band_selected) {
        this.band_selected = band_selected;
    }

    public int getAddBrightnessValue() {
        return add_brightness_value;
    }

    public void setAddBrightnessValue(int add_brightness_value) {
        this.add_brightness_value = add_brightness_value;
    }

    public float getMultBrightnessValue() {
        return mult_brightness_value;
    }

    public void setMultBrightnessValue(float mult_brightness_value) {
        this.mult_brightness_value = mult_brightness_value;
    }

    public int getThresholdingValue() {
        return thresholding_M_value;
    }

    public void setThresholdingValue(int thresholding_M_value) {
        this.thresholding_M_value = thresholding_M_value;
    }

    public int getAverageFilterValue() {
        return average_filter_value;
    }

    public void setAverageFilterValue(int average_filter_value) {
        this.average_filter_value = average_filter_value;
    }

    public int getMedianFilterValue() {
        return median_filter_value;
    }

    public void setMedianFilterValue(int median_filter_value) {
        this.median_filter_value = median_filter_value;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public void clone(State state) throws NullPointerException {
        this.image = Image.clone(state.getImage()); //Image.clone(state.getImage());
        
        if(this.image == null)
            throw new NullPointerException();
        
        this.color_space = state.getColorSpace();
        this.band_selected = state.getBandSelector();
        this.add_brightness_value = state.getAddBrightnessValue();
        this.mult_brightness_value = state.getMultBrightnessValue();
        this.thresholding_M_value = state.getThresholdingValue();
        this.average_filter_value = state.getAverageFilterValue();
        this.median_filter_value = state.getMedianFilterValue();
        this.color_balance = new int[] {
            state.getColorBalance()[0],
            state.getColorBalance()[1],
            state.getColorBalance()[2]
        };
    }
}
