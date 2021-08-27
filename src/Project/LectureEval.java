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

public class LectureEval {
    JFrame frame = new JFrame();
    JList list;
    String tf;
    DefaultListModel model;
    String name;
    public LectureEval(String name){//학생이름 받아오기
        //setLayout(null);
        //this.name = name;
        name="홍길동";
        String filepath = name+".txt";
        File file = new File(filepath);
        int count = 0;
         list = new JList(new DefaultListModel());
        try{
            //BufferedReader bufReader = new BufferedReader(new FileReader(file));
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = "";
            while((line = bufReader.readLine()) != null){
              //  String[] splitedStr = line.split("/");

              //System.out.println(line);
              //if(!splitedStr[1].equals("0")){
              // list = new JList(new DefaultListModel());
              model = (DefaultListModel) list.getModel();
              model.addElement(line);
              //list.setBounds(100,100,100,100);
              frame.add(new JScrollPane(list),"Center");
              
              line=" ";      
             // }
            }
            bufReader.close();
        } catch(FileNotFoundException e){
        }catch(IOException e){
            System.out.println(e);
        }
    JLabel l = new JLabel("강의평가");
    frame.add(l,"North");
    JButton b = new JButton("평가하기");
    //b.setBounds(120,120,50,20);
    frame.add(b,"South");    
    b.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
            // 모달창으로 만들기
        //  System.out.println(list.getSelectedValue());
          String str = list.getSelectedValue().toString(); // 강의평가할 강의이름 받음 
          new LectureEval2(str);
       }
    });
    
    
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(300,400);
    frame.setVisible(true); 
    frame.setLocationRelativeTo(null);
}
  public static void main(String[] args){
      new LectureEval("");
   }
}
