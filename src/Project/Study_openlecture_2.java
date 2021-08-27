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
 * @author 이혜주
 */
public class Study_openlecture_2 extends JDialog {
    
   
    
     public Study_openlecture_2(Window parent,String str){
        super(parent, "강좌 개설",ModalityType.APPLICATION_MODAL);
        setSize(350,350);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lb1 = new JLabel("담당 교수");
        lb1.setFont(new Font("굴림", Font.PLAIN, 15));
        lb1.setBounds(60,40,150,50); // 위치 , 글자 크기 
         add(lb1);
         
        JTextField field1 = new JTextField(10);
        field1.setBounds(135,50,100,30);
        add(field1);
        // 입력 받은 교수가 존재하는 교수인지 확인하는 것은 버튼 눌럿을때 다른
        //클래스 생성해서 거기서 찾고 있으면 새 메모장에 넣기
        
        JLabel lb2 = new JLabel("최대 인원");
        lb2.setFont(new Font("굴림", Font.PLAIN, 15));
        lb2.setBounds(60,85,150,50);
        add(lb2);
        
        JTextField field2 = new JTextField(10);
        field2.setBounds(135,95,100,30);
        add(field2);
        
        JLabel lb3 = new JLabel("최소 인원");
        lb3.setFont(new Font("굴림", Font.PLAIN, 15));
        lb3.setBounds(60,125,150,50);
        add(lb3);
        
        JTextField field3 = new JTextField(10);
        field3.setBounds(135,135,100,30);
        add(field3);
        
        //////////여기서 부터 필요 없음!
        
        JButton b1 = new JButton("취소");
        b1.setBounds(95,210,60,40);
        add(b1);
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //label.setText(field1.getText());
                dispose();
            }
        });
        
        JButton b2 = new JButton("개설");
        b2.setBounds(160,210,60,40);
        add(b2);
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ee){
                JOptionPane.showMessageDialog(null,"개설 되었습니다.");

                Study_lecture_open o = new Study_lecture_open();
                String str1 = field1.getText(); // 담당 교수
                String str2 = field2.getText(); // 최대
                String str3 = field3.getText(); // 최소
                String str4 = str; // 강좌 정보 
                o.info(str1,str2,str3,str4);
                
                dispose();
            }
        });
         
        
    }

}
