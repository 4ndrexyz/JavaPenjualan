/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;
/**
 *
 * @author rpl
 */
public class Produk extends javax.swing.JFrame {
    DefaultTableModel tabModel;
    ResultSet RsProduk = null;
    /**
     * Creates new form Produk
     */
    public Produk() {
        initComponents();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height){
            frameSize.height = screenSize.height;
        }
        
        if (frameSize.width > screenSize.width){
            frameSize.width = screenSize.width;
        }
        
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height = screenSize.height) / 20);
    
        // Fungsi Tampil Data & Set Edit Off Dijalankan Saat Aplikasi di Run
        tampilData();
        setEditOff();
    }   
    
    // Fungsi untuk menampilkan data Produk ke dalam table
    private void tampilData(){
        
        try {
            Object[]judul_kolom = {"Kode", "Nama", "Satuan", "Harga", "Stok", "Tanggal"};
            
            tabModel = new DefaultTableModel(null, judul_kolom);
            TabelProduk.setModel(tabModel);
            
            Connection conn = (Connection)Koneksi.KoneksiDB();
            Statement stt = conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk = stt.executeQuery("SELECT * FROM produk");
            while (RsProduk.next()){
                Object[]data = {
                    RsProduk.getString("KodeProduk"),
                    RsProduk.getString("NamaProduk"),
                    RsProduk.getString("Satuan"),
                    RsProduk.getString("Harga"),
                    RsProduk.getString("Stok"),
                    RsProduk.getString("CreateDate")
                };
                
                tabModel.addRow(data);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        // disable button
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonCencel.setEnabled(false);
    }
    
    // Menampilkan data ke form saat data pada table di klik
    void tblKeForm(){
        jTextKodeProduk.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),0)+""); 
        jTextNama.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),1)+"");
        jComboBoxSatuan.setSelectedItem(tabModel.getValueAt(TabelProduk.getSelectedRow(),2)+"");
        jTextHarga.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),3)+"");
        jTextStok.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),4)+"");
        
        jButtonUpdate.setEnabled(true);
        jButtonDelete.setEnabled(true);
        jButtonCencel.setEnabled(true);
        jButtonSave.setEnabled(false);
    }
    
    // Membersihkan Form
    private void BersihData(){
        jTextKodeProduk.setText("");
        jTextNama.setText("");
        jComboBoxSatuan.setSelectedIndex(0);
        jTextHarga.setText("");
        jTextStok.setText("");
    }
    
    // Disable Form
    private void setEditOff(){
        jTextKodeProduk.setEnabled(false);
        jTextNama.setEnabled(false);
        jComboBoxSatuan.setEnabled(false);
        jTextHarga.setEnabled(false);
        jTextStok.setEnabled(false);
    }
    
    // Edit Form
    private void seteditOn(){
        jTextKodeProduk.setEnabled(true);
        jTextNama.setEnabled(true);
        jComboBoxSatuan.setEnabled(true);
        jTextHarga.setEnabled(true);
        jTextStok.setEnabled(true);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextKodeProduk = new javax.swing.JTextField();
        jTextNama = new javax.swing.JTextField();
        jTextHarga = new javax.swing.JTextField();
        jTextStok = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelProduk = new javax.swing.JTable();
        jButtonSave = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonCencel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jComboBoxSatuan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BUSINNES CENTER SMK NEGERI 9 SEMARANG");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATA BARANG");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("KODE");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("NAMA");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("SATUAN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("HARGA");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("STOK");

        jTextKodeProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextKodeProdukActionPerformed(evt);
            }
        });

        jTextNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNamaActionPerformed(evt);
            }
        });

        jTextHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextHargaActionPerformed(evt);
            }
        });

        jTextStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextStokActionPerformed(evt);
            }
        });

        TabelProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama", "Satuan", "Harga", "Stok", "Tanggal"
            }
        ));
        TabelProduk.setToolTipText("");
        TabelProduk.setFocusTraversalPolicyProvider(true);
        TabelProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelProduk);

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCencel.setText("Cencel");
        jButtonCencel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCencelActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("@ BC SMK NEGERI 9 SEMARANG");

        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAdd.setText("+");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jComboBoxSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pcs", "Kg", "Pac", "Liter", "Dus", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSave)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDelete)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCencel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextKodeProduk)
                                    .addComponent(jTextNama)
                                    .addComponent(jTextHarga)
                                    .addComponent(jTextStok)
                                    .addComponent(jComboBoxSatuan, 0, 216, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonAdd))))
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBoxSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonCencel))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(10, 10, 10))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(338, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextKodeProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextKodeProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextKodeProdukActionPerformed

    private void jTextNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNamaActionPerformed

    private void jTextHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextHargaActionPerformed

    private void jTextStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextStokActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        String KodeProduk = jTextKodeProduk.getText();
        String NamaProduk = jTextNama.getText();
        String Satuan = jComboBoxSatuan.getSelectedItem().toString();
        String Harga = jTextHarga.getText();
        String Stok = jTextStok.getText();
        
        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate = TanggalFormat.format(tanggal);
        
        if (KodeProduk.isEmpty()){
            JOptionPane.showMessageDialog(null, "Kode Produk Tidak Boleh Kosong !");
            jTextKodeProduk.requestFocus();
        } else if (NamaProduk.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Produk Tidak Boleh Kosong !");
            jTextNama.requestFocus();
        } else if (Satuan.isEmpty()){
            JOptionPane.showMessageDialog(null, "Satuan Produk Tidak Boleh Kosong !");
            jComboBoxSatuan.requestFocus();
        } else if (Harga.isEmpty()){
            JOptionPane.showMessageDialog(null, "Harga Tidak Boleh Kosong !");
            jTextHarga.requestFocus();
        } else if (Stok.isEmpty()){
            JOptionPane.showMessageDialog(null, "Stok Produk Tidak Boleh Kosong !");
            jTextStok.requestFocus();
        } else if (!(new Scanner(Harga).hasNextInt())){
            JOptionPane.showMessageDialog(null, "Harga Produk Harus Angka !");
            jTextHarga.requestFocus();
        } else if (!(new Scanner(Stok).hasNextInt())){
            JOptionPane.showMessageDialog(null, "Stok Produk Harus Angka !");
            jTextStok.requestFocus();
        } else {
            try {
                Connection conn = (Connection)Koneksi.KoneksiDB();
                Statement stt = conn.createStatement();
                stt.executeUpdate("INSERT INTO produk (KodeProduk, NamaProduk, Satuan, Harga, Stok, CreateDate)" + "VALUES('"+KodeProduk+"','"+NamaProduk+"','"+Satuan+"','"+Harga+"','"+Stok+"','"+CreateDate+"')");
                BersihData();
                tampilData();
                setEditOff();
                
                JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan !", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(this, "Simpan Data Gagal !\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        String KodeProduk = jTextKodeProduk.getText();
        String NamaProduk = jTextNama.getText();
        String Satuan = jComboBoxSatuan.getSelectedItem().toString();
        String Harga = jTextHarga.getText();
        String Stok = jTextStok.getText();
        
        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate = TanggalFormat.format(tanggal);
        
        if (KodeProduk.isEmpty()){
            JOptionPane.showMessageDialog(null, "Kode Produk Tidak Boleh Kosong !");
            jTextKodeProduk.requestFocus();
        } else if (NamaProduk.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Produk Tidak Boleh Kosong !");
            jTextNama.requestFocus();
        } else if (Satuan.isEmpty()){
            JOptionPane.showMessageDialog(null, "Satuan Produk Tidak Boleh Kosong !");
            jComboBoxSatuan.requestFocus();
        } else if (Harga.isEmpty()){
            JOptionPane.showMessageDialog(null, "Harga Tidak Boleh Kosong !");
            jTextHarga.requestFocus();
        } else if (Stok.isEmpty()){
            JOptionPane.showMessageDialog(null, "Stok Produk Tidak Boleh Kosong !");
            jTextStok.requestFocus();
        } else if (!(new Scanner(Harga).hasNextInt())){
            JOptionPane.showMessageDialog(null, "Harga Produk Harus Angka !");
            jTextHarga.requestFocus();
        } else if (!(new Scanner(Stok).hasNextInt())){
            JOptionPane.showMessageDialog(null, "Stok Produk Harus Angka !");
            jTextStok.requestFocus();
        } else {
            try {
                Connection conn = (Connection)Koneksi.KoneksiDB();
                Statement stt = conn.createStatement();
                stt.executeUpdate("UPDATE produk SET NamaProduk = '"+NamaProduk+"', Satuan = '"+Satuan+"', Harga = '"+Harga+"', Stok = '"+Stok+"' WHERE KodeProduk = '"+KodeProduk+"'");
                BersihData();
                tampilData();
                setEditOff();
                
                JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan !", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(this, "Ubah Data Gagal !\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        String KodeProduk = jTextKodeProduk.getText();
        
        if(KodeProduk.isEmpty()){
            JOptionPane.showMessageDialog(null, "Kode Produk Tidak Boleh Kosong !");
            jTextKodeProduk.requestFocus();
        } else if (JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data Ini ??", "Informasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                Connection conn = (Connection)Koneksi.KoneksiDB();
                Statement stt = conn.createStatement();
                stt.executeUpdate("DELETE FROM produk WHERE KodeProduk = '"+KodeProduk+"'");
                BersihData();
                tampilData();
                setEditOff();
                JOptionPane.showMessageDialog(this, "Data Berhasil Di Hapus !", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(this, "Hapus Data Gagal !\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonCencelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCencelActionPerformed
        // TODO add your handling code here:
        BersihData();
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(true);
        jButtonDelete.setEnabled(true);
        setEditOff();
    }//GEN-LAST:event_jButtonCencelActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        BersihData();
        jTextKodeProduk.requestFocus();
        jButtonSave.setEnabled(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        seteditOn();
  
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void TabelProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelProdukMouseClicked
        // TODO add your handling code here:
        seteditOn();
        jTextKodeProduk.setEnabled(false);
        tblKeForm();
    }//GEN-LAST:event_TabelProdukMouseClicked

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
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelProduk;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCencel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextHarga;
    private javax.swing.JTextField jTextKodeProduk;
    private javax.swing.JTextField jTextNama;
    private javax.swing.JTextField jTextStok;
    // End of variables declaration//GEN-END:variables
}
