/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControllerL1G8_GUI.score;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author firlisaanggraeni
 */
public class ControllerL1G1_GUI extends Level implements ActionListener,Score{
    L1G1_GUI View;
    Database DB=new Database();
    Login_GUI user;
    
    
    
    static int lives=5;
    static int score=0;
    public ControllerL1G1_GUI() {
        DB = new Database();
        
        View= new L1G1_GUI();
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
        if (source.equals(View.getBtnCek())){
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
        if (View.getTfJawaban().equals("Kambing hitam")||View.getTfJawaban().equals("kambing hitam")||View.getTfJawaban().equals("KAMBING HITAM")){
            View.showMessage("Yeaaay jawabanmu benar, skormu bertambah 5", "Success", 1);
            hitungscore();
            new ControllerL1G2_GUI();
            View.dispose();
        }
        else{
            
            hitunglives();
            if (lives>0){
                View.showMessage("Yaaah jawabanmu salah, nyawamu berkurang 1", "Error", 0);
                View.Reset();
                new ControllerL1G1_GUI();
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

    /**
     *
     */
    

    
    
}
