/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author firlisaanggraeni
 */
public class ControllerHome_GUI implements ActionListener{
    Home_GUI View;
    Database DB;
    
    
    public ControllerHome_GUI() {
        DB = new Database();
        View = new Home_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       if (source.equals(View.getBtnexit())){
            View.dispose();
            
       }
       if (source.equals(View.getBtnplay())){
           new ControllerMenu_GUI();
           View.dispose();
           
       }
    }
    
}
