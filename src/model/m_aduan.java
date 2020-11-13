/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import view.v_user;
import view.v_createComplaint;
import view.v_admin;
import view.v_technic;
import view.v_headOffice;

/**
 *
 * @author INUN
 */
public interface m_aduan {
    public void Tampil(v_user aduan);
    
    public void Tampil(v_createComplaint aduan) throws SQLException;
    public void Baru(v_createComplaint aduan);
    public void Simpan(v_createComplaint aduan) throws SQLException;
    public void Ubah(v_createComplaint aduan) throws SQLException;
    public void Hapus(v_createComplaint aduan) throws SQLException;
    public void KlikTabel(v_createComplaint aduan) throws SQLException;

    public void Tampil(v_admin aduan) throws SQLException;
    public void Ubah(v_admin aduan) throws SQLException;
    
    public void Tampil(v_technic aduan) throws SQLException;
    public void Ubah(v_technic aduan) throws SQLException;
    
    public void TampilAduan(v_headOffice aduan);
    
}
    
