/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import View.L5G11_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class ControllerL5G11_GUI implements ActionListener{
    L5G11_GUI View;
    Database DB;
    static int lives=ControllerL5G10_GUI.lives;
    static int score=ControllerL5G10_GUI.score;
    
    public ControllerL5G11_GUI() {
        DB = new Database();
        View= new L5G11_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
        View.setLblives(Integer.toString(lives));
        View.setLbscore(Integer.toString(score));
    }
    public void hitunglives() {
        lives--;
        DB.Updatelives(ControllerLogin_GUI.namaUser, lives);

    }
    public void hitungscore(){
        score=score+25;
        DB.Updatescore(ControllerLogin_GUI.namaUser, score);
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(View.getBtncek())){
            System.out.println("Tombol cek di klik");
            btnCekActionPerformed();
        }
        if (source.equals(View.getBtnback2())){
            new ControllerMenu_GUI();
           
            View.dispose();
            System.out.println("Tombol back di klik");
        }
        if (source.equals(View.getBtnback2())){
            new ControllerMenu_GUI();
           
            View.dispose();
            System.out.println("Tombol back di klik");
        }
    }
    public void btnCekActionPerformed(){
        if (View.getTfjawaban().equals("Lullaby")||View.getTfjawaban().equals("lullaby")||View.getTfjawaban().equals("LULLABY")){
            View.showMessage("Yeaaay jawabanmu benar, skormu bertambah 5", "Success", 1);
                hitungscore();
            new ControllerL5G12_GUI();
            View.dispose();
            
        }
        else{
            hitunglives();
            if (lives>0){
                View.showMessage("Yaaah jawabanmu salah, nyawamu berkurang 1", "Error", 0);
                View.Reset();
                new ControllerL5G11_GUI();
                View.dispose();
            }
            else{
                View.showMessage("GAME OVER", "Error", 0);
                View.Reset();
                score=5;
                new ControllerL1G1_GUI();
                View.dispose();
            }
            
            
        }
    }
}
