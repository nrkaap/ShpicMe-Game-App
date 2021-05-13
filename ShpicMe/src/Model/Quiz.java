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
public class Quiz {
     private String jawabanBenar;
    private String Gambar;

    public Quiz(String jawabanBenar, String Gambar) {
        this.jawabanBenar = jawabanBenar;
        this.Gambar = Gambar;
    }

    public String getJawabanBenar() {
        return jawabanBenar;
    }

    public String getGambar() {
        return Gambar;
    }
}
