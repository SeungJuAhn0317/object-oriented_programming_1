/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author 이혜주
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class ChangePassword3 extends JFrame {
    private String password;
     
    ChangePassword3(String str){
        setTitle("변경");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        
        JLabel l = new JLabel("변경할 비밀번호를 입력해주세요 ");
        l.setBounds(250,60,100,40);
        this.add(l);
        
        JTextField text = new JTextField();
        text.setBounds(250,110,100,30);
        this.add(text);
        
        JButton b2 = new JButton("변경");
        b2.setBounds(230,200,60,40);
        this.add(b2);
        
        password = str;
        System.out.println("원래 비밀번호"+password);
        System.out.println("바꿀비밀번호"+text.getText());
                
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //메모장 수정하는 클래스 만들기 
                ChangePassword4 m = new ChangePassword4();
                m.modify(password,text.getText()); // 원래 비밀번호랑 바꿀 비밀번호 받음\
                System.out.println("원래 비밀번호"+str);
                System.out.println("바꿀비밀번호"+text.getText());
            }
        });
        
        JButton b3 = new JButton("취소");
        b3.setBounds(300,200,60,40);
        this.add(b3);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        setSize(400,300);
        setVisible(true);
        
    }

    ChangePassword3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
