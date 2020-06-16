/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransaksiPengirimanBarang;

import List.*;
import MainMenu.Login;
import MainMenu.MainMenuStaffKirim;
import connection.DBConnect;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * (-) Belum memunculkan data barang berdasarkan kantor yang log in
 * @author user
 */
public class CekDoc extends javax.swing.JFrame {

    /**
     * Creates new form CekDoc
     */
    private String id_pemesanan;
    private String id_connote;
    public CekDoc() {
        initComponents();
        model = new DefaultTableModel();
        addColomn();
        tblList.setModel(model);
        liatdata();
    }
    DefaultTableModel model;
    public void addColomn() {
        model.addColumn("ID Connote");
        model.addColumn("ID Pemesanan");
        model.addColumn("Jenis Barang");
        model.addColumn("Berat Barang");
        model.addColumn("Nama Penerima");
        model.addColumn("Alamat Penerima");
        model.addColumn("Kota Penerima");
        model.addColumn("No Telphone Penerima");
        model.addColumn("Total harga");
        model.addColumn("Keterangan Pembayaran");
    }

    public void liatdata(){
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();
        try{
            DBConnect c = new DBConnect();
            c.stat = c.conn.createStatement();
            String sql = "SELECT * FROM Connote join DataBarangPelanggan  on Connote.id_pemesanan = DataBarangPelanggan.id_pemesanan and DataBarangPelanggan.status_barang != 'Barang siap berangkat' and Connote.status_pengiriman = 'Belum'";
            c.result = c.stat.executeQuery(sql);
            
            while (c.result.next()) {
                    Object[] obj = new Object[10];
                    obj[0] = c.result.getString("id_connote");
                    obj[1] = c.result.getString("id_pemesanan");
                    obj[2] = c.result.getString("jenis_barang");
                    obj[3] = c.result.getString("berat_barang");
                    obj[4] = c.result.getString("nama_penerima");
                    obj[5] = c.result.getString("alamat_penerima");
                    obj[6] = c.result.getString("kota_penerima");
                    obj[7] = c.result.getString("no_telphone_penerima");
                    obj[8] = c.result.getString("total_harga");
                    obj[9] = c.result.getString("keterangan_pembayaran");

                    model.addRow(obj);

            }
            c.stat.close();
            c.result.close();  
        } catch (SQLException ex){
            System.out.println("Terjadi error"+ex);
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

        btnKembali = new javax.swing.JButton();
        btnKomen = new javax.swing.JButton();
        btnSesuai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKomen = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnKomen.setText("Komentar");
        btnKomen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKomenActionPerformed(evt);
            }
        });

        btnSesuai.setText("Sesuai");
        btnSesuai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesuaiActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("List Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tblList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblList);

        txtKomen.setColumns(20);
        txtKomen.setRows(5);
        jScrollPane1.setViewportView(txtKomen);

        jLabel2.setText("Komentar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnKembali)
                        .addGap(182, 182, 182)
                        .addComponent(btnKomen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSesuai)
                        .addGap(164, 164, 164))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(540, 540, 540))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKembali)
                    .addComponent(btnKomen)
                    .addComponent(btnSesuai))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        MainMenuStaffKirim MainMenuStaffKirim = new MainMenuStaffKirim();
        this.setVisible(false);
        MainMenuStaffKirim.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnSesuaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesuaiActionPerformed
        // TODO add your handling code here:
        DBConnect connection = new DBConnect();
        try {
                
                String query = "UPDATE DataBarangPelanggan SET status_barang = 'Barang siap berangkat' WHERE id_pemesanan=?";
                //System.out.println(query);
                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, id_pemesanan);

                connection.pstat.executeUpdate();
                connection.pstat.close();
                JOptionPane.showMessageDialog(this, "Data barang telah sesuai");
            }
        catch (SQLException e) {
            System.out.println("Terjadi error saat menambahkan komentar: " + e.toString());
        }
       liatdata(); 
    }//GEN-LAST:event_btnSesuaiActionPerformed
    private void ubahStatusGagal(){
        DBConnect connection = new DBConnect();
        try {
                
                String query = "UPDATE Connote SET status_pengiriman = 'Gagal' WHERE id_connote=?";
                //System.out.println(query);
                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, id_connote);

                connection.pstat.executeUpdate();
                connection.pstat.close();
            }
        catch (SQLException e) {
            System.out.println("Terjadi error saat menambahkan komentar: " + e.toString());
        }
        liatdata();
    }
    private void btnKomenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKomenActionPerformed
        // TODO add your handling code here:
//        CommentCek Comment = new CommentCek();
//        this.setVisible(true);
//        Comment.setVisible(true);
        
        
        //System.out.println(id_pemesanan);
        DBConnect connection = new DBConnect();
        try {
                
                String query = "UPDATE DataBarangPelanggan SET status_barang = ? WHERE id_pemesanan=?";
                //System.out.println(query);
                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, txtKomen.getText());
                connection.pstat.setString(2, id_pemesanan);

                connection.pstat.executeUpdate();
                connection.pstat.close();
                JOptionPane.showMessageDialog(this, "Menambah komentar berhasil");
                ubahStatusGagal();
            }
            catch (SQLException e) {
                System.out.println("Terjadi error saat menambahkan komentar: " + e.toString());
            }
        
    }//GEN-LAST:event_btnKomenActionPerformed
    
    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        // TODO add your handling code here:
        int i = tblList.getSelectedRow();
        
        if(i != -1){
            id_pemesanan = tblList.getValueAt(i, 1).toString();
            id_connote = tblList.getValueAt(i, 0).toString();
        }
        
        JOptionPane.showMessageDialog(this,id_connote +" Dipilih");
    }//GEN-LAST:event_tblListMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(CekDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CekDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CekDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CekDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CekDoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnKomen;
    private javax.swing.JButton btnSesuai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblList;
    private javax.swing.JTextArea txtKomen;
    // End of variables declaration//GEN-END:variables
}
