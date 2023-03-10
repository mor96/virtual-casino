/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;


import javax.swing.JOptionPane;

/**
 *
 * @author mor
 */
public class HiLoWin extends javax.swing.JFrame {
    private DeckOfCards deck = new DeckOfCards();
    private balancePalet bp;
    private Card currCard;
    private Card prevCard;
    private int size = 52;
    private int betSum;
    private int streak = 0;
    private Player player;
    private mainWindow mw;
   
    
    /**
     * Creates new form HiLoWin
     * @param a
     * @param mw
     */
    public HiLoWin(Player a, mainWindow mw) {
        this.mw = mw;
        player = a;
        currCard = new Card();
        prevCard = new Card();
        initComponents();
        
        int indx = deck.getRandomCardIndx(size);
        currCard = deck.getRandomCard(indx);
        labelFrontCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(currCard.img)));
       
        
    }
    public void setNewWallet(){
        bp.wallet = player.getBalance();
        balancePalet1.updateBalance();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLOW = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnHIGH = new javax.swing.JButton();
        labelFrontCard = new javax.swing.JLabel();
        labelStreak = new javax.swing.JLabel();
        labelBackCard = new javax.swing.JLabel();
        betButtons1 = new com.mycompany.casino.BetButtons();
        balancePalet1 = new com.mycompany.casino.balancePalet();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Hi Lo");

        btnLOW.setText("LOW");
        btnLOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOWActionPerformed(evt);
            }
        });

        jLabel5.setText("STREAK");

        btnHIGH.setText("HIGH");
        btnHIGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHIGHActionPerformed(evt);
            }
        });

        labelFrontCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/7D.png"))); // NOI18N

        labelStreak.setText("0");

        labelBackCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelStreak)
                                .addGap(35, 35, 35)
                                .addComponent(labelFrontCard)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelBackCard))
                            .addComponent(balancePalet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnHIGH, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnLOW)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 114, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(betButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(betButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(labelStreak)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFrontCard, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelBackCard, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLOW)
                                    .addComponent(btnHIGH)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBack)
                                    .addComponent(balancePalet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOWActionPerformed
        // TODO add your handling code here:
        betSum = betButtons1.getBetSum();
        if(bp.wallet >= betSum){
            if(size > 0){
                Card card;
                int x;
                prevCard = currCard;
                x = deck.getRandomCardIndx(size);
                card = deck.getRandomCard(x);
                size = size - 1;
                deck.removeCard(x);
                currCard = card;
                labelFrontCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(currCard.getImg())));
                if(currCard.rank < prevCard.rank){
                    bp.wallet = bp.wallet + betSum;
                    JOptionPane.showMessageDialog(this,"YOU WON!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    streak += 1;
                    labelStreak.setText(String.valueOf(streak));

                }
                else{
                    bp.wallet = bp.wallet - betSum;
                    JOptionPane.showMessageDialog(this,"YOU LOST!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    streak = 0;
                    labelStreak.setText(String.valueOf(streak));

                }

                player.setWallet(bp.wallet);
                balancePalet1.updateBalance();

            }

            else{
                JOptionPane.showMessageDialog(this,"NO MORE CARDS!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"insufficient funds :(", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLOWActionPerformed

    private void btnHIGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHIGHActionPerformed
        // TODO add your handling code here:
        int x; 
        betSum = betButtons1.getBetSum();
        if(bp.wallet >= betSum){
            if(size > 0){
                Card card;
                prevCard = currCard;
                x = deck.getRandomCardIndx(size);
                card = deck.getRandomCard(x);
                size = size - 1;
                deck.removeCard(x);
                currCard = card;
                labelFrontCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(currCard.getImg())));
                if(currCard.rank > prevCard.rank){
                    bp.wallet = bp.wallet + betSum;           
                    JOptionPane.showMessageDialog(this,"YOU WON!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    streak += 1;
                    labelStreak.setText(String.valueOf(streak));
                }
                else{
                    bp.wallet = bp.wallet - betSum;           
                    JOptionPane.showMessageDialog(this,"YOU LOST!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    streak = 0;
                    labelStreak.setText(String.valueOf(streak));
                }

                player.setWallet(bp.wallet);
                balancePalet1.updateBalance();

            }
            else{    
                JOptionPane.showMessageDialog(this,"NO MORE CARD!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"insufficient funds :(", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHIGHActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        mw.setNewWallet();
        mw.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.casino.balancePalet balancePalet1;
    private com.mycompany.casino.BetButtons betButtons1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHIGH;
    private javax.swing.JButton btnLOW;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelBackCard;
    private javax.swing.JLabel labelFrontCard;
    private javax.swing.JLabel labelStreak;
    // End of variables declaration//GEN-END:variables
}
