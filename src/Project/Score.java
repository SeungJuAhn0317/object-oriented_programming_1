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
import javax.swing.JScrollPane;

/**
 *
 * @author 이혜주
 */
public class Score {
     JFrame frame = new JFrame();
    JList list;
    String tf;
    DefaultListModel model;
    String name;
    
    
    public Score(String name){
       this.name = name;
       int len = name.length();
       String filepath = name.substring(1,len)+".txt";
       System.out.println(filepath);
       
        int count = 0;
       
        list = new JList(new DefaultListModel());
        File file = new File(filepath);
        try{
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = "";
            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");

              System.out.println(line);
 
              model = (DefaultListModel) list.getModel();
              model.addElement(line);
              //list.setBounds(100,100,100,100);
              frame.add(new JScrollPane(list),"Center");
              
              
              line="";      

            }
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
    JLabel l = new JLabel("학생선택");
    frame.add(l,"North");
    JButton b = new JButton("성적입력");
    frame.add(b,"South");    
    b.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
            // 모달창으로 만들기
            String str = list.getSelectedValue().toString();
            String[] splitedStr = str.split("/");
           new Score2(name,splitedStr[0]); // 강의이름. 이름

       }
    });
    
    
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(300,400);
    frame.setVisible(true); 
    frame.setLocationRelativeTo(null);
}
}
