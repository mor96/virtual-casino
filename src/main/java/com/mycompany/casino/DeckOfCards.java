/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;

import java.util.ArrayList;

/**
 *
 * @author mor
 */
public class DeckOfCards {
    private ArrayList <Card> deck;
    //private String[] cardType = {"Clubs","Diamond","Heart","Spades"};
    char type;
    
    public DeckOfCards(){
        
        deck = new ArrayList();
        for(int i = 0; i <=3; i++){
            if(i == 0){
                type = 'C';
            }
            else if(i == 1){
                type = 'D';
            }
             else if(i == 2){
                type = 'H';
            }
            else if(i == 3){
                type = 'S';
            }
            for(int j = 2; j <= 14; j++){              
                Card a = new Card(j,"/" + j + type +".png"); 
                deck.add(a);
            }  
            
        }
           
    }
    
    public int getRandomCardIndx(int size){
        int x = size;
        x = (int)(Math.random() * size);
        return x;
    }
    public Card getRandomCard(int x){
        Card card = new Card();
        card = deck.get(x);
        return card;
    }
    public void removeCard(int x){
        deck.remove(x);
        
    }
    public int getSize(){
       return deck.size();
   }
}
