/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransaksiPengambilanBarang;

import MainMenu.Login;
import TransaksiPengirimanBarang.ListCargo;
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
 * @author Polman
 */
public class KonfirmasiPickUp extends javax.swing.JFrame {

    /**
     * Creates new form KonfirmasiPickUp
     */
    private String id = "";
    private String KantorCabang = "KMF JKT";
    private DefaultTableModel model;
            
    private List<String> txtid_pemesanan = new ArrayList();
    private String txtstatus = "";
    public KonfirmasiPickUp() {
        initComponents();
        model = new DefaultTableModel();
        addColumn();
        
        
        tblBarang.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        statlbl = new javax.swing.JLabel();
        txtid_driver = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNama_driver = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnKonfirmasiSemua = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(958, 701));

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nama Barang"
            }
        ));
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBarang);

        statlbl.setText("ID Driver");

        txtid_driver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtid_driverKeyReleased(evt);
            }
        });

        jLabel1.setText("Nama");

        txtNama_driver.setEnabled(false);
        txtNama_driver.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNama_driverPropertyChange(evt);
            }
        });

        btnRefresh.setText("R");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnKonfirmasiSemua.setText("Konfirmasi semua");
        btnKonfirmasiSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfirmasiSemuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKonfirmasiSemua)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtid_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNama_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(510, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(69, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid_driver)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtNama_driver)))
                .addGap(336, 336, 336)
                .addComponent(btnKonfirmasiSemua)
                .addGap(120, 120, 120))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(159, 159, 159)
                    .addComponent(statlbl)
                    .addGap(56, 56, 56)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(161, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(240, 700));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pemesanan");
        jLabel3.setToolTipText("");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Update Pick Up");
        jLabel4.setToolTipText("");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Keluar");
        jLabel5.setToolTipText("");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Konfirmasi Pemberangkatan");
        jLabel6.setToolTipText("");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainMenu/b.png"))); // NOI18N
        jLabel7.setToolTipText("");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void addColumn() {
        model.addColumn("No");
        model.addColumn("ID Pemesanan");
        model.addColumn("Pengirim");
        model.addColumn("Jenis Barang");
        model.addColumn("Alamat jemput");
        model.addColumn("Kota Penjemputan");
    }
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        TransaksiPemesanan transaksi = new TransaksiPemesanan(id, KantorCabang);
        transaksi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        LihatStatusPickUp s = new LihatStatusPickUp(id, KantorCabang);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Login t= new Login();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        ListCargo c = new ListCargo(id, KantorCabang);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int i = tblBarang.getSelectedRow();
        if (i == -1) {
            return;
        }
        
        txtid_pemesanan.add(((String) model.getValueAt(i, 1)));
        
        Object[] options = {"Konfirmasi berhasil",
                "Konfirmasi batal"};
            int n;

        
            
            penjemputan:
            {
                n = JOptionPane.showOptionDialog(this,
                        "Konfirmasi data pick up\n"
                        + "ID Pemesanan\t: " + txtid_pemesanan.get(0),
                        "Pertanyaan",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                        );
            }
            if (n == 0) {
                addRiwayat();
            } else if (n == 1) {
                addRiwayat1();
            }else{
                JOptionPane.showMessageDialog(this,
                        "Batal!");
            }
        //txtnama_penerima.setText((String) model.getValueAt(i, 1));
    }//GEN-LAST:event_tblBarangMouseClicked

    private void txtid_driverKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_driverKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtid_driverKeyReleased

    private void txtNama_driverPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNama_driverPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNama_driverPropertyChange

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        /// Cari nama driver
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        try {

            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "select d.nama_staff from Driver d inner join KantorCabang kc on d.kode_kantor_cabang = kc.kode_kantor_cabang where kc.nama_kantor = '"+KantorCabang+"' and d.ID_Staff ='"+txtid_driver.getText()+"'";

            

            //   JOptionPane.showMessageDialog(this, query);
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            while (connection.result.next()) {
                txtNama_driver.setText(connection.result.getString("nama_staff"));
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        //Cari data pickup driver
        addData();
    }//GEN-LAST:event_btnRefreshActionPerformed
    private void addData(){
        try {

            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "select dp.id_pemesanan, p.nama_pelanggan, dtg.jenis_barang, dp.alamat_penjemputan, dp.kota_penjemputan  from detailPickUp dp "
                    + "inner join DataBarangPelanggan dtg on dp.id_pemesanan = dtg.id_pemesanan inner join Pelanggan p on p.id_pelanggan = dtg.id_pelanggan "+
                    "where dp.ID_Staff ='"+txtid_driver.getText()+"' and dp.keterangan= 'Belum'";
                    

            //   JOptionPane.showMessageDialog(this, query);
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            int i = 1;
            while (connection.result.next()) {
                Object obj[] = new Object[6];
                obj[0] = i;
                obj[1] = connection.result.getString("id_pemesanan");
                obj[2] = connection.result.getString("nama_pelanggan");
                obj[3] = connection.result.getString("jenis_barang");
                obj[4] = connection.result.getString("alamat_penjemputan");
                obj[5] = connection.result.getString("kota_penjemputan");
                
                i++;
                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    private void btnKonfirmasiSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfirmasiSemuaActionPerformed
        // TODO add your handling code here:
        for(int i = 0 ; i < model.getRowCount() ; i++){
            txtid_pemesanan.add((String) model.getValueAt(i, 1));
        }
        if(txtid_pemesanan.size() == 0){
            JOptionPane.showMessageDialog(this, "Tidak ada data");
            return;
        }
        addRiwayat();
    }//GEN-LAST:event_btnKonfirmasiSemuaActionPerformed
    
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
            java.util.logging.Logger.getLogger(KonfirmasiPickUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPickUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPickUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPickUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonfirmasiPickUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKonfirmasiSemua;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel statlbl;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtNama_driver;
    private javax.swing.JTextField txtid_driver;
    // End of variables declaration//GEN-END:variables
    
    private void addRiwayat() {
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("hh:mm:ss");
        for(int i = 0; i< txtid_pemesanan.size(); i++){
            try {
            DBConnect c = new DBConnect();
            String query = "INSERT INTO Riwayat VALUES (?,?,?,?)";
            c.pstat = c.conn.prepareStatement(query);
            c.pstat.setString(1, formatter.format(new Date()));
            c.pstat.setString(2, formatterTime.format(new Date()));
            c.pstat.setString(3, "Telah dipickup, sedang diproses");
            c.pstat.setString(4, txtid_pemesanan.get(i));

            //insert ke dalam database
            c.pstat.executeUpdate();
            c.pstat.close();
            //JOptionPane.showMessageDialog(this, "insert data Baggin berhasil");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi error pada saat insert data riwayat :" + e);
            }
        }
        updateStatusBarang();
        
    }
    private void updateStatusBarang() {
        for(int i = 0 ; i < txtid_pemesanan.size(); i++){
            try {
            DBConnect connection = new DBConnect();
            String query = "UPDATE DataBarangPelanggan SET status_barang = 'Telah dipickup, sedang diproses' WHERE id_pemesanan=?";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, txtid_pemesanan.get(i));

            connection.pstat.executeUpdate();
            connection.pstat.close();
            } catch (Exception e) {
                System.out.println("Terjadi error saat updateStatusBarang: " + e.toString());
            }
        }
        
        updateStatusDetail();
    }
    private void updateStatusDetail() {
        for(int i = 0 ; i < txtid_pemesanan.size(); i++){
            try {
            DBConnect connection = new DBConnect();
            String query = "UPDATE DetailPickUp SET keterangan = 'Sudah' WHERE id_pemesanan=?";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, txtid_pemesanan.get(i));

            connection.pstat.executeUpdate();
            connection.pstat.close();
            } catch (Exception e) {
                System.out.println("Terjadi error saat updateStatusBarang: " + e.toString());
            }
        }
        JOptionPane.showMessageDialog(this, "Konfirmasi berhasil");
        txtid_pemesanan.clear();
        updateStatusDriver();
        addData();
    }
    private void updateStatusDriver() {
        
        try {
            DBConnect connection = new DBConnect();
            String query = "UPDATE Driver SET Status_pickup = 'Tidak aktif' WHERE ID_Staff='"+txtid_driver.getText()+"'";
            connection.pstat = connection.conn.prepareStatement(query);

                System.out.println(query);
            connection.pstat.executeUpdate();
            connection.pstat.close();
        } catch (Exception e) {
            System.out.println("Terjadi error saat updateStatusBarang: " + e.toString());
        }
        addData();
    }
    private void addRiwayat1() {
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("hh:mm:ss");
        for(int i = 0; i< txtid_pemesanan.size(); i++){
            try {
            DBConnect c = new DBConnect();
            String query = "INSERT INTO Riwayat VALUES (?,?,?,?)";
            c.pstat = c.conn.prepareStatement(query);
            c.pstat.setString(1, formatter.format(new Date()));
            c.pstat.setString(2, formatterTime.format(new Date()));
            c.pstat.setString(3, "Pick up gagal, transaksi dibatalkan");
            c.pstat.setString(4, txtid_pemesanan.get(i));

            //insert ke dalam database
            c.pstat.executeUpdate();
            c.pstat.close();
            //JOptionPane.showMessageDialog(this, "insert data Baggin berhasil");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi error pada saat insert data riwayat :" + e);
            }
        }
        updateStatusBarang1();
        
    }
    private void updateStatusBarang1() {
        for(int i = 0 ; i < txtid_pemesanan.size(); i++){
            try {
            DBConnect connection = new DBConnect();
            String query = "UPDATE DataBarangPelanggan SET status_barang = 'Pick up gagal, transaksi dibatalkan' WHERE id_pemesanan=?";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, txtid_pemesanan.get(i));

            connection.pstat.executeUpdate();
            connection.pstat.close();
            } catch (Exception e) {
                System.out.println("Terjadi error saat updateStatusBarang: " + e.toString());
            }
        }
        updateStatusDetail();
        
    }

}