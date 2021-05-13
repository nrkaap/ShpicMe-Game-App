/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Database;
import View.Menu_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author firlisaanggraeni
 */
public class ControllerMenu_GUI implements ActionListener {
    Menu_GUI View;
    Database DB;
            
    public ControllerMenu_GUI() {
        
        View = new Menu_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(View.getBtnlogin2())){
            new ControllerLogin_GUI();
            View.dispose();
            
        }
        if (source.equals(View.getBtnabout())){
            new ControllerAbout_GUI();
            
            View.dispose();
            
        }
        if (source.equals(View.getBtninstruction())){
            new ControllerInstruction_GUI();
           
            View.dispose();
            
        }
        if (source.equals(View.getBtnfaq())){
            new ControllerFAQ_GUI();
           
            View.dispose();
            
        }
        if (source.equals(View.getBtncredits())){
            new ControllerCredits_GUI();
           
            View.dispose();
            
        }
        if (source.equals(View.getBtndaftarscore())){
            new ControllerDaftarscore_GUI();
           
            View.dispose();
            
        }
    } 
}
