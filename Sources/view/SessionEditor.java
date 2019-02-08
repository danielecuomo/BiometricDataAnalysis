package view;

import controller.DataController;
import controller.ViewController;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import model.Parser;
import model.schema.Device;
import model.schema.Acquisition;
import model.schema.Sensor;
import model.schema.Session;
import model.schema.User;
import upgrade.ListModel;

/**
 * @author Daniele
 */
public class SessionEditor extends JFrame{
    private DefaultListModel<Device> deviceListModel = new DefaultListModel<>();
    private final JFrame mainFrame = this;

    private final Session session = new Session();
    private final Set<Acquisition> samples = new HashSet<>();
    
    private Date start, end;
    private User u;

    public SessionEditor(){
        initComponents();
        session.setAcquisitions(samples);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        deviceBox = new JComboBox<>(DataController.<Device>execNamedQuery(Device.NAMED_QUERY).toArray());
        deviceLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        day1 = new javax.swing.JFormattedTextField();
        month1 = new javax.swing.JFormattedTextField();
        year1 = new javax.swing.JFormattedTextField();
        day2 = new javax.swing.JFormattedTextField();
        month2 = new javax.swing.JFormattedTextField();
        year2 = new javax.swing.JFormattedTextField();
        startLabel = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deviceList = new javax.swing.JList<>(deviceListModel);
        backButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        minuteBox1 = new javax.swing.JComboBox<>(IntStream.range(0, 60).boxed().toArray());
        h1Label = new javax.swing.JLabel();
        h2Label = new javax.swing.JLabel();
        m1Label = new javax.swing.JLabel();
        m2Label = new javax.swing.JLabel();
        hourBox1 = new javax.swing.JComboBox<>(IntStream.range(0, 24).boxed().toArray());
        hourBox2 = new javax.swing.JComboBox<>(IntStream.range(0, 24).boxed().toArray());
        minuteBox2 = new javax.swing.JComboBox<>(IntStream.range(0, 60).boxed().toArray());
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        contextArea = new javax.swing.JTextArea();
        contextLabel = new javax.swing.JLabel();
        selectedDevicesLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Session editor");
        setResizable(false);

        idLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        idLabel.setText("User ID");

        deviceLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        deviceLabel.setText("Device");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        day1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd"))));
        day1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        month1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MM"))));
        month1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        year1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy"))));
        year1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        day2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd"))));
        day2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        month2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MM"))));
        month2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        year2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy"))));
        year2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        startLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        startLabel.setText("* Start Date");

        endLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        endLabel.setText("* End Date");

        deviceList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deviceListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(deviceList);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        h1Label.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        h1Label.setText("hh");

        h2Label.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        h2Label.setText("hh");

        m1Label.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        m1Label.setText("mm");

        m2Label.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        m2Label.setText("mm");

        contextArea.setColumns(20);
        contextArea.setRows(5);
        jScrollPane2.setViewportView(contextArea);

        contextLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        contextLabel.setText("Context");

        selectedDevicesLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        selectedDevicesLabel.setText("* List of selected devices");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(idLabel)
                                .addComponent(deviceLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(deviceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(day2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(month2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(year2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(startLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(endLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hourBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(h1Label)
                                            .addComponent(h2Label, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(hourBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(16, 16, 16)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(m2Label)
                                        .addComponent(m1Label)
                                        .addComponent(minuteBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minuteBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectedDevicesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(selectedDevicesLabel))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startLabel)
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(year1)
                                    .addComponent(day1)
                                    .addComponent(month1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(endLabel)
                                    .addComponent(h2Label))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(day2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(month2)
                                    .addComponent(year2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hourBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minuteBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(m1Label)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(16, 16, 16)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(minuteBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(hourBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(h1Label)
                                        .addGap(20, 20, 20)))
                                .addComponent(m2Label)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deviceLabel)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deviceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton)))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Device d = (Device)deviceBox.getSelectedItem();

        new SampleChooser( d ).setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ViewController.openFrame(Homepage.class);
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if( !checkFields() )
            return;
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        session.setUser(u);

        //devices
        List<Device> devices = new ArrayList<>();
        for(int i=0 ; i<deviceListModel.size() ; i++)
            devices.add(deviceListModel.get(i));
        session.setDevices(devices);
        
        //date
        session.setStart( start );
        session.setEnd( end );
        
        //context
        if( contextArea.getText() != null )
            session.setContext( contextArea.getText() );
        
        DataController.<Session>create(session);
        
        ViewController.showInfo("Session " + session.getId() + " created!");
        ViewController.openFrame(Homepage.class);
    }//GEN-LAST:event_submitButtonActionPerformed

    private void deviceListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deviceListKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DELETE)
            for( Device d : deviceList.getSelectedValuesList() )
                deviceListModel.removeElement(d);
    }//GEN-LAST:event_deviceListKeyReleased

    private boolean checkFields(){
        if( deviceListModel.size() == 0 ){
            ViewController.showInfo("Insert at least one device");
            return false;
        }
        
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        try{
            int year = Integer.valueOf(year1.getText());
            int month = Integer.valueOf(month1.getText()) - 1;
            int day = Integer.valueOf(day1.getText());
            int hh =  Integer.valueOf(hourBox1.getSelectedItem().toString());
            int mm = Integer.valueOf(minuteBox1.getSelectedItem().toString());
            
            c.set(year, month, day, hh, mm);
            start = c.getTime();
            
            year = Integer.valueOf(year2.getText());
            month = Integer.valueOf(month2.getText()) - 1;
            day = Integer.valueOf(day2.getText());
            hh =  Integer.valueOf(hourBox2.getSelectedItem().toString());
            mm = Integer.valueOf(minuteBox2.getSelectedItem().toString());
            
            c = (Calendar)c.clone();
            c.set(year, month, day, hh, mm);
            end = c.getTime();
        }
        catch( IllegalArgumentException e ){
            ViewController.showInfo("Insert valid dates");
            return false;
        }

        u = DataController.<User>getReference(User.class, Long.valueOf(idField.getText()));
        if( u == null ){
            ViewController.showInfo("Enter valid user ID");
            return false;
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea contextArea;
    private javax.swing.JLabel contextLabel;
    private javax.swing.JFormattedTextField day1;
    private javax.swing.JFormattedTextField day2;
    private javax.swing.JComboBox<Object> deviceBox;
    private javax.swing.JLabel deviceLabel;
    private javax.swing.JList<Device> deviceList;
    private javax.swing.JLabel endLabel;
    private javax.swing.JLabel h1Label;
    private javax.swing.JLabel h2Label;
    private javax.swing.JComboBox<Object> hourBox1;
    private javax.swing.JComboBox<Object> hourBox2;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel m1Label;
    private javax.swing.JLabel m2Label;
    private javax.swing.JComboBox<Object> minuteBox1;
    private javax.swing.JComboBox<Object> minuteBox2;
    private javax.swing.JFormattedTextField month1;
    private javax.swing.JFormattedTextField month2;
    private javax.swing.JLabel selectedDevicesLabel;
    private javax.swing.JLabel startLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JFormattedTextField year1;
    private javax.swing.JFormattedTextField year2;
    // End of variables declaration//GEN-END:variables

    public class SampleChooser extends javax.swing.JFrame{
        private final AbstractListModel<Sensor> sensorListModel;
        private final JFileChooser fileChooser = new JFileChooser();
        private final Device dev;
    
        public SampleChooser( Device d ){
            dev = d;
            initComponents();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

            sensorListModel = new <Sensor>ListModel(d.getSensors());
            sensorList.setModel(sensorListModel);
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            browseButton = new javax.swing.JButton();
            submitButton = new javax.swing.JButton();
            cancelButton = new javax.swing.JButton();
            pathTextField = new javax.swing.JTextField();
            jScrollPane1 = new javax.swing.JScrollPane();
            sensorList = new javax.swing.JList<>();
            infoLabel = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Choose a file");
            setResizable(false);

            browseButton.setText("Browse");
            browseButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    browseButtonActionPerformed(evt);
                }
            });

            submitButton.setText("Submit");
            submitButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    submitButtonActionPerformed(evt);
                }
            });

            cancelButton.setText("Cancel");
            cancelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cancelButtonActionPerformed(evt);
                }
            });

            jScrollPane1.setViewportView(sensorList);

            infoLabel.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
            infoLabel.setText("Select sensors used for this sample");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(browseButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(browseButton)
                        .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(infoLabel)
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(submitButton)
                        .addComponent(cancelButton))
                    .addContainerGap())
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>                        

        private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                pathTextField.setText(fileChooser.getSelectedFile().toPath().toString());
        }                                            

        private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
            List<Sensor> sensors = sensorList.getSelectedValuesList();
                if( sensors.isEmpty() ){
                    ViewController.showException(new RuntimeException("Select at least one sensor"));
                    return;
                }

                File f = new File(pathTextField.getText());
                if( !f.exists() ){
                    ViewController.showException(new IOException("File does not exist"));
                    return;
                }
                Parser p = dev.getParser();
                Acquisition s;
                try{ s = p.parse(f, sensors); }
                catch( Exception e ){
                    ViewController.showException(e);
                    return;
                }
                
                s.setSession(session);

                samples.add(s);
                deviceListModel.addElement(dev);
                mainFrame.setEnabled(true);
                dispose();
        }                                            

        private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
            mainFrame.setAlwaysOnTop(true); //unexpected behavior without this procedure
            setVisible(false);
            mainFrame.setEnabled(true);
            dispose();
            mainFrame.setAlwaysOnTop(false);
        }                                            
                  
        private javax.swing.JButton browseButton;
        private javax.swing.JButton cancelButton;
        private javax.swing.JLabel infoLabel;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextField pathTextField;
        private javax.swing.JList<Sensor> sensorList;
        private javax.swing.JButton submitButton;              
    }
}