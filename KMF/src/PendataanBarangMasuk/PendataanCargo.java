/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PendataanBarangMasuk;

import MainMenu.MainMenuStaffTerima;
import connection.DBConnect;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    
    public PendataanCargo() {
        initComponents();
        
        model = new DefaultTableModel();
        addColumn();
        addDataColumn();
        tableCargo.setModel(model);
    }
    private String KantorCabang = "";
    public PendataanCargo(String kantorCabang) {
        initComponents();
        
        this.KantorCabang = kantorCabang;
        model = new DefaultTableModel();
        addColumn();
        addDataColumn();
        tableCargo.setModel(model);
    }

    
    
    private void addColumn(){
        model.addColumn("ID Cargo");
        model.addColumn("Nomor Registrasi");
        model.addColumn("Nomor Penerbangan");
        model.addColumn("Kota Asal");
        model.addColumn("Kota Tujuan");
        model.addColumn("Pemberangkatan");
        model.addColumn("Sampai");
        model.addColumn("Total Kantong");
        model.addColumn("Berat Total");
        model.addColumn("Biaya");
        model.addColumn("Status");

    }
    
    private void addDataColumn(){
        id_cargo = "";
        nomor_penerbangan = "";
        nomor_registrasi = "";
        belum = false;
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();

        try {
            DBConnect connection = new DBConnect();
            connection.stat = connection.conn.createStatement();
            String query = "select * from CargoManifest";
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                Object[] obj = new Object[11];
                	
                obj[0] = connection.result.getString("id_cargo_manifest");
                obj[1] = connection.result.getString("nomor_registrasi");
                obj[2] = connection.result.getString("nomor_penerbangan");
                obj[3] = connection.result.getString("kota_asal");
                obj[4] = connection.result.getString("kota_tujuan");
                obj[5] = connection.result.getString("tanggal_pemberangkatan") + " " + connection.result.getString("waktu_pemberangkatan");
                obj[6] = connection.result.getString("tanggal_sampai") + " " + connection.result.getString("waktu_sampai");
                obj[7] = connection.result.getString("jumlah_kantong");
                obj[8] = connection.result.getString("berat_barang_total");
                obj[9] = connection.result.getString("total_biaya");
                obj[10] = connection.result.getString("status");

                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal111!\n" + e.toString());
        }
    }
    private void addDataColumn(String parameter){
        
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
            if(parameter.equals("Semua")){
                query = "select * from CargoManifest";
            }else{
                query = "select * from CargoManifest where status = '"+parameter+"'";
            }
            
            connection.result = connection.stat.executeQuery(query);

            while (connection.result.next()) {
                Object[] obj = new Object[11];
                	
                obj[0] = connection.result.getString("id_cargo_manifest");
                obj[1] = connection.result.getString("nomor_registrasi");
                obj[2] = connection.result.getString("nomor_penerbangan");
                obj[3] = connection.result.getString("kota_asal");
                obj[4] = connection.result.getString("kota_tujuan");
                obj[5] = connection.result.getString("tanggal_pemberangkatan") + " " + connection.result.getString("waktu_pemberangkatan");
                obj[6] = connection.result.getString("tanggal_sampai") + " " + connection.result.getString("waktu_sampai");
                obj[7] = connection.result.getString("jumlah_kantong");
                obj[8] = connection.result.getString("berat_barang_total");
                obj[9] = connection.result.getString("total_biaya");
                obj[10] = connection.result.getString("status");

                model.addRow(obj);
            }
            connection.stat.close();
            connection.result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal111!\n" + e.toString());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCargo = new javax.swing.JTable();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnGagal = new javax.swing.JButton();
        btnBerhasil = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Pendataan Barang Masuk");

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

        jLabel2.setText("Status Cargo");

        btnGagal.setText("Konfirmasi Gagal");
        btnGagal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGagalActionPerformed(evt);
            }
        });

        btnBerhasil.setText("Konfirmasi Berhasil");
        btnBerhasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerhasilActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(263, 263, 263))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btnGagal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(btnBerhasil)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGagal)
                    .addComponent(btnBerhasil))
                .addGap(36, 36, 36)
                .addComponent(btnKembali)
                .addContainerGap())
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
        
        id_cargo = (String) model.getValueAt(i, 0);
        nomor_registrasi = (String) model.getValueAt(i, 1);
        nomor_penerbangan = (String) model.getValueAt(i, 2);
        if(((String)model.getValueAt(i, 10)).equals("Belum")){
            belum = true;
        }else{
            belum = false;
        }
        JOptionPane.showMessageDialog(this, id_cargo + " Dipilih!\n");
    }//GEN-LAST:event_tableCargoMouseClicked

    private void btnBerhasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBerhasilActionPerformed
        // TODO add your handling code here:
        if(!id_cargo.equals("") && belum){
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
        }else if(!id_cargo.equals("") && !belum){
            JOptionPane.showMessageDialog(this,
                        id_cargo+" sudah terkonfirmasi");
            addDataColumn();
        }
        else{
            InputIdCargo input = new InputIdCargo(true);
            input.setVisible(true);
        }
    }//GEN-LAST:event_btnBerhasilActionPerformed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        addDataColumn();
    }//GEN-LAST:event_formWindowOpened

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        MainMenuStaffTerima main = new  MainMenuStaffTerima();
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnGagalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGagalActionPerformed
        // TODO add your handling code here:
        if(!id_cargo.equals("") && belum){
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
        }else if(!id_cargo.equals("") && !belum){
            JOptionPane.showMessageDialog(this,
                        id_cargo+" sudah terkonfirmasi");
            addDataColumn();
        }else{
            InputIdCargo input = new InputIdCargo(false);
            input.setVisible(true);
        }
    }//GEN-LAST:event_btnGagalActionPerformed

    private void cmbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbStatusItemStateChanged
        // TODO add your handling code here:
        addDataColumn(cmbStatus.getSelectedItem().toString());
    }//GEN-LAST:event_cmbStatusItemStateChanged

    private void updateCargoStatus(int i){
        DBConnect connection = new DBConnect();
        try {
                String query;
            if(i == 0){
                query = "UPDATE CargoManifest SET status='Sampai' WHERE id_cargo_manifest=?";
            }else{
                query = "UPDATE CargoManifest SET status='Gagal' WHERE id_cargo_manifest=?";
            }
                
                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, id_cargo);
                connection.pstat.executeUpdate();
                //connection.result.close();

                addDataColumn();
                JOptionPane.showMessageDialog(this, "Konfirmasi berhasil");
            }
            catch (Exception e) {
                System.out.println("Terjadi error saat update status cargo: " + e.toString());
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
    private javax.swing.JButton btnKembali;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCargo;
    // End of variables declaration//GEN-END:variables
}

