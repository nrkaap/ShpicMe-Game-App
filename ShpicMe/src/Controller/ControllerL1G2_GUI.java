/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControllerL1G8_GUI.score;
import Model.Database;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author firlisaanggraeni
 */
public class ControllerL1G2_GUI extends ControllerL1G1_GUI implements ActionListener{
    L1G2_GUI View;
    Database DB;
    Login_GUI user;
    static int lives=ControllerL1G1_GUI.lives;
    static int score=ControllerL1G1_GUI.score;
    public ControllerL1G2_GUI() {
        DB = new Database();
        View= new L1G2_GUI();
        View.setVisible(true);
        View.AddActionListener(this);
        View.setLblives(Integer.toString(lives));
        View.setLbscore(Integer.toString(score));
    }
    @Override
    public void hitunglives() {
        lives--;
        DB.Updatelives(ControllerLogin_GUI.namaUser, lives);
    }
    @Override
    public void hitungscore(){
        score=score+5;
        DB.Updatescore(ControllerLogin_GUI.namaUser, score);
    }
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(View.getBtncek())){
            System.out.println("Tombol cek di klik");
            btnCekActionPerformed();
            View.dispose();
        }
        if (source.equals(View.getBtnback2())){
            new ControllerMenu_GUI();
            View.dispose();
            System.out.println("Tombol back di klik");
        }
       
    }
    public void btnCekActionPerformed(){
        if (View.getTfjawaban().equals("Rumah hantu")||View.getTfjawaban().equals("rumah hantu")||View.getTfjawaban().equals("RUMAH HANTU")){
            View.showMessage("Yeaaay jawabanmu benar, skormu bertambah 5", "Success", 1);
            hitungscore();
             View.dispose();
            new ControllerL1G3_GUI();
            View.dispose();
        }
        else{
            
            hitunglives();
            if (lives>0){
                View.showMessage("Yaaah jawabanmu salah, nyawamu berkurang 1", "Error", 0);
                View.Reset();
                new ControllerL1G2_GUI();
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
