/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.v_admin;

/**
 *
 * @author INUN
 */
public class c_admin {
    v_admin view;
    
    public c_admin(v_admin view){
        this.view = view;
        this.view.setVisible(true);
    }
}
