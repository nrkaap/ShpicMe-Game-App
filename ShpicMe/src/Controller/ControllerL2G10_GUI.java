/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControllerL1G1_GUI.lives;
import static Controller.ControllerL1G9_GUI.lives;
import Model.Database;
import View.L2G10_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class ControllerL2G10_GUI implements ActionListener{
    L2G10_GUI View;
    Database DB;
    static int lives=ControllerL2G9_GUI.lives;
    static int score=ControllerL2G9_GUI.score;
    
    public ControllerL2G10_GUI() {
        DB = new Database();
        View= new L2G10_GUI();
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
        score=score+10;
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
    }
    public void btnCekActionPerformed(){
        if (View.getTfjawaban().equals("Bcl")||View.getTfjawaban().equals("bcl")||View.getTfjawaban().equals("BCL")){
            View.showMessage("Yeaaay jawabanmu benar, skormu bertambah 5", "Success", 1);
            hitungscore();
            new ControllerL2G11_GUI();
            View.dispose();
            
        }
        else{
            
            hitunglives();
            if (lives>0){
                View.showMessage("Yaaah jawabanmu salah, nyawamu berkurang 1", "Error", 0);
                View.Reset();
                new ControllerL2G10_GUI();
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
