/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Database;
import View.Credits_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class ControllerCredits_GUI implements ActionListener{
    Credits_GUI View;
    Database DB;
   

    public ControllerCredits_GUI() {
        
        View = new Credits_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(View.getBtnback4())){
            new ControllerMenu_GUI();
            View.dispose();
            
        }
    }
    
    
    
    
}
