/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Database;
import Model.User;
import View.Login_GUI;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author firlisaanggraeni
 */
public class ControllerLogin_GUI extends MouseAdapter implements ActionListener{
    Login_GUI View;
    Database DB;
    public static String namaUser;
    
    
    public ControllerLogin_GUI() {
        View = new Login_GUI();
        DB = new Database();
        
        View.setVisible(true);
        View.AddActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(View.getBtncreateaccount())) {
            new ControllerCreateAccount_GUI();
            View.dispose();
            
        }
        if (source.equals(View.getBtnlogin())){
 
            if(View.getTfusername().equals("admin")&&View.getTfpassword().equals("admin")){
                new ControllerDeleteAccount_GUI();
                View.dispose();
            }
            else{
                btnloginActionPerformed();
                
            }
            
        } 
        if (source.equals(View.getBtnforgotpass())){
            new ControllerForgotPassword_GUI();
            View.dispose();
            
        }
    }
    

    
    
    public void btnloginActionPerformed(){
        String nama = View.getTfusername();
        String password = View.getTfpassword();
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
                if(!DB.cekDuplikatUsername(nama)){
                    View.showMessage("Username belum ada", "Error", 0);
                    View.Reset();
                }
                else{
                    if (DB.cekDuplikatPassword(nama, password)){
                        View.Reset();
                        ControllerLogin_GUI.namaUser=nama;
                        View.showMessage("Berhasil login yaa ", "Success", 1);
                        new ControllerL1G1_GUI();
                        View.dispose();
                    }
                    else{
                        View.showMessage("password salah", "Error", 0);
                        View.Reset();
                    }
                }
                        
                    
                    
                
        }
    }
    
    
    
    
    }

