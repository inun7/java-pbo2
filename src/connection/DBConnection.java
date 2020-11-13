/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author INUN
 */
public class DBConnection {
    private static Connection koneksi = null;
    public static Connection konek() throws SQLException{  
        if(koneksi==null){
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/dbPbo";
            String user = "root";
            String pass = "";
            Class.forName(driver);
            koneksi = DriverManager.getConnection(url,user,pass);
            System.out.println("Koneksi Berhasil");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"SQL Exception" +e.getMessage());
        }
        }
        return koneksi;
    }


//koneksi login
    public Connection getConnection() {
    Connection cn;
        try {
            String server = "jdbc:mysql://localhost/dbPbo";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            cn = DriverManager.getConnection (server, "root","");
            return cn;
        } catch (SQLException se) {
            System.out.println(se.toString());
            return null;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
