/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import MainMenu.MainMenu;
import connection.DBConnect;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Polman
 */
public class UbahDriver extends javax.swing.JFrame {

    /**
     * Creates new form UbahDriver
     */
    private DefaultTableModel model;
    
        
    public UbahDriver() {
        initComponents();
        
        model = new DefaultTableModel();
        
        //menambahkan table model ke table
        addColumn();
        addDataColumn();
        tableDriver.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnKembali = new javax.swing.JButton();
        btnNavTambah = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnKembali1 = new javax.swing.JButton();
        btnNavTambah1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtid_driver = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtnama_driver = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txttanggal_lahir = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtno_telepon = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDriver = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("UBAH DEPARTEMEN");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnNavTambah.setText("Tambah");
        btnNavTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNavTambah)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(btnNavTambah)
                .addGap(100, 100, 100)
                .addComponent(btnKembali)
                .addGap(24, 24, 24))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("UBAH DRIVER");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        btnKembali1.setText("Kembali");
        btnKembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembali1ActionPerformed(evt);
            }
        });

        btnNavTambah1.setText("Tambah");
        btnNavTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavTambah1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNavTambah1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKembali1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnNavTambah1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKembali1)
                .addGap(24, 24, 24))
        );

        jLabel1.setText("ID Driver");

        btnCari.setText("Cari");
        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariMouseClicked(evt);
            }
        });
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel5.setText("Nama");

        txtnama_driver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnama_driverKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnama_driverKeyTyped(evt);
            }
        });

        jLabel6.setText("Alamat");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        txtAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlamatKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtAlamat);

        jLabel7.setText("Tanggal Lahir");

        txttanggal_lahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttanggal_lahirKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttanggal_lahirKeyTyped(evt);
            }
        });

        jLabel8.setText("No Telepon");

        txtno_telepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtno_teleponKeyTyped(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        jLabel9.setText("Email");

        tableDriver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDriver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDriverMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableDriver);

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(47, 47, 47)
                                .addComponent(txtid_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnama_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnUbah)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txttanggal_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtno_telepon)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtid_driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtnama_driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtno_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnUbah)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addColumn(){
        model.addColumn("ID Driver");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Tanggal Lahir");
        model.addColumn("No Telepon");
        model.addColumn("Email");
        model.addColumn("Status Pcik Up");
    }
    private void addDataColumn(){
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();

        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "select * from Driver";
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                Object[] obj = new Object[7];
                obj[0] = connection.result.getString("ID_Staff");
                obj[1] = connection.result.getString("nama_staff");
                obj[2] = connection.result.getString("alamat_staff");
                obj[3] = connection.result.getString("tgl_lahir");
                obj[4] = connection.result.getString("no_telphone");
                obj[5] = connection.result.getString("email");
                obj[6] = connection.result.getString("Status_pickup");



                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal111!\n" + e.toString());
        }
    }
    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        MainMenu m = new MainMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnNavTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavTambahActionPerformed
        CreateDriver dpt = new CreateDriver();
        dpt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNavTambahActionPerformed

    private void btnKembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembali1ActionPerformed
        MainMenu m = new MainMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKembali1ActionPerformed

    private void btnNavTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavTambah1ActionPerformed
        CreateDriver dpt = new CreateDriver();
        dpt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNavTambah1ActionPerformed

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        //menghapus seluruh data ditamp
        DBConnect connection = new DBConnect();
        model.getDataVector().removeAllElements();

        //memberi tahu data telah kosong
        model.fireTableDataChanged();

        try{
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM Driver WHERE ID_Staff LIKE '%" +
            txtid_driver.getText() + "%'";
            connection.result = connection.stat.executeQuery(query);
            //lakukan perbaris data
            while(connection.result.next()){
                Object[] obj = new Object[7];
                obj[0] = connection.result.getString("ID_Staff");
                obj[1] = connection.result.getString("nama_staff");
                obj[2] = connection.result.getString("alamat_staff");
                obj[3] = connection.result.getString("tgl_lahir");
                obj[4] = connection.result.getString("no_telphone");
                obj[5] = connection.result.getString("email");
                obj[6] = connection.result.getString("Status_pickup");
                model.addRow(obj);
            }
            //jika di table tidak ada data yg dicari
            if(model.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
            }
            connection.stat.close();
            connection.result.close();
        }
        catch(Exception e){
            System.out.println("Terjadi error saat load Data Jenis Paket: "+e);
        }
    }//GEN-LAST:event_btnCariMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
       
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtnama_driverKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnama_driverKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtnama_driverKeyPressed

    private void txtnama_driverKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnama_driverKeyTyped
        // TODO add your handling code here:
        if(txtnama_driver.getText().length()==25){
            evt.consume();
        }else{
            char enter = evt.getKeyChar();
            if(!Character.isLetter(enter) && !Character.isISOControl(enter) && !Character.isWhitespace(enter)){
                evt.consume();

            }
        }
    }//GEN-LAST:event_txtnama_driverKeyTyped

    private void txtAlamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlamatKeyTyped
        // TODO add your handling code here:
        if(txtAlamat.getText().length()==50){
            evt.consume();
        }
    }//GEN-LAST:event_txtAlamatKeyTyped

    private void txttanggal_lahirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttanggal_lahirKeyPressed
        // TODO add your handling code here:
        txttanggal_lahir.setDate(null);
    }//GEN-LAST:event_txttanggal_lahirKeyPressed

    private void txttanggal_lahirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttanggal_lahirKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txttanggal_lahirKeyTyped

    private void txtno_teleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtno_teleponKeyTyped
        // TODO add your handling code here:
        if(txtno_telepon.getText().length()==13){
            evt.consume();
        }else{
            char enter = evt.getKeyChar();
            if(!Character.isDigit(enter) && !Character.isISOControl(enter)){
                evt.consume();
            }
        }

    }//GEN-LAST:event_txtno_teleponKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
        if(txtEmail.getText().length()==13){
            evt.consume();
        }else{

        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void tableDriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDriverMouseClicked
        // TODO add your handling code here:
        int i = tableDriver.getSelectedRow();
        if (i == -1) {
            return;
        }
        
        
        txtid_driver.setText((String) model.getValueAt(i, 0));
        txtnama_driver.setText((String) model.getValueAt(i, 1));
        txtAlamat.setText((String) model.getValueAt(i, 2));
        String dateValue = model.getValueAt(i, 3).toString();
        
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
            txttanggal_lahir.setDate(date);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,
                        "Masukkan data dengan benar!");
        }

        
        txtEmail.setText((String) model.getValueAt(i, 5));
        txtno_telepon.setText((String) model.getValueAt(i, 4));
        
        
        addDataColumn();
    }//GEN-LAST:event_tableDriverMouseClicked
    private static final String EMAIL_PATTERN = 
    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        boolean benar = true;
        if(txtnama_driver.getText().equals("") || txtAlamat.getText().equals("") || txttanggal_lahir.getDateFormatString().equals("") || txtno_telepon.getText().equals("")){
                JOptionPane.showMessageDialog(this,
                        "Masukkan data dengan benar!");
                benar = false;
        }else{
            if (!txtEmail.getText().matches(EMAIL_PATTERN)) {
            benar = false;
            JOptionPane.showMessageDialog(this,
                        "Masukkan email dengan benar!");
            }
        }
        if(benar){
            Format formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String tanggal = formatter.format(txttanggal_lahir.getDate());
            Object[] options = {"Yaa, simpan",
                "Tidak, batal"};
            int n;
            penjemputan:
            {
                n = JOptionPane.showOptionDialog(this,
                        "Periksa data sebelum disimpan\n"
                        + "ID Driver     : " + txtid_driver.getText()
                        + "\nNama          : " + txtnama_driver.getText()
                        + "\nAlamat        : " + txtAlamat.getText()
                        + "\nTanggal Lahir : " + tanggal
                        + "\nNo Telepon    : " + txtno_telepon.getText()
                        + "\nEmail         : " + txtEmail.getText(),
                        "Pertanyaan",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
            }
            if (n == 0) {
                updateDriver();
            } else if (n == 1) {
                JOptionPane.showMessageDialog(this,
                        "Batal!");
            }
        }
          
        
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void updateDriver(){
        DBConnect connection = new DBConnect();
        try {

                String query = "UPDATE Driver SET nama_staff=?, alamat_staff=?, tgl_lahir=?, no_telphone = ?, email = ?, WHERE ID_Staff=?";
                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, txtnama_driver.getText());
                connection.pstat.setString(2, txtAlamat.getText());

                Format formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String tanggal = formatter.format(txttanggal_lahir.getDate());

                connection.pstat.setString(3, tanggal);
                connection.pstat.setString(4, txtno_telepon.getText());
                connection.pstat.setString(5, txtEmail.getText());
                connection.pstat.setString(6, txtid_driver.getText());



                connection.pstat.executeUpdate();
                connection.result.close();

                addDataColumn();
                JOptionPane.showMessageDialog(this, "Ubah data driver berhasil");
                clear();
            }
            catch (Exception e) {
                System.out.println("Terjadi error saat load data driver: " + e.toString());
            }
    }
    private void clear(){
        txtid_driver.setText("");
        txtnama_driver.setText("");
        txtAlamat.setText("");
        txtno_telepon.setText("");
        txtEmail.setText("");
        txttanggal_lahir.setDate(null);
    }
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
            java.util.logging.Logger.getLogger(UbahDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UbahDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UbahDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UbahDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UbahDriver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnKembali1;
    private javax.swing.JButton btnNavTambah;
    private javax.swing.JButton btnNavTambah1;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableDriver;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtid_driver;
    private javax.swing.JTextField txtnama_driver;
    private javax.swing.JTextField txtno_telepon;
    private com.toedter.calendar.JDateChooser txttanggal_lahir;
    // End of variables declaration//GEN-END:variables
}
