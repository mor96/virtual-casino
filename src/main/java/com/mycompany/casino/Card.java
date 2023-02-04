/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;

import java.awt.Image;

/**
 *
 * @author mor
 */
public class Card {
    int rank;
    String type;
    String img;
    
    
    public Card(){
        
    }
    public Card(int rank, String img){
        this.rank = rank;
        this.img = img;
        
    }
    
    public int getRank(){
        return rank;
    }
    public String getImg(){
        return img;
    }
  
    
}
