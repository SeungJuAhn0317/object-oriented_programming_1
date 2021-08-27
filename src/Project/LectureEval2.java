/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author 이혜주
 */
public class LectureEval2 {
    String str;
    JFrame frame = new JFrame();
    JList list;
    String tf;
    DefaultListModel model;
    String name;
    public LectureEval2(String str){//평가할 강의 정보 받아옴 
        frame.setLayout(null);
        this.str = str;
        System.out.println(str);
        String[] splitedStr = str.split("/");
             
    JLabel l = new JLabel();
    l.setText(splitedStr[1]+"평가");
    l.setBounds(65,30,150,30);
    frame.add(l);
    
    JTextField text = new JTextField();
    text.setBounds(65,60,150,110);
    frame.add(text);
    
   JButton b = new JButton("평가완료");
    b.setBounds(80,200,100,40);
    frame.add(b);    
    
    b.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
            String str = text.getText();
            System.out.println(str);
            JOptionPane.showMessageDialog(null,"완료되었습니다!");
            frame.dispose();
            new LectureEval3(splitedStr[1],str); // 강의명, 평가내용
       }
    });
    
    
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(300,300);
    frame.setVisible(true); 
    frame.setLocationRelativeTo(null);
}
  public static void main(String[] args){
      new LectureEval2("d/f");
   }
    
}
