/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author mor
 */
public class BlackJackWindow extends javax.swing.JFrame implements ActionListener {
    Timer timer;
    int count = 0;
    private DeckOfCards deck;
    private balancePalet bp;
    private Card[] playerHand; 
    private Card[] dealerHand;
    private int dealerCardCount = 0;
    private int playerCardCount = 0;
    private int indx;
    private int size = 1; 
    private int betSum;
    private int playerHandSum = 0;
    private int dealerHandSum = 0;
    private Player player;
    private mainWindow mw;
    private boolean duringAgame = false;
    /**
     * Creates new form BlackJack
     */
    public BlackJackWindow(Player a, mainWindow mw) {
        timer = new Timer(900, this);
        this.mw = mw;
        player = a;
        initComponents();
        bp.wallet = player.getBalance();
        balancePalet1.updateBalance();
        standBtn.setEnabled(false);
        hitBtn.setEnabled(false);
        doubleBtn.setEnabled(false);
    }
        
        
       
    public void initializeGame(){
        System.out.println("--------------------------------------------------");
        if(size < 20){
            deck = new DeckOfCards();
            size = 52;
        }
        playerHand = new Card[5]; 
        dealerHand = new Card[5];
        
        dealerHand[0] = getCard();
        dealerCardCount++;
        dealerHand[1] = getCard();
        dealerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource(dealerHand[1].img)));
        
        playerHand[0] = getCard();
        playerCardCount++;
        playerHand[1] = getCard();
        
        userCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource(playerHand[0].img)));
        userCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource(playerHand[1].img)));
        playerHandSum = calculateHand(playerHand, playerCardCount);
        
        jTextSumUser.setText(String.valueOf(playerHandSum));
        jTextSumDealer.setText(String.valueOf("?"));
        
        
        if(checkForBj(playerHandSum)){
            bp.wallet = bp.wallet + (int)(betSum * 1.5);
            endOfround();
            JOptionPane.showMessageDialog(this,"BLACK JACK! YOU WON", "Black Jack", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(dealerHand[1].getRank() == 14){
            insurance();
            return;
        }
    }
    public void setNewWallet(){
        bp.wallet = player.getBalance();
        balancePalet1.updateBalance();
    }
    
    public Card getCard(){
        int tmp = deck.getRandomCardIndx(size);
        Card x = deck.getRandomCard(tmp);
        deck.removeCard(tmp);
        size = size - 1;
        return x;
    }
    
    public int calculateHand(Card[] hand, int count){
        int value = 0;
        int sum = 0;
        boolean ace = false;
        for(int i = 0; i <= count; i++){
            if(hand[i].getRank() == 14){
               value = 1;        
               ace = true;
            }
            else if(hand[i].getRank() > 10){
                value = 10;
            }
            else{
                value = hand[i].getRank();
            }

            sum = sum + value;
        }
        if (ace && sum + 10 <= 21) {
            sum += 10;
        }
        
        return sum;
        
    }
    public void resetGame(){
        standBtn.setEnabled(true);
        hitBtn.setEnabled(true);
        doubleBtn.setEnabled(true);
   
        userCard3.setIcon(null);
        userCard4.setIcon(null);
        userCard5.setIcon(null);
        
        dealerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png")));
        dealerCard3.setIcon(null);
        dealerCard4.setIcon(null);
        dealerCard5.setIcon(null);
       
        playerHandSum = 0;
        dealerHandSum = 0;
        
        playerCardCount = 0;
        dealerCardCount = 0;
        hitBtn.setEnabled(true);
        initializeGame();
    }
    public boolean checkForBj(int total){
        return total == 21;
    }
    public boolean busted(int a){
        return a > 21;
    }
    void insurance(){
        Object[] options = {"Yes", "No"};
        
       
        String msg = "Do you want insurance?";
        int userPick = JOptionPane.showOptionDialog(this, msg ,"Insurance",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        null);
        if (userPick == JOptionPane.YES_OPTION) {
            bp.wallet = bp.wallet - (int)(betSum * 0.5);
            player.setWallet(bp.wallet);
            balancePalet1.updateBalance();
            if(dealerHand[0].getRank() > 9 && dealerHand[0].getRank() < 14){
                dealerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource(dealerHand[0].img)));
                endOfround();
                JOptionPane.showMessageDialog(this,"Dealer got Black Jack", "BlackJack", JOptionPane.INFORMATION_MESSAGE);  
            }
        }    
        else if(userPick == JOptionPane.NO_OPTION){
                if(dealerHand[0].getRank() > 9 && dealerHand[0].getRank() < 14){
                    dealerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource(dealerHand[0].img)));
                    bp.wallet = bp.wallet - betSum; 
                    endOfround();
                    JOptionPane.showMessageDialog(this,"Dealer got Black Jack", "BlackJack", JOptionPane.INFORMATION_MESSAGE);
                }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

         boolean x = false;
         System.out.println("1");
         System.out.println("count -- " + dealerCardCount);
         if(dealerHandSum < 17){
            System.out.println("2");
            System.out.println("count -- " + dealerCardCount);
            dealerCardCount++; // add card to the dealer
            dealerHand[dealerCardCount] = getCard();   
        
         
           if(dealerCardCount == 2){ // if its the delaer 3rd card so setting the 3rd lable(card count start from 0)
                dealerCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource(dealerHand[dealerCardCount].img)));
                System.out.println("3");
                System.out.println("count -- " + dealerCardCount);
           }
           else if(dealerCardCount == 3){
                dealerCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource(dealerHand[dealerCardCount].img)));
                System.out.println("4");
                System.out.println("count -- " + dealerCardCount);
           }
           else if(dealerCardCount == 4){
                dealerCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource(dealerHand[dealerCardCount].img)));
           }
           
            dealerHandSum = calculateHand(dealerHand, dealerCardCount);
            jTextSumDealer.setText(String.valueOf(dealerHandSum));
           
        }
        if(dealerHandSum >= 17){
            x = true;
            System.out.println("5");
            System.out.println("count -- " + dealerCardCount);
            System.out.println("hand sum -- " + dealerHandSum);
            
        }
        else{
            x = false;
        }
       
        if(x){
            System.out.println("6");
            System.out.println("count -- " + dealerCardCount);
            System.out.println("hand sum -- " + dealerHandSum);
             
             
           if(playerHandSum > dealerHandSum || dealerHandSum > 21){
                JOptionPane.showMessageDialog(this,"YOU WON!", "Message", JOptionPane.INFORMATION_MESSAGE);
                bp.wallet = bp.wallet + betSum;
            }
            else if(playerHandSum == dealerHandSum){           
                JOptionPane.showMessageDialog(this,"PUSH!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(dealerHandSum < 22) {
                JOptionPane.showMessageDialog(this,"YOU LOST...", "Message", JOptionPane.INFORMATION_MESSAGE);
                bp.wallet = bp.wallet - betSum;
            }    

            endOfround();
            timer.stop();   
        }
            
       
        
    }
    public void endOfround(){
        standBtn.setEnabled(false);
        hitBtn.setEnabled(false);
        doubleBtn.setEnabled(false);
        player.setWallet(bp.wallet);
        balancePalet1.updateBalance();
        playBtn.setEnabled(true);
        betButtons1.enable();
        duringAgame = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        hitBtn = new javax.swing.JButton();
        standBtn = new javax.swing.JButton();
        doubleBtn = new javax.swing.JButton();
        userCard5 = new javax.swing.JLabel();
        userCard4 = new javax.swing.JLabel();
        userCard3 = new javax.swing.JLabel();
        userCard2 = new javax.swing.JLabel();
        userCard1 = new javax.swing.JLabel();
        dealerCard5 = new javax.swing.JLabel();
        dealerCard4 = new javax.swing.JLabel();
        dealerCard3 = new javax.swing.JLabel();
        dealerCard2 = new javax.swing.JLabel();
        dealerCard1 = new javax.swing.JLabel();
        jTextSumUser = new javax.swing.JTextField();
        jTextSumDealer = new javax.swing.JTextField();
        playBtn = new javax.swing.JButton();
        balancePalet1 = new com.mycompany.casino.balancePalet();
        backBtn = new javax.swing.JButton();
        betButtons1 = new com.mycompany.casino.BetButtons();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BlackJack 21");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Your Hand:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel4.setIconTextGap(0);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 373, -1, -1));

        jLabel5.setIconTextGap(0);
        jLabel5.setIgnoreRepaint(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 373, -1, -1));

        jLabel6.setText("Dealer Hand:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        hitBtn.setText("HIT");
        hitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(hitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 750, -1, -1));

        standBtn.setText("STAND");
        standBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standBtnActionPerformed(evt);
            }
        });
        jPanel1.add(standBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 750, -1, -1));

        doubleBtn.setText("DOUBLE");
        doubleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleBtnActionPerformed(evt);
            }
        });
        jPanel1.add(doubleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 750, -1, -1));
        jPanel1.add(userCard5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 200, 300));
        jPanel1.add(userCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 200, 300));
        jPanel1.add(userCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 200, 300));
        jPanel1.add(userCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 200, 300));
        jPanel1.add(userCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 200, 300));
        jPanel1.add(dealerCard5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 200, 300));
        jPanel1.add(dealerCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 200, 300));
        jPanel1.add(dealerCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 200, 300));
        jPanel1.add(dealerCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 200, 300));

        dealerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_back.png"))); // NOI18N
        jPanel1.add(dealerCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 200, 300));

        jTextSumUser.setEditable(false);
        jTextSumUser.setText("0");
        jTextSumUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSumUserActionPerformed(evt);
            }
        });
        jPanel1.add(jTextSumUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 30, 30));

        jTextSumDealer.setEditable(false);
        jTextSumDealer.setText(" ?");
        jTextSumDealer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSumDealerActionPerformed(evt);
            }
        });
        jPanel1.add(jTextSumDealer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 30, 30));

        playBtn.setText("PLAY");
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });
        jPanel1.add(playBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, 110, 80));
        jPanel1.add(balancePalet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 750, -1, -1));
        jPanel1.add(betButtons1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void standBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standBtnActionPerformed
        // TODO add your handling code here:
        dealerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource(dealerHand[0].img))); // flipping dealer first card
        dealerHandSum = calculateHand(dealerHand, dealerCardCount);
        jTextSumDealer.setText(String.valueOf(dealerHandSum));        
        timer.start();   
    }//GEN-LAST:event_standBtnActionPerformed
 
    private void hitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitBtnActionPerformed
        // TODO add your handling code here:
        playerCardCount++; 
        playerHand[playerCardCount] = getCard();
        playerHandSum = calculateHand(playerHand, playerCardCount);
        jTextSumUser.setText(String.valueOf(playerHandSum));
        if(playerCardCount == 2){
            userCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource(playerHand[playerCardCount].img)));
        }
        else if(playerCardCount == 3){
            userCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource(playerHand[playerCardCount].img)));
        }
        else if(playerCardCount == 4){
            userCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource(playerHand[playerCardCount].img)));
            hitBtn.setEnabled(false);
        }
        if(busted(playerHandSum)){
            JOptionPane.showMessageDialog(this,"YOU BUSTED!", "BUSTED", JOptionPane.INFORMATION_MESSAGE);
            bp.wallet = bp.wallet - betSum;  
            endOfround();
            return;
            }
        if(checkForBj(playerHandSum)){
            JOptionPane.showMessageDialog(this,"BLACK JACK! YOU WON", "Black Jack", JOptionPane.INFORMATION_MESSAGE);
            bp.wallet = bp.wallet + betSum;
              
            endOfround();
        }
        
          
    }//GEN-LAST:event_hitBtnActionPerformed

    private void doubleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleBtnActionPerformed
        // TODO add your handling code here:
        if(bp.wallet  > betSum * 2){
            betSum = betSum * 2;
            hitBtn.doClick();
            standBtn.doClick();
            standBtn.setEnabled(false);
            hitBtn.setEnabled(false);
            doubleBtn.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(this,"You dont have anough money to double your bet", "Double up", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_doubleBtnActionPerformed

    private void jTextSumUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSumUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSumUserActionPerformed

    private void jTextSumDealerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSumDealerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSumDealerActionPerformed

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
        // TODO add your handling code here:
        duringAgame = true;
        betSum = betButtons1.getBetSum();
        if(bp.wallet >= betSum){
            betButtons1.disable();
            playBtn.setEnabled(false);
            resetGame();
        }
        else{
            JOptionPane.showMessageDialog(this,"insufficient funds :(", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_playBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        if(duringAgame == false){
            mw.setNewWallet();
            mw.setVisible(true);
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(this,"You can't leave during a game", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private com.mycompany.casino.balancePalet balancePalet1;
    private com.mycompany.casino.BetButtons betButtons1;
    private javax.swing.JLabel dealerCard1;
    private javax.swing.JLabel dealerCard2;
    private javax.swing.JLabel dealerCard3;
    private javax.swing.JLabel dealerCard4;
    private javax.swing.JLabel dealerCard5;
    private javax.swing.JButton doubleBtn;
    private javax.swing.JButton hitBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextSumDealer;
    private javax.swing.JTextField jTextSumUser;
    private javax.swing.JButton playBtn;
    private javax.swing.JButton standBtn;
    private javax.swing.JLabel userCard1;
    private javax.swing.JLabel userCard2;
    private javax.swing.JLabel userCard3;
    private javax.swing.JLabel userCard4;
    private javax.swing.JLabel userCard5;
    // End of variables declaration//GEN-END:variables

    
}
