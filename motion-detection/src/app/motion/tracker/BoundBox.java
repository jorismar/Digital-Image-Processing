/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.motion.tracker;

/**
 *
 * @author Jorismar
 */
public class BoundBox {
    /**
     * 
     */
    public class Start {
        public int x = 0;
        public int y = 0;
    }
    
    /**
     * 
     */
    public class End {
        public int x = 0;
        public int y = 0;
    }
    
    public Start start;
    public End end;

    /**
     * 
     */
    public BoundBox() {
        this.start = new Start();
        this.end = new End();
    }
}
