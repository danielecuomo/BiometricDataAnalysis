package view;

import controller.DataController;
import controller.ViewController;
import java.lang.reflect.Method;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import model.Parser;
import model.schema.Device;
import model.schema.Sensor;
import upgrade.ListModel;
import upgrade.TableModel;

/**
 * @author Daniele Cuomo
 */
public class DeviceCrud extends javax.swing.JFrame{ 
    private Object oldValue = null;
    private final TableModel<Device> tableModel;
    private final AbstractListModel<Sensor> listModel = new <Sensor>ListModel(Sensor.getSensors());
    
    public DeviceCrud(){
        List<Device> l = DataController.<Device>execNamedQuery(Device.NAMED_QUERY);
        
        Object[][] table = Device.getMatrix( l );
        tableModel = new <Device>TableModel(l, table, Device.metaData){
            @Override
            public boolean isCellEditable(int row, int col){ return col != 0; }
        };
        
        tableModel.addTableModelListener((TableModelEvent e) -> {
            int row = e.getFirstRow(), col = e.getColumn();
            if(col < 0) return;
            
            Object newValue = DeviceTable.getValueAt(row, col);
            if( newValue.equals(oldValue)) return;
            if( newValue.equals("") ){
                DeviceTable.setValueAt(oldValue, row, col);
                return;
            }
            
            Device d = tableModel.getRow(row);
            
            Method m = null;
            try{
                switch( col ){
                    case 1: m = Device.class.getMethod("setName", String.class); break;
                    case 2: m = Device.class.getMethod("setModel", String.class); break;
                }
            }
            catch(Exception ex){ throw new RuntimeException(); }
            
            DataController.<Device>update(d, m, newValue.toString());
        });
        
        initComponents();
        
        sensorList.setModel(listModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        DeviceTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        CreateButton = new javax.swing.JButton();
        nameField = new javax.swing.JFormattedTextField();
        modelField = new javax.swing.JFormattedTextField();
        nameLabel = new javax.swing.JLabel();
        ModelLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sensorList = new javax.swing.JList<>();
        parserBox = new javax.swing.JComboBox<>(model.Parser.values());
        parserLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Device Management");
        setResizable(false);

        DeviceTable.setModel(tableModel);
        DeviceTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DeviceTableFocusLost(evt);
            }
        });
        DeviceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeviceTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(DeviceTable);
        DeviceTable.getAccessibleContext().setAccessibleName("");

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
        ModelLabel.setText("Model");

        jScrollPane1.setViewportView(sensorList);

        parserLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        parserLabel.setText("Parser");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parserLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(parserBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modelField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModelLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(nameLabel)
                                        .addGap(19, 19, 19))
                                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ModelLabel)
                                .addGap(0, 0, 0)
                                .addComponent(modelField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parserLabel)
                                .addGap(0, 0, 0)
                                .addComponent(parserBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BackButton)
                            .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BackButton, CreateButton, DeleteButton});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        ViewController.openFrame(Homepage.class);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int[] rows = DeviceTable.getSelectedRows();
            
        if( rows.length == 0 || !ViewController.getConfirm() )
            return;
        for( int i : rows )
            DataController.<Device>delete(tableModel.getRow(i));
        for( int i=0 ; i<rows.length ; i++ )
            tableModel.removeRow( DeviceTable.getSelectedRow() );
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void DeviceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeviceTableMouseClicked
        if( DeviceTable.getSelectedRowCount() == 1 ){
            sensorList.setModel( new <Sensor>ListModel(
                tableModel.getRow(DeviceTable.getSelectedRow()).getSensors()) );
        }
        
        Object o = evt.getSource();
        if( !(o instanceof JTable) )
            return;
        JTable table = (JTable)o;
        
        int row = table.rowAtPoint(evt.getPoint());
        int col = table.columnAtPoint(evt.getPoint());
        
        if( !DeviceTable.isCellEditable(row, col) )
            return;
        oldValue = table.getValueAt(row, col);
    }//GEN-LAST:event_DeviceTableMouseClicked

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        if( !isFilled() ){
            JOptionPane.showMessageDialog(this, "Fill in all the fields, first",
                                            "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String name = nameField.getText();
        String model = modelField.getText();
        Parser parser = (Parser)parserBox.getSelectedItem();
        List<Sensor> l = sensorList.getSelectedValuesList();
        
        Device d = new Device();
        d.setName(name);
        d.setModel(model);
        d.setParser(parser);
        d.setSensors(l);
        
        d = DataController.<Device>create( d );
        if( d != null )
            tableModel.addRow(d, new Object[]{d.getId(), d.getName(), d.getModel()});
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void DeviceTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DeviceTableFocusLost
        sensorList.setModel(listModel);
    }//GEN-LAST:event_DeviceTableFocusLost
    
    private boolean isFilled(){
        if( nameField.getText() == null || modelField.getText() == null )
            return false;
        return !( nameField.getText().equals("") || modelField.getText().equals(""));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTable DeviceTable;
    private javax.swing.JLabel ModelLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField modelField;
    private javax.swing.JFormattedTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox<model.Parser> parserBox;
    private javax.swing.JLabel parserLabel;
    private javax.swing.JList<Sensor> sensorList;
    // End of variables declaration//GEN-END:variables
}
