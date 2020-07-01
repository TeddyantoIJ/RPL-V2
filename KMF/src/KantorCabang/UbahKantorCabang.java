/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KantorCabang;

import MainMenu.MainMenuStaffKelola;
import connection.DBConnect;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author harvianti Putri
 */
public class UbahKantorCabang extends javax.swing.JFrame {
    private DefaultTableModel model;
    DBConnect connection = new DBConnect();
    String kode_kantor_cabang;
    String nama_kantor;
    String telepon;
    String alamat;
    String status_aktif;
    private String KantorCabang = "";
    
    /**
     * Creates new form UbahKantorCabang
     */
    public UbahKantorCabang() {
        initComponents();
        model = new DefaultTableModel();
        
        tblKantorCabang.setModel(model);
        addcolumn();
         
    }
    
    public UbahKantorCabang(String kantorCabang) {
        initComponents();
        this.KantorCabang = kantorCabang;
        
        model = new DefaultTableModel();
        
        tblKantorCabang.setModel(model);
        addcolumn();    
    }
    
    public void tampilStatus()
    {
        try{
            DBConnect c = new DBConnect();
            c.stat = c.conn.createStatement();
            String sql = "SELECT status_aktif FROM KantorCabang";
            c.result = c.stat.executeQuery(sql);
            
            while (c.result.next()){
                cmbStatus.addItem(c.result.getString("status_aktif"));
            }
            c.stat.close();
            c.result.close();
          
        }catch (Exception ex){
            System.out.println("Terjadi erro saat load data status" + ex);
        }
    }
    
    public void addcolumn()
    {
        model.addColumn("Kode Kantor Cabang");
        model.addColumn("Nama Kantor Cabang");
        model.addColumn("Telepon");
        model.addColumn("Alamat Kantor Cabang");
        model.addColumn("Status");
    }
    
    private void clear()
    {
        txtKodeKC.setText("");
        txtNamaKC.setText("");
        txtTeleponKC.setText("");
        txtAlamatKC.setText("");
       
    }
    
    public void loaddata()
    {
        model.getDataVector().removeAllElements();
        
        //memberi tahu data telah kosong
        
        model.fireTableDataChanged();
        
        try{
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM KantorCabang";
            connection.result = connection.stat.executeQuery(query);
            //lakukan perbaris data
            while(connection.result.next()){
                Object[] obj = new Object[6];
                obj[0] = connection.result.getString("kode_kantor_cabang");
                obj[1] = connection.result.getString("nama_kantor");
                obj[2] = connection.result.getString("telphone");
                obj[3] = connection.result.getString("alamat");
                obj[4] = connection.result.getString("status_aktif");
                
                model.addRow(obj);
            }
            
            connection.stat.close();
            connection.result.close();
            
        } catch (Exception e)
        {
            System.out.println("Terjadi error saat load data kantor cabang" + e);
        }
        
        
    }
    public void showbyKode()
    {
         model.getDataVector().removeAllElements();
        
        //memberi tahu data telah kosong
        model.fireTableDataChanged();
        
        try{
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM KantorCabang WHERE kode_kantor_cabang LIKE '%" + txtKodeKC.getText() + "%'";
            connection.result = connection.stat.executeQuery(query);
            
            //lakukakn perbaris data
            while (connection.result.next()){
                Object[] obj = new Object[6];
                obj[0] = connection.result.getString("kode_kantor_cabang");
                obj[1] = connection.result.getString("nama_kantor");
                obj[2] = connection.result.getString("telphone");
                obj[3] = connection.result.getString("alamat");
                obj[4] = connection.result.getString("status_aktif");
                
                model.addRow(obj);
            }
            
            //jika di tabel tidak ada data yg dicari
            if (model.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(this," Data kantor cabang tidak ditemukan");
                
            }
            connection.stat.close();
            connection.result.close();
        }
        catch(Exception e)
        {
            System.out.println("Terjadi error pada saat load data kantor cabang" + e);
        }
        
    }
    
    
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtKodeKC = new javax.swing.JTextField();
        txtNamaKC = new javax.swing.JTextField();
        btnUbah1 = new javax.swing.JButton();
        txtTeleponKC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamatKC = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKantorCabang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnKembali1 = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(950, 400));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtKodeKC.setBackground(new java.awt.Color(204, 204, 255));
        txtKodeKC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeKCActionPerformed(evt);
            }
        });

        txtNamaKC.setBackground(new java.awt.Color(204, 204, 255));
        txtNamaKC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaKCKeyTyped(evt);
            }
        });

        btnUbah1.setBackground(new java.awt.Color(204, 255, 204));
        btnUbah1.setText("Cari");
        btnUbah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbah1ActionPerformed(evt);
            }
        });

        txtTeleponKC.setBackground(new java.awt.Color(204, 204, 255));
        txtTeleponKC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTeleponKCKeyTyped(evt);
            }
        });

        jLabel2.setText("Kode Kantor Cabang");

        txtAlamatKC.setBackground(new java.awt.Color(204, 204, 255));
        txtAlamatKC.setColumns(20);
        txtAlamatKC.setRows(5);
        jScrollPane1.setViewportView(txtAlamatKC);

        jLabel5.setText("Alamat");

        jLabel3.setText("Nama Kantor Cabang");

        jLabel4.setText("Telepon");

        jLabel8.setText("Status");

        cmbStatus.setBackground(new java.awt.Color(204, 204, 255));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buka", "Tutup" }));

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("Batal");

        btnUbah.setBackground(new java.awt.Color(204, 255, 204));
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(txtKodeKC, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnUbah)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(txtNamaKC)
                                .addComponent(txtTeleponKC)
                                .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(92, 92, 92)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnUbah, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKodeKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUbah1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNamaKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTeleponKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(btnUbah))))))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ubah Data Kantor Cabang");

        tblKantorCabang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKantorCabang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKantorCabangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKantorCabang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        btnKembali1.setBackground(new java.awt.Color(204, 255, 204));
        btnKembali1.setText("Kembali");
        btnKembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembali1ActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(204, 255, 204));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah)
                    .addComponent(btnKembali1))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKembali1)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
       kode_kantor_cabang = txtKodeKC.getText();
       nama_kantor = txtNamaKC.getText();
       telepon = txtTeleponKC.getText();
       alamat = txtAlamatKC.getText();
        if(cmbStatus.getSelectedItem() == "Aktif")
        {
            status_aktif = "1";
        }
        else
        {
            status_aktif = "0";
        }
       
       
//       if(kode_kantor_cabang.equals("")|| nama_kantor.equals("")|| telepon.equals("") || alamat.equals("")|| provinsi.equals("") || kotakab.equals("")){
//            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!");
//        }
//        else
//        {
//            
       try
       {
           String query = "UPDATE KantorCabang set nama_kantor=?, telphone=?, alamat=?, status_aktif=? WHERE kode_kantor_cabang=?";
           connection.pstat = connection.conn.prepareStatement(query);
           connection.pstat.setString(1, nama_kantor);
           connection.pstat.setString(2, telepon);
           connection.pstat.setString(3, alamat);
           connection.pstat.setString(4, status_aktif);
           connection.pstat.setString(5, kode_kantor_cabang);
           
           connection.pstat.executeUpdate(); //insert ke database
           connection.pstat.close(); //menutup koneksi database
           loaddata();
           clear();
           
            
       }catch(Exception e)
       {
            System.out.println("Terjadi error saat update kantor cabang" + e);
       }
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tblKantorCabangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKantorCabangMouseClicked
       
         int i = tblKantorCabang.getSelectedRow();
        if( i == 1 )
        {
            return;
        }
       txtKodeKC.setText((String) model.getValueAt(i, 0));
       txtNamaKC.setText((String) model.getValueAt(i, 1));
       txtTeleponKC.setText((String) model.getValueAt(i, 2));
       txtAlamatKC.setText((String) model.getValueAt(i, 3));
       cmbStatus.setSelectedItem((String) model.getValueAt(i, 4));
       
    }//GEN-LAST:event_tblKantorCabangMouseClicked

    private void btnUbah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbah1ActionPerformed
        // TODO add your handling code here:
        showbyKode();
      
    }//GEN-LAST:event_btnUbah1ActionPerformed

    private void txtNamaKCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKCKeyTyped
        // TODO add your handling code here:
         char enter = evt.getKeyChar();
            if(!Character.isLetter(enter) && !Character.isISOControl(enter) && !Character.isWhitespace(enter)){
                evt.consume();
            }
    }//GEN-LAST:event_txtNamaKCKeyTyped

    private void txtTeleponKCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeleponKCKeyTyped
        // TODO add your handling code here:
         char enter = evt.getKeyChar();
            if(txtTeleponKC.getText().length()==13){
            evt.consume();
            }
    }//GEN-LAST:event_txtTeleponKCKeyTyped

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        TambahKantorCabang t = new TambahKantorCabang(KantorCabang);
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembali1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnKembali1ActionPerformed

    private void txtKodeKCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeKCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeKCActionPerformed

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
            java.util.logging.Logger.getLogger(UbahKantorCabang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UbahKantorCabang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UbahKantorCabang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UbahKantorCabang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UbahKantorCabang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali1;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnUbah1;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKantorCabang;
    private javax.swing.JTextArea txtAlamatKC;
    private javax.swing.JTextField txtKodeKC;
    private javax.swing.JTextField txtNamaKC;
    private javax.swing.JTextField txtTeleponKC;
    // End of variables declaration//GEN-END:variables
}
