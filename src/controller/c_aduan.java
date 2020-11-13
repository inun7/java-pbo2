/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.v_createComplaint;
import view.v_user;
import model.m_aduan;
import connection.DBConnection;
import java.sql.*;
import javax.swing.JOptionPane;
import view.v_headOffice;
import view.v_admin;
import view.v_technic;


/**
 *
 * @author INUN
 */
public class c_aduan implements m_aduan {
//V_USER
    @Override
    public void Tampil(v_user aduan) {
      aduan.tblModel.getDataVector().removeAllElements();
      aduan.tblModel.fireTableDataChanged();
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
              aduan.tblModel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }



//V_CREATECOMPLAINT
    @Override
    public void Tampil(v_createComplaint aduan) throws SQLException {
      aduan.tblmodel.getDataVector().removeAllElements();
      aduan.tblmodel.fireTableDataChanged();
      try {
          Connection con = DBConnection.konek();
          Statement stt = con.createStatement();
          String sql = "select * from aduan where statusAduan = 'Belum Terverifikasi' order by idAduan desc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              aduan.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(v_createComplaint aduan) {
        aduan.txtIdAduan.setText("");
        aduan.txtIdUser.setText("");
        aduan.txtAduan.setText("");
        aduan.cbStatus.setSelectedIndex(0);
    }
    
    @Override
    public void Simpan(v_createComplaint aduan) throws SQLException {
        try {
            Connection con = DBConnection.konek();
            String sql = "insert aduan values(?, ?, ?, ?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, aduan.txtIdAduan.getText());
            prepare.setString(2, aduan.txtIdUser.getText());
            prepare.setString(3, aduan.txtAduan.getText());
            prepare.setString(4, (String) aduan.cbStatus.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(aduan);
            aduan.setLebarKolom();
        }
    }

    @Override
    public void Ubah(v_createComplaint aduan) throws SQLException {
        try {
            Connection con = DBConnection.konek();
            String sql = "update aduan set idUser=?, aduan=?, statusAduan=?  where idAduan= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(4, aduan.txtIdAduan.getText());
            prepare.setString(1, aduan.txtIdUser.getText());
            prepare.setString(2, aduan.txtAduan.getText());
            prepare.setString(3, (String) aduan.cbStatus.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(aduan);
            aduan.setLebarKolom();
        }
    }

    @Override
    public void Hapus(v_createComplaint aduan) throws SQLException {
        try {
            Connection con = DBConnection.konek();
            String sql = "delete from aduan where idAduan= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, aduan.txtIdAduan.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(aduan);
            aduan.setLebarKolom();
            Baru(aduan);
        }
    }

    @Override
    public void KlikTabel(v_createComplaint aduan) throws SQLException {
        try {
             int pilih = aduan.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             aduan.txtIdAduan.setText(aduan.tblmodel.getValueAt(pilih, 0).toString());
             aduan.txtIdUser.setText(aduan.tblmodel.getValueAt(pilih, 1).toString());
             aduan.txtAduan.setText(aduan.tblmodel.getValueAt(pilih, 2).toString());
             aduan.cbStatus.setSelectedItem(aduan.tblmodel.getValueAt(pilih, 3).toString());
                                
        } catch (Exception e) {
        }   
    }

    

//V_ADMIN
    @Override
    public void Tampil(v_admin aduan) throws SQLException {
      aduan.tblmodel_aduan.getDataVector().removeAllElements();
      aduan.tblmodel_aduan.fireTableDataChanged();
      try {
          Connection con = DBConnection.konek();
          Statement stt = con.createStatement();
          String sql = "select a.idAduan, au.nama, au.desa, a.statusAduan, a.aduan "
                  + "from aduan a, akunUser au "
                  + "where a.idUser = au.idUser and a.statusAduan = 'Belum Terverifikasi' "
                  + "order by a.idAduan asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[5];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              aduan.tblmodel_aduan.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Ubah(v_admin aduan) throws SQLException {
        try {
            Connection con = DBConnection.konek();
            String sql = "update aduan set statusAduan=?  where idAduan= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(2, aduan.txtIdAduan.getText());
            prepare.setString(1, (String) aduan.cbStatus.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Terverifikasi");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(aduan);
            aduan.setLebarKolom();
        }
    }
    

    
//V_TECHNIC
    @Override
    public void Tampil(v_technic aduan) throws SQLException {
      aduan.tblmodel.getDataVector().removeAllElements();
      aduan.tblmodel.fireTableDataChanged();
      try {
          Connection con = DBConnection.konek();
          Statement stt = con.createStatement();
          String sql = "select a.idAduan, au.nama, au.desa, a.statusAduan, a.aduan "
                  + "from aduan a, akunUser au "
                  + "where a.idUser = au.idUser and statusAduan = 'Terverifikasi' "
                  + "order by a.idAduan asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[5];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              aduan.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Ubah(v_technic aduan) throws SQLException {
        try {
            Connection con = DBConnection.konek();
            String sql = "update aduan set statusAduan=?  where idAduan= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(2, aduan.txtIdAduan.getText());
            prepare.setString(1, (String) aduan.cbStatus.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Aduan Selesai Dikerjakan.");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(aduan);
            aduan.setLebarKolom();
        }
    }

    
    
//V_HEADOFFICE
    @Override
    public void TampilAduan(v_headOffice aduan) {
      aduan.tblModel.getDataVector().removeAllElements();
      aduan.tblModel.fireTableDataChanged();
      try {
          Connection con = DBConnection.konek();
          Statement stt = con.createStatement();
          String sql = "select a.idAduan, au.nama, au.desa, a.statusAduan, a.aduan "
                  + "from aduan as a, akunUser as au "
                  + "where au.idUser = a.idUser "
                  + "order by a.statusAduan asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[5];
              ob[0] = res.getString("idAduan");
              ob[1] = res.getString("au.nama");
              ob[2] = res.getString("au.desa");
              ob[3] = res.getString("a.statusAduan");
              ob[4] = res.getString("a.aduan");
              aduan.tblModel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

}
