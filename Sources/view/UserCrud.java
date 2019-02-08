package view;

import controller.DataController;
import controller.ViewController;
import model.schema.User;
import javax.swing.JOptionPane;
import java.util.List;
import upgrade.TableModel;

/**
 * @author Daniele Cuomo
 */
public class UserCrud extends javax.swing.JFrame{
    private final TableModel<User> tableModel;
    
    public UserCrud(){
        List<User> l = DataController.<User>execNamedQuery(User.NAMED_QUERY);
        Object[][] table = User.getMatrix( l );
        tableModel = new <User>TableModel(l, table, User.metaData);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        UsersTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        CreateButton = new javax.swing.JButton();
        idField = new javax.swing.JFormattedTextField();
        idLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Management");
        setResizable(false);

        UsersTable.setModel(tableModel);
        jScrollPane2.setViewportView(UsersTable);
        UsersTable.getAccessibleContext().setAccessibleName("");

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

        idLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        idLabel.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CreateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idField))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idLabel)
                                .addGap(0, 0, 0)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 171, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BackButton)
                .addGap(18, 18, 18))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BackButton, CreateButton, DeleteButton});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        ViewController.openFrame(Homepage.class);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        deleteProcedure();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        if( !isFilled() ){
            JOptionPane.showMessageDialog(this, "Enter a valid value", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String id = idField.getText();
        User u = new User();
        u.setId(Long.valueOf(id));
        
        if( (u = DataController.<User>create(u)) != null );
            tableModel.addRow(u, new Object[]{u.getId()});
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void deleteProcedure(){
        int[] rows = UsersTable.getSelectedRows();

        if( rows.length == 0 || !ViewController.getConfirm() )
                return;
        for( int i : rows )
            DataController.<User>delete( tableModel.getRow(i));
        for( int i=0 ; i<rows.length ; i++ )
            tableModel.removeRow(UsersTable.getSelectedRow());
    }
    
    private boolean isFilled(){
        return idField.getText() != null && !idField.getText().equals("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTable UsersTable;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JFormattedTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
