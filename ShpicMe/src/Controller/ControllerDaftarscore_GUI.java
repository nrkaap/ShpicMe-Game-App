/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.User;
import View.Credits_GUI;
import View.Daftarscore_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author firlisaanggraeni
 */
public class ControllerDaftarscore_GUI implements ActionListener{
    Daftarscore_GUI View;
    Database DB=new Database();
   

    public ControllerDaftarscore_GUI() {
        View = new Daftarscore_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
        loadTable();
    }
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"username", "score"}, 0);
        ArrayList<User> user = DB.getUser();
        for (User u : user) {
            model.addRow(new Object[]{u.getUsername(), u.getScore()});
        }
        View.setjTable1(model);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(View.getBtnback2())){
            new ControllerMenu_GUI();
            
            View.dispose();
            
        }
    }
}
