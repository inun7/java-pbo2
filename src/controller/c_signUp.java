/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.v_loginPage;
import view.v_signUp;
/**
 *
 * @author INUN
 */
public class c_signUp {
    v_signUp view;
    
    public c_signUp(v_signUp view){
        this.view = view;
        this.view.setVisible(true);
        this.view.klikBackLogin(new tblBackLogin());
    }

    private class tblBackLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            controller.c_loginPage loginPage = new controller.c_loginPage(new v_loginPage());
            view.setVisible(false);
        }
    }
}
