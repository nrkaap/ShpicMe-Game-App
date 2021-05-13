/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author firlisaanggraeni
 */
public abstract class Level {
    
    private int lives=5;
    
    

    public void setLives(int lives){
        this.lives=lives;
    }
    public abstract void hitunglives();
}
