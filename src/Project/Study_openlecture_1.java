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
public class Study_openlecture_1 {
    JFrame frame = new JFrame();
    JList list;
    String tf;
    DefaultListModel model;
    
    public Study_openlecture_1(){
        //setLayout(null);
        
        File file = new File("lecture.txt");
        int count = 0;
         list = new JList(new DefaultListModel());
        try{
            //BufferedReader bufReader = new BufferedReader(new FileReader(file));
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = "";
            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");

              System.out.println(line);
              if(!splitedStr[1].equals("0")){
              // list = new JList(new DefaultListModel());
              model = (DefaultListModel) list.getModel();
              model.addElement(line);
              //list.setBounds(100,100,100,100);
              frame.add(new JScrollPane(list),"Center");
              
              line=" ";      
              }

            }
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
    JLabel l = new JLabel("개설 가능 강좌 목록");
    frame.add(l,"North");
    JButton b = new JButton("개설하기");
    //b.setBounds(120,120,50,20);
    frame.add(b,"South");    
    b.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
            // 모달창으로 만들기
        //  System.out.println(list.getSelectedValue());
          String str = list.getSelectedValue().toString();
          //System.out.println(str);

            Study_openlecture_2 open2 = new Study_openlecture_2(frame, str);
            open2.setVisible(true);
            //open2.info(str);
       }
    });
    
    
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(300,400);
    frame.setVisible(true); 
    frame.setLocationRelativeTo(null);
}

}
