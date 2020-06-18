/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransaksiPengambilanBarang;

import MainMenu.MainMenuPencetakConnote;
import connection.DBConnect;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

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
    /**
     * Creates new form Connote
     */
        
        
        
        
        
    public Connote() {
        Format formatterDate = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("HHmm");
        initComponents();
        txtIdC.setText(formatterDate.format(new Date())+formatterTime.format(new Date())+autoID());
        tglConnote.setDate(new Date());
    }
    public Connote(String namaKantor) {
        Format formatterDate = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("HHmm");
        
        
        initComponents();
        kantor_cabang = namaKantor;
        txtkode_kantor_cabang = getIDKantor();
        txtIdC.setText(formatterDate.format(new Date())+formatterTime.format(new Date())+autoID());
        tglConnote.setDate(new Date());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Consignment Note");

        jLabel2.setText("Kantor Cabang ");

        jLabel3.setText("ID Pemesanan");

        tglConnote.setEnabled(false);

        jLabel4.setText("ID Pelanggan");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel5.setText("Nama Pelanggan");

        txtNamaPelanggan.setEditable(false);
        txtNamaPelanggan.setEnabled(false);

        txtIdC.setEditable(false);

        jLabel9.setText("Keterangan Barang");

        AreaKet.setEditable(false);
        AreaKet.setColumns(20);
        AreaKet.setRows(5);
        AreaKet.setEnabled(false);
        jScrollPane1.setViewportView(AreaKet);

        jLabel10.setText("Status Barang");

        txtStatusBrg.setEditable(false);
        txtStatusBrg.setEnabled(false);

        n.setText("Jenis Barang");

        txtjenisBarang.setEditable(false);
        txtjenisBarang.setEnabled(false);

        jLabel12.setText("Tanggal Transaksi");

        jLabel6.setText("Nama Penerima");

        txtNamaPenerima.setEditable(false);
        txtNamaPenerima.setEnabled(false);

        jLabel13.setText("Alamat Penerima");

        txtAlamatPenerima.setEditable(false);
        txtAlamatPenerima.setEnabled(false);

        jLabel14.setText("Kota/Kabupaten");

        txtKotaPenerima.setEditable(false);
        txtKotaPenerima.setEnabled(false);

        jLabel15.setText("No.Telepon");

        txtTelp.setEditable(false);
        txtTelp.setEnabled(false);

        jLabel16.setText("Keterangan");

        txtKeterangan.setEditable(false);
        txtKeterangan.setEnabled(false);

        jLabel17.setText("Total Biaya");

        txtTotal.setEditable(false);
        txtTotal.setEnabled(false);

        jLabel18.setText("Tanggal");

        txtIdPelanggan1.setEditable(false);
        txtIdPelanggan1.setEnabled(false);

        btnUpdate.setText("Cetak");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        txtJnsBrg1.setText("Berat Barang");

        txtBerat.setEditable(false);
        txtBerat.setEnabled(false);

        jLabel19.setText("Pembayaran");

        txtKetP.setEditable(false);
        txtKetP.setEnabled(false);

        txtKC.setEnabled(false);

        txtTglTransaksi.setText("Tanggal");

        jLabel7.setText("KG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(32, 32, 32)
                                .addComponent(txtStatusBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(n)
                                .addGap(39, 39, 39)
                                .addComponent(txtjenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKetP, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtTotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel18))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtIdPelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtKC, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tglConnote, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addComponent(txtIdPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel13)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(383, 383, 383)
                                .addComponent(jLabel16))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(383, 383, 383)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(txtJnsBrg1)
                                    .addComponent(jLabel19))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaPenerima, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtAlamatPenerima)
                            .addComponent(txtKotaPenerima)
                            .addComponent(txtTelp)
                            .addComponent(txtKeterangan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(btnSimpan)
                                .addGap(49, 49, 49)
                                .addComponent(btnUpdate)
                                .addGap(50, 50, 50)
                                .addComponent(btnBatal))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtTglTransaksi)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNamaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtAlamatPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCari))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tglConnote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtIdPelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel9))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(txtJnsBrg1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtStatusBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(n)
                                    .addComponent(txtjenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtTglTransaksi)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtKetP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSimpan)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnBatal)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(txtKotaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
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
            txtKC.setText(connection.result.getString("kode_kantor_cabang"));
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
        if(!txtTglTransaksi.getText().equals("")){
            updateStatusBarang();
            JOptionPane.showMessageDialog(this, "Mencetak....");
        }else{
            JOptionPane.showMessageDialog(this, "Tidak ada yang dapat dicetak....");
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed
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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel n;
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
