package view;

import controller.DataController;
import controller.MongoController;
import controller.SvmController;
import controller.ViewController;
import edu.berkeley.compbio.jlibsvm.util.SparseVector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ListSelectionModel;
import model.SvmDocument;
import model.schema.Session;
import upgrade.TableModel;

/**
 * @author Daniele Cuomo N8601346
 */
public class DataAnalysis extends javax.swing.JFrame{
    private final TableModel<Session> tableModel;
    private boolean OVERLAP = true;
    
    public DataAnalysis(){
        List<Session> l = DataController.<Session>execNamedQuery("getSessions");
        Object[][] table = Session.getMatrix( l );
        tableModel = new <Session>TableModel(l, table, Session.metaData);
        initComponents();
        
        new Thread(() -> {
            long[] ids = new long[l.size()];
            for(int i=0 ; i<l.size() ; i++)
                ids[i] = l.get(i).getId();
            MongoController.initialize(ids);

            predictButton.setEnabled(true);
            trainButton.setEnabled(true);
            select75();
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        sessionTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        trainButton = new javax.swing.JButton();
        predictButton = new javax.swing.JButton();
        sizeSpinner = new javax.swing.JSpinner();
        sizeLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        typeBox = new javax.swing.JComboBox<>();
        cSpinner = new javax.swing.JSpinner();
        cLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Analysis");
        setResizable(false);

        sessionTable.setModel(tableModel);
        jScrollPane2.setViewportView(sessionTable);
        sessionTable.getAccessibleContext().setAccessibleName("");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        trainButton.setText("Train");
        trainButton.setEnabled(false);
        trainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainButtonActionPerformed(evt);
            }
        });

        predictButton.setText("Predict");
        predictButton.setEnabled(false);
        predictButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predictButtonActionPerformed(evt);
            }
        });

        sizeSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.5f), Float.valueOf(0.5f), Float.valueOf(5.0f), Float.valueOf(0.5f)));

        sizeLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        sizeLabel.setText("Window size");

        typeLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        typeLabel.setText("Partition type");

        typeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "non-overlap", "overlap" }));

        cSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(10.0f), Float.valueOf(0.1f)));

        cLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        cLabel.setText("C");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189)
                        .addComponent(predictButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(trainButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sizeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(sizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(typeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BackButton, predictButton, trainButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(typeLabel)
                        .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sizeLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton)
                    .addComponent(trainButton)
                    .addComponent(predictButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        ViewController.openFrame(Homepage.class);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void trainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainButtonActionPerformed
        int[] rows = sessionTable.getSelectedRows();
        if(rows.length == 0){
            ViewController.showInfo("Select at least two sessions");
            return;
        }
        
        SvmController.setC((float)cSpinner.getValue());
        
        if(typeBox.getSelectedItem().equals("non-overlap"))
            OVERLAP = false;
        
        Map<SparseVector, String> examples = getExamples(rows, (float)sizeSpinner.getValue());        
        SvmController.train(examples);
        
        select25();
    }//GEN-LAST:event_trainButtonActionPerformed

    private void predictButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predictButtonActionPerformed
        int[] rows = sessionTable.getSelectedRows();
        if(rows.length == 0){
            ViewController.showInfo("Select at least one session");
            return;
        }
        long id;
        
        Map<SparseVector, String> test = getExamples(rows, (float)sizeSpinner.getValue());
        try{ SvmController.predict(test); }
        catch(Exception e){ ViewController.showException(e); }      
        
        select75();
    }//GEN-LAST:event_predictButtonActionPerformed
    
    private Map<SparseVector, String> getExamples(int[] rows, float range){
        Map<SparseVector, String> map = new HashMap<>();
        long id; SvmDocument doc;
        for(int i : rows){
            id = tableModel.getRow(i).getId();
            doc = MongoController.getDocument(id);
            for(SparseVector x : doc.partition(range, OVERLAP))
                map.put(x, doc.getContext());
        }
        return map;
    }

    private void select75(){
        ListSelectionModel model = sessionTable.getSelectionModel();
        model.clearSelection();
        for(int i=0 ; i<tableModel.getRowCount() ; i+=4)
            model.addSelectionInterval(i, i+2);
    }
    
    private void select25(){
        ListSelectionModel model = sessionTable.getSelectionModel();
        model.clearSelection();
        for(int i=0 ; i<tableModel.getRowCount() ; i+=4)
            model.addSelectionInterval(i+3, i+3);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel cLabel;
    private javax.swing.JSpinner cSpinner;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton predictButton;
    private javax.swing.JTable sessionTable;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JSpinner sizeSpinner;
    private javax.swing.JButton trainButton;
    private javax.swing.JComboBox<String> typeBox;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
