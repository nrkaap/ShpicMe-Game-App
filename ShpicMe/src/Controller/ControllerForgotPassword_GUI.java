/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Database;
import View.ForgotPassword_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class ControllerForgotPassword_GUI implements ActionListener{
    ForgotPassword_GUI View;
    Database DB=new Database();

    public ControllerForgotPassword_GUI() {
        
        View = new ForgotPassword_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(View.getBtnforgotpass())){
            btnForgetActionPerformed();
            System.out.println("Tombol forgot password di klik");
        }
   } 
    public void btnForgetActionPerformed(){
        String username = View.getTfusername();
            
        if (username.isEmpty()){
            View.showMessage("Anda Belum memasukkan Username ", "Error", 0);
        }else if (!DB.cekDuplikatUsername(username)){
                View.showMessage("Username Salah atau Belum terdaftar", "Error", 0);
        }else{
            DB.ubahpassword(username, View.getTfubahpassword());
            View.showMessage("Password telah di ubah menjadi \n    password anda sekarang: "+View.getTfubahpassword(), "Success", 1);
            View.dispose();
            new ControllerLogin_GUI();
        } 
    }
    
    
}
