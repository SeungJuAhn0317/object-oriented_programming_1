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
public class ShowEval {
      JFrame frame = new JFrame();
    JList list;
    String tf;
    DefaultListModel model;
    String name;
    public ShowEval(String name){ // 자신이 맡고 잇는 강의 목록 보기 name은 교수 자기 이름 
       
        File file = new File("openlecture.txt");
        int count = 0;
        this.name = name;
       // name = "빈기철";
        list = new JList(new DefaultListModel());
        try{
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = "";
            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");

              System.out.println(line);
              if(splitedStr[0].equals(name)){
              // list = new JList(new DefaultListModel());
              model = (DefaultListModel) list.getModel();
              model.addElement(splitedStr[3]+" : "+splitedStr[4]);
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
    JLabel l = new JLabel("강의 목록");
    frame.add(l,"North");
    JButton b = new JButton("강의평가보기");
    frame.add(b,"South");    
    b.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
            // 모달창으로 만들기
            String str = list.getSelectedValue().toString();
            String[] splitedStr = str.split(":");
            System.out.println(splitedStr[1]);
            new ShowEval2(splitedStr[1]);
       }
    });
    
    
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(300,400);
    frame.setVisible(true); 
    frame.setLocationRelativeTo(null);
}
    public static void main(String[] args){
       //Study_openlecture_1 l = new Study_openlecture_1();
       new ShowEval("빈기철");
    }
}
