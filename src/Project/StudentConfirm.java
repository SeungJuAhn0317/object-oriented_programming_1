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

public class StudentConfirm extends JFrame{
    String name;
   String str;
    
    StudentConfirm(String name){ // 학생 이름 
        //본인 성적 확인하기 
        this.name = name;
        setTitle("성적확인");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        
        JRadioButton rb1 = new JRadioButton("중간고사");
        JRadioButton rb2 = new JRadioButton("기말고사");
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        rb1.setBounds(70,30,80,30);
        rb2.setBounds(170,30,80,30);
        this.add(rb1);
        this.add(rb2);
       
        JLabel l = new JLabel("성적을 확인하고 싶은 강의명을 입력하세요");
        l.setBounds(30,50,250,40);
        this.add(l);
        
        JTextField text = new JTextField();
        text.setBounds(100,100,120,30);
        this.add(text);
        
        JButton b = new JButton("확인");
        b.setBounds(130,150,60,40);
        this.add(b);
        
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //메모장에서 불러오기  
                String lecture = text.getText();
                
                
                if(rb1.isSelected()){//중간고사
                  str = lecture+"mid" ;//강의중간메모장에 학생 성적 입력 넣기 
                    }
                else{//기말고사
                  str = lecture+"final";
                    }   
                new StudentConfirm2(name,str);
            }
        });
       
        setSize(330,250);
        setVisible(true);
    }
    public static void main(String[] args){
        new StudentConfirm("황윤주");
    }
        
}
