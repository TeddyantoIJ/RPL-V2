/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;

import MainMenu.MainMenuStaffKelola;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.Format;
import java.text.SimpleDateFormat;
import connection.DBConnect;
import java.util.Date;
import javax.swing.JTable;
/**
 *
 * @author SATRIA ADJIE PRAYOGA
 */
public class Ubah_Staff extends javax.swing.JFrame {

    private DefaultTableModel model;
    public ResultSet rs;
    DBConnect connection = new DBConnect();
    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    String KantorCabang;
    String outputKodeKc, outputDeptId;
    /**
     * Creates new form Ubah_Staff
     */
    public Ubah_Staff() {
        initComponents();
        
        model = new DefaultTableModel();
        tableStaff.setModel(model);
        
        addColumn();
        loadData();
    }
    
    public Ubah_Staff(String KantorCabang){
        initComponents();
        this.KantorCabang = KantorCabang;
        
        model = new DefaultTableModel();
        tableStaff.setModel(model);
        addItemDepartemen();
        addColumn();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtTelp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateLahir = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStaff = new javax.swing.JTable();
        cbStatus = new javax.swing.JComboBox<>();
        txtKantorCabang = new javax.swing.JTextField();
        cbDept = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1075, 450));
        setResizable(false);
        setSize(new java.awt.Dimension(1075, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtNama.setBackground(new java.awt.Color(204, 204, 255));
        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaKeyTyped(evt);
            }
        });

        txtAlamat.setBackground(new java.awt.Color(204, 204, 255));

        txtTelp.setBackground(new java.awt.Color(204, 204, 255));
        txtTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelpKeyTyped(evt);
            }
        });

        jLabel6.setText("Tanggal Lahir");

        txtEmail.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 55));
        jLabel1.setText("UBAH STAFF");

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        jLabel4.setText("No Telp");

        dateLahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateLahirKeyTyped(evt);
            }
        });

        jLabel5.setText("Email");
        jLabel5.setToolTipText("");

        jLabel8.setText("Id");

        txtId.setBackground(new java.awt.Color(204, 204, 255));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(255, 255, 255));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tableStaff.setModel(new javax.swing.table.DefaultTableModel(
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
        tableStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableStaff);

        cbStatus.setBackground(new java.awt.Color(204, 204, 255));
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Tidak aktif" }));

        txtKantorCabang.setBackground(new java.awt.Color(204, 204, 255));
        txtKantorCabang.setEnabled(false);

        cbDept.setBackground(new java.awt.Color(204, 204, 255));
        cbDept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Departemen --" }));

        jLabel7.setText("Status");

        jLabel9.setText("Kantor Cabang");

        jLabel10.setText("Departement");

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKembali)
                    .addComponent(btnTambah))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNama)
                            .addComponent(txtAlamat)
                            .addComponent(dateLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTelp)
                            .addComponent(txtEmail)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(btnSimpan))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCari))
                            .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKantorCabang)
                            .addComponent(cbDept, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel6)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel5)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel7)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel9)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCari))
                                .addGap(9, 9, 9)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(dateLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(txtKantorCabang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(cbDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnSimpan)))))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        new Staff(KantorCabang).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTambahActionPerformed

    private String getKodeKantorCabang(String in){
        outputKodeKc= "";
        try{
            connection.stat = connection.conn.createStatement();
                String query = "select * from KantorCabang where nama_kantor ='"+in+"'";
                connection.result = connection.stat.executeQuery(query);
                
                connection.result.next();
                    
                outputKodeKc = (connection.result.getString("kode_kantor_cabang"));
                
                
                connection.stat.close();
                connection.result.close();
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Get Kode Kc error!!\n" + e.toString());
        }
        return outputKodeKc;
    }
    
    private String getDeptID(String in){
        outputDeptId= "";
        try{
            connection.stat = connection.conn.createStatement();
                String query = "select * from Departement where nama_dept ='"+in+"'";
                connection.result = connection.stat.executeQuery(query);
                
                connection.result.next();
                    
                outputDeptId = (connection.result.getString("id_dept"));
                
                
                connection.stat.close();
                connection.result.close();
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Get Id Dept error!!\n" + e.toString());
        }
        return outputDeptId;
    }
    
    private void addItemDepartemen(){
        cbDept.removeAll();
        try {
            
            connection.stat = connection.conn.createStatement();
            String query = "SELECT nama_dept FROM Departement";
            connection.result = connection.stat.executeQuery(query);
            connection.result.next();
            do{
                
                cbDept.addItem(connection.result.getString("nama_dept"));
            }while(connection.result.next());
            
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tambah item Departemen gagal!\n" + e.toString());
        }
    }
    
    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
//            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM Staff WHERE id_staff LIKE '%" +
                    txtId.getText() + "%'";
            connection.result = connection.stat.executeQuery(query);
            
            while(connection.result.next()){
                Object[] obj = new Object[9];
                obj[0] = connection.result.getString("id_staff");
                obj[1] = connection.result.getString("nama_staff");
                obj[2] = connection.result.getString("alamat_staff");
                obj[3] = connection.result.getString("tgl_lahir");
                obj[4] = connection.result.getString("no_telphone");
                obj[5] = connection.result.getString("email");
                obj[6] = connection.result.getString("status_aktif");
                obj[7] = connection.result.getString("id_dept");
                obj[8] = connection.result.getString("kode_kantor_cabang");
                
                model.addRow(obj);
            }
            if(model.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Data Staff tidak ditemukan");
            }
            connection.stat.close();
            connection.result.close();
        }catch(Exception ex){
            System.out.println("Terjadi error saat load data: " + ex);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String id_staff = txtId.getText();
        String nama = txtNama.getText();
        String alamat = txtAlamat.getText();
        String noTelp = txtTelp.getText();
        String tglLahir = formatter.format(dateLahir.getDate());
        String email = txtEmail.getText();
        String status = (String)cbStatus.getSelectedItem();
        String Kc = txtKantorCabang.getText();
        String Dept = (String)cbDept.getSelectedItem();
        getKodeKantorCabang(Kc);
        getDeptID(Dept);
        
        if(id_staff.equals("")||nama.equals("")||alamat.equals("")||tglLahir.equals("")||noTelp.equals("")||email.equals("")){
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!");
        }
        else
        {
            try {
                String query = ("INSERT INTO Staff VALUES(?,?,?,?,?,?,?,?,?)");
                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, id_staff);
                connection.pstat.setString(2, nama);
                connection.pstat.setString(3, alamat);
                connection.pstat.setString(4, tglLahir);
                connection.pstat.setString(5, noTelp);
                connection.pstat.setString(6, email);
                connection.pstat.setString(7, status);
                connection.pstat.setString(8, outputKodeKc);
                connection.pstat.setString(9, outputDeptId);

                connection.pstat.executeUpdate();
                connection.pstat.close();
                JOptionPane.showMessageDialog(this, "Insert data staff berhasil");
                Clear();
                loadData();
            }
            catch(Exception e) {
                System.out.println("Terjadi error saat insert ke database: " + e);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtNamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
            if(!Character.isLetter(enter) && !Character.isISOControl(enter) && !Character.isWhitespace(enter)){
                evt.consume();
            }
    }//GEN-LAST:event_txtNamaKeyTyped

    private void txtTelpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelpKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
            if(!Character.isDigit(enter)){
                evt.consume();
            }
            
            if(txtTelp.getText().length()==13){
                evt.consume();
            }
    }//GEN-LAST:event_txtTelpKeyTyped

    private void dateLahirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateLahirKeyTyped
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_dateLahirKeyTyped

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tableStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStaffMouseClicked
        // TODO add your handling code here:
        int i = tableStaff.getSelectedRow();
        if(i == 1){
            return;
        }
        txtId.setText((String)model.getValueAt(i, 0));
        txtNama.setText((String)model.getValueAt(i, 1));
        txtAlamat.setText((String)model.getValueAt(i, 2));
        dateLahir.setDate(getTanggalFromTable(tableStaff, 3));
        txtTelp.setText((String)model.getValueAt(i, 4));
        txtEmail.setText((String)model.getValueAt(i, 5));
        cbStatus.addItem((String)model.getValueAt(i, 6));
        txtKantorCabang.setText((String)model.getValueAt(i, 7));
        cbDept.addItem((String)model.getValueAt(i, 8));
    }//GEN-LAST:event_tableStaffMouseClicked

    public static Date getTanggalFromTable(JTable  table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tanggal = null;
        try {
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        } catch (Exception ex) {
            
        }
        return tanggal;
    }
    
    public void addColumn(){
        model.addColumn("Id");
        model.addColumn("Nama Staff");
        model.addColumn("Alamat");
        model.addColumn("Tgl Lahir");
        model.addColumn("No Telp");
        model.addColumn("Email");
        model.addColumn("Status");
        model.addColumn("Kantor Cabang");
        model.addColumn("Departemen");
    }
    
    public void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM Staff";
            connection.result = connection.stat.executeQuery(query);
            
            while(connection.result.next()){
                Object[] obj = new Object[9];
                obj[0] = connection.result.getString("id_staff");
                obj[1] = connection.result.getString("nama_staff");
                obj[2] = connection.result.getString("alamat_staff");
                obj[3] = connection.result.getString("tgl_lahir");
                obj[4] = connection.result.getString("no_telphone");
                obj[5] = connection.result.getString("email");
                obj[6] = connection.result.getString("status_aktif");
                obj[7] = connection.result.getString("kode_kantor_cabang");
                obj[8] = connection.result.getString("id_dept");
                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        }catch(Exception ex){
            System.out.println("Terjadi error saat load data: " + ex);
        }
    }
    
    private void Clear(){
        txtId.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtTelp.setText("");
        txtEmail.setText("");
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
            java.util.logging.Logger.getLogger(Ubah_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ubah_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ubah_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ubah_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ubah_Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbDept;
    private javax.swing.JComboBox<String> cbStatus;
    private com.toedter.calendar.JDateChooser dateLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStaff;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKantorCabang;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}
