package view;

import controller.DataController;
import controller.ViewController;
import java.util.List;
import javax.swing.JOptionPane;
import model.schema.Sensor;
import model.schema.Sensor.Domain;
import upgrade.TableModel;

/**
 * @author Daniele Cuomo
 */
public class SensorCrud extends javax.swing.JFrame{
    private final TableModel<Sensor> tableModel;
    
    public SensorCrud(){
        List<Sensor> l = Sensor.getSensors();
        Object[][] table = Sensor.getMatrix( l );
        tableModel = new <Sensor>TableModel( l, table, Sensor.metaData );  
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        SensorTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        CreateButton = new javax.swing.JButton();
        nameField = new javax.swing.JFormattedTextField();
        nameLabel = new javax.swing.JLabel();
        ModelLabel = new javax.swing.JLabel();
        domainBox = new javax.swing.JComboBox<Domain>(Domain.values());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sensor Management");
        setResizable(false);

        SensorTable.setModel(tableModel);
        jScrollPane2.setViewportView(SensorTable);
        SensorTable.getAccessibleContext().setAccessibleName("");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        CreateButton.setText("Create");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        nameLabel.setText("Name");

        ModelLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        ModelLabel.setText("Domain");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 71, Short.MAX_VALUE)
                        .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(domainBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ModelLabel)
                            .addComponent(nameLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nameField))
                .addGap(0, 0, 0)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BackButton, CreateButton, DeleteButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(0, 0, 0)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ModelLabel)
                                .addGap(0, 0, 0)
                                .addComponent(domainBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton)
                    .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BackButton, CreateButton, DeleteButton});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        ViewController.openFrame(Homepage.class);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int[] rows = SensorTable.getSelectedRows();
            
        if( rows.length == 0 || !ViewController.getConfirm() )
            return;
        for( int i : rows )
            DataController.<Sensor>delete(tableModel.getRow(i));
        for( int i=0 ; i<rows.length ; i++ )
            tableModel.removeRow( SensorTable.getSelectedRow() );
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        if( !isFilled() ){
            JOptionPane.showMessageDialog(this, "Fill in all the fields, first",
                                            "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }        
        String name = nameField.getText();
        Domain dom = (Domain)domainBox.getSelectedItem();
        
        Sensor s = new Sensor();
        s.setName(name);
        s.setDomain(dom);
        
        s = DataController.<Sensor>create(s);
        if( s != null )
            tableModel.addRow(s, new Object[]{ s.getName(), s.getDomain()});
    }//GEN-LAST:event_CreateButtonActionPerformed
    
    private boolean isFilled(){
        return nameField.getText() != null && !nameField.getText().equals("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel ModelLabel;
    private javax.swing.JTable SensorTable;
    private javax.swing.JComboBox<Domain> domainBox;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField nameField;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables

}
