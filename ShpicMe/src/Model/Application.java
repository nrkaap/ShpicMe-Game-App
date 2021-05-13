/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author firlisaanggraeni
 */
public class Application {
    ArrayList<User> userList = new ArrayList();
    ArrayList<Quiz> quizList = new ArrayList();
    Database DB = new Database();

    public Application() {
        DB.connect();
    }
    
    public void registerUser(User a){
        userList.add(a);
    }
    
    public boolean loginUser(String nama, String password){
        boolean ditemukan = false;
        
        for (User a: userList){
            if (a.getUsername().equals(nama)&&a.getPassword().equals(password)){
                ditemukan = true;
            }
        }
        return ditemukan;
    }
}
