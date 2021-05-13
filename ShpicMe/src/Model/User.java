/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author firlisaanggraeni
 */
public class User {
    public String username;
    public String password;
    public int score;
    public int lives;
    
    public User(String username, String password, int lives, int score) {
        this.username = username;
        this.password = password;
        this.lives= lives;
        this.score=score;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }   

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
}
