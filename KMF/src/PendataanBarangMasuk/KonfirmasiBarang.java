/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PendataanBarangMasuk;

import MainMenu.MainMenuStaff;
import connection.DBConnect;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Polman
 */
public class KonfirmasiBarang extends javax.swing.JFrame {

    /**
     * Creates new form KonfirmasiBarang
     */
    private String namaKantor = "KMF PEMALANG";
    private DefaultTableModel model;

    private String txtid_connote = "";
    private String txtstatus = "";

    public KonfirmasiBarang() {
        initComponents();
        model = new DefaultTableModel();
        addColumn();

        tblBarang.setModel(model);
        addSource("Semua");
    }
    
    public KonfirmasiBarang(String namaKantor) {
        initComponents();
        this.namaKantor = namaKantor;
        model = new DefaultTableModel();
        addColumn();

        tblBarang.setModel(model);
        addSource("Semua");
    }

    private void addColumn() {
        model.addColumn("Connote");
        model.addColumn("Pengirim");
        model.addColumn("Jenis Barang");
        model.addColumn("Jenis Pengiriman");
        model.addColumn("Penerima");
        model.addColumn("Alamat Penerima");
        model.addColumn("Keterangan");
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
        lblmasuk = new javax.swing.JLabel();
        lblkon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblpod = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblkon1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        statlbl = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        btnGagal = new javax.swing.JButton();
        btnBerhasil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 700));

        lblmasuk.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblmasuk.setForeground(new java.awt.Color(255, 255, 255));
        lblmasuk.setText("Data Barang Masuk");
        lblmasuk.setToolTipText("");
        lblmasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmasukMouseClicked(evt);
            }
        });

        lblkon.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblkon.setForeground(new java.awt.Color(255, 255, 255));
        lblkon.setText("Konfirmasi Penerima");
        lblkon.setToolTipText("");
        lblkon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkonMouseClicked(evt);
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

        lblpod.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblpod.setForeground(new java.awt.Color(255, 255, 255));
        lblpod.setText("Print Out Delivery");
        lblpod.setToolTipText("");
        lblpod.setPreferredSize(new java.awt.Dimension(240, 700));
        lblpod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblpodMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setToolTipText("");

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainMenu/b.png"))); // NOI18N
        jLabel25.setToolTipText("");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        lblkon1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblkon1.setForeground(new java.awt.Color(255, 255, 255));
        lblkon1.setText("Konfirmasi Barang");
        lblkon1.setToolTipText("");
        lblkon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkon1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblkon1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblkon, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpod, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(13, 13, 13)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblkon1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblkon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblpod, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("List Penerimaan Barang");

        statlbl.setText("Status Penerimaan");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Sampai", "Gagal" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

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

        btnGagal.setBackground(new java.awt.Color(204, 255, 204));
        btnGagal.setText("Konfirmasi Gagal");
        btnGagal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGagalActionPerformed(evt);
            }
        });

        btnBerhasil.setBackground(new java.awt.Color(204, 255, 204));
        btnBerhasil.setText("Konfirmasi Berhasil");
        btnBerhasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerhasilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGagal)
                        .addGap(696, 696, 696)
                        .addComponent(btnBerhasil)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(353, 353, 353))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statlbl)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(statlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGagal)
                    .addComponent(btnBerhasil))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblmasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmasukMouseClicked
        PendataanCargo cargo = new PendataanCargo(namaKantor);
        cargo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblmasukMouseClicked

    private void lblkonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkonMouseClicked
        KonfirmasiPenerima s = new KonfirmasiPenerima(namaKantor);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblkonMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        MainMenuStaff t = new MainMenuStaff(namaKantor);
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void lblpodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpodMouseClicked
        POD p = new POD(namaKantor);
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblpodMouseClicked

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
        String status;
        status = (String) cmbStatus.getSelectedItem();
        addSource(status);
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int i = tblBarang.getSelectedRow();
        if (i == -1) {
            return;
        }
        txtid_connote = ((String) model.getValueAt(i, 0));
        txtstatus = ((String) model.getValueAt(i, 6));
        JOptionPane.showMessageDialog(this, txtid_connote +" Dipilih");
        //txtnama_penerima.setText((String) model.getValueAt(i, 1));

    }//GEN-LAST:event_tblBarangMouseClicked

    private void btnGagalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGagalActionPerformed
        // TODO add your handling code here:
        if (!txtid_connote.equals("")) {
            Object[] options = {"Konfirmasi",
                "Batal"};
            int n;
            penjemputan:
            {
                n = JOptionPane.showOptionDialog(this,
                        "Konfirmasi GAGAL cargo masuk untuk ID\n"
                        + "ID Connote          : " + txtid_connote,
                        "Pertanyaan",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
            }
            if (n == 0) {
                addRiwayat1();
                JOptionPane.showMessageDialog(this,
                    "Konfirmasi berhasil");
            } else if (n == 1) {
                JOptionPane.showMessageDialog(this,
                        "Batal!");
                addSource(cmbStatus.getSelectedItem().toString());
            }
            
        } else {
            JOptionPane.showMessageDialog(this,
                    "Tidak bisa konfirmasi");

        }
        addSource(cmbStatus.getSelectedItem().toString());
    }//GEN-LAST:event_btnGagalActionPerformed

    private void btnBerhasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBerhasilActionPerformed
        // TODO add your handling code here:
        if (!txtid_connote.equals("")) {
            Object[] options = {"Konfirmasi",
                "Batal"};
            int n;
            penjemputan:
            {
                n = JOptionPane.showOptionDialog(this,
                        "Konfirmasi barang masuk untuk \n"
                        + "ID Connote          : " + txtid_connote,
                        "Pertanyaan",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
            }
            if (n == 0) {
                addRiwayat();
                JOptionPane.showMessageDialog(this,
                    "Konfirmasi berhasil");
            } else if (n == 1) {
                JOptionPane.showMessageDialog(this,
                        "Batal!");
            }
            
        } else {
            JOptionPane.showMessageDialog(this,
                    "Tidak bisa konfirmasi");
        }
        addSource(cmbStatus.getSelectedItem().toString());
    }//GEN-LAST:event_btnBerhasilActionPerformed

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void lblkon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkon1MouseClicked
       KonfirmasiBarang k = new KonfirmasiBarang(namaKantor);
       k.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_lblkon1MouseClicked

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
            java.util.logging.Logger.getLogger(KonfirmasiBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonfirmasiBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBerhasil;
    private javax.swing.JButton btnGagal;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblkon;
    private javax.swing.JLabel lblkon1;
    private javax.swing.JLabel lblmasuk;
    private javax.swing.JLabel lblpod;
    private javax.swing.JLabel statlbl;
    private javax.swing.JTable tblBarang;
    // End of variables declaration//GEN-END:variables

    private void addRiwayat1() {
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("hh:mm:ss");

        try {
            DBConnect c = new DBConnect();
            String query = "INSERT INTO Riwayat VALUES (?,?,?,?)";
            c.pstat = c.conn.prepareStatement(query);
            c.pstat.setString(1, formatter.format(new Date()));
            c.pstat.setString(2, formatterTime.format(new Date()));
            c.pstat.setString(3, "Tidak sampai di kantor tujuan");
            c.pstat.setString(4, getIDPemesanan());

            //insert ke dalam database
            c.pstat.executeUpdate();
            c.pstat.close();
            //JOptionPane.showMessageDialog(this, "insert data Baggin berhasil");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi error pada saat insert data riwayat :" + e);
        }

        updateStatusBarang1();

    }

        private void updateStatusBarang1() {

        try {
            DBConnect connection = new DBConnect();
            String query = "UPDATE DataBarangPelanggan SET status_barang = 'Tidak sampai kantor di kantor tujuan' WHERE id_pemesanan=?";
            JOptionPane.showMessageDialog(this, getIDPemesanan());
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, getIDPemesanan());

            connection.pstat.executeUpdate();
            connection.pstat.close();
        } catch (Exception e) {
            System.out.println("Terjadi error saat updateStatusBarang: " + e.toString());
        }
        updateStatusConnote();
    }

    private String getKotaKantor() {
        DBConnect connection = new DBConnect();
        try {
            connection.stat = connection.conn.createStatement();
            String query = "select kota from KantorCabang where kode_kantor_cabang = '" + getIDKantor(namaKantor) + "'";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("kota"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error getSingkatan!!\n" + e.toString());
        }
        return null;
    }

    private void addSource(String status) {
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();

        try {

            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query;

            if (status.equals("Semua")) {
                query = "select [Connote].id_connote, [b].nama_pelanggan, [a].jenis_barang, c.jns_nama, a.nama_penerima, a.alamat_penerima, [Connote].status_pengiriman from\n"
                        + "Connote inner join DataBarangPelanggan a on Connote.id_pemesanan = a.id_pemesanan\n"
                        + "inner join Pelanggan b on [a].id_pelanggan = [b].id_pelanggan\n"
                        + "inner join JenisPaket c on [a].jns_id = c.jns_id \n"
                        + "inner join KantorCabang d on a.kode_kantor_cabang = d.kode_kantor_cabang\n"
                        + "inner join KotaKabupaten e on a.kota_penerima = e.nama_kota\n"
                        + "inner join detailBagging db on db.id_connote = Connote.id_connote\n"
                        + "inner join detailCargo dc on dc.id_bagging = db.id_bagging\n"
                        + "inner join CargoManifest cm on cm.id_cargo_manifest = dc.id_cargo_manifest\n"
                        + "where\n"
                        + "e.singkatan = '" + getKotaKantor() + "' and Connote.status_pengiriman = 'Dikirim' and\n"
                        +"a.status_barang != 'Sampai di kantor tujuan' and a.status_barang != 'Tidak sampai kantor di kantor tujuan'";
            } else {
                query = "select [Connote].id_connote, [b].nama_pelanggan, [a].jenis_barang, c.jns_nama, a.nama_penerima, a.alamat_penerima, [Connote].status_pengiriman from\n"
                        + "Connote inner join DataBarangPelanggan a on Connote.id_pemesanan = a.id_pemesanan\n"
                        + "inner join Pelanggan b on [a].id_pelanggan = [b].id_pelanggan\n"
                        + "inner join JenisPaket c on [a].jns_id = c.jns_id \n"
                        + "inner join KantorCabang d on a.kode_kantor_cabang = d.kode_kantor_cabang\n"
                        + "inner join KotaKabupaten e on a.kota_penerima = e.nama_kota\n"
                        + "inner join detailBagging db on db.id_connote = Connote.id_connote\n"
                        + "inner join detailCargo dc on dc.id_bagging = db.id_bagging\n"
                        + "inner join CargoManifest cm on cm.id_cargo_manifest = dc.id_cargo_manifest\n"
                        + "where\n"
                        + "e.singkatan = '" + getKotaKantor() + "' and "
                        + "cm.status = '" + status + "' and Connote.status_pengiriman = 'Dikirim' and\n"
                        + "a.status_barang != 'Sampai di kantor tujuan' and a.status_barang != 'Tidak sampai kantor di kantor tujuan'";
                
            }

            //   JOptionPane.showMessageDialog(this, query);
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            while (connection.result.next()) {
                Object obj[] = new Object[7];
                obj[0] = connection.result.getString("id_connote");
                obj[1] = connection.result.getString("nama_pelanggan");
                obj[2] = connection.result.getString("jenis_barang");
                obj[3] = connection.result.getString("jns_nama");
                obj[4] = connection.result.getString("nama_penerima");
                obj[5] = connection.result.getString("alamat_penerima");
                obj[6] = connection.result.getString("status_pengiriman");

                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    private void updateStatusConnote() {
        DBConnect connection = new DBConnect();
        try {
            String query;

            
                query = "UPDATE Connote SET status_pengiriman='Gagal' WHERE id_connote='" + txtid_connote + "'";
            

            connection.pstat = connection.conn.prepareStatement(query);

            connection.pstat.executeUpdate();
            //connection.result.close();
            
            addSource(cmbStatus.getSelectedItem().toString());
            //JOptionPane.showMessageDialog(this, "Bagging berhasil");
        } catch (Exception e) {
            System.out.println("Terjadi error saat update status Connote: " + e.toString());
        }
    }
    private void addRiwayat() {
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("hh:mm:ss");

        try {
            DBConnect c = new DBConnect();
            String query = "INSERT INTO Riwayat VALUES (?,?,?,?)";
            c.pstat = c.conn.prepareStatement(query);
            c.pstat.setString(1, formatter.format(new Date()));
            c.pstat.setString(2, formatterTime.format(new Date()));
            c.pstat.setString(3, "Sampai di kantor tujuan");
            c.pstat.setString(4, getIDPemesanan());

            //insert ke dalam database
            c.pstat.executeUpdate();
            c.pstat.close();
            //JOptionPane.showMessageDialog(this, "insert data Baggin berhasil");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi error pada saat insert data riwayat :" + e);
        }

        updateStatusBarang();

    }

    private void updateStatusBarang() {

        try {
            DBConnect connection = new DBConnect();
            String query = "UPDATE DataBarangPelanggan SET status_barang = 'Sampai di kantor tujuan' WHERE id_pemesanan=?";
            //System.out.println(query);
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, getIDPemesanan());

            connection.pstat.executeUpdate();
            connection.pstat.close();
        } catch (Exception e) {
            System.out.println("Terjadi error saat updateStatusBarang: " + e.toString());
        }

    }

    private String getIDPemesanan() {
        DBConnect connection = new DBConnect();
        try {
            connection.stat = connection.conn.createStatement();
            String query = "select dp.id_pemesanan from DataBarangPelanggan dp inner join Connote c on c.id_pemesanan = dp.id_pemesanan where c.id_connote = '" + txtid_connote + "'";
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("id_pemesanan"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "getIDPemesanan!!\n" + e.toString());
        }
        return null;
    }

    private String getIDKantor(String in) {
        DBConnect connection = new DBConnect();
        try {
            connection.stat = connection.conn.createStatement();
            String query = "select kode_kantor_cabang from KantorCabang where nama_kantor = '" + in + "'";
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("kode_kantor_cabang"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;
    }
}
