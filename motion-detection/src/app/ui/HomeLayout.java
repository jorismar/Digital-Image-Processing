/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui;

import app.Monitor;
import app.device.manager.Source;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;

/**
 *
 * @author Jorismar
 */
public class HomeLayout extends javax.swing.JFrame {
    private int clicked_point_x;
    private int clicked_point_y;
    private int selected_area_x1;
    private int selected_area_y1;
    private int selected_area_x2;
    private int selected_area_y2;
    
    /**
     * Creates new form home
     */
    public HomeLayout() {
        initComponents();
        this.selected_area_x1 = 0;
        this.selected_area_y1 = 0;
        this.selected_area_x2 = this.panel_canvas.getWidth();
        this.selected_area_y2 = this.panel_canvas.getHeight();
    }
    
    /**
     * 
     * @param width
     * @param height 
     */
    public void resizeWindow(int width, int height) {
        this.setSize(width, height + this.panel_status_area.getHeight() + this.panel_menu.getHeight());
        this.selected_area_x2 = width - 1;
        this.selected_area_y2 = height - 1;
    }
    
    /**
     * 
     * @param frame
     * @param vector 
     */
    public void showFrame(BufferedImage frame, int[][] vector) {
        if(frame == null)
            return;
        
        Graphics2D graphics = (Graphics2D) this.panel_canvas.getGraphics();
        
        // Draw rectangle of area seletect on frame
        this.drawSelectedArea(
            frame, this.selected_area_x1, this.selected_area_y1, this.selected_area_x2, this.selected_area_y2, 0xff00
        );
        
        // Draw frame
        graphics.drawImage(
            frame, 
            0, 0, this.panel_canvas.getWidth(), this.panel_canvas.getHeight(), 
            0, 0, frame.getWidth(), frame.getHeight(), null
        );
        
        if(vector != null)
            this.drawArrow(graphics, vector[0][0], vector[0][1], vector[1][0], vector[1][1]);
    }
    
    /**
     * 
     * @param is_detected 
     */
    public void updateStatus(boolean is_detected) {
        String text = "";
        Color color = null;
        
        if(is_detected) {
            color = new java.awt.Color(204, 0, 0);
            text = "Motion Detected";
        } else {
            color = new java.awt.Color(0, 204, 0);
            text = "Nothing Detected";
        }
        
        this.label_status.setForeground(color);
        this.label_status.setText(text);
    }
    
    /**
     * 
     * @param g
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    private void drawArrow(Graphics2D g, int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        
        // Translate system coordinates origin to (x1, y1)
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        
        // Rotate system coordinates
        at.concatenate(AffineTransform.getRotateInstance(angle));
        
        // Apply transformation
        g.transform(at);

        // Draw horizontal line starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        
        // Draw arrow
        g.fillPolygon(new int[] {len, len - 4, len - 4, len},
                      new int[] {0, -4, 4, 0}, 4);
    }
    
    /**
     * 
     * @param frame
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param color 
     */
    public void drawSelectedArea(BufferedImage frame, int x1, int y1, int x2, int y2, int color) {
        // Draw horizontal lines of box
        for(int y = y1; y < y2; y++) {
            frame.setRGB(x1, y, color);
            frame.setRGB(x2, y, color);
        }
        
        // Draw vertical lines of box
        for(int x = x1; x < x2; x++) {
            frame.setRGB(x, y1, color);
            frame.setRGB(x, y2, color);
        }
    }
    
    /**
     * 
     * @return 
     */
    public int[][] getSelectedArea() {
        return new int[][] {
            { this.selected_area_x1, this.selected_area_y1 }, { this.selected_area_x2, this.selected_area_y2 }
        };
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        panel_canvas = new javax.swing.JPanel();
        panel_status_area = new javax.swing.JPanel();
        label_status = new javax.swing.JLabel();
        panel_menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        button_webcam = new javax.swing.JButton();
        button_video_file = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_canvas.setBackground(new java.awt.Color(0, 0, 0));
        panel_canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel_canvasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panel_canvasMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_canvasLayout = new javax.swing.GroupLayout(panel_canvas);
        panel_canvas.setLayout(panel_canvasLayout);
        panel_canvasLayout.setHorizontalGroup(
            panel_canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_canvasLayout.setVerticalGroup(
            panel_canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        panel_status_area.setBackground(new java.awt.Color(0, 0, 0));

        label_status.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_status.setForeground(new java.awt.Color(0, 204, 0));
        label_status.setText("Nothing Detected");

        javax.swing.GroupLayout panel_status_areaLayout = new javax.swing.GroupLayout(panel_status_area);
        panel_status_area.setLayout(panel_status_areaLayout);
        panel_status_areaLayout.setHorizontalGroup(
            panel_status_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_status_areaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_status, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(562, Short.MAX_VALUE))
        );
        panel_status_areaLayout.setVerticalGroup(
            panel_status_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_status, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panel_menu.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Source");

        button_webcam.setText("Webcam");
        button_webcam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_webcamActionPerformed(evt);
            }
        });

        button_video_file.setText("Video File");
        button_video_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_video_fileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(button_webcam)
                .addGap(18, 18, 18)
                .addComponent(button_video_file)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_webcam)
                    .addComponent(jLabel1)
                    .addComponent(button_video_file))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_status_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panel_status_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panel_canvasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_canvasMousePressed
        this.clicked_point_x = evt.getX();
        this.clicked_point_y = evt.getY();
    }//GEN-LAST:event_panel_canvasMousePressed

    private void panel_canvasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_canvasMouseReleased
        if(this.clicked_point_x == evt.getX() && this.clicked_point_y == evt.getY())
            return;
       
        if(this.clicked_point_x > evt.getX()) {
            this.selected_area_x1 = evt.getX();
            this.selected_area_x2 = this.clicked_point_x;
        } else {
            this.selected_area_x1 = this.clicked_point_x;
            this.selected_area_x2 = evt.getX();
        }
        
        if(this.clicked_point_y > evt.getY()) {
            this.selected_area_y1 = evt.getY();
            this.selected_area_y2 = this.clicked_point_y;
        } else {
            this.selected_area_y1 = this.clicked_point_y;
            this.selected_area_y2 = evt.getY();
        }
    }//GEN-LAST:event_panel_canvasMouseReleased

    private void button_webcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_webcamActionPerformed
        Monitor.source = new Source();
        this.button_webcam.setEnabled(false);
        this.button_video_file.setEnabled(false); 
    }//GEN-LAST:event_button_webcamActionPerformed

    private void button_video_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_video_fileActionPerformed
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            String filename = chooser.getSelectedFile().getPath();
            System.err.println(filename);
            Monitor.source = new Source(filename);
            this.button_video_file.setEnabled(false); 
            this.button_webcam.setEnabled(false);
        }
    }//GEN-LAST:event_button_video_fileActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(Monitor.source != null)
            Monitor.source.releaseDevice();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_video_file;
    private javax.swing.JButton button_webcam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel label_status;
    private javax.swing.JPanel panel_canvas;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_status_area;
    // End of variables declaration//GEN-END:variables
}
