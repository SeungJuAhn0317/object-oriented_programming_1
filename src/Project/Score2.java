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
public class Score2 extends JFrame{
   String lecture;
   String name;
   String str;
   
    Score2(String lecture,String name){
        setTitle("성적입력");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.lecture = lecture;
        this.name = name;
        this.setLayout(null);
       //String filepath = name+".txt";
      // String filepath = "비주얼프로그래밍.txt";
       System.out.println("강의제목"+lecture);
        JRadioButton rb1 = new JRadioButton("중간고사");
        JRadioButton rb2 = new JRadioButton("기말고사");
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        rb1.setBounds(30,40,80,30);
        rb2.setBounds(30,70,80,30);
        this.add(rb1);
        this.add(rb2);
        
        //File file = new File(filepath);
        int count = 0;
        
       JTextField text = new JTextField();
        text.setBounds(150,55,100,30);
        this.add(text);

        JButton b = new JButton("성적입력");
        b.setBounds(85,130,100,30);
        this.add(b);
        b.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
            // 모달창으로 만들기

            if(rb1.isSelected()){//중간고사
                  str = lecture+"mid" ;//강의중간메모장에 학생 성적 입력 넣기 
                         System.out.println("넘어간당"+str);

                  new MidScore(str,name,text.getText()); //강의명,이름,점수 넘기기
                }
            else{//기말고사
                  str = lecture+"final";
                  new FinalScore(str,name,text.getText());
            }
            
           
       }
    });
    
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300,260);
    this.setVisible(true); 
    this.setLocationRelativeTo(null);
    }
    
}

/*
try{
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
            String line = "";
            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");

              System.out.println(line);
              //if(splitedStr[0].equals(name)){
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

*/