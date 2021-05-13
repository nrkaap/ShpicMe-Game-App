/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControllerL2G12_GUI.lives;
import Model.Database;
import View.L1G12_GUI;
import View.L2G1_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author firlisaanggraeni
 */
public class ControllerL2G1_GUI implements ActionListener {
    L2G1_GUI View;
    Database DB;
    static int lives=ControllerL1G12_GUI.lives;
    static int score=ControllerL1G12_GUI.score;
    public ControllerL2G1_GUI() {
        DB = new Database();
        View= new L2G1_GUI();
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
            View.dispose();
        }
        if (source.equals(View.getBtnback2())){
            new ControllerMenu_GUI();
           
            View.dispose();
            System.out.println("Tombol back di klik");
        }
    }
    public void btnCekActionPerformed(){
        if (View.getTfjawaban().equals("Suka kamu")||View.getTfjawaban().equals("suka kamu")||View.getTfjawaban().equals("SUKA KAMU")){
            View.showMessage("Yeaaay jawabanmu benar, skormu bertambah 5", "Success", 1);
           hitungscore();
            new ControllerL2G2_GUI();
            View.dispose();
            
        }
        else{
            hitunglives();
            if (lives>0){
                View.showMessage("Yaaah jawabanmu salah, nyawamu berkurang 1", "Error", 0);
                View.Reset();
                new ControllerL2G1_GUI();
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
