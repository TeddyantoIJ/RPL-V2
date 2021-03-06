/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransaksiPengirimanBarang;

import TransaksiPengambilanBarang.LihatStatusPickUp;
import MainMenu.Login;
import MainMenu.MainMenuCS;
import TransaksiPengambilanBarang.TransaksiPemesanan;
import connection.DBConnect;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
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
 * @author SATRIA ADJIE PRAYOGA
 */
public class ListCargo extends javax.swing.JFrame {

    private DefaultTableModel model;
    DBConnect connection = new DBConnect();
    int i;
    String KantorCabang = "KMF JKT";
    String idBagging = "";
    String Bandara = "";
    String idPemesanan = "";
    String id_cs = "";
    List<String> pemesanan = new ArrayList();
    List<String> bagging = new ArrayList();
    List<String> bandara = new ArrayList();
    
    
    //Format uang
    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    
    /**
     * Creates new form ListCargo
     */
    public ListCargo() {
        initComponents();
        
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        model = new DefaultTableModel();
        
        tblCargo.setModel(model);
        addColumn();
        loadData();
        
        
    }
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    
    
    public ListCargo(String id,String KantorCabang) {
        initComponents();
        
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        model = new DefaultTableModel();
        this.KantorCabang = KantorCabang;
        this.id_cs = id;
        tblCargo.setModel(model);
        addColumn();
        loadData();
        
    }
    
        public ListCargo(String KantorCabang) {
        initComponents();
        
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        model = new DefaultTableModel();
        this.KantorCabang = KantorCabang;
        tblCargo.setModel(model);
        addColumn();
        loadData();
        
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
        txtIdCargo = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCargo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("List Cargo");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Cargo ID");

        txtIdCargo.setBackground(new java.awt.Color(204, 204, 255));

        btnCari.setBackground(new java.awt.Color(204, 255, 204));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnSelesai.setBackground(new java.awt.Color(204, 255, 204));
        btnSelesai.setText("Selesai");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        tblCargo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCargoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCargo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(txtIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(805, 805, 805)
                        .addComponent(btnSelesai)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdCargo)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelesai)
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 76, 890, -1));

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

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Update Pick Up");
        jLabel5.setToolTipText("");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Keluar");
        jLabel4.setToolTipText("");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
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

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainMenu/b.png"))); // NOI18N
        jLabel7.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(37, 37, 37))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 960, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addRiwayat(){
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        Format formatterTime = new SimpleDateFormat("hh:mm:ss");
        for(int i = 0; i < pemesanan.size() ; i++){
            try
            {
                DBConnect c = new DBConnect();
                String query = "INSERT INTO Riwayat VALUES (?,?,?,?)";
                     c.pstat = c.conn.prepareStatement(query);
                     c.pstat.setString(1, formatter.format(new Date()));
                     c.pstat.setString(2, formatterTime.format(new Date()));
                     c.pstat.setString(3, "Berangkat dari bandara " + bandara.get(i));
                     c.pstat.setString(4, pemesanan.get(i));

                      //insert ke dalam database
                c.pstat.executeUpdate();
                c.pstat.close();
                //JOptionPane.showMessageDialog(this, "insert data Baggin berhasil");
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data riwayat :" + e);
            }  
        }
        updateStatusCargo();
        updateStatusBarang();
    }
    private void updateStatusBarang(){
        for(int i = 0 ; i < pemesanan.size() ; i++){
            try {
                DBConnect connection = new DBConnect();
                String query = "UPDATE DataBarangPelanggan SET status_barang = 'Berangkat dari bandara " + bandara.get(i) + "' WHERE id_pemesanan=?";
                //System.out.println(query);
                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, pemesanan.get(i));

                connection.pstat.executeUpdate();
                connection.pstat.close();
                }
            catch (Exception e) {
                System.out.println("Terjadi error saat updateStatusBarang: " + e.toString());
            }
        }
        
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
    public void updateStatusCargo(){
        DBConnect connection = new DBConnect();
        try {
            String query;

            query = "UPDATE CargoManifest SET status='Belum' WHERE id_cargo_manifest='" + txtIdCargo.getText() + "'";
            System.out.println("updateStatusCargo "+query);
            connection.pstat = connection.conn.prepareStatement(query);

            connection.pstat.executeUpdate();
            loadData();
            //connection.result.close();
            //addRiwayat();
            //JOptionPane.showMessageDialog(this, "Bagging berhasil");
        } catch (Exception e) {
            System.out.println("Terjadi error saat updateStatusCargo: " + e.toString());
        }
    }
    public void CariData()
    {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        try{
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT distinct(c.id_cargo_manifest), c.bandara_asal, c.bandara_tujuan, c.berat_barang_total,c.berat_barang_total,\n" +
                    "C.jumlah_kantong,c.nomor_penerbangan,c.nomor_registrasi,c.status,c.tanggal_pemberangkatan,c.tanggal_sampai,\n" +
                    "c.total_biaya,c.waktu_pemberangkatan,c.waktu_pemberangkatan,c.waktu_sampai FROM CargoManifest AS C \n" +
                    "INNER JOIN detailCargo AS d ON c.id_cargo_manifest = d.id_cargo_manifest\n" +
                    "INNER JOIN detailBagging AS b ON d.id_bagging = b.id_bagging\n" +
                    "INNER JOIN Connote AS o ON o.id_connote = b.id_connote\n" +
                    "WHERE C.id_cargo_manifest='" + txtIdCargo.getText() +
                    "' AND o.kantor_cabang='" + getIDKantor(KantorCabang)+"'";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            
            while(connection.result.next()){
                Object[] obj = new Object[11];
                obj[0] = connection.result.getString("id_cargo_manifest");
                obj[1] = connection.result.getString("nomor_registrasi");
                obj[2] = connection.result.getString("nomor_penerbangan");
                obj[3] = connection.result.getString("bandara_asal");
                obj[4] = connection.result.getString("bandara_tujuan");
                obj[5] = connection.result.getString("tanggal_pemberangkatan") + " "+LocalTime.parse(connection.result.getString("waktu_pemberangkatan"));
                obj[6] = connection.result.getString("tanggal_sampai") + " " + LocalTime.parse(connection.result.getString("waktu_sampai")); 
                obj[7] = connection.result.getString("jumlah_kantong");
                obj[8] = connection.result.getString("berat_barang_total");
                obj[9] = kursIndonesia.format(Integer.parseInt((connection.result.getString("total_biaya")).substring(0, (connection.result.getString("total_biaya")).length()-5)));
                obj[10] = connection.result.getString("status");
                
                model.addRow(obj);
                i = 1;
            }
            if(model.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Data Cargo tidak ditemukan");
                i = 0;
            }
            connection.stat.close();
            connection.result.close();
        }catch(Exception ex){
            System.out.println("Terjadi error saat load data: " + ex);
        }
        resizeColumnWidth(tblCargo);
    }
    
    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        CariData();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        // TODO add your handling code here:
        MainMenuCS cs = new MainMenuCS(id_cs, KantorCabang);
        cs.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSelesaiActionPerformed
    
    private void tblCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargoMouseClicked
        // TODO add your handling code here:
        String query;
        
        
        
        int i = tblCargo.getSelectedRow();
        if(i != -1){
            txtIdCargo.setText(tblCargo.getValueAt(i, 0).toString());
        }
        String IdCargo = txtIdCargo.getText();
        
        
        if(IdCargo.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Textbox id masih kosong!");
        }
        else
        {
            try{
                connection.stat = connection.conn.createStatement();
                query = "SELECT * FROM CargoManifest AS C\n" +
                            "INNER JOIN detailCargo AS d ON c.id_cargo_manifest = d.id_cargo_manifest\n" +
                            "INNER JOIN detailBagging AS b ON d.id_bagging = b.id_bagging\n" +
                            "INNER JOIN Connote AS O ON O.id_connote = b.id_connote\n" +
                            "WHERE C.id_cargo_manifest = '" + txtIdCargo.getText() + "'";
                System.out.println(query);
                connection.result = connection.stat.executeQuery(query);
                while (connection.result.next()) {
                    idBagging = (connection.result.getString("id_bagging"));
                    Bandara = (connection.result.getString("bandara_asal"));
                    idPemesanan = (connection.result.getString("id_pemesanan"));
                    bagging.add(idBagging);
                    bandara.add(Bandara);
                    pemesanan.add(idPemesanan);
                }
            }
            catch (Exception e){
                    System.out.println("Terjadi error saat mencari id bagging: " + e.toString());
            }
            int jawab = JOptionPane.showOptionDialog(this, 
                "Konfirmasi Cargo",  
                "Konfirmasi", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(jawab == JOptionPane.YES_OPTION){
                for(int h = 0; h < bagging.size();h++){
                    try{
                    query = "UPDATE detailBagging SET status_barang_bagging = 'Berangkat dari bandara "
                            + bandara.get(h) + "' WHERE id_bagging='"
                            + bagging.get(h) + "'";

                    connection.pstat = connection.conn.prepareStatement(query);

                    connection.pstat.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println("Terjadi error saat update status Cargo: " + e.toString());
                    }
                }
                JOptionPane.showMessageDialog(this, "Status barang sudah diupdate");
                
                addRiwayat();
            }
        }
    }//GEN-LAST:event_tblCargoMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        TransaksiPemesanan transaksi = new TransaksiPemesanan(id_cs, KantorCabang);
        this.setVisible(false);
        transaksi.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        LihatStatusPickUp s = new LihatStatusPickUp(id_cs,KantorCabang);
        s.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Login t= new Login();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        ListCargo c = new ListCargo(id_cs, KantorCabang);
        this.setVisible(false);
        c.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked


    public void addColumn()
    {
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
    
    public void loadData()
    {
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        
        try{
            connection.stat = connection.conn.createStatement();
            String query = "SELECT distinct(c.id_cargo_manifest), c.bandara_asal, c.bandara_tujuan, c.berat_barang_total,c.berat_barang_total,\n" +
                    "C.jumlah_kantong,c.nomor_penerbangan,c.nomor_registrasi,c.status,c.tanggal_pemberangkatan,c.tanggal_sampai,\n" +
                    "c.total_biaya,c.waktu_pemberangkatan,c.waktu_pemberangkatan,c.waktu_sampai FROM CargoManifest AS C \n" +
                    "INNER JOIN detailCargo AS d ON c.id_cargo_manifest = d.id_cargo_manifest\n" +
                    "INNER JOIN detailBagging AS b ON d.id_bagging = b.id_bagging\n" +
                    "INNER JOIN Connote AS o ON o.id_connote = b.id_connote\n" +
                    "WHERE o.kantor_cabang='" + getIDKantor(KantorCabang)  + "' and c.status != 'Sampai' and c.status != 'Gagal' and c.status != 'Belum'";
//            String query = "SELECT * FROM CargoManifest";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            
            while(connection.result.next()){
                Object[] obj = new Object[11];
                
                obj[0] = connection.result.getString("id_cargo_manifest");
                obj[1] = connection.result.getString("nomor_registrasi");
                obj[2] = connection.result.getString("nomor_penerbangan");
                obj[3] = connection.result.getString("bandara_asal");
                obj[4] = connection.result.getString("bandara_tujuan");
                obj[5] = connection.result.getString("tanggal_pemberangkatan") + " "+LocalTime.parse(connection.result.getString("waktu_pemberangkatan"));
                obj[6] = connection.result.getString("tanggal_sampai") + " " + LocalTime.parse(connection.result.getString("waktu_sampai")); 
                obj[7] = connection.result.getString("jumlah_kantong");
                obj[8] = connection.result.getString("berat_barang_total");
                obj[9] = kursIndonesia.format(Integer.parseInt((connection.result.getString("total_biaya")).substring(0, (connection.result.getString("total_biaya")).length()-5)));
                obj[10] = connection.result.getString("status");
                
                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        }catch(Exception e){
            System.out.println("Terjadi error saat load data cargo: " + e);
        }
        resizeColumnWidth(tblCargo);
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
            java.util.logging.Logger.getLogger(ListCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListCargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCargo;
    private javax.swing.JTextField txtIdCargo;
    // End of variables declaration//GEN-END:variables
}
