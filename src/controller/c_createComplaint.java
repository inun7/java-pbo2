/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.v_createComplaint;
import view.v_user;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INUN
 */
public class c_createComplaint {
    v_createComplaint view;
    
    public c_createComplaint(v_createComplaint view){
        this.view = view;
        this.view.setVisible(true);
        this.view.klikBack(new tblBack());
    }

    private class tblBack implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                controller.c_user dashboard = new controller.c_user(new v_user());
            } catch (SQLException ex) {
                Logger.getLogger(c_createComplaint.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.setVisible(false);
        }
    }
}
