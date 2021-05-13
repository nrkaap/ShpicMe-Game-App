/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Login_GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author firlisaanggraeni
 */
public class Database {
    Connection conn;
    Statement stmt = null;
    ResultSet rs;
    Login_GUI View;
    private ArrayList<User> user = new ArrayList<>();
    private  ArrayList<Quiz> quizList = new ArrayList();

    public Database(){
        loaduser();
    }
    public void connect() {
        String url = "jdbc:mysql://localhost:3366/tubespbo";
        String username = "root";
        String password = "";
        try {
            conn = (Connection) DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            

        } catch (SQLException e) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect() {
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean manipulate(String query) {
        boolean cek = false;
        int row;
        try {
            row = stmt.executeUpdate(query);
            if (row > 0) {
                cek = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cek;
    }

    public void loaduser() {
        connect();
        String query = "SELECT * FROM user";
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.add(new User(rs.getString("username"), rs.getString("password"), rs.getInt("lives"),rs.getInt("Score")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public ArrayList<User> getUser() {
        return user;
    }

    public void addUser(User u) {
        connect();
        
            String query = "INSERT INTO user VALUES (";
            query += "'" + u.getUsername() + "',";
            query += "'" + u.getPassword() + "',";
            query += "'" + u.getLives() + "',";
            query += "'" + u.getScore() + "')";
            if (manipulate(query)){
               user.add(u);
            }
            
        disconnect();
    }


     public boolean cekDuplikatUsername(String username){
        boolean cek = false;
        for (User u : user) {
            if (u.getUsername().equals(username)) {
                cek = true;
                break;
            }
        }
        return cek;
    }
     
     
         public boolean cekDuplikatPassword(String username,String password){
        boolean cek = false;
        for (User pgn : user) {
            if (pgn.getPassword().equals(password) && pgn.getUsername().equals(username)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    public int getScore(String username){
        connect();
        int score = 0;
        try {
            String query = "SELECT score FROM user where username='"+username+"';";
            rs = stmt.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return score;
    }
    
    public void Updatescore(String username,int score) {
        connect();
        String query = "UPDATE user SET score = '"+score+"' WHERE username ='"+username+"';";
        manipulate(query);
        disconnect();
        
    }
    public int getLives(String username){
        connect();
        int lives=5;
        try {
            String query = "SELECT lives FROM user where username='"+username+"';";
            rs = stmt.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return lives;
    }
    public void Updatelives(String username,int lives) {
        connect();
        String query = "UPDATE user SET lives = '"+lives+"' WHERE username ='"+username+"';";
        manipulate(query);
        disconnect();
        
    }
    public void deluser(String username){
        connect();
        String query = "DELETE FROM user WHERE username='"+ username+"';";
        if (manipulate(query)) {
            for (User u : user) {
                if (u.getUsername().equals(username)) {
                    user.remove(u);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void ubahpassword(String username,String pass) {
        connect();
        String query = "UPDATE user SET password = '"+pass+"' WHERE username ='"+username+"';";
        manipulate(query);
        disconnect();
        
    }
    
}
