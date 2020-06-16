/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PendataanBarangMasuk;

import connection.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Izzah
 */
public class KonfirmasiPenerima extends javax.swing.JFrame {

    private DefaultTableModel model;
    /**
     * Creates new form KonfirmasiPenerima
     */
    private String namaKantor = "KMF PEMALANG";
    private String txtkode_kantor_penerima = "";

    public KonfirmasiPenerima() {
        initComponents();
        model = new DefaultTableModel();
        addColumn();

        getData();
        tblBarang.setModel(model);
        addSource("Semua");
    }

    public KonfirmasiPenerima(String namaKantor) {
        initComponents();
        this.namaKantor = namaKantor;
        model = new DefaultTableModel();
        addColumn();
        addSource("Semua");
        //getData();
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

    private String getSingkatanKantor(String in) {
        DBConnect connection = new DBConnect();
        try {
            connection.stat = connection.conn.createStatement();
            String query = "select singkatan from KotaKabupaten where nama_kota = '" + in + "'";
            //System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("singkatan"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;
    }

    public void getData() {

        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {

//membuat statement untuk memanggil data table DataBarangPelanggan
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String sql = "Select * from DataBarangPelanggan";
            connection.result = connection.stat.executeQuery(sql);

//pengecekan terhadap data DataBarangPelanggan
            while (connection.result.next()) {
                Object[] obj = new Object[1];
                obj[0] = connection.result.getString("keterangan_barang");
                model.addRow(obj);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    private String getIDPemesanan() {

        DBConnect connection = new DBConnect();
        try {
            connection.stat = connection.conn.createStatement();
            String query = "select id_pemesanan from Connote where id_connote = '" + txtid_connote.getText() + "'";
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("id_pemesanan"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;

    }

    private String getStatusConnote() {

        DBConnect connection = new DBConnect();
        try {
            connection.stat = connection.conn.createStatement();
            String query = "select status_pengiriman from Connote where id_connote = '" + txtid_connote.getText() + "'";
            connection.result = connection.stat.executeQuery(query);
            //System.out.println("Status connote "+query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("status_pengiriman"));

            }
            //System.out.println(output);
            connection.stat.close();
            connection.result.close();
            return output;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;

    }

    private String getStatusBarang() {

        DBConnect connection = new DBConnect();
        try {
            connection.stat = connection.conn.createStatement();
            String query = "select status_barang from DataBarangPelanggan where id_pemesanan = '" + getIDPemesanan() + "'";
            connection.result = connection.stat.executeQuery(query);
            System.out.println("status"+query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("status_barang"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;

    }

    private boolean getTrueID(){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select * from Connote inner join DataBarangPelanggan a on Connote.id_pemesanan = a.id_pemesanan\n" +
            "inner join KotaKabupaten b on b.nama_kota = a.kota_penerima \n" +
            "inner join KantorCabang c on c.kota = b.singkatan "+
            "where Connote.id_connote = '"+txtid_connote.getText()+"' and a.kota_penerima ='"+getNamaKota()+"'";
            connection.result = connection.stat.executeQuery(query);
            String output = "";
            while (connection.result.next()) {

                output = (connection.result.getString("status_pengiriman"));

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
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
            return false;
        }
    }
    private String getNamaKota(){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select nama_kota from KotaKabupaten where singkatan = '"+getKotaKantor()+"'";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("nama_kota"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error getSingkatan!!\n" + e.toString());
        }
        return null;
    }
    private String getKotaKantor(){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select kota from KantorCabang where kode_kantor_cabang = '"+getIDKantor(namaKantor)+"'";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("kota"));

            }
            connection.stat.close();
            connection.result.close();
            return output;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error getSingkatan!!\n" + e.toString());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnKonfirmasi = new javax.swing.JButton();
        txtnama_penerima = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        statlbl = new javax.swing.JLabel();
        txtid_connote = new javax.swing.JTextField();
        rbGagal = new javax.swing.JRadioButton();
        rbDiterima = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKomentar = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("List Barang & Data Penerima");

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

        jLabel2.setText("Connote");

        jLabel3.setText("Penerima");

        jButton1.setText("Selesai");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnKonfirmasi.setText("Konfirmasi");
        btnKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfirmasiActionPerformed(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Belum", "Dikirim", "Diterima", "Gagal" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        statlbl.setText("Status Penerimaan");

        txtid_connote.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtid_connotePropertyChange(evt);
            }
        });
        txtid_connote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtid_connoteKeyReleased(evt);
            }
        });

        rbGagal.setText("Gagal");
        rbGagal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGagalActionPerformed(evt);
            }
        });

        rbDiterima.setText("Diterima");
        rbDiterima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDiterimaActionPerformed(evt);
            }
        });

        txtKomentar.setColumns(20);
        txtKomentar.setRows(5);
        jScrollPane3.setViewportView(txtKomentar);

        jLabel4.setText("Keterangan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statlbl)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid_connote, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnama_penerima, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbGagal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbDiterima))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKonfirmasi)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(statlbl)
                        .addGap(18, 18, 18)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbGagal)
                            .addComponent(rbDiterima))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtid_connote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnama_penerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnKonfirmasi))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfirmasiActionPerformed
        if(!txtid_connote.getText().equals("") && getTrueID()){
            int jawab = JOptionPane.showConfirmDialog(this, "Konfirmasi barang sudah sampai?");

            if (jawab == JOptionPane.OK_OPTION) {

                if (rbDiterima.isSelected()) {
                    updateStatusBarang(0);
                } else {
                    updateStatusBarang(1);
                }
                JOptionPane.showMessageDialog(this, "Barang diterima");
            }
            if (jawab == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(this, "Barang belum Gagal");

            }
        }else if(!getTrueID()){
            JOptionPane.showMessageDialog(this, "Connote tidak ditemukan!");
        }else{
            JOptionPane.showMessageDialog(this, "Masukkan data dengan benar!");
        }
        
    }//GEN-LAST:event_btnKonfirmasiActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
        String status;
        status = (String) cmbStatus.getSelectedItem();
        addSource(status);
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void updateStatusBarang(int i) {
        DBConnect connection = new DBConnect();
        try {
            String query;
            if (i == 0) {
                query = "UPDATE DataBarangPelanggan SET status_barang='Diterima oleh " + txtnama_penerima.getText() + "' WHERE id_pemesanan='" + getIDPemesanan() + "'";
            } else {
                query = "UPDATE DataBarangPelanggan SET status_barang='Gagal " + txtKomentar.getText() + "' where id_pemesanan='" + getIDPemesanan() + "'";
            }

            connection.pstat = connection.conn.prepareStatement(query);

            connection.pstat.executeUpdate();
            //connection.result.close();

            addSource((String) cmbStatus.getSelectedItem());
            updateStatusConnote();
            //JOptionPane.showMessageDialog(this, "Bagging berhasil");
        } catch (Exception e) {
            System.out.println("Terjadi error saat update status Barang: " + e.toString());
        }
    }

    private void updateStatusConnote() {
        DBConnect connection = new DBConnect();
        try {
            String query;

            if (rbDiterima.isSelected()) {
                query = "UPDATE Connote SET status_pengiriman='Diterima' WHERE id_connote='" + txtid_connote.getText() + "'";
            } else {
                query = "UPDATE Connote SET status_pengiriman='Gagal' WHERE id_connote='" + txtid_connote.getText() + "'";
            }

            connection.pstat = connection.conn.prepareStatement(query);

            connection.pstat.executeUpdate();
            //connection.result.close();
            
            addRiwayat();
            addSource(cmbStatus.getSelectedItem().toString());
            //JOptionPane.showMessageDialog(this, "Bagging berhasil");
        } catch (Exception e) {
            System.out.println("Terjadi error saat update status Connote: " + e.toString());
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
                     c.pstat.setString(3, getStatusBarang());
                     c.pstat.setString(4, getIDPemesanan());

                      //insert ke dalam database
                c.pstat.executeUpdate();
                c.pstat.close();
                //JOptionPane.showMessageDialog(this, "insert data Baggin berhasil");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data bagging :" + e);
            }        
    }
    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int i = tblBarang.getSelectedRow();
        if (i == -1) {
            return;
        }
        txtid_connote.setText((String) model.getValueAt(i, 0));
        //txtnama_penerima.setText((String) model.getValueAt(i, 1));
        getValue();
        addSource((String) cmbStatus.getSelectedItem());
        
    }//GEN-LAST:event_tblBarangMouseClicked

    private void rbDiterimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDiterimaActionPerformed
        // TODO add your handling code here:
        if (rbDiterima.isSelected()) {
            txtKomentar.setText("");
            txtKomentar.setEnabled(false);
            rbGagal.setSelected(false);
            txtnama_penerima.setText("");
            txtnama_penerima.setEnabled(true);
        } else {
            rbGagal.setSelected(true);
            txtKomentar.setEnabled(false);
            txtnama_penerima.setText("");
            txtnama_penerima.setEnabled(false);
             txtKomentar.setText("");
            txtKomentar.setEnabled(true);
        }

    }//GEN-LAST:event_rbDiterimaActionPerformed

    private void rbGagalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGagalActionPerformed
        // TODO add your handling code here:
        if (rbGagal.isSelected()) {
            rbDiterima.setSelected(false);
            txtKomentar.setEnabled(true);
            txtnama_penerima.setText("");
            txtnama_penerima.setEnabled(false);
        } else {
            rbDiterima.setSelected(true);
            txtKomentar.setEnabled(false);
            txtnama_penerima.setText("");
            txtnama_penerima.setEnabled(true);
        }
    }//GEN-LAST:event_rbGagalActionPerformed

    private void txtid_connotePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtid_connotePropertyChange
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_txtid_connotePropertyChange

    private void txtid_connoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_connoteKeyReleased
        // TODO add your handling code here:
        if(getTrueID()){
            getValue();
        }
        
    }//GEN-LAST:event_txtid_connoteKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void getValue(){
        try{
            if (getStatusConnote().equals("Gagal")) {
            rbDiterima.setSelected(false);
            rbGagal.setSelected(true);
            txtKomentar.setText(getStatusBarang());
            txtKomentar.setEnabled(true);
            } else if (getStatusConnote().equals("Diterima")) {
                rbGagal.setSelected(false);
                rbDiterima.setSelected(true);
                txtKomentar.setText(getStatusBarang());
                txtKomentar.setEnabled(false);
            } else {
                rbGagal.setSelected(false);
                rbDiterima.setSelected(false);
                txtKomentar.setText(getStatusBarang());
            }
        }catch(Exception e){
            //System.out.println(e);
            rbGagal.setSelected(false);
            rbDiterima.setSelected(false);
            txtKomentar.setText("");
        }
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
                        + "where\n"
                        + "e.singkatan = '" + getKotaKantor() + "'";
            } else {
                query = "select [Connote].id_connote, [b].nama_pelanggan, [a].jenis_barang, c.jns_nama, a.nama_penerima, a.alamat_penerima, [Connote].status_pengiriman from\n"
                        + "Connote inner join DataBarangPelanggan a on Connote.id_pemesanan = a.id_pemesanan\n"
                        + "inner join Pelanggan b on [a].id_pelanggan = [b].id_pelanggan\n"
                        + "inner join JenisPaket c on [a].jns_id = c.jns_id \n"
                        + "inner join KantorCabang d on a.kode_kantor_cabang = d.kode_kantor_cabang\n"
                        + "inner join KotaKabupaten e on a.kota_penerima = e.nama_kota\n"
                        + "where\n"
                        + "e.singkatan = '" + getKotaKantor() + "' and [Connote].status_pengiriman = '" + status + "'";
            }

            //JOptionPane.showMessageDialog(this, query);
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
            java.util.logging.Logger.getLogger(KonfirmasiPenerima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPenerima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPenerima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPenerima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonfirmasiPenerima().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKonfirmasi;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbDiterima;
    private javax.swing.JRadioButton rbGagal;
    private javax.swing.JLabel statlbl;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextArea txtKomentar;
    private javax.swing.JTextField txtid_connote;
    private javax.swing.JTextField txtnama_penerima;
    // End of variables declaration//GEN-END:variables
}
