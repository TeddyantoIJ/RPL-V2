/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import ListPickUp.LihatStatusPickUp;
import TransaksiPengambilanBarang.TransaksiPemesanan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import connection.DBConnect;
;

/**
 *
 * @author SATRIA ADJIE PRAYOGA
 */
public class Login extends javax.swing.JFrame {

    DBConnect connection = new DBConnect();
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql, query;
    public String KantorCabang;
    int i;
    String IdCs;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        //connection.DBConnect();
        con = connection.conn;
        stat = connection.stat;
        addItemKantor();
        addItemDepartement();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPas = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbDept = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbKantorCabang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("LOGIN");

        lblUser.setText("Username :");

        jLabel3.setText("Password :");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Masuk sebagai");

        cbDept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Departemen --" }));
        cbDept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDeptActionPerformed(evt);
            }
        });

        jLabel2.setText("Kantor Cabang");

        cbKantorCabang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Kantor --" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(lblUser)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbKantorCabang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbDept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogin))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUser))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPas))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbKantorCabang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnLogin))
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    public void Clear(){
        txtUser.setText("");
        txtPas.setText("");
    }
    
    private void addItemKantor(){
        cbKantorCabang.removeAll();
        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT nama_kantor FROM KantorCabang";
            connection.result = connection.stat.executeQuery(query);
            connection.result.next();
            do{
                
                cbKantorCabang.addItem(connection.result.getString("nama_kantor"));
            }while(connection.result.next());
            
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan item KantorCabang!\n" + e.toString());
        }
    }
    
    private void addItemDepartement(){
        cbDept.removeAll();
        try {
            DBConnect connection = new DBConnect();
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
            JOptionPane.showMessageDialog(this, "Gagal menambahkan item Departement!\n" + e.toString());
        }
    }
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here: 
        if(driver)
        {
            LihatStatusPickUp status = new LihatStatusPickUp();
            this.setVisible(false);
            status.setVisible(true);
        }
        else
        {
            String user = txtUser.getText();
            String pass = txtPas.getText();
            String akun = (String)cbDept.getSelectedItem();
            KantorCabang = (String)cbKantorCabang.getSelectedItem();
            System.out.println(akun);
            if(akun.equals("Customer Service"))
            {
                txtUser.setVisible(true);
                lblUser.setVisible(true);
                if(user.equals("") || pass.equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!");
                }
                else
                {
                    try {
                    sql = "SELECT * FROM CustomerService WHERE username='"+ user+"' AND password='"+ pass +"' AND status_aktif='Aktif' and kode_kantor_cabang = '"+getIDKantor(cbKantorCabang.getSelectedItem().toString())+"'";
                    rs = stat.executeQuery(sql);
                    if(rs.next()){
                        if(user.equals(rs.getString("username")) && pass.equals(rs.getString("password")) && getTrueKantor(cbKantorCabang.getSelectedItem().toString())){
                            IdCs = (rs.getString("id_staff"));
                            JOptionPane.showMessageDialog(null, "berhasil login");
                            MainMenuCS transaksi = new MainMenuCS(IdCs, KantorCabang);
                            this.setVisible(false);
                            transaksi.setVisible(true);
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "Nama pengguna atau kata sandi salah");
                            int jawab = JOptionPane.showOptionDialog(this, 
                                        "Ingin Mencoba lagi?", 
                                        "Mengulang", 
                                        JOptionPane.YES_NO_OPTION, 
                                        JOptionPane.QUESTION_MESSAGE, null, null, null);

                            if(jawab == JOptionPane.NO_OPTION){
                                JOptionPane.showMessageDialog(this, "Program Akan Keluar");
                                System.exit(0);
                            }
                            else
                            {
                                Clear();
                                i++;
                                if(i == 3){
                                    JOptionPane.showMessageDialog(this, "Anda telah gagal 3x. Aplikasi akan ditutup");
                                    System.exit(0);
                                }
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }else{
                if(pass.equals(""))
                {   
                    JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!");
                }else{
                    if(pass.equals(getPassDepartment(akun))){
                        JOptionPane.showMessageDialog(null, "berhasil login");
                        switch (akun){
                            case "Dispatch" :{
                                MainMenuDispatch m = new MainMenuDispatch(KantorCabang);
                                m.setVisible(true);
                                this.setVisible(false);
                                break;
                            }
                            case "Pencetak Connote" : {
                                MainMenuPencetakConnote m = new MainMenuPencetakConnote(KantorCabang);
                                m.setVisible(true);
                                this.setVisible(false);
                                break;
                            }
                            case "Staff" : {
                                MainMenuStaff m = new MainMenuStaff(KantorCabang);
                                m.setVisible(true);
                                this.setVisible(false);
                                break;
                            }
                    }
                    }else{
                        JOptionPane.showMessageDialog(null, "Nama pengguna atau kata sandi salah");
                        int jawab = JOptionPane.showOptionDialog(this, 
                                        "Ingin Mencoba lagi?", 
                                        "Mengulang", 
                                        JOptionPane.YES_NO_OPTION, 
                                        JOptionPane.QUESTION_MESSAGE, null, null, null);

                            if(jawab == JOptionPane.NO_OPTION){
                                JOptionPane.showMessageDialog(this, "Program Akan Keluar");
                                System.exit(0);
                            }
                            else
                            {
                                Clear();
                                i++;
                                if(i == 3){
                                    JOptionPane.showMessageDialog(this, "Anda telah gagal 3x. Aplikasi akan ditutup");
                                    System.exit(0);
                                }
                            }
                    }
                    
                }
            }
//            else if(akun.equals("Staff Kelola"))
//            {
//                txtUser.setVisible(true);
//                lblUser.setVisible(true);
//                if(user.equals("") || pass.equals(""))
//                {
//                    JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!");
//                }
//                else
//                {
//                    if(user.equals("admin") && pass.equals("admin"))
//                    {
//                        
//                        MainMenuStaffKelola m = new MainMenuStaffKelola(KantorCabang);
//                        m.setVisible(true);
//                        this.setVisible(false);
//                    }
//                    else
//                    {
//                        JOptionPane.showMessageDialog(null, "Nama pengguna atau kata sandi salah");
//                        int jawab = JOptionPane.showOptionDialog(this, 
//                                    "Ingin Mencoba lagi?", 
//                                    "Mengulang", 
//                                    JOptionPane.YES_NO_OPTION, 
//                                    JOptionPane.QUESTION_MESSAGE, null, null, null);
//
//                        if(jawab == JOptionPane.NO_OPTION){
//                            JOptionPane.showMessageDialog(this, "Program Akan Keluar");
//                            System.exit(0);
//                        }
//                        else
//                        {
//                            Clear();
//                            i++;
//                            if(i == 3){
//                                JOptionPane.showMessageDialog(this, "Anda telah gagal 3x. Aplikasi akan ditutup");
//                                System.exit(0);
//                            }
//                        }
//                    }
//                }
//            }
//            else
//            {
//                txtUser.setVisible(false);
//                lblUser.setVisible(false);
//                if(pass.equals(""))
//                {
//                    JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!");
//                }
//                else
//                {
//                    if(pass.equals("KMFJAYA"))
//                    {
//                        if(akun.equals("Staff"))
//                        {
//                            JOptionPane.showMessageDialog(null, "berhasil login");
//                            MainMenuStaff m = new MainMenuStaff();
//                            m.setVisible(true);
//                            this.setVisible(false);
//                        }
//                        else if(akun.equals("Dispatch"))
//                        {
//                            JOptionPane.showMessageDialog(null, "berhasil login");
//                            MainMenuDispatch m = new MainMenuDispatch();
//                            m.setVisible(true);
//                            this.setVisible(false);
//                        }
//                        else if(akun.equals("Pencetak Connote"))
//                        {
//                            JOptionPane.showMessageDialog(null, "berhasil login");
//                            MainMenuPencetakConnote m = new MainMenuPencetakConnote();
//                            m.setVisible(true);
//                            this.setVisible(false);
//                        }
//                    }
//                    else
//                    {
//                        JOptionPane.showMessageDialog(null, "Nama pengguna atau kata sandi salah");
//                        int jawab = JOptionPane.showOptionDialog(this, 
//                                    "Ingin Mencoba lagi?", 
//                                    "Mengulang", 
//                                    JOptionPane.YES_NO_OPTION, 
//                                    JOptionPane.QUESTION_MESSAGE, null, null, null);
//
//                        if(jawab == JOptionPane.NO_OPTION){
//                            JOptionPane.showMessageDialog(this, "Program Akan Keluar");
//                            System.exit(0);
//                        }
//                        else
//                        {
//                            Clear();
//                            i++;
//                            if(i == 3){
//                                JOptionPane.showMessageDialog(this, "Anda telah gagal 3x. Aplikasi akan ditutup");
//                                System.exit(0);
//                            }
//                        }
//                    }
//                }
//            }
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private String getPassDepartment(String akun){
        try{DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "select pass_dept from Departement where nama_dept = '"+akun+"'";
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("pass_dept"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;
    }
    private boolean getTrueKantor(String in){
        
        try{DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "select id_staff from CustomerService where username = '"+txtUser.getText()+"' and password ='"+txtPas.getText()+"' and kode_kantor_cabang = '"+getIDKantor(in)+"'";
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("id_staff"));

            }
            connection.stat.close();
            connection.result.close();
            if(output.equals("")){
                return false;
            }else{
                return true;
            }
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
            return false;
        }
        
    }
    private String getIDKantor(String in){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select kode_kantor_cabang from KantorCabang where nama_kantor = '"+in+"'";
            //System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("kode_kantor_cabang"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error do getIdKantor!!\n" + e.toString());
        }
        return null;
    }
    private void cbDeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDeptActionPerformed
        // TODO add your handling code here:
        String akun = (String)cbDept.getSelectedItem();
        if(akun.equals("Customer Service") || akun.equals("Staff Kelola"))
        {
            txtUser.setVisible(true);
            lblUser.setVisible(true);
        }
        else{
            
            txtUser.setVisible(false);
            lblUser.setVisible(false);
        }
    }//GEN-LAST:event_cbDeptActionPerformed
    boolean driver = false;
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cbDept;
    private javax.swing.JComboBox<String> cbKantorCabang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtPas;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
