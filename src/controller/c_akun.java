/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


/**
 *
 * @author INUN
 */
import model.m_akun;
import connection.DBConnection;
import java.sql.*;
import javax.swing.JOptionPane;
import view.v_admin;

/**
 *
 * @author INUN
 */
public class c_akun implements m_akun {

//V_ADMIN   
    @Override
    public void TampilAkun(v_admin akun) {
      akun.tblmodel_akun.getDataVector().removeAllElements();
      akun.tblmodel_akun.fireTableDataChanged();
      try {
          Connection con = DBConnection.konek();
          Statement stt = con.createStatement();
          String sql = "select nama, jenisKelamin, desa, alamat, rt_rw, noHandphone "
                  + "from akunUser order by idUser asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[6];
              ob[0] = res.getString("nama");
              ob[1] = res.getString("jenisKelamin");
              ob[2] = res.getString("desa");
              ob[3] = res.getString("alamat");
              ob[4] = res.getString("rt_rw");
              ob[5] = res.getString("noHandphone");
              akun.tblmodel_akun.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    
}
