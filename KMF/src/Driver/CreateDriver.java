/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import MainMenu.MainMenuStaffKelola;
import connection.DBConnect;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Polman
 */
public class CreateDriver extends javax.swing.JFrame {

    /**
     * Creates new form CreateDriver
     */
    private boolean dariubah = false;
    
    private static final String EMAIL_PATTERN = 
    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private String KantorCabang = "";
    public CreateDriver() {
        initComponents();
        txtid_driver.setText("DRV-"+getLastID());
    }
    
    public CreateDriver(String kantorCabang) {
        initComponents();
        txtid_driver.setText("DRV-"+getLastID());
        this.KantorCabang = kantorCabang;
        txtKantorCabang.setText(kantorCabang);
    }
    
    public CreateDriver(String kantorCabang, boolean in) {
        initComponents();
        dariubah = in;
        txtid_driver.setText("DRV-"+getLastID());
        this.KantorCabang = kantorCabang;
        txtKantorCabang.setText(kantorCabang);
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
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtno_telepon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBatal = new javax.swing.JButton();
        txtid_driver = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        txtnama_driver = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtKantorCabang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttanggal_lahir = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setText("No Telepon");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Tambah Driver");

        txtno_telepon.setBackground(new java.awt.Color(204, 204, 255));
        txtno_telepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtno_teleponKeyTyped(evt);
            }
        });

        jLabel2.setText("ID Driver");

        jLabel7.setText("Email");

        jLabel3.setText("Nama");

        txtEmail.setBackground(new java.awt.Color(204, 204, 255));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        jLabel4.setText("Alamat");

        btnBatal.setBackground(new java.awt.Color(204, 255, 204));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        txtid_driver.setText("Generate");

        btnSimpan.setBackground(new java.awt.Color(204, 255, 204));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        txtnama_driver.setBackground(new java.awt.Color(204, 204, 255));
        txtnama_driver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnama_driverKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnama_driverKeyTyped(evt);
            }
        });

        jLabel8.setText("kantor");

        txtAlamat.setBackground(new java.awt.Color(204, 204, 255));
        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        txtAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlamatKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtAlamat);

        txtKantorCabang.setText("KantorCabang");

        jLabel5.setText("Tanggal Lahir");

        txttanggal_lahir.setBackground(new java.awt.Color(204, 204, 255));
        txttanggal_lahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttanggal_lahirKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttanggal_lahirKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKantorCabang)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txttanggal_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtno_telepon)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid_driver)
                            .addComponent(txtnama_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addComponent(btnBatal)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSimpan))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(54, 54, 54)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19))))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBatal, btnSimpan});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid_driver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnama_driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtno_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtKantorCabang))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnSimpan))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
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
                        + "\nEmail         : " + txtEmail.getText()
                        + "\nKantor        : " + txtKantorCabang.getText(),
                        "Pertanyaan",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
            }
            if (n == 0) {
                inputDriver();
            } else if (n == 1) {
                JOptionPane.showMessageDialog(this,
                        "Batal!");
            }
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

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

    private void txttanggal_lahirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttanggal_lahirKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txttanggal_lahirKeyTyped

    private void txttanggal_lahirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttanggal_lahirKeyPressed
        // TODO add your handling code here:
      txttanggal_lahir.setDate(null);
    }//GEN-LAST:event_txttanggal_lahirKeyPressed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        if(dariubah){
            UbahDriver i = new UbahDriver(KantorCabang);
            i.setVisible(true);
        }else{
            MainMenuStaffKelola m = new MainMenuStaffKelola(KantorCabang);
            m.setVisible(true);
        }
        
    }//GEN-LAST:event_btnBatalActionPerformed
    private String getLastID(){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
                String query = "select count(ID_Staff) Total from Driver";
                connection.result = connection.stat.executeQuery(query);
                int count = 0;
                while (connection.result.next()) {
                    
                    count = Integer.parseInt(connection.result.getString("total"));
                    }
                connection.stat.close();
                connection.result.close();
                
                
                count++;
                
                if(Integer.toString(count).length() == 1)
            {
                return "000" + count;
            }
            else if (Integer.toString(count).length() == 2)
            {
                return "00" + count;
            }
            else if (Integer.toString(count).length() == 3)
            {
                return "0" + count;
            }
            else
            {
                return Integer.toString(count);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;
    }
    private String getDeptID(String in){
        DBConnect connection = new DBConnect();
        String output= "";
        try{
            connection.stat = connection.conn.createStatement();
                String query = "select * from Departement where nama_dept ='"+in+"'";
                connection.result = connection.stat.executeQuery(query);
                
                connection.result.next();
                    
                output = (connection.result.getString("id_dept"));
                
                
                connection.stat.close();
                connection.result.close();
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return output;
    }
    private String getKodeKantorCabang(String in){
        DBConnect connection = new DBConnect();
        String output= "";
        try{
            connection.stat = connection.conn.createStatement();
                String query = "select * from KantorCabang where nama_kantor ='"+in+"'";
                connection.result = connection.stat.executeQuery(query);
                
                connection.result.next();
                    
                output = (connection.result.getString("kode_kantor_cabang"));
                
                
                connection.stat.close();
                connection.result.close();
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return output;
    }
    private void inputDriver() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String tanggal = formatter.format(txttanggal_lahir.getDate());
        DBConnect connection = new DBConnect();
        try {
            String query = "insert into Driver values (?,?,?,?,?,?,?,?,?,?)";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, txtid_driver.getText());
            connection.pstat.setString(2, txtnama_driver.getText());
            connection.pstat.setString(3, txtAlamat.getText());
            connection.pstat.setString(4, tanggal);
            connection.pstat.setString(5, txtno_telepon.getText());
            connection.pstat.setString(6, txtEmail.getText());
            connection.pstat.setString(7, "Tidak aktif");
            connection.pstat.setString(8, "Aktif");
            connection.pstat.setString(9, getKodeKantorCabang(KantorCabang));
            connection.pstat.setString(10, getDeptID("Driver"));
            
            connection.pstat.executeUpdate();
            connection.pstat.close();
            JOptionPane.showMessageDialog(this,
                    "Data tersimpan");
            txtid_driver.setText("DRV-"+getLastID());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal!\n" + e.toString());
        }
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
            java.util.logging.Logger.getLogger(CreateDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateDriver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtKantorCabang;
    private javax.swing.JLabel txtid_driver;
    private javax.swing.JTextField txtnama_driver;
    private javax.swing.JTextField txtno_telepon;
    private com.toedter.calendar.JDateChooser txttanggal_lahir;
    // End of variables declaration//GEN-END:variables
}
