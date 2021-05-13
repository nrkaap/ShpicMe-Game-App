/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Database;
import View.FAQ_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class ControllerFAQ_GUI implements ActionListener{
    FAQ_GUI View;
    Database DB;

    public ControllerFAQ_GUI() {
       
        View = new FAQ_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(View.getBtnback3())){
            new ControllerMenu_GUI();
           
            View.dispose();
            
        }
    }
    
    
            
}
