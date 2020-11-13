/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.v_user;
import view.v_createComplaint;
import view.v_loginPage;
/**
 *
 * @author INUN
 */
public class c_user {
    v_user view;
    
    public c_user (v_user view){
        this.view = view;
        this.view.setVisible(true);
        this.view.klikCreateComplaint(new createComplaint());
        this.view.klikLogout(new tblLogout());
    }


    private class createComplaint implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                controller.c_createComplaint createComplaint = new controller.c_createComplaint(new v_createComplaint());
            } catch (SQLException ex) {
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.setVisible(false);
        }
    }
    
    
    private class tblLogout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            controller.c_loginPage loginPage = new controller.c_loginPage(new v_loginPage());
            view.setVisible(false);
        }
    }
    
}
