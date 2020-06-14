/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransaksiPengirimanBarang;

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
    private String KantorCabang = "";
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
        this.KantorCabang = getIDKantor(kantorCabang);
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
            "select [Connote].id_connote, "
                    + "[Pelanggan].nama_pelanggan, "
                    + "[DataBarangPelanggan].jenis_barang, "
                    + "[DataBarangPelanggan].nama_penerima\n" +
            "from [Connote] "
                    + "inner join [DataBarangPelanggan] on [Connote].id_pemesanan = [DataBarangPelanggan].id_pemesanan\n" +
                      "inner join [Pelanggan] on [DataBarangPelanggan].id_pelanggan = [Pelanggan].id_pelanggan "
          + "where [DataBarangPelanggan].kota_penerima = '"+cmbkota_tujuan.getSelectedItem().toString()+"' \n" +
            "and [DataBarangPelanggan].kode_kantor_cabang = '"+getIDKantor(txtKantorCabang.getText())
           +"' and [Connote].status_pengiriman = 'Belum'";
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
    private String getIDKantorPengirim(String in){
        
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
        try{
            connection.stat = connection.conn.createStatement();
            String query = "select * from Connote where id_connote = '"+txtid_connote.getText()+"'";
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
    private boolean belumBagging(){
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
                System.out.println("Terjadi error saat update status cargo: " + e.toString());
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
                    JOptionPane.showMessageDialog(this,"Terjadi error pada saat insert data connote :" + n);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel4.setText("Kantor Cabang");

        txtKantorCabang.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtKantorCabang.setText("jLabel5");

        btnBagging.setText("Bagging");
        btnBagging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaggingActionPerformed(evt);
            }
        });

        jButton2.setText("Selesai");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("ID Bagging");

        txtid_bagging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_baggingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbkota_tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(62, 62, 62))
                                    .addComponent(txtKantorCabang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtid_connote)
                                    .addComponent(txtid_bagging, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBagging)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbkota_tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKantorCabang)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtid_bagging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtid_connote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBagging, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButton2)
                .addContainerGap())
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBagging;
    private javax.swing.JLabel txtKantorCabang;
    private javax.swing.JTextField txtid_bagging;
    private javax.swing.JTextField txtid_connote;
    // End of variables declaration//GEN-END:variables
}
