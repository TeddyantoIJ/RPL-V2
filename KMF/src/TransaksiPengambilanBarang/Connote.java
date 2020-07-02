/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransaksiPengambilanBarang;

import FormCetak.PrintConnote;
import MainMenu.Login;
import MainMenu.MainMenuPencetakConnote;
import TransaksiPengirimanBarang.ListCargo;
import connection.DBConnect;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author harvianti Putri
 */
public class Connote extends javax.swing.JFrame {
        DBConnect connection = new DBConnect();
        boolean valid;
        String kantor_cabang = "KMF JKT";
        String id_connote = "";
        String id_pemesanan= "";
        String tgl_connote= "";
         Format formatterDate = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("HHmm");
        private String txtkode_kantor_cabang = getIDKantor();;
        private String KantorCabang = "";
        
        private DefaultTableModel model;
        
    /**
     * Creates new form Connote
     */
        
        
        
    public Connote() {
        initComponents();
        Format formatterDate = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("HHmm");
        model = new DefaultTableModel();
        addColumn();
        addData();
        
        tableBarang.setModel(model);
        
        kantor_cabang = KantorCabang;
        txtkode_kantor_cabang = getIDKantor();
        txtIdC.setText(formatterDate.format(new Date())+formatterTime.format(new Date())+autoID());
        tglConnote.setDate(new Date());
    }
    
    public Connote(String KantorCabang) {
        initComponents();
        Format formatterDate = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("HHmm");
        model = new DefaultTableModel();
        addColumn();
        addData();
        
        tableBarang.setModel(model);
        
        kantor_cabang = KantorCabang;
        txtkode_kantor_cabang = getIDKantor();
        txtIdC.setText(formatterDate.format(new Date())+formatterTime.format(new Date())+autoID());
        tglConnote.setDate(new Date());
    }
    private void addData(){
        try {

            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "select dbp.id_pemesanan, dbp.jenis_barang, dbp.keterangan_barang, dbp.kota_penerima from DataBarangPelanggan dbp"
                    + " inner join KantorCabang kc on kc.kode_kantor_cabang = dbp.kode_kantor_cabang"
                    + " where dbp.keterangan_barang = 'Connote barang segera dicetak' and nama_kantor = '"+KantorCabang+"'";
                    

            //   JOptionPane.showMessageDialog(this, query);
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            int i = 1;
            while (connection.result.next()) {
                Object obj[] = new Object[5];
                obj[0] = i;
                obj[1] = connection.result.getString("id_pemesanan");
                obj[2] = connection.result.getString("jenis_baran");
                obj[3] = connection.result.getString("keterangan_barang");
                obj[4] = connection.result.getString("kota_penerima");
                
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
    private void addColumn() {
        model.addColumn("No");
        model.addColumn("ID Pemesanan");
        model.addColumn("Jenis Barang");
        model.addColumn("Keterangan");
        model.addColumn("Kota Tujuan");
    }
    private String getIDKantor(String nama){
        
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select kode_kantor_cabang from KantorCabang where nama_kantor = '"+nama+"'";
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
            JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
        }
        return null;
    }
    
    private String getNamaPelanggan(){
        
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select nama_pelanggan from Pelanggan where id_pelanggan = '"+txtIdPelanggan1.getText()+"'";
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("nama_pelanggan"));

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
    private void clear(){
            txtIdPelanggan1.setText("");
            txtNamaPelanggan.setText("");
            txtjenisBarang.setText("");
            AreaKet.setText("");
            txtNamaPenerima.setText("");
            txtAlamatPenerima.setText("");
            txtKotaPenerima.setText("");
            txtTelp.setText("");
            txtKeterangan.setText("");
            txtBerat.setText("");
            txtTotal.setText("");
            txtStatusBrg.setText("");
            txtKetP.setText("");
            txtKC.setText("");
            txtTglTransaksi.setText("");
    }
//    private void tampilkc()
//    {
//        try{
//            DBConnect c = new DBConnect();
//            c.stat = c.conn.createStatement();
//            String sql = "SELECT nama_kantor FROM KantorCabang";
//            c.result = c.stat.executeQuery(sql);
//            
//            while (c.result.next()){
//                cmbKC.addItem(c.result.getString("nama_kantor"));
//            }
//            c.stat.close();
//            c.result.close();
//          
//        }catch (Exception ex){
//            System.out.println("Terjadi erro saat load data kantor cabang" + ex);
//        }
//        
//    }
    
    private String autoID()
    {
        String maxID = null;
        int idtr = 0;
        String id = null;
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        try{
            connection.stat = connection.conn.createStatement();
            String query = "SELECT count(id_connote) as ID FROM Connote WHERE id_connote LIKE '%"+formatter.format(new Date())+"%'";
            //System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            
            while(connection.result.next()){
                    maxID = connection.result.getString("ID");
                }
           connection.stat.close();
           connection.result.close();
           
           if(maxID != null)
           {
               idtr = Integer.parseInt(maxID)+1;
                       if (idtr < 10)
                       {
                           id = "000" + idtr;
                       }
                       else if (idtr < 100)
                       {
                           id = "00" + idtr;
                       }
                       else if (idtr < 1000)
                       {
                           id = "0" + idtr;
                       }else{
                           id = ""+idtr;
                       }
           }
           else
           {
               id = "0001";
           }

        } catch(SQLException ex){
                System.out.println("Terjadi Error Saat ambil id " + ex);
        }
        return id;
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tglConnote = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtIdPemesanan = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNamaPelanggan = new javax.swing.JTextField();
        txtIdC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaKet = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtStatusBrg = new javax.swing.JTextField();
        n = new javax.swing.JLabel();
        txtjenisBarang = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNamaPenerima = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtAlamatPenerima = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtKotaPenerima = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTelp = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtIdPelanggan1 = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtJnsBrg1 = new javax.swing.JLabel();
        txtBerat = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtKetP = new javax.swing.JTextField();
        txtKC = new javax.swing.JTextField();
        txtTglTransaksi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Consignment Note");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 264, -1));

        jLabel2.setText("Kantor Cabang ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 345, -1, -1));

        jLabel3.setText("ID Pemesanan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 225, -1, -1));

        tglConnote.setEnabled(false);
        jPanel1.add(tglConnote, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 213, -1));

        jLabel4.setText("ID Pelanggan");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 383, -1, -1));

        txtIdPemesanan.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.add(txtIdPemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 221, 146, -1));

        btnCari.setBackground(new java.awt.Color(204, 255, 204));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        jPanel1.add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 217, 59, -1));

        jLabel5.setText("Nama Pelanggan");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 422, -1, -1));

        txtNamaPelanggan.setEditable(false);
        txtNamaPelanggan.setBackground(new java.awt.Color(204, 204, 255));
        txtNamaPelanggan.setEnabled(false);
        jPanel1.add(txtNamaPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 418, 213, -1));

        txtIdC.setEditable(false);
        txtIdC.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.add(txtIdC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 217, -1));

        jLabel9.setText("Keterangan Barang");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 467, -1, -1));

        AreaKet.setEditable(false);
        AreaKet.setBackground(new java.awt.Color(204, 204, 255));
        AreaKet.setColumns(20);
        AreaKet.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        AreaKet.setRows(5);
        AreaKet.setEnabled(false);
        jScrollPane1.setViewportView(AreaKet);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 454, 213, 46));

        jLabel10.setText("Status Barang");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 519, -1, -1));

        txtStatusBrg.setEditable(false);
        txtStatusBrg.setBackground(new java.awt.Color(204, 204, 255));
        txtStatusBrg.setEnabled(false);
        jPanel1.add(txtStatusBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 515, 213, -1));

        n.setText("Jenis Barang");
        jPanel1.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 549, -1, -1));

        txtjenisBarang.setEditable(false);
        txtjenisBarang.setBackground(new java.awt.Color(204, 204, 255));
        txtjenisBarang.setEnabled(false);
        jPanel1.add(txtjenisBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 545, 213, -1));

        jLabel12.setText("Tanggal Transaksi");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, -1, -1));

        jLabel6.setText("Nama Penerima");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 219, -1, -1));

        txtNamaPenerima.setEditable(false);
        txtNamaPenerima.setBackground(new java.awt.Color(204, 204, 255));
        txtNamaPenerima.setEnabled(false);
        jPanel1.add(txtNamaPenerima, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 215, 186, -1));

        jLabel13.setText("Alamat Penerima");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 255, -1, -1));

        txtAlamatPenerima.setEditable(false);
        txtAlamatPenerima.setBackground(new java.awt.Color(204, 204, 255));
        txtAlamatPenerima.setEnabled(false);
        jPanel1.add(txtAlamatPenerima, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 251, 186, -1));

        jLabel14.setText("Kota/Kabupaten");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 283, -1, -1));

        txtKotaPenerima.setEditable(false);
        txtKotaPenerima.setBackground(new java.awt.Color(204, 204, 255));
        txtKotaPenerima.setEnabled(false);
        jPanel1.add(txtKotaPenerima, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 283, 186, -1));

        jLabel15.setText("No.Telepon");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 323, -1, -1));

        txtTelp.setEditable(false);
        txtTelp.setBackground(new java.awt.Color(204, 204, 255));
        txtTelp.setEnabled(false);
        jPanel1.add(txtTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 319, 186, -1));

        jLabel16.setText("Keterangan");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 415, -1, 10));

        txtKeterangan.setEditable(false);
        txtKeterangan.setBackground(new java.awt.Color(204, 204, 255));
        txtKeterangan.setEnabled(false);
        jPanel1.add(txtKeterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 415, 186, 36));

        jLabel17.setText("Total Biaya");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 500, -1, 10));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(204, 204, 255));
        txtTotal.setEnabled(false);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 493, 186, -1));

        jLabel18.setText("Tanggal");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        txtIdPelanggan1.setEditable(false);
        txtIdPelanggan1.setBackground(new java.awt.Color(204, 204, 255));
        txtIdPelanggan1.setEnabled(false);
        jPanel1.add(txtIdPelanggan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 383, 213, -1));

        btnUpdate.setBackground(new java.awt.Color(204, 255, 204));
        btnUpdate.setText("Cek Cetak");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 625, -1, -1));

        btnSimpan.setBackground(new java.awt.Color(204, 255, 204));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 625, -1, -1));

        btnBatal.setBackground(new java.awt.Color(204, 255, 204));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 638, -1, -1));

        txtJnsBrg1.setText("Berat Barang");
        jPanel1.add(txtJnsBrg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 458, -1, -1));

        txtBerat.setEditable(false);
        txtBerat.setBackground(new java.awt.Color(204, 204, 255));
        txtBerat.setEnabled(false);
        jPanel1.add(txtBerat, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 463, 33, -1));

        jLabel19.setText("Pembayaran");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 539, -1, -1));

        txtKetP.setEditable(false);
        txtKetP.setBackground(new java.awt.Color(204, 204, 255));
        txtKetP.setEnabled(false);
        jPanel1.add(txtKetP, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 535, 186, -1));

        txtKC.setBackground(new java.awt.Color(204, 204, 255));
        txtKC.setEnabled(false);
        jPanel1.add(txtKC, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 341, 213, -1));

        txtTglTransaksi.setText("Tanggal");
        jPanel1.add(txtTglTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 580, -1, -1));

        jLabel7.setText("KG");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 467, -1, -1));

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableBarang);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 700, 140));

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 700));

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Cetak Connote");
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(24, 24, 24)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        
        try{
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM DataBarangPelanggan WHERE id_pemesanan LIKE '%" + txtIdPemesanan.getText() + "%' and kode_kantor_cabang = '"+getIDKantor()+"'";
            System.out.println("btnCariActionPerformed  "+query);
            connection.result = connection.stat.executeQuery(query);
            connection.result.next();
            //txtIdPemesanan.setText(connection.result.getString("id_pemesanan"));
            txtIdPelanggan1.setText(connection.result.getString("id_pelanggan"));
            txtNamaPelanggan.setText(getNamaPelanggan());
            txtjenisBarang.setText(connection.result.getString("jenis_barang"));
            AreaKet.setText(connection.result.getString("keterangan_barang"));
            txtNamaPenerima.setText(connection.result.getString("nama_penerima"));
            txtAlamatPenerima.setText(connection.result.getString("alamat_penerima"));
            txtKotaPenerima.setText(connection.result.getString("kota_penerima"));
            txtTelp.setText(connection.result.getString("no_telphone_penerima"));
            txtKeterangan.setText(connection.result.getString("keterangan"));
            txtBerat.setText(connection.result.getString("berat_barang"));
            txtTotal.setText(connection.result.getString("total_harga"));
            txtStatusBrg.setText(connection.result.getString("status_barang"));
            txtKetP.setText(connection.result.getString("keterangan_pembayaran"));
            txtKC.setText(kantor_cabang);
            txtTglTransaksi.setText(connection.result.getString("tanggal"));
            
            connection.stat.close();
            connection.result.close();
        }catch (Exception ex) {
           JOptionPane.showMessageDialog(this, "ID Tidak Ditemukan");
           clear();
        }
        
      
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(cekConnote(txtIdPemesanan.getText())){
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            
            id_connote = txtIdC.getText();
            id_pemesanan = txtIdPemesanan.getText();
            tgl_connote = formatter.format(new Date());

            try
            {
                DBConnect c = new DBConnect();
                String query = "INSERT INTO Connote VALUES (?,?,?,?,?)";
                     c.pstat = c.conn.prepareStatement(query);
                     c.pstat.setString(1, id_connote);
                     c.pstat.setString(2, id_pemesanan);
                     c.pstat.setString(3, txtkode_kantor_cabang);
                     c.pstat.setString(4, formatter.format(new Date()));
                     c.pstat.setString(5, "Belum");

                      //insert ke dalam database
                c.pstat.executeUpdate();
                c.pstat.close();
                JOptionPane.showMessageDialog(this, "insert data connote berhasil");
                clear();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data connote :" + e);
            }
             

             txtIdC.setText(formatterDate.format(new Date())+formatterTime.format(new Date())+autoID());
        }else{
            JOptionPane.showMessageDialog(this, "Data sudah ada");
        }
    }//GEN-LAST:event_btnSimpanActionPerformed
    private boolean cekConnote(String in){
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select * from Connote where id_pemesanan = '"+in+"'";
            connection.result = connection.stat.executeQuery(query);
            String output = "";
            while (connection.result.next()) {

                output = (connection.result.getString("kode_kantor_cabang"));

            }
            connection.stat.close();
            connection.result.close();
            if(output.equals("")){
                return true;
            }else{
                return false;
            }
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(this, "Error!!\n" + e.toString());
            return false;
        }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        MainMenuPencetakConnote m = new MainMenuPencetakConnote(kantor_cabang);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBatalActionPerformed

    private String getIDKantor(){
        
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select kode_kantor_cabang from KantorCabang where nama_kantor = '"+kantor_cabang+"'";
            System.out.println(query);
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
            JOptionPane.showMessageDialog(this, "Error getIDKantor!!\n" + e.toString());
        }
        return null;
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        id_connote = txtIdC.getText();
        id_pemesanan = txtIdPemesanan.getText();
        PrintConnote Pconnote = new PrintConnote(id_pemesanan, id_connote);
        Pconnote.setVisible(true);
        this.setVisible(false);
        
//        if(!txtTglTransaksi.getText().equals("")){
//            updateStatusBarang();
//            JOptionPane.showMessageDialog(this, "Mencetak....");
//        }else{
//            JOptionPane.showMessageDialog(this, "Tidak ada yang dapat dicetak....");
//        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        Connote connote = new Connote(KantorCabang);
        connote.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        Login t= new Login();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked
    private void updateStatusBarang() {
        DBConnect connection = new DBConnect();
        try {
            String query;

            query = "UPDATE DataBarangPelanggan SET status_barang='Connote barang sudah tercetak' WHERE id_pemesanan='" + id_pemesanan + "'";

            connection.pstat = connection.conn.prepareStatement(query);

            connection.pstat.executeUpdate();
            //connection.result.close();
            
            //JOptionPane.showMessageDialog(this, "Bagging berhasil");
        } catch (Exception e) {
            System.out.println("Terjadi error saat updateStatusBarang: " + e.toString());
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaKet;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel n;
    private javax.swing.JTable tableBarang;
    private com.toedter.calendar.JDateChooser tglConnote;
    private javax.swing.JTextField txtAlamatPenerima;
    private javax.swing.JTextField txtBerat;
    private javax.swing.JTextField txtIdC;
    private javax.swing.JTextField txtIdPelanggan1;
    private javax.swing.JTextField txtIdPemesanan;
    private javax.swing.JLabel txtJnsBrg1;
    private javax.swing.JTextField txtKC;
    private javax.swing.JTextField txtKetP;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtKotaPenerima;
    private javax.swing.JTextField txtNamaPelanggan;
    private javax.swing.JTextField txtNamaPenerima;
    private javax.swing.JTextField txtStatusBrg;
    private javax.swing.JTextField txtTelp;
    private javax.swing.JLabel txtTglTransaksi;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtjenisBarang;
    // End of variables declaration//GEN-END:variables
}
