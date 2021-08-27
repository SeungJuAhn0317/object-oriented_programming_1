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

public class LectureModify4 extends JFrame {
    private String str;
     
    LectureModify4(String line){
        setTitle("수정");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        
        JRadioButton rb1 = new JRadioButton("강좌번호");
        JRadioButton rb2 = new JRadioButton("강좌명");
        JRadioButton rb3 = new JRadioButton("학과");
        JRadioButton rb4 = new JRadioButton("학점수");
        JRadioButton rb5 = new JRadioButton("강좌설명");
        
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        group.add(rb4);
        group.add(rb5);
        
        rb1.setBounds(30,40,80,30);
        rb2.setBounds(30,70,80,30);
        rb3.setBounds(30,100,80,30);
        rb4.setBounds(30,130,80,30);
        rb5.setBounds(30,160,80,30);
        
        this.add(rb1);
        this.add(rb2);
        this.add(rb3);
        this.add(rb4);
        this.add(rb5);
        
        JLabel l = new JLabel("수정되기전");
        l.setBounds(250,60,100,40);
        this.add(l);
        
        JTextField text = new JTextField();
        text.setBounds(250,110,100,30);
        this.add(text);
        
        JButton b = new JButton("확인");
        b.setBounds(150,100,60,40);
        this.add(b);
        
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //메모장에서 불러오기  
                String[] splitedStr = line.split("/");
               
                if(rb1.isSelected())
                  str = splitedStr[0];
                else if(rb2.isSelected())
                  str = splitedStr[1];
                else if(rb3.isSelected())
                    str = splitedStr[2];
                else if(rb4.isSelected())
                    str = splitedStr[3];
                else
                        str = splitedStr[4];
                l.setText(str);
            }
        });
        
       
        
        JButton b2 = new JButton("수정");
        b2.setBounds(230,200,60,40);
        this.add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //메모장 수정하는 클래스 만들기 
                LectureModify5 m = new LectureModify5();
                m.modify(str,text.getText());
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
    //public static void main(String[] args){
     //   new LectureModify4(line);
    //}

    LectureModify4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
