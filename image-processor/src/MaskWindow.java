
import DigitalImageProcess.Tools.Mask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorismar
 */
public class MaskWindow extends javax.swing.JFrame {

    /**
     * Creates new form MaskWindow
     */
    public MaskWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("resrc/img/app_icon.png").getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        input_value00 = new javax.swing.JTextField();
        input_value10 = new javax.swing.JTextField();
        input_value20 = new javax.swing.JTextField();
        input_value01 = new javax.swing.JTextField();
        input_value11 = new javax.swing.JTextField();
        input_value21 = new javax.swing.JTextField();
        input_value02 = new javax.swing.JTextField();
        input_value12 = new javax.swing.JTextField();
        input_value22 = new javax.swing.JTextField();
        button_ok = new javax.swing.JButton();
        button_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Matrix Mask");
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setResizable(false);

        input_value00.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        input_value00.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        input_value10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        input_value10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        input_value20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        input_value20.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        input_value01.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        input_value01.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        input_value11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        input_value11.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        input_value21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        input_value21.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        input_value02.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        input_value02.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        input_value12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        input_value12.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        input_value22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        input_value22.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        button_ok.setText("Aplicar");
        button_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_okActionPerformed(evt);
            }
        });

        button_cancel.setText("Cancelar");
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(button_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(input_value00, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(input_value10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(input_value20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(input_value01, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(input_value11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(input_value21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(input_value02, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(input_value12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(input_value22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_value00, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_value10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_value20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_value01, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_value11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_value21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_value02, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_value12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_value22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(button_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_okActionPerformed
        JTextField[][] values = new JTextField[][] {
            { this.input_value00, this.input_value01, this.input_value02 }, 
            { this.input_value10, this.input_value11, this.input_value12 }, 
            { this.input_value20, this.input_value21, this.input_value22 }
        };
        
        Mask mask = new Mask(3, 3);
       
        try {
            for(int x = 0; x < 3; x++)
                for(int y = 0; y < 3; y++)
                    mask.setValue(x, y, Integer.parseInt(values[x][y].getText()));
            
            ApplicationWindow.window_application.applyMask(mask);
            ApplicationWindow.window_application.customFilterButtonSwitch();
            this.setVisible(false);
        } catch(NumberFormatException ex) {
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Valor inválido!\nVerifique os valores digitados e tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            this.setVisible(true);
        }
    }//GEN-LAST:event_button_okActionPerformed

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
        ApplicationWindow.window_application.customFilterButtonSwitch();
        this.setVisible(false);
    }//GEN-LAST:event_button_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MaskWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaskWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaskWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaskWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MaskWindow window = new MaskWindow();
                window.setLocationRelativeTo(null);
                window.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_ok;
    private javax.swing.JTextField input_value00;
    private javax.swing.JTextField input_value01;
    private javax.swing.JTextField input_value02;
    private javax.swing.JTextField input_value10;
    private javax.swing.JTextField input_value11;
    private javax.swing.JTextField input_value12;
    private javax.swing.JTextField input_value20;
    private javax.swing.JTextField input_value21;
    private javax.swing.JTextField input_value22;
    // End of variables declaration//GEN-END:variables
}