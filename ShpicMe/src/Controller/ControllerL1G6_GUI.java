/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControllerL1G1_GUI.lives;
import static Controller.ControllerL1G5_GUI.lives;
import static Controller.ControllerL1G8_GUI.score;
import Model.Database;
import View.L1G5_GUI;
import View.L1G6_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author firlisaanggraeni
 */
public class ControllerL1G6_GUI extends ControllerL1G7_GUI implements ActionListener {
    L1G6_GUI View;
    Database DB;
    static int lives=ControllerL1G5_GUI.lives;
    static int score=ControllerL1G5_GUI.score;

    public ControllerL1G6_GUI() {
        DB = new Database();
        View= new L1G6_GUI();
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
        score=score+5;
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
        if (View.getTfjawaban().equals("Kursi panas")||View.getTfjawaban().equals("kursi panas")||View.getTfjawaban().equals("KURSI PANAS")){
            View.showMessage("Yeaaay jawabanmu benar, skormu bertambah 5", "Success", 1);
                hitungscore();
                new ControllerL1G7_GUI();
                View.dispose();
        }
        else{
            hitunglives();
            if (lives>0){
                View.showMessage("Yaaah jawabanmu salah, nyawamu berkurang 1", "Error", 0);
                View.Reset();
                new ControllerL1G6_GUI();
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
