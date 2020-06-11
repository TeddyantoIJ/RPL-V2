package CS;


import MainMenu.MainMenu;
import connection.DBConnect;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class tambahCS extends javax.swing.JFrame {
    
    DBConnect koneksi = new DBConnect();
    String id,nama,alamat, noTelp, email, username, password;
    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    private String txtkode_kantor_cabang = "";
    /**
     * Creates new form CrudRole
     */
    public tambahCS() {
        //this.tanggal = String.valueOf(fm.format(TglLahir.getDate()));
        initComponents();
        txtId.setText("CS-"+getLastID());
    }
    public tambahCS(String kantorcabang) {
        //this.tanggal = String.valueOf(fm.format(TglLahir.getDate()));
        this.txtkode_kantor_cabang = getIDKantor(kantorcabang);
        initComponents();
        txtId.setText("CS-"+getLastID());
    }
    private String getIDKantor(String in){
        
        try{
            koneksi.stat = koneksi.conn.createStatement();
            String query = "select kode_kantor_cabang from KantorCabang where nama_kantor = '"+in+"'";
            koneksi.result = koneksi.stat.executeQuery(query);
            String output = null;
            while (koneksi.result.next()) {

                output = (koneksi.result.getString("kode_kantor_cabang"));

            }
            koneksi.stat.close();
            koneksi.result.close();
            return output;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;
    }
    private String getLastID(){
        String id= null;
        try{
                koneksi.stat = koneksi.conn.createStatement();
                String query = "select count(id_staff) Total from CustomerService";
                koneksi.result = koneksi.stat.executeQuery(query);
                int count = 0;
                while (koneksi.result.next()) {
                    
                    count = Integer.parseInt(koneksi.result.getString("total"));
                    }
                koneksi.stat.close();
                koneksi.result.close();
                
                
                count++;
                
            if(Integer.toString(count).length() == 1)
            {
                id = "000" + count;
            }
            else if (Integer.toString(count).length() == 2)
            {
                id =  "00" + count;
            }
            else if (Integer.toString(count).length() == 3)
            {
                id = "0" + count;
            }
            else
            {
                id = Integer.toString(count);
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error!"+ex.toString());
        }
        return String.valueOf(id);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnKebali = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTlp = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtUname = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtTgl = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Master Customer Service");

        jLabel2.setText("ID");

        jLabel3.setText("Nama");

        jLabel4.setText("Alamat");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaKeyTyped(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnKebali.setText("Kembali");
        btnKebali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKebaliActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel5.setText("Tanggal Lahir");

        jLabel6.setText("No Telphone");

        jLabel7.setText("Email");

        jLabel8.setText("Username");

        jLabel9.setText("Password");

        txtTlp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTlpActionPerformed(evt);
            }
        });
        txtTlp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTlpKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnKebali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUbah))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAlamat, txtEmail, txtNama, txtPass, txtTgl, txtTlp, txtUname});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btnTambah))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnClear)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKebali)
                    .addComponent(btnUbah))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtTlpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTlpActionPerformed
        
    }//GEN-LAST:event_txtTlpActionPerformed

    private void txtTlpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTlpKeyTyped
        char enter = evt.getKeyChar();
            if(!Character.isDigit(enter)){
                evt.consume();
            }
    }//GEN-LAST:event_txtTlpKeyTyped

    private void txtNamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyTyped
        char enter = evt.getKeyChar();
            if(!Character.isLetter(enter) && !Character.isISOControl(enter) && !Character.isWhitespace(enter)){
                evt.consume();
            }
    }//GEN-LAST:event_txtNamaKeyTyped

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        txtId.setText("CS-"+getLastID());
        nama = txtNama.getText();
        alamat = txtAlamat.getText();
        String tanggal = formatter.format(txtTgl.getDate());
        //TglLahir = TglLahir;
        noTelp = txtTlp.getText();
        email = txtEmail.getText();
        username = txtUname.getText();
        password = txtPass.getText();
        id = txtId.getText();
        try{
            String query = "insert into CustomerService values(?,?,?,?,?,?,?,?,?,?,?)";
            koneksi.pstat = koneksi.conn.prepareStatement(query);
            koneksi.pstat.setString(1, id);
            koneksi.pstat.setString(2, nama);
            koneksi.pstat.setString(3, alamat);
            koneksi.pstat.setString(4, tanggal);
            koneksi.pstat.setString(5, noTelp);
            koneksi.pstat.setString(6, email);
            koneksi.pstat.setString(7, username);
            koneksi.pstat.setString(8, password);
            koneksi.pstat.setString(9, "Aktif");
            koneksi.pstat.setString(10, getIDDepartment("Customer Service"));
            koneksi.pstat.setString(11, txtkode_kantor_cabang);
            
            koneksi.pstat.executeUpdate();
            koneksi.pstat.close();
            JOptionPane.showMessageDialog(this, "Berhasil");
        }catch(Exception ex){
            System.out.println("Erorr = "+ex);
        }
        
        txtId.setText("CS-"+getLastID());
    }//GEN-LAST:event_btnTambahActionPerformed
    private String getIDDepartment(String akun){
        try{
            koneksi.stat = koneksi.conn.createStatement();
            String query = "select id_dept from Departement where nama_dept = '"+akun+"'";
            koneksi.result = koneksi.stat.executeQuery(query);
            String output = null;
            while (koneksi.result.next()) {

                output = (koneksi.result.getString("id_dept"));

            }
            koneksi.stat.close();
            koneksi.result.close();
            return output;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;
    }
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtId.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtEmail.setText("");
        txtTgl.setDate(null);
        txtTlp.setText("");
        txtUname.setText("");
        txtPass.setText("");
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        ubahCS dpt = new ubahCS();
        dpt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnKebaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKebaliActionPerformed
        // TODO add your handling code here:
        MainMenu m = new MainMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKebaliActionPerformed

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
            java.util.logging.Logger.getLogger(tambahCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambahCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambahCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambahCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambahCS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnKebali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPass;
    private com.toedter.calendar.JDateChooser txtTgl;
    private javax.swing.JTextField txtTlp;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables
}
