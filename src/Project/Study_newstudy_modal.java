/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 이혜주
 */
public class Study_newstudy_modal extends JDialog{
    public Study_newstudy_modal(Window parent) throws IOException{//, JLabel label, JLabel label2, JLabel label3, JLabel label4, JLabel label5
        super(parent, "신규강좌등록",ModalityType.APPLICATION_MODAL);
        setSize(350,440);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lb1 = new JLabel("강좌 번호");
        lb1.setFont(new Font("굴림", Font.PLAIN, 15));
        lb1.setBounds(60,40,150,50); // 위치 , 글자 크기 
         add(lb1);
         
        JTextField field1 = new JTextField(10);
        field1.setBounds(135,50,100,30);
        add(field1);
        
        JLabel lb2 = new JLabel("강좌 이름");
        lb2.setFont(new Font("굴림", Font.PLAIN, 15));
        lb2.setBounds(60,85,150,50);
        add(lb2);
        
        JTextField field2 = new JTextField(10);
        field2.setBounds(135,95,100,30);
        add(field2);
        
        
        JLabel lb3 = new JLabel("학     과");
        lb3.setFont(new Font("굴림", Font.PLAIN, 15));
        lb3.setBounds(60,125,150,50);
        add(lb3);
        
       
        String [] s = {"전산학과","전자공학과","화학공학과","기계공학과","항공우주학과"};
        JComboBox<String> combo;
        combo = new JComboBox<String> (s);
        combo.setFont(new Font("굴림", Font.PLAIN, 15));
        combo.setBounds(135,135,150,30);
        add(combo);
        
        JLabel lb4 = new JLabel("학점 수");
        lb4.setFont(new Font("굴림", Font.PLAIN, 15));
        lb4.setBounds(60,165,150,50);
        add(lb4);
        
        JTextField field4 = new JTextField(10);
        field4.setBounds(135,175,100,30);
        add(field4);
        
        JLabel lb5 = new JLabel("강좌 설명");
        lb5.setFont(new Font("굴림", Font.PLAIN, 15));
        lb5.setBounds(60,205,150,50);
        add(lb5);
        
        JTextArea field5 = new JTextArea();
        field5.setBounds(135,225,150,60);
        add(field5);
        JButton b1 = new JButton("취소");
        b1.setBounds(95,335,60,40);
        add(b1);
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                //label.setText(field1.getText());
                dispose();
            }
        });
        
        JButton b2 = new JButton("등록");
        b2.setBounds(160,335,60,40);
        add(b2);
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ee){
                FileWriter reader;
                try {
                    String filename = field2.getText();
                    reader = new FileWriter(filename+".txt"); // 텍스트 파일이 없으면 새로 생성함!
                    
                } catch (IOException ex) {
                    Logger.getLogger(Study_newstudy_modal.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"등록 되었습니다.");

                Study_lecture sl = new Study_lecture();
                String str1 = field1.getText();
                String str2 = field2.getText();
       String str3 = combo.getSelectedItem().toString();
       String str4 = field4.getText();
       String str5 = field5.getText();
                sl.info(str1,str2,str3,str4,str5);

                dispose();
            }
        });
        
    }
}
