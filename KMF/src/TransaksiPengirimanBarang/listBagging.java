/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransaksiPengirimanBarang;

import MainMenu.MainMenuStaffKirim;
import connection.DBConnect;
import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author putri ramadani rais
 */
public class listBagging extends javax.swing.JFrame {

    private DefaultTableModel model;
    private String KantorCabang = "";
    private DBConnect connection = new DBConnect();
    /**
     * Creates new form listBagging
     */
    public listBagging() {
        initComponents();
        model = new DefaultTableModel();
        addItemKota();
        addColumn();
        addDataColumn();
        tableBagging.setModel(model);
        txtKantorCabang.setText(KantorCabang);
    }
    
     public listBagging(String kantorCabang) {
        initComponents();
        this.KantorCabang = getIDKantor(kantorCabang);
        txtKantorCabang.setText(kantorCabang);
        model = new DefaultTableModel();
        addColumn();
        addDataColumn();
        addItemKota();
        tableBagging.setModel(model);
        
    }
    
    private void addColumn(){
        model.addColumn("ID Bagging");
        model.addColumn("Jumlah");
        model.addColumn("Berat");
        model.addColumn("Tanggal");
        model.addColumn("Status Bagging");
    }
    
    private void addItemKota(){
        cmbkota_tujuan.removeAll();
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
    
    private String getSingkatan(String in){
        
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
    
    private boolean getTrueID(){
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select * from Bagging where id_bagging = '"+txtid_bagging.getText()+"'";
            connection.result = connection.stat.executeQuery(query);
            String output = "";
            while (connection.result.next()) {

                output = (connection.result.getString("status_bagging"));

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
    
    private void addDataColumn(){
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();

        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = 
            
           "select * from Bagging \n inner join detailBagging a on [Bagging].id_bagging = a.id_bagging"+
            " inner join Connote b on a.id_connote = b.id_connote "+
            " inner join DataBarangPelanggan c on b.id_pemesanan = c.id_pemesanan "+
            " inner join KantorCabang d on c.kode_kantor_cabang = d.kode_kantor_cabang "+
            " inner join KotaKabupaten e on d.kota = e.singkatan "+
            " where d.kode_kantor_cabang = '"+getIDKantor(txtKantorCabang.getText())+
            "' and status_bagging = 'Belum'";
            System.out.println(query);
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                Object[] obj = new Object[5];
                	
                obj[0] = connection.result.getString("id_bagging");
                obj[1] = connection.result.getString("jumlah");
                obj[2] = connection.result.getString("berat");
                obj[3] = connection.result.getString("tanggal");
                obj[4] = connection.result.getString("status_bagging");
                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal111!\n" + e.toString());
        }
    }
    
    private String getIDKantor(String in){
        
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select kode_kantor_cabang from KantorCabang where nama_kantor = '"+in+"'";
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
    
    private boolean belumCargo(){
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select * from detailCargo where id_bagging = '"+txtid_bagging.getText()+"' and id_cargo_manifest = '"+txtid_cargo.getText()+"'";
            connection.result = connection.stat.executeQuery(query);
            String output = "";
            while (connection.result.next()) {

                output = (connection.result.getString("status_barang_bagging"));

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
    
    private int getBerat(String in){
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
    
    private void inputCargo(){
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HHmm");
        String time = formatterTime.format(new Date());
        if(belumCargo()){
            try
            {
                DBConnect c = new DBConnect();
                String query = "INSERT INTO CargoManifest VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                     c.pstat = c.conn.prepareStatement(query);
                     c.pstat.setString(1, txtid_cargo.getText());
                     c.pstat.setString(2, "");
                     c.pstat.setString(3, "");
                     c.pstat.setString(4, ""+txtKantorCabang);
                     c.pstat.setString(5, ""+cmbkota_tujuan.getSelectedItem());
                     c.pstat.setString(6, formatter.format(new Date()));
                     c.pstat.setString(7, time);
                     c.pstat.setString(8, "");
                     c.pstat.setString(9, "");
                     c.pstat.setString(10, "");
                     c.pstat.setString(11, ""+getBerat(txtid_bagging.getText()));
                     c.pstat.setString(12, "");
                     c.pstat.setString(13, "");

                      //insert ke dalam database
                c.pstat.executeUpdate();
                c.pstat.close();
                //JOptionPane.showMessageDialog(this, "insert data Baggin berhasil");
            }catch(Exception e){
                //JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data bagging :" + e);
                try
                {
                    int i = getBerat(txtid_bagging.getText());

                    DBConnect c = new DBConnect();
                    String query = "update CargoManifest set jumlah = jumlah+1, berat = berat+? where id_cargo_manifest = '"+txtid_cargo.getText()+"'";
                         c.pstat = c.conn.prepareStatement(query);
                         c.pstat.setString(1, ""+i);


                    //insert ke dalam database
                    c.pstat.executeUpdate();
                    c.pstat.close();
                    //JOptionPane.showMessageDialog(this, "insert data connote berhasil");
                }catch(Exception n){
                    JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data connote :" + n);
                }
            }
            inputDetailCargo();
        }else{
            JOptionPane.showMessageDialog(this, "Sudah dibagging");
        }
        
    }
    private void inputDetailCargo(){
        try
        {
            DBConnect c = new DBConnect();
            String query = "INSERT INTO detailCargo VALUES (?,?,?)";
                 c.pstat = c.conn.prepareStatement(query);
                 c.pstat.setString(1, txtid_cargo.getText());
                 c.pstat.setString(2, txtid_bagging.getText());
                 c.pstat.setString(3, "Akan dikirim");
                 

                  //insert ke dalam database
            c.pstat.executeUpdate();
            c.pstat.close();
            //JOptionPane.showMessageDialog(this, "insert data Bagging berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data detailBagging :" + e);
        }
    }
    
    private String autoID()
    {
        String maxID = null;
        int idtr = 0;
        String id = null;
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        try{
            connection.stat = connection.conn.createStatement();
            String query = "SELECT count(id_cargo_manifest) as ID FROM CargoManifest WHERE id_cargo_manifest LIKE '%"+formatter.format(new Date())+"%'";
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableBagging = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnBuat = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKantorCabang = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbkota_tujuan = new javax.swing.JComboBox<>();
        btnCargo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtid_cargo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtid_bagging = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBuat.setText("Buat");
        btnBuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuatActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Daftar Cargo");

        jLabel4.setText("Kantor Cabang");

        txtKantorCabang.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtKantorCabang.setText("jLabel5");

        jLabel2.setText("Kota Tujuan");

        cmbkota_tujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Kota-" }));
        cmbkota_tujuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbkota_tujuanItemStateChanged(evt);
            }
        });

        btnCargo.setText("Tambah");
        btnCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargoActionPerformed(evt);
            }
        });

        jLabel5.setText("ID Cargo");

        txtid_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_cargoActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Bagging");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuat))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtid_bagging, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCargo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(27, 27, 27))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbkota_tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(223, 223, 223)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKantorCabang, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(40, 40, 40)))))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(258, 258, 258))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(cmbkota_tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtKantorCabang))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtid_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtid_bagging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(btnCargo))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnBuat))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableBaggingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBaggingMouseClicked
        // TODO add your handling code here:
        int i = tableBagging.getSelectedRow();
        if (i == -1) {
            return;
        }

        txtid_bagging.setText((String) model.getValueAt(i, 0));

        JOptionPane.showMessageDialog(this, txtid_bagging.getText() + " Dipilih!\n");
    }//GEN-LAST:event_tableBaggingMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainMenuStaffKirim m = new MainMenuStaffKirim(KantorCabang);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuatActionPerformed
        CargoManifest c = new CargoManifest(KantorCabang);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBuatActionPerformed

    private void cmbkota_tujuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbkota_tujuanItemStateChanged
        // TODO add your handling code here:
        Format formatterDate = new SimpleDateFormat("yyyyMMdd");
        addDataColumn();
        txtid_cargo.setText((getSingkatan(cmbkota_tujuan.getSelectedItem().toString()))+"-"+formatterDate.format(new Date())+autoID());
    }//GEN-LAST:event_cmbkota_tujuanItemStateChanged

    private void btnCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargoActionPerformed
        if(getTrueID()){
            //updateStatusConnote();
            //inputBagging();
        }else{
            JOptionPane.showMessageDialog(this," ID Tidak ditemukan !\n");
        }

    }//GEN-LAST:event_btnCargoActionPerformed

    private void txtid_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_cargoActionPerformed

    }//GEN-LAST:event_txtid_cargoActionPerformed

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
            java.util.logging.Logger.getLogger(listBagging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listBagging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listBagging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listBagging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listBagging().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuat;
    private javax.swing.JButton btnCargo;
    private javax.swing.JComboBox<String> cmbkota_tujuan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBagging;
    private javax.swing.JLabel txtKantorCabang;
    private javax.swing.JTextField txtid_bagging;
    private javax.swing.JTextField txtid_cargo;
    // End of variables declaration//GEN-END:variables
}
