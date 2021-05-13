/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.CreateAccount_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author firlisaanggraeni
 */
public class ControllerCreateAccount_GUI implements ActionListener{
    CreateAccount_GUI View;
    Database DB;

    public ControllerCreateAccount_GUI() {
        
        DB= new Database();
        View = new CreateAccount_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(View.getBtncreate())){
            btncreateaccountActionPerformed();
        }
    }
    public void btncreateaccountActionPerformed(){
        String nama = View.getTfusername();
        String password = View.getTfpassword();
        int lives=5;
        int score=0;
        View.Reset();
        if(nama.isEmpty() && password.isEmpty()){
            View.showMessage("Semua data masih kosong","Error", 0);
        }
        else if (nama.isEmpty()){
            View.showMessage("Username Masih Kosong ", "Error", 0);
        }
        else if (password.isEmpty()){
            View.showMessage("Password Masih Kosong ", "Error", 0);
        }
        else{
                if(DB.cekDuplikatUsername(nama)){
                    View.showMessage("Username sudah ada", "Error", 0);
                }else{
                    
                    DB.addUser(new User(nama,password,lives,score));
                    View.Reset();
                    View.showMessage("User berhasil daftar ", "Success", 1);
                    View.dispose();
                    new ControllerHome_GUI();
                }
        }
    }
    
    
}
