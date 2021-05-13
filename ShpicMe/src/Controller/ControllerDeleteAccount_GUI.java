/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import View.DeleteAccount_GUI;
import View.ForgotPassword_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author firlisaanggraeni
 */
public class ControllerDeleteAccount_GUI implements ActionListener{
    Database DB= new Database();
    DeleteAccount_GUI View;

    public ControllerDeleteAccount_GUI() {
        
        View = new DeleteAccount_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(View.getBtndelete())){
            btnDeleteActionPerformed();
            
            new ControllerLogin_GUI();
            View.dispose();
        }
   }
    public void btnDeleteActionPerformed(){
        if (DB.cekDuplikatUsername(View.getTfusername())){
            String username = View.getTfusername();
            DB.deluser(username);
            View.Reset();
            View.showMessage("Data Berhasil Dihapus", "Success", 1);
        }
        else{
            View.showMessage("username belum terdaftar", "error", 0);
        }
        
    }
}
