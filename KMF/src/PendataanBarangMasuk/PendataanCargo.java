/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PendataanBarangMasuk;

import MainMenu.MainMenuStaff;
import MainMenu.MainMenuStaffTerima;
import connection.DBConnect;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Polman
 */
public class PendataanCargo extends javax.swing.JFrame {

    /**
     * Creates new form PendataanCargo
     */
    private DBConnect connection = new DBConnect();
    private DefaultTableModel model;
    private String id_cargo = "";
    private String nomor_registrasi = "";
    private String nomor_penerbangan = "";
    private boolean belum = false;

    List<String> pemesanan = new ArrayList();
    List<String> bagging = new ArrayList();
    List<String> bandara = new ArrayList();

    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

    public PendataanCargo() {
        initComponents();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        model = new DefaultTableModel();
        tableCargo.setModel(model);
        addColumn();
        addDataColumn();

    }
    private String KantorCabang = "KMF PEMALANG";

    public PendataanCargo(String kantorCabang) {
        initComponents();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        this.KantorCabang = kantorCabang;
        model = new DefaultTableModel();
        tableCargo.setModel(model);
        addColumn();
        addDataColumn();

    }

    private void addColumn() {
        model.addColumn("ID Cargo");
        model.addColumn("Registrasi");
        model.addColumn("Penerbangan");
        model.addColumn("Bandara Asal");
        model.addColumn("Bandara Tujuan");
        model.addColumn("Pemberangkatan");
        model.addColumn("Sampai");
        model.addColumn("Kantong");
        model.addColumn("Berat");
        model.addColumn("Biaya");
        model.addColumn("Status");

    }

    private void addDataColumn() {
        id_cargo = "";
        nomor_penerbangan = "";
        nomor_registrasi = "";
        belum = false;
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();

        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT distinct(c.id_cargo_manifest), c.bandara_asal, c.bandara_tujuan, c.berat_barang_total,c.berat_barang_total,\n"
                    + "                    C.jumlah_kantong,c.nomor_penerbangan,c.nomor_registrasi,c.status,c.tanggal_pemberangkatan,c.tanggal_sampai,\n"
                    + "                    c.total_biaya,c.waktu_pemberangkatan,c.waktu_pemberangkatan,c.waktu_sampai FROM CargoManifest AS C\n"
                    + "                    INNER JOIN detailCargo AS d ON c.id_cargo_manifest = d.id_cargo_manifest\n"
                    + "                    INNER JOIN detailBagging AS b ON d.id_bagging = b.id_bagging\n"
                    + "                    INNER JOIN Connote AS o ON o.id_connote = b.id_connote\n"
                    + "					inner join DataBarangPelanggan db on o.id_pemesanan = db.id_pemesanan\n"
                    + "					inner join KotaKabupaten k on k.nama_kota = db.kota_penerima\n"
                    + "					inner join KantorCabang kc on kc.kota = k.singkatan\n"
                    + "                    WHERE kc.kode_kantor_cabang = '" + getIDKantor(KantorCabang) + "'";
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                Object[] obj = new Object[11];

                obj[0] = connection.result.getString("id_cargo_manifest");
                obj[1] = connection.result.getString("nomor_registrasi");
                obj[2] = connection.result.getString("nomor_penerbangan");
                obj[3] = connection.result.getString("bandara_asal");
                obj[4] = connection.result.getString("bandara_tujuan");
                obj[5] = connection.result.getString("tanggal_pemberangkatan") + " " + LocalTime.parse(connection.result.getString("waktu_pemberangkatan"));
                obj[6] = connection.result.getString("tanggal_sampai") + " " + LocalTime.parse(connection.result.getString("waktu_sampai"));
                obj[7] = connection.result.getString("jumlah_kantong");
                obj[8] = connection.result.getString("berat_barang_total");
                obj[9] = kursIndonesia.format(Integer.parseInt((connection.result.getString("total_biaya")).substring(0, (connection.result.getString("total_biaya")).length() - 5)));
                obj[10] = connection.result.getString("status");

                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal111!\n" + e.toString());
        }
        resizeColumnWidth(tableCargo);
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

    private void addDataColumn(String parameter) {

        id_cargo = "";
        nomor_penerbangan = "";
        nomor_registrasi = "";
        belum = false;
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();

        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query;
            if (parameter.equals("Semua")) {
                query = "SELECT distinct(c.id_cargo_manifest), c.bandara_asal, c.bandara_tujuan, c.berat_barang_total,c.berat_barang_total,\n"
                        + "                    C.jumlah_kantong,c.nomor_penerbangan,c.nomor_registrasi,c.status,c.tanggal_pemberangkatan,c.tanggal_sampai,\n"
                        + "                    c.total_biaya,c.waktu_pemberangkatan,c.waktu_pemberangkatan,c.waktu_sampai FROM CargoManifest AS C\n"
                        + "                    INNER JOIN detailCargo AS d ON c.id_cargo_manifest = d.id_cargo_manifest\n"
                        + "                    INNER JOIN detailBagging AS b ON d.id_bagging = b.id_bagging\n"
                        + "                    INNER JOIN Connote AS o ON o.id_connote = b.id_connote\n"
                        + "					inner join DataBarangPelanggan db on o.id_pemesanan = db.id_pemesanan\n"
                        + "					inner join KotaKabupaten k on k.nama_kota = db.kota_penerima\n"
                        + "					inner join KantorCabang kc on kc.kota = k.singkatan\n"
                        + "                    WHERE kc.kode_kantor_cabang = '" + getIDKantor(KantorCabang) + "'";
            } else {
                query = "SELECT distinct(c.id_cargo_manifest), c.bandara_asal, c.bandara_tujuan, c.berat_barang_total,c.berat_barang_total,\n"
                        + "                    C.jumlah_kantong,c.nomor_penerbangan,c.nomor_registrasi,c.status,c.tanggal_pemberangkatan,c.tanggal_sampai,\n"
                        + "                    c.total_biaya,c.waktu_pemberangkatan,c.waktu_pemberangkatan,c.waktu_sampai FROM CargoManifest AS C\n"
                        + "                    INNER JOIN detailCargo AS d ON c.id_cargo_manifest = d.id_cargo_manifest\n"
                        + "                    INNER JOIN detailBagging AS b ON d.id_bagging = b.id_bagging\n"
                        + "                    INNER JOIN Connote AS o ON o.id_connote = b.id_connote\n"
                        + "					inner join DataBarangPelanggan db on o.id_pemesanan = db.id_pemesanan\n"
                        + "					inner join KotaKabupaten k on k.nama_kota = db.kota_penerima\n"
                        + "					inner join KantorCabang kc on kc.kota = k.singkatan\n"
                        + "                    WHERE C.status = '" + parameter + "' AND \n"
                        + "					kc.kode_kantor_cabang = '" + getIDKantor(KantorCabang) + "'";
            }

            connection.result = connection.stat.executeQuery(query);
            System.out.println(query);
            while (connection.result.next()) {
                Object[] obj = new Object[11];

                obj[0] = connection.result.getString("id_cargo_manifest");
                obj[1] = connection.result.getString("nomor_registrasi");
                obj[2] = connection.result.getString("nomor_penerbangan");
                obj[3] = connection.result.getString("bandara_asal");
                obj[4] = connection.result.getString("bandara_tujuan");
                obj[5] = connection.result.getString("tanggal_pemberangkatan") + " " + LocalTime.parse(connection.result.getString("waktu_pemberangkatan"));
                obj[6] = connection.result.getString("tanggal_sampai") + " " + LocalTime.parse(connection.result.getString("waktu_sampai"));
                obj[7] = connection.result.getString("jumlah_kantong");
                obj[8] = connection.result.getString("berat_barang_total");
                obj[9] = kursIndonesia.format(Integer.parseInt((connection.result.getString("total_biaya")).substring(0, (connection.result.getString("total_biaya")).length() - 5)));
                obj[10] = connection.result.getString("status");

                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal111!\n" + e.toString());
        }
        resizeColumnWidth(tableCargo);
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
        tableCargo = new javax.swing.JTable();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnGagal = new javax.swing.JButton();
        btnBerhasil = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblmasuk = new javax.swing.JLabel();
        lblkon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblpod = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Pendataan Cargo Masuk");

        tableCargo.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCargo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableCargo.setRowSelectionAllowed(false);
        tableCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCargoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCargo);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Sampai", "Belum", "Gagal" }));
        cmbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbStatusItemStateChanged(evt);
            }
        });
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        jLabel2.setText("Status Cargo");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(348, 348, 348))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(btnGagal)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(417, 417, 417)))
                        .addComponent(btnBerhasil))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGagal)
                    .addComponent(btnBerhasil))
                .addContainerGap(52, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblkon, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpod, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblkon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblpod, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCargoMouseClicked
        // TODO add your handling code here:

        int i = tableCargo.getSelectedRow();
        if (i == -1) {
            return;
        }

        this.id_cargo = (String) model.getValueAt(i, 0);
        nomor_registrasi = (String) model.getValueAt(i, 1);
        nomor_penerbangan = (String) model.getValueAt(i, 2);
        if (((String) model.getValueAt(i, 10)).equals("Belum")) {
            belum = true;
        } else {
            belum = false;
        }
        JOptionPane.showMessageDialog(this, id_cargo + " Dipilih!\n");
    }//GEN-LAST:event_tableCargoMouseClicked

    private void btnBerhasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBerhasilActionPerformed
        // TODO add your handling code here:
        if (!id_cargo.equals("") && belum) {
            Object[] options = {"Konfirmasi",
                "Batal"};
            int n;
            penjemputan:
            {
                n = JOptionPane.showOptionDialog(this,
                        "Konfirmasi SAMPAI cargo masuk untuk ID\n"
                        + "ID Cargo          : " + id_cargo
                        + "\nNo Registrasi     : " + nomor_registrasi
                        + "\nNo Penerbangan    : " + nomor_penerbangan,
                        "Pertanyaan",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
            }
            if (n == 0) {
                updateCargoStatus(0);
            } else if (n == 1) {
                JOptionPane.showMessageDialog(this,
                        "Batal!");
                addDataColumn();
            }
        } else if (!id_cargo.equals("") && !belum) {
            JOptionPane.showMessageDialog(this,
                    id_cargo + " sudah terkonfirmasi");
            addDataColumn();
        } else {
            InputIdCargo input = new InputIdCargo(true);
            input.setVisible(true);
        }
    }//GEN-LAST:event_btnBerhasilActionPerformed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnGagalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGagalActionPerformed
        // TODO add your handling code here:
        if (!id_cargo.equals("") && belum) {
            Object[] options = {"Konfirmasi",
                "Batal"};
            int n;
            penjemputan:
            {
                n = JOptionPane.showOptionDialog(this,
                        "Konfirmasi GAGAL cargo masuk untuk ID\n"
                        + "ID Cargo          : " + id_cargo
                        + "\nNo Registrasi     : " + nomor_registrasi
                        + "\nNo Penerbangan    : " + nomor_penerbangan,
                        "Pertanyaan",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
            }
            if (n == 0) {
                updateCargoStatus(-1);
            } else if (n == 1) {
                JOptionPane.showMessageDialog(this,
                        "Batal!");
                addDataColumn();
            }
        } else if (!id_cargo.equals("") && !belum) {
            JOptionPane.showMessageDialog(this,
                    id_cargo + " sudah terkonfirmasi");
            addDataColumn();
        } else {
            InputIdCargo input = new InputIdCargo(false);
            input.setVisible(true);
        }
    }//GEN-LAST:event_btnGagalActionPerformed

    private void cmbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbStatusItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbStatusItemStateChanged

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
        addDataColumn(cmbStatus.getSelectedItem().toString());
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void lblmasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmasukMouseClicked
        PendataanCargo cargo = new PendataanCargo(KantorCabang);
        cargo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblmasukMouseClicked

    private void lblkonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkonMouseClicked
        KonfirmasiPenerima s = new KonfirmasiPenerima(KantorCabang);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblkonMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        MainMenuStaff t = new MainMenuStaff(KantorCabang);
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void lblpodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpodMouseClicked
        POD p = new POD(KantorCabang);
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblpodMouseClicked
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void updateCargoStatus(int i) {
        DBConnect connection = new DBConnect();
        try {
            String query;
            if (i == 0) {
                query = "UPDATE CargoManifest SET status='Sampai' WHERE id_cargo_manifest=?";
            } else {
                query = "UPDATE CargoManifest SET status='Gagal' WHERE id_cargo_manifest=?";
            }
            System.out.println("IDCARGO  "+id_cargo);
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, id_cargo);
            connection.pstat.executeUpdate();
            //connection.result.close();

            
            isiList();
            JOptionPane.showMessageDialog(this, "Konfirmasi berhasil");
            addDataColumn();
        } catch (Exception e) {
            System.out.println("Terjadi error saat update status cargo: " + e.toString());
        }
        if (i == 0) {
            updateDetailBagging();
        }else{
            updateDetailBagging1();
        }
    }

    

    private void updateDetailBagging() {
        for (int h = 0; h < bagging.size(); h++) {
            try {
                DBConnect connection = new DBConnect();
                String query = "UPDATE detailBagging SET status_barang_bagging = 'Sampai di kantor tujuan' "
                        + "WHERE id_bagging='"
                        + bagging.get(h) + "'";

                connection.pstat = connection.conn.prepareStatement(query);

                connection.pstat.executeUpdate();
                connection.pstat.close();
            } catch (Exception e) {
                System.out.println("Terjadi error saat update updateDetailBagging: " + e.toString());
            }
        }
    }

    
    private void updateDetailBagging1() {
        for (int h = 0; h < bagging.size(); h++) {
            try {
                DBConnect connection = new DBConnect();
                String query = "UPDATE detailBagging SET status_barang_bagging = 'Tidak sampai kantor di tujuan' "
                        + "WHERE id_bagging='"
                        + bagging.get(h) + "'";

                connection.pstat = connection.conn.prepareStatement(query);

                connection.pstat.executeUpdate();
                connection.pstat.close();
            } catch (Exception e) {
                System.out.println("Terjadi error saat update updateDetailBagging: " + e.toString());
            }
        }
    }

   

    private void isiList() {
        String idBagging = "";
        String Bandara = "";
        String idPemesanan = "";
        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM CargoManifest AS C\n"
                    + "INNER JOIN detailCargo AS d ON c.id_cargo_manifest = d.id_cargo_manifest\n"
                    + "INNER JOIN detailBagging AS b ON d.id_bagging = b.id_bagging\n"
                    + "INNER JOIN Connote AS O ON O.id_connote = b.id_connote\n"
                    + "WHERE C.id_cargo_manifest = '" + id_cargo + "'";
            System.out.println("isiList : " + query);
            connection.result = connection.stat.executeQuery(query);
            while (connection.result.next()) {
                idBagging = (connection.result.getString("id_bagging"));
                Bandara = (connection.result.getString("bandara_asal"));
                idPemesanan = (connection.result.getString("id_pemesanan"));
                bagging.add(idBagging);
                bandara.add(Bandara);
                pemesanan.add(idPemesanan);
            }
        } catch (Exception e) {
            System.out.println("Terjadi error saat mencari isiList: " + e.toString());
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
            java.util.logging.Logger.getLogger(PendataanCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PendataanCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PendataanCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PendataanCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PendataanCargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBerhasil;
    private javax.swing.JButton btnGagal;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblkon;
    private javax.swing.JLabel lblmasuk;
    private javax.swing.JLabel lblpod;
    private javax.swing.JTable tableCargo;
    // End of variables declaration//GEN-END:variables
}
