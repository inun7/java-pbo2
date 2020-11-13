/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.m_tanggapan;
import view.v_admin;

/**
 *
 * @author INUN
 */
public class c_tanggapan implements m_tanggapan {

    @Override
    public void TampilTanggapan(v_admin tanggapan) {
      tanggapan.tblmodel_tanggapan.getDataVector().removeAllElements();
      tanggapan.tblmodel_tanggapan.fireTableDataChanged();
      try {
          Connection con = DBConnection.konek();
          Statement stt = con.createStatement();
          String sql = "select t.idTanggapan, au.nama, au.desa, a.aduan, t.tanggapan, a.statusAduan "
                  + "from tanggapan t, aduan a, akunUser au "
                  + "where t.idAduan = a.idAduan and a.idUser = au.idUser "
                  + "order by t.idTanggapan asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[6];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              ob[5] = res.getString(6);
              tanggapan.tblmodel_tanggapan.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }
    
}
