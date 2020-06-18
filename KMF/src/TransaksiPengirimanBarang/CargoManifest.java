/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransaksiPengirimanBarang;

import connection.DBConnect;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author putri ramadani rais
 */
public class CargoManifest extends javax.swing.JFrame {

    /**
     * Creates new form CargoManifest
     */
    private String KantorCabang = "";
    listBagging g = new listBagging();
    private DefaultTableModel model;
    private DBConnect connection = new DBConnect();
    List<String> calonCargo = new ArrayList();
    
    public CargoManifest() {
        initComponents();
        //addCargo(); 
    }
    
    public CargoManifest(String kantorCabang, List<String> a) {
        this.KantorCabang = kantorCabang;
        this.calonCargo = a;
        initComponents();
        //addCargo(); 
        id();
        txtberat.setText(String.valueOf(getBerat(txtid_cargo.getText())));
        txtJumkantong.setText(String.valueOf(calonCargo.size()));
    }
    
    private int getBerat(String in){
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select [DataBarangPelanggan].berat_barang as berat "
                    + "from DataBarangPelanggan "
                    + "inner join Connote on [DataBarangPelanggan].id_pemesanan = [Connote].id_pemesanan "
                    + "inner join detailBagging on [Connote].id_connote = [detailBagging].id_connote "
                    + "inner join detailCargo on [detailBagging].id_bagging = [detailCargo].id_bagging "
                    + "where [detailCargo].id_cargo_manifest = '"+in+"'";
            connection.result = connection.stat.executeQuery(query);
            int output = 0;
            while (connection.result.next()) {

                output = Integer.parseInt(connection.result.getString("berat"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error getBerat!!\n" + e.toString());
        }
        return 0;
    }
    
//    private int getBerat(String in){
//        try{
//            connection.stat = connection.conn.createStatement();
//            String query = "select [DataBarangPelanggan].berat_barang as singkatan from DataBarangPelanggan inner join Connote "
//                    + "on [DataBarangPelanggan].id_pemesanan = [Connote].id_pemesanan where [Connote].id_connote ='"+in+"'";
//            connection.result = connection.stat.executeQuery(query);
//            int output = 0;
//            while (connection.result.next()) {
//
//                output = Integer.parseInt(connection.result.getString("singkatan"));
//
//            }
//            connection.stat.close();
//            connection.result.close();
//            return output;
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(this, "Error getBerat!!\n" + e.toString());
//        }
//        return 0;
//    }
//    
    private void id(){
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select top 1 id_cargo_manifest as id_cargo from detailCargo order by id_Cargo_manifest desc";
            connection.result = connection.stat.executeQuery(query);
            while (connection.result.next()) {

                txtid_cargo.setText(String.valueOf(connection.result.getString("id_cargo"))); 

            }
            connection.stat.close();
            connection.result.close();
        }catch(Exception e){
        }              
    }
    
    private void inputDetailCargo(){
        int n = calonCargo.size();
        for(int i = 0; i < n ; i++){
            try
            {
                DBConnect c = new DBConnect();
                String query = "INSERT INTO detailCargo VALUES (?,?,?)";
                     c.pstat = c.conn.prepareStatement(query);
                     c.pstat.setString(1, calonCargo.get(i));
                     c.pstat.setString(2, txtid_cargo.getText());
                     c.pstat.setString(3, "Akan dikirim");


                      //insert ke dalam database
                c.pstat.executeUpdate();
                c.pstat.close();
                //JOptionPane.showMessageDialog(this, "insert data detail cargo berhasil");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data detailCargo :" + e);
            }
        }     
    }
    
    private void inputCargoManifest(){
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        String time = formatterTime.format(new Date());
        try
        {
            String query = "UPDATE CargoManifest SET "
                    + "nomor_registrasi=?, nomor_penerbangan=?, "
                    + "bandara_asal=?, bandara_tujuan=?, "
                    + "berat_barang_total=?, jumlah_kantong=?, "
                    + "tanggal_pemberangkatan=?, waktu_pemberangkatan=?, "
                    + "tanggal_sampai=?, waktu_sampai=?, "
                    + "total_biaya=?, status=?"
                    + " WHERE id_cargo_manifest=?"; //+ txtid_cargo.getText()+"'";
            connection.pstat = connection.conn.prepareStatement(query);

            connection.pstat.setString(1, txtnoreg.getText());
            connection.pstat.setString(2, txtnopenerbangan.getText());
            connection.pstat.setString(3, txtbanAsal.getText());
            connection.pstat.setString(4, txtbanTujuan.getText());
            connection.pstat.setString(5, txtberat.getText());
            connection.pstat.setString(6, txtJumkantong.getText());
            connection.pstat.setString(7, formatter.format(dateBerangkat.getDate()));
            connection.pstat.setString(8, txttimeberangkat.getText());//formatterTime.format(formatterTime.parse(txttimeberangkat.getText())));
            connection.pstat.setString(9, formatter.format(dateSampai.getDate()));
            connection.pstat.setString(10, txttimesampai.getText());
            connection.pstat.setString(11, txtharga.getText());
            connection.pstat.setString(12, "sampai");
            connection.pstat.setString(13, txtid_cargo.getText());

            connection.pstat.executeUpdate();
            connection.result.close();

            JOptionPane.showMessageDialog(this, "insert data cargo manifest berhasil");
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi error : " + e);
        }
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
        jLabel5 = new javax.swing.JLabel();
        txttimeberangkat = new javax.swing.JTextField();
        txtberat = new javax.swing.JTextField();
        txtid_cargo = new javax.swing.JTextField();
        txtJumkantong = new javax.swing.JTextField();
        dateBerangkat = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnoreg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtbanAsal = new javax.swing.JTextField();
        txtnopenerbangan = new javax.swing.JTextField();
        txtbanTujuan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dateSampai = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txttimesampai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        btnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Waktu Pemberangkatan");

        jLabel2.setText("ID Cargo Manifest");

        jLabel3.setText("Jumlah Kantong");

        jLabel4.setText("Berat Barang Total");

        jLabel5.setText("Tanggal Pemberangkatan");

        txtid_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_cargoActionPerformed(evt);
            }
        });

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Cargo Manifest");

        jLabel11.setText("Nomor Registrasi");

        jLabel12.setText("Nomor Penerbangan");

        jLabel13.setText("Bandaraa Tujuan");

        jLabel14.setText("Bandara Asal");

        jLabel15.setText("Waktu Sampai");

        jLabel16.setText("Tanggal Sampai");

        jLabel6.setText("Harga");

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(40, 40, 40)))
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnopenerbangan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addComponent(txtbanAsal, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtnoreg)
                                .addComponent(txtbanTujuan))
                            .addComponent(txtid_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(27, 27, 27)
                                .addComponent(dateBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateSampai, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                        .addComponent(txttimeberangkat)
                                        .addComponent(txttimesampai))))))
                    .addComponent(txtJumkantong, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpan)
                .addGap(49, 49, 49)
                .addComponent(btnCetak)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnoreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txttimeberangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnopenerbangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtbanAsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtharga))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtbanTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateSampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txttimesampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJumkantong))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnSimpan)
                    .addComponent(btnCetak))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listBagging l = new listBagging(KantorCabang);
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtid_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_cargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_cargoActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        inputDetailCargo();
        inputCargoManifest();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
       JOptionPane.showMessageDialog(this,"Mencetak ....");
    }//GEN-LAST:event_btnCetakActionPerformed

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
            java.util.logging.Logger.getLogger(CargoManifest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargoManifest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargoManifest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargoManifest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargoManifest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnSimpan;
    private com.toedter.calendar.JDateChooser dateBerangkat;
    private com.toedter.calendar.JDateChooser dateSampai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtJumkantong;
    private javax.swing.JTextField txtbanAsal;
    private javax.swing.JTextField txtbanTujuan;
    private javax.swing.JTextField txtberat;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtid_cargo;
    private javax.swing.JTextField txtnopenerbangan;
    private javax.swing.JTextField txtnoreg;
    private javax.swing.JTextField txttimeberangkat;
    private javax.swing.JTextField txttimesampai;
    // End of variables declaration//GEN-END:variables
}
