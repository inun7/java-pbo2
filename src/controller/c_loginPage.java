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
import view.v_loginPage;
import view.v_signUp;
import view.v_user;
/**
 *
 * @author INUN
 */
public class c_loginPage {
    v_loginPage view;
    
    public c_loginPage (v_loginPage view){
        this.view = view;
        this.view.setVisible(true);
        this.view.klikLogin(new tblLogin());
        this.view.klikSignUp(new tblSignUp());
    }

    private class tblSignUp implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent ae) {
            controller.c_signUp signUp = new controller.c_signUp(new v_signUp());
            view.setVisible(false);
        }
    }

    
    
    private class tblLogin implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                controller.c_user dashboard = new controller.c_user(new v_user());
            } catch (SQLException ex) {
                Logger.getLogger(c_loginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.setVisible(false);
            

        }
    }
}
