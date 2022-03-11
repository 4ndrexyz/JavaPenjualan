/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author rpl
 */
public class Koneksi {
    private static Connection KoneksiDatabase;
    
    public static Connection KoneksiDB() throws SQLException{
       
        try {
            String DB = "jdbc:mysql://localhost/penjualan";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            KoneksiDatabase = (Connection) DriverManager.getConnection(DB, user, pass);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi !", "Error", JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        
      return KoneksiDatabase;
      
    }
}
