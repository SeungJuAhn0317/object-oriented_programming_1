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
public class StudyBill extends JFrame {
     JList list;
    String tf;
    DefaultListModel model;
    String name;

    
    StudyBill(){
        setTitle("청구서 발급");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel l = new JLabel("청구서 발급할 학생을 고르세요");
        //l.setBounds(30,30,200,30);
        this.add(l,"North");
        
         File file = new File("student.txt");
        int count = 0;
         list = new JList(new DefaultListModel());
        try{
            //BufferedReader bufReader = new BufferedReader(new FileReader(file));
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
            String line = "";
            int i = 1;
            while((line = bufReader.readLine()) != null){
                
                String[] splitedStr = line.split("/");
                if(!splitedStr[0].equals("이름")){

              System.out.println(line);
             // if(!splitedStr[1].equals("0")){
              // list = new JList(new DefaultListModel());
              model = (DefaultListModel) list.getModel();
              
              model.addElement(i+" : "+splitedStr[0]+" : "+splitedStr[1]+" : "+splitedStr[2]);
              //list.setBounds(100,100,100,100);
              this.add(new JScrollPane(list),"Center");
              i++;
              line=" ";      
              }
                
                
              JButton b = new JButton("발급하기");
              this.add(b,"South");    
             b.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
            // 모달창으로 만들기
        //  System.out.println(list.getSelectedValue());
          String str = list.getSelectedValue().toString();
          //System.out.println(str);
          //StudyBill2 bill = new StudyBill2();
          new StudyBill2(str);
          
          //발급을 한 한 학생을 이름으로 한 파일을 읽어서 거기에 *쓰기!!(청구서 발급 유무 하기 위해서)
          JOptionPane.showMessageDialog(null,"청구서를 발급하였습니다.");
       }
    });

            }
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
        setSize(400,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new StudyBill();
    }
}


