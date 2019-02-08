package view;

import javax.swing.JFrame;
import controller.ViewController;
import javax.swing.ImageIcon;

/**
 * @author Daniele Cuomo
 */
public class Homepage extends JFrame{
    public Homepage(){
        initComponents();
        setIconImage(new ImageIcon("./leaf.png").getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        SessionButton = new javax.swing.JButton();
        AnalysisButton = new javax.swing.JButton();
        DeviceButton = new javax.swing.JButton();
        UserButton = new javax.swing.JButton();
        SensorButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biometric Data Management");
        setResizable(false);

        SessionButton.setText("Create Session");
        SessionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SessionButtonActionPerformed(evt);
            }
        });

        AnalysisButton.setText("Data Analysis");
        AnalysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalysisButtonActionPerformed(evt);
            }
        });

        DeviceButton.setText("Device Management");
        DeviceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeviceButtonActionPerformed(evt);
            }
        });

        UserButton.setText("User Management");
        UserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserButtonActionPerformed(evt);
            }
        });

        SensorButton.setText("Sensor Management");
        SensorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SensorButtonActionPerformed(evt);
            }
        });

        viewButton.setText("Read Sessions");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        label1.setText("Session Management");

        label2.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        label2.setText("Other");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SessionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(AnalysisButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addComponent(label1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DeviceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(SensorButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label2))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeviceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SessionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SensorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnalysisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SessionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SessionButtonActionPerformed
        ViewController.openFrame(SessionEditor.class);
    }//GEN-LAST:event_SessionButtonActionPerformed

    private void UserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserButtonActionPerformed
        ViewController.openFrame(UserCrud.class);
    }//GEN-LAST:event_UserButtonActionPerformed

    private void DeviceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeviceButtonActionPerformed
        ViewController.openFrame(DeviceCrud.class);
    }//GEN-LAST:event_DeviceButtonActionPerformed

    private void SensorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SensorButtonActionPerformed
        ViewController.openFrame(SensorCrud.class);
    }//GEN-LAST:event_SensorButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        ViewController.openFrame(SessionReader.class);
    }//GEN-LAST:event_viewButtonActionPerformed

    private void AnalysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalysisButtonActionPerformed
        ViewController.openFrame(DataAnalysis.class);
    }//GEN-LAST:event_AnalysisButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnalysisButton;
    private javax.swing.JButton DeviceButton;
    private javax.swing.JButton SensorButton;
    private javax.swing.JButton SessionButton;
    private javax.swing.JButton UserButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}