/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Tools;

/**
 *
 * @author Jorismar
 */
public class Mask {
    private int width;
    private int height;
    private int[][] matrix;

    public Mask() {
        this.width = 0;
        this.height = 0;
        this.matrix = null;
    }

    public Mask(int[][] matrix) {
        this.width = matrix[0].length;
        this.height = matrix.length;
        this.matrix = matrix;
    }

    public Mask(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int getValue(int x, int y) {
        return this.matrix[y][x];
    }

    public void setValue(int x, int y, int value) {
        this.matrix[y][x] = value;
    }
}
