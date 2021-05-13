/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Database;
import View.About_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class ControllerAbout_GUI implements ActionListener{
    About_GUI View;
    Database DB;

    public ControllerAbout_GUI() {
        View = new About_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(View.getBtnback2())){
            new ControllerMenu_GUI();
            View.dispose();
        }
    }

    
    
}
