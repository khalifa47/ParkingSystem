/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author angel
 */
public class TopupWallet extends JFrame implements ActionListener {
    JLabel L1;
//    JComboBox list;
    JButton  topupBtn, backBtn;
    
    public TopupWallet(){
        setVisible(true);
        setSize(900,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TOP UP WALLET");
        
        L1 = new JLabel("Enter amount to top up");
        L1.setForeground(Color.red);

        JTextField amount = new JTextField();
        
        topupBtn = new JButton("Top up");
        backBtn = new JButton("Back");


        L1.setBounds(100,100,400,50);
        amount.setBounds(100,180,70,30);
        topupBtn.setBounds(180,180,140,30);
        backBtn.setBounds(210, 220, 70, 30);
        
        add(L1);
        add(amount);
        add(topupBtn);
        add(backBtn);
        
//        list.addActionListener(this);
        topupBtn.addActionListener(this);
        backBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {
           Dashboard d = new Dashboard();
           d.setVisible(true);
           this.setVisible(false);
        } 
    }
//    @Override
//    public void actionPerformed(ActionEvent d){
//        if(d.getSource()==list){
//            System.out.println(list.gatSelectedIndex());//Alternatively .getSelectedItem
//        }
//    }
}
