/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransaksiPengirimanBarang;

import MainMenu.MainMenuStaff;
import MainMenu.MainMenuStaffKirim;
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
public class Bagging extends javax.swing.JFrame {

    /**
     * Creates new form Bagging
     */
    private DefaultTableModel model;
    private String KantorCabang = "KMF JKT";
    private DBConnect connection = new DBConnect();
    
    
    public Bagging() {
        initComponents();
        
        //this.KantorCabang = getIDKantor(kantorCabang);
        
        model = new DefaultTableModel();
        addColumn();
        addDataColumn();
        addItemKota();
        tableBagging.setModel(model);
        txtKantorCabang.setText(KantorCabang);
    }

    public Bagging(String kantorCabang) {
        initComponents();
        this.KantorCabang = kantorCabang;
        txtKantorCabang.setText(kantorCabang);
        model = new DefaultTableModel();
        addColumn();
        addDataColumn();
        addItemKota();
        tableBagging.setModel(model);
        
    }
    
    private void addColumn(){
        model.addColumn("ID Connote");
        model.addColumn("Nama Pengirim");
        model.addColumn("Jenis Barang");
        model.addColumn("Nama Penerima");
    }
    private void addDataColumn(){
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();

        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = 
            "select [Connote].id_connote, [Pelanggan].nama_pelanggan, [DataBarangPelanggan].jenis_barang, [DataBarangPelanggan].nama_penerima\n" +
            "from [Connote] inner join [DataBarangPelanggan] on [Connote].id_pemesanan = [DataBarangPelanggan].id_pemesanan\n" +
            "inner join [Pelanggan] on [DataBarangPelanggan].id_pelanggan = [Pelanggan].id_pelanggan where [DataBarangPelanggan].kota_penerima = '"+cmbkota_tujuan.getSelectedItem().toString()+"' \n" +
            "and [DataBarangPelanggan].kode_kantor_cabang = '"+getIDKantor(txtKantorCabang.getText())+"' and [Connote].status_pengiriman = 'Belum'";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                Object[] obj = new Object[11];
                	
                obj[0] = connection.result.getString("id_connote");
                obj[1] = connection.result.getString("nama_pelanggan");
                obj[2] = connection.result.getString("jenis_barang");
                obj[3] = connection.result.getString("nama_penerima");

                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal111!\n" + e.toString());
        }
    }
    private void addItemKota(){
        cmbkota_tujuan.removeAll();
        DBConnect connection = new DBConnect();
        try {
            
            connection.stat = connection.conn.createStatement();
            String query = "select nama_kota from KotaKabupaten";
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                cmbkota_tujuan.addItem(connection.result.getString("nama_kota"));
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal111!\n" + e.toString());
        }
    }
    private String getIDKantor(String in){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select kode_kantor_cabang from KantorCabang where nama_kantor = '"+in+"'";
            connection.result = connection.stat.executeQuery(query);
            System.out.println(query);
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
    private String getIDKantorPengirim(String in){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select kode_kantor_cabang from KantorCabang where kota = '"+in+"'";
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
    private String getSingkatan(String in){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select singkatan from KotaKabupaten where nama_kota = '"+in+"'";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);
            String output = null;
            while (connection.result.next()) {

                output = (connection.result.getString("singkatan"));

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
    private int getBerat(String in){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select [DataBarangPelanggan].berat_barang as singkatan from DataBarangPelanggan inner join Connote "
                    + "on [DataBarangPelanggan].id_pemesanan = [Connote].id_pemesanan where [Connote].id_connote ='"+in+"'";
            connection.result = connection.stat.executeQuery(query);
            int output = 0;
            while (connection.result.next()) {

                output = Integer.parseInt(connection.result.getString("singkatan"));

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
    
    private boolean getTrueID(){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select * from Connote inner join DataBarangPelanggan a on Connote.id_pemesanan = a.id_pemesanan\n" +
                "where Connote.id_connote = '"+txtid_connote.getText()+"' and a.kode_kantor_cabang = '"+getIDKantor(KantorCabang)+"'";
            connection.result = connection.stat.executeQuery(query);
            System.out.println(query);
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
    private boolean belumBagging(){
        DBConnect connection = new DBConnect();
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select * from detailBagging where id_connote = '"+txtid_connote.getText()+"' and id_bagging = '"+txtid_bagging.getText()+"'";
            connection.result = connection.stat.executeQuery(query);
            String output = "";
            while (connection.result.next()) {

                output = (connection.result.getString("status_pengiriman"));

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
                return true;
        }
        }
    private void updateStatusConnote(){
        DBConnect connection = new DBConnect();
        try {
                String query;
            
                query = "UPDATE Connote SET status_pengiriman='Dikirim' WHERE id_connote='"+txtid_connote.getText()+"'";
                
                connection.pstat = connection.conn.prepareStatement(query);
                
                connection.pstat.executeUpdate();
                //connection.result.close();

                addDataColumn();
                JOptionPane.showMessageDialog(this, "Bagging berhasil");
            }
            catch (Exception e) {
                System.out.println("Terjadi error saat update status connote: " + e.toString());
            }
    }
    private void inputBagging(){
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        if(belumBagging()){
            try
            {
                DBConnect c = new DBConnect();
                String query = "INSERT INTO Bagging VALUES (?,?,?,?,?)";
                     c.pstat = c.conn.prepareStatement(query);
                     c.pstat.setString(1, txtid_bagging.getText());
                     c.pstat.setString(2, "1");
                     c.pstat.setString(3, ""+getBerat(txtid_connote.getText()));
                     c.pstat.setString(4, formatter.format(new Date()));
                     c.pstat.setString(5, "Belum");

                      //insert ke dalam database
                c.pstat.executeUpdate();
                c.pstat.close();
                //JOptionPane.showMessageDialog(this, "insert data Baggin berhasil");
            }catch(Exception e){
                //JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data bagging :" + e);
                try
                {
                    int i = getBerat(txtid_connote.getText());

                    DBConnect c = new DBConnect();
                    String query = "update Bagging set jumlah = jumlah+1, berat = berat+? where id_bagging = '"+txtid_bagging.getText()+"'";
                         c.pstat = c.conn.prepareStatement(query);
                         c.pstat.setString(1, ""+i);


                          //insert ke dalam database
                    c.pstat.executeUpdate();
                    c.pstat.close();
                    //JOptionPane.showMessageDialog(this, "insert data connote berhasil");
                }catch(Exception n){
                    JOptionPane.showMessageDialog(this,"Terjadi error pada saat inputBagginge :" + n);
                }
            }
            inputDetailBagging();
        }else{
            JOptionPane.showMessageDialog(this, "Sudah dibagging");
        }
        
    }
    private void inputDetailBagging(){
        try
        {
            DBConnect c = new DBConnect();
            String query = "INSERT INTO detailBagging VALUES (?,?,?)";
                 c.pstat = c.conn.prepareStatement(query);
                 c.pstat.setString(1, txtid_bagging.getText());
                 c.pstat.setString(2, txtid_connote.getText());
                 c.pstat.setString(3, "Akan dikirim");
                 

                  //insert ke dalam database
            c.pstat.executeUpdate();
            c.pstat.close();
            txtid_connote.setText("");
            //JOptionPane.showMessageDialog(this, "insert data Bagging berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data detailBagging :" + e);
        }
    }
    private String autoID()
    {
        DBConnect connection = new DBConnect();
        String maxID = null;
        int idtr = 0;
        String id = null;
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        try{
            connection.stat = connection.conn.createStatement();
            String query = "SELECT count(id_bagging) as ID FROM Bagging WHERE id_bagging LIKE '%"+formatter.format(new Date())+"%'";
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

        } catch(Exception ex){
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBagging = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbkota_tujuan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtid_connote = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKantorCabang = new javax.swing.JLabel();
        btnBagging = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtid_bagging = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblcek = new javax.swing.JLabel();
        lblsortir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblbagg = new javax.swing.JLabel();
        lbldatacar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Sesi Bagging");

        tableBagging.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBagging.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBaggingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBagging);

        jLabel2.setText("Kota Tujuan");

        cmbkota_tujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Kota-" }));
        cmbkota_tujuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbkota_tujuanItemStateChanged(evt);
            }
        });

        jLabel3.setText("ID Connote");

        txtid_connote.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setText("Kantor Cabang");

        txtKantorCabang.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtKantorCabang.setText("jLabel5");

        btnBagging.setBackground(new java.awt.Color(204, 255, 204));
        btnBagging.setText("Bagging");
        btnBagging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaggingActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setText("Selesai");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("ID Bagging");

        txtid_bagging.setBackground(new java.awt.Color(204, 204, 255));
        txtid_bagging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_baggingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(23, 23, 23)
                                    .addComponent(txtid_connote, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnBagging)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(24, 24, 24)
                                .addComponent(txtid_bagging, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbkota_tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(194, 194, 194)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtKantorCabang, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbkota_tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtid_bagging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKantorCabang))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid_connote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBagging, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(28, 28, 28))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 700));

        lblcek.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblcek.setForeground(new java.awt.Color(255, 255, 255));
        lblcek.setText("Cek Connote");
        lblcek.setToolTipText("");
        lblcek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcekMouseClicked(evt);
            }
        });

        lblsortir.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblsortir.setForeground(new java.awt.Color(255, 255, 255));
        lblsortir.setText("Sortir Barang");
        lblsortir.setToolTipText("");
        lblsortir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsortirMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Keluar");
        jLabel6.setToolTipText("");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        lblbagg.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblbagg.setForeground(new java.awt.Color(255, 255, 255));
        lblbagg.setText("Bagging Barang");
        lblbagg.setToolTipText("");
        lblbagg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbaggMouseClicked(evt);
            }
        });

        lbldatacar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbldatacar.setForeground(new java.awt.Color(255, 255, 255));
        lbldatacar.setText("Data Cargo Manifest");
        lbldatacar.setToolTipText("");
        lbldatacar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldatacarMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\_PROJEK BESAR RPL\\logokmf.png")); // NOI18N
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
                            .addComponent(lbldatacar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblsortir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblbagg)
                            .addComponent(lblcek, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcek, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblsortir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblbagg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbldatacar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 174, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbkota_tujuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbkota_tujuanItemStateChanged
        // TODO add your handling code here:
        Format formatterDate = new SimpleDateFormat("yyyyMMdd");
        addDataColumn();
        txtid_bagging.setText(getIDKantorPengirim(getSingkatan(cmbkota_tujuan.getSelectedItem().toString()))+"-"+formatterDate.format(new Date())+autoID());
    }//GEN-LAST:event_cmbkota_tujuanItemStateChanged

    private void tableBaggingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBaggingMouseClicked
        // TODO add your handling code here:
        int i = tableBagging.getSelectedRow();
        if (i == -1) {
            return;
        }
        
        txtid_connote.setText((String) model.getValueAt(i, 0));
        


        JOptionPane.showMessageDialog(this, txtid_connote.getText() + " Dipilih!\n");
    }//GEN-LAST:event_tableBaggingMouseClicked

    private void btnBaggingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaggingActionPerformed
        // TODO add your handling code here:
        if(getTrueID()){
            updateStatusConnote();
            inputBagging();
        }else{
            JOptionPane.showMessageDialog(this," ID Tidak ditemukan !\n");
        }
        
    }//GEN-LAST:event_btnBaggingActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        MainMenuStaffKirim t = new MainMenuStaffKirim(txtKantorCabang.getText());
        t.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtid_baggingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_baggingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_baggingActionPerformed

    private void lblcekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcekMouseClicked
        CekDoc c = new CekDoc(KantorCabang);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblcekMouseClicked

    private void lblsortirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsortirMouseClicked
        Sortir s = new Sortir(KantorCabang);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblsortirMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        MainMenuStaff t= new MainMenuStaff(KantorCabang);
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void lblbaggMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbaggMouseClicked
        Bagging bag = new Bagging(KantorCabang);
        bag.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblbaggMouseClicked

    private void lbldatacarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldatacarMouseClicked
        listBagging bag = new listBagging(KantorCabang);
        this.setVisible(false);
        bag.setVisible(true);
    }//GEN-LAST:event_lbldatacarMouseClicked

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
            java.util.logging.Logger.getLogger(Bagging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bagging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bagging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bagging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bagging().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBagging;
    private javax.swing.JComboBox<String> cmbkota_tujuan;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbagg;
    private javax.swing.JLabel lblcek;
    private javax.swing.JLabel lbldatacar;
    private javax.swing.JLabel lblsortir;
    private javax.swing.JTable tableBagging;
    private javax.swing.JLabel txtKantorCabang;
    private javax.swing.JTextField txtid_bagging;
    private javax.swing.JTextField txtid_connote;
    // End of variables declaration//GEN-END:variables
}
