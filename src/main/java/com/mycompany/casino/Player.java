/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;

/**
 *
 * @author mor
 */
public class Player {
    private String firstName;
    private String lastName;
    private String userName;
    private String dateOfbirth;
    private String email;
    private String password;
    private int wallet;
    
    public Player(String firstName, String lastName, String userName,String dateOfbirth, String email,String password, int wallet){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.dateOfbirth = dateOfbirth;
        this.password = password ;
        this.wallet = wallet;
    }        
    
    public String getName(){
        return firstName;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public int getBalance(){
        return wallet;
    }
    public void setWallet(int wallet){
        this.wallet = wallet;
    }
}
