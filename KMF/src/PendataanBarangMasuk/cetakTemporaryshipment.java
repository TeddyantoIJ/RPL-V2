/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PendataanBarangMasuk;

import FormCetak.PrintTemporary;
import MainMenu.Login;
import MainMenu.MainMenuDispatch;
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
public class cetakTemporaryshipment extends javax.swing.JFrame {

    /**
     * Creates new form cetakTemporaryshipment
     */
    private DefaultTableModel model;
    private DefaultTableModel modelTemp;
    private String KantorCabang = "KMF JKT";

    private String kode = "";

    public cetakTemporaryshipment() {
        initComponents();
        model = new DefaultTableModel();
        modelTemp = new DefaultTableModel();
        tablePemesanan.setModel(model);
        tableTemp.setModel(modelTemp);

        addDataColumn();

    }

    public cetakTemporaryshipment(String kantorCabang) {
        initComponents();
        model = new DefaultTableModel();
        modelTemp = new DefaultTableModel();
        tablePemesanan.setModel(model);
        tableTemp.setModel(modelTemp);

        this.KantorCabang = kantorCabang;
        addDataColumn();

    }

    private void addColumn() {
        txtkantorCabang.setText(KantorCabang);

        model.addColumn("ID Pemesanan");
        model.addColumn("Nama Pengirim");
        model.addColumn("Jenis Barang");
        model.addColumn("Keterangan Barang");
        model.addColumn("Nama Penerima");
        model.addColumn("Alamat Penerima");
        model.addColumn("Kota Penerima");
        model.addColumn("No Penerima");

        modelTemp.addColumn("ID Pemesanan");
        modelTemp.addColumn("Nama Pengirim");
        modelTemp.addColumn("Jenis Barang");
        modelTemp.addColumn("Keterangan Barang");
        modelTemp.addColumn("Nama Penerima");
        modelTemp.addColumn("Alamat Penerima");
        modelTemp.addColumn("Kota Penerima");
        modelTemp.addColumn("No Penerima");

    }

    private void addDataColumn() {

        addColumn();
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();

        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query
                    = "select d.id_pemesanan, p.nama_pelanggan, d.jenis_barang, d.keterangan_barang, d.nama_penerima,"
                    + " d.alamat_penerima, d.kota_penerima, d.no_telphone_penerima from DataBarangPelanggan d inner join Pelanggan p on d.id_pelanggan = p.id_pelanggan \n"
                    + "where d.kode_kantor_cabang = '" + getIDKantor(KantorCabang) + "' and d.status_barang = 'Sedang diproses pada kantor pengirim' or d.status_barang = 'Segera dipickup'";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                Object[] obj = new Object[8];

                obj[0] = connection.result.getString("id_pemesanan");
                obj[1] = connection.result.getString("nama_pelanggan");
                obj[2] = connection.result.getString("jenis_barang");
                obj[3] = connection.result.getString("keterangan_barang");
                obj[4] = connection.result.getString("nama_penerima");
                obj[5] = connection.result.getString("alamat_penerima");
                obj[6] = connection.result.getString("kota_penerima");
                obj[7] = connection.result.getString("no_telphone_penerima");

                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal111!\n" + e.toString());
        }
    }

    private void addDataTemp() {
        if (adaDiTemp()) {
            return;
        }
        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query
                    = "select d.id_pemesanan, p.nama_pelanggan, d.jenis_barang, d.keterangan_barang, d.nama_penerima,"
                    + " d.alamat_penerima, d.kota_penerima, d.no_telphone_penerima from DataBarangPelanggan d inner join Pelanggan p on d.id_pelanggan = p.id_pelanggan \n"
                    + "where d.id_pemesanan = '" + kode + "'";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                Object[] obj = new Object[8];

                obj[0] = connection.result.getString("id_pemesanan");
                obj[1] = connection.result.getString("nama_pelanggan");
                obj[2] = connection.result.getString("jenis_barang");
                obj[3] = connection.result.getString("keterangan_barang");
                obj[4] = connection.result.getString("nama_penerima");
                obj[5] = connection.result.getString("alamat_penerima");
                obj[6] = connection.result.getString("kota_penerima");
                obj[7] = connection.result.getString("no_telphone_penerima");

                modelTemp.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
            //model.fireTableDataChanged();
            removePemesanan();
            kode = "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "addDataTemp!\n" + e.toString());
        }
    }

    private void removePemesanan() {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (kode.equals(model.getValueAt(i, 0))) {
                model.removeRow(i);
            }
        }
        model.fireTableDataChanged();
    }

    private void removeTemp() {
        for (int i = 0; i < modelTemp.getRowCount(); i++) {
            if (kode.equals(modelTemp.getValueAt(i, 0))) {
                modelTemp.removeRow(i);
            }
        }
        modelTemp.fireTableDataChanged();
    }

    private String getIDKantor(String in) {
        DBConnect connection = new DBConnect();
        try {
            connection.stat = connection.conn.createStatement();
            String query = "select kode_kantor_cabang from KantorCabang where nama_kantor = '" + in + "'";
            connection.result = connection.stat.executeQuery(query);
            System.out.println(query);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePemesanan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtkantorCabang = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTemp = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnMasukkan = new javax.swing.JButton();
        btnBatalkan = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 700));

        jLabel1.setText("CETAK TEMPORARY SHIPMENT");

        tablePemesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePemesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePemesanan);

        jLabel4.setText("Kantor Cabang");

        txtkantorCabang.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtkantorCabang.setText("jLabel5");

        tableTemp.setModel(new javax.swing.table.DefaultTableModel(
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
        tableTemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTempMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableTemp);

        jLabel2.setText("DAFTAR CETAK TEMPORARY SHIPMENT");

        btnMasukkan.setBackground(new java.awt.Color(204, 255, 204));
        btnMasukkan.setText("Masukkan ke daftar");
        btnMasukkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukkanActionPerformed(evt);
            }
        });

        btnBatalkan.setBackground(new java.awt.Color(204, 255, 204));
        btnBatalkan.setText("Batalkan");
        btnBatalkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalkanActionPerformed(evt);
            }
        });

        btnCetak.setBackground(new java.awt.Color(204, 255, 204));
        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnKembali.setBackground(new java.awt.Color(204, 255, 204));
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnMasukkan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(407, 407, 407)
                                .addComponent(btnBatalkan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(640, 640, 640)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtkantorCabang, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(txtkantorCabang)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMasukkan)
                    .addComponent(btnBatalkan))
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(122, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCetak)
                            .addComponent(btnKembali))
                        .addGap(77, 77, 77))))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 700));

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Cetak Temporary Shipment");
        jLabel29.setToolTipText("");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Keluar");
        jLabel31.setToolTipText("");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setToolTipText("");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablePemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePemesananMouseClicked
        // TODO add your handling code here:
        int row = tablePemesanan.getSelectedRow();
        if (row == -1) {
            return;
        }

        kode = tablePemesanan.getValueAt(row, 0).toString();
    }//GEN-LAST:event_tablePemesananMouseClicked

    private void btnMasukkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukkanActionPerformed
        // TODO add your handling code here:
        if (!kode.equals("")) {
            addDataTemp();
        }
    }//GEN-LAST:event_btnMasukkanActionPerformed

    private void tableTempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTempMouseClicked
        // TODO add your handling code here:
        int row = tableTemp.getSelectedRow();
        if (row == -1) {
            return;
        }

        kode = tableTemp.getValueAt(row, 0).toString();

    }//GEN-LAST:event_tableTempMouseClicked

    private void btnBatalkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalkanActionPerformed
        // TODO add your handling code here:
        if (!kode.equals("")) {
            rollBackAdding();
        }
    }//GEN-LAST:event_btnBatalkanActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        int count = tableTemp.getRowCount();
        if (count == 0) {
            return;
        }
        List<String> id_pemesanan = new ArrayList();
        for (int i = count-1; i >= 0; i--) {
            kode = tableTemp.getValueAt(i, 0).toString();
            //updateStatusBarang();
            id_pemesanan.add(kode);
            modelTemp.removeRow(i);
        }
        PrintTemporary cetakTemp = new PrintTemporary(id_pemesanan);
        cetakTemp.setVisible(true);
        
        kode = "";
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        MainMenuDispatch cs = new MainMenuDispatch(KantorCabang);
        this.setVisible(false);
        cs.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        cetakTemporaryshipment ct = new cetakTemporaryshipment(KantorCabang);
        this.setVisible(false);
        ct.setVisible(true);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        Login t= new Login();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked
    private void updateStatusBarang() {
        DBConnect connection = new DBConnect();
        try {
            String query;

            query = "UPDATE DataBarangPelanggan SET status_barang='Connote barang segera dicetak' WHERE id_pemesanan='" + kode + "'";

            connection.pstat = connection.conn.prepareStatement(query);

            connection.pstat.executeUpdate();
            //connection.result.close();
            addRiwayat();
            //JOptionPane.showMessageDialog(this, "Bagging berhasil");
        } catch (Exception e) {
            System.out.println("Terjadi error saat updateStatusBarang: " + e.toString());
        }
    }

    private void addRiwayat(){
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("hh:mm:ss");
        
            try
            {
                DBConnect c = new DBConnect();
                String query = "INSERT INTO Riwayat VALUES (?,?,?,?)";
                     c.pstat = c.conn.prepareStatement(query);
                     c.pstat.setString(1, formatter.format(new Date()));
                     c.pstat.setString(2, formatterTime.format(new Date()));
                     c.pstat.setString(3, "Connote barang segera dicetak");
                     c.pstat.setString(4, kode);

                      //insert ke dalam database
                c.pstat.executeUpdate();
                c.pstat.close();
                //JOptionPane.showMessageDialog(this, "insert data Baggin berhasil");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Terjadi error pada addRiwayat :" + e);
            }        
    }
    private boolean adaDiPemesanan() {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (kode.equals(model.getValueAt(i, 0))) {
                return true;
            }
        }
        return false;
    }

    private boolean adaDiTemp() {
        for (int i = 0; i < modelTemp.getRowCount(); i++) {
            if (kode.equals(modelTemp.getValueAt(i, 0))) {
                return true;
            }
        }
        return false;
    }

    private void rollBackAdding() {
        if (adaDiPemesanan()) {
            return;
        }
        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query
                    = "select d.id_pemesanan, p.nama_pelanggan, d.jenis_barang, d.keterangan_barang, d.nama_penerima,"
                    + " d.alamat_penerima, d.kota_penerima, d.no_telphone_penerima from DataBarangPelanggan d inner join Pelanggan p on d.id_pelanggan = p.id_pelanggan \n"
                    + "where d.id_pemesanan = '" + kode + "'";
            //System.out.println(query);
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                Object[] obj = new Object[8];

                obj[0] = connection.result.getString("id_pemesanan");
                obj[1] = connection.result.getString("nama_pelanggan");
                obj[2] = connection.result.getString("jenis_barang");
                obj[3] = connection.result.getString("keterangan_barang");
                obj[4] = connection.result.getString("nama_penerima");
                obj[5] = connection.result.getString("alamat_penerima");
                obj[6] = connection.result.getString("kota_penerima");
                obj[7] = connection.result.getString("no_telphone_penerima");

                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
            removeTemp();
            model.fireTableDataChanged();
            kode = "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "rollBackAdding!\n" + e.toString());
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
            java.util.logging.Logger.getLogger(cetakTemporaryshipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cetakTemporaryshipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cetakTemporaryshipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cetakTemporaryshipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cetakTemporaryshipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatalkan;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnMasukkan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablePemesanan;
    private javax.swing.JTable tableTemp;
    private javax.swing.JLabel txtkantorCabang;
    // End of variables declaration//GEN-END:variables
}
