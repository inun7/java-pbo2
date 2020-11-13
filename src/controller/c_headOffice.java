/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.v_headOffice;
import view.v_loginPage;
/**
 *
 * @author INUN
 */
public class c_headOffice {
    v_headOffice view;
    
    public c_headOffice(v_headOffice view){
        this.view = view;
        this.view.setVisible(true);
        this.view.klikLogout(new tblLogout());
    }

    private class tblLogout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            controller.c_loginPage loginPage = new controller.c_loginPage(new v_loginPage());
            view.setVisible(false);
        }
    }
}
