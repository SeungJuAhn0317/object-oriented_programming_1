/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author 이혜주sd
 */
public class LectureModify {
    public void Modify(){
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(280,300);
        frame.setLocationRelativeTo(null);
        frame.setTitle("수정");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBounds(0,0,280,300);
        frame.add(panel);
        panel.setLayout(null);
        
        JLabel label = new JLabel("수정하고 싶은 강좌명을 입력하세요");
        label.setBounds(30,20,300,100);
        panel.add(label);
        
        JTextField field = new JTextField();
        field.setBounds(60,100,140,30);
        panel.add(field);
        
        JButton b = new JButton("검색");
        b.setBounds(100,150,60,50);
        panel.add(b);
        
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ee){
                
                String str = field.getText();
                LectureModify2 m = new LectureModify2();
               String str2 =  m.Confirm(str);
                //String str2 = m.confirm(str);
                
            }
        });
        
        frame.setVisible(true);
             
        
    }
    public static void main(String[] args){
       LectureModify m = new LectureModify();
        m.Modify();
    }
}
