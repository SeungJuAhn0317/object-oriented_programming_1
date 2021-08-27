/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 이혜주
 */

public class Study{
    
    public void show(){
        
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(1000,700);        
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        //panel.setLayout(null);
        panel.setLayout(new FlowLayout());
        frame.add(panel);
        //panel.setVisible(true);
        
        JLabel text = new JLabel("강좌 관리");
        text.setFont(new Font("굴림", Font.PLAIN, 15));
        text.setBounds(100,100,100,100);
        panel.add(text);

        String[] headings = new String[]{"강좌번호","강좌이름","학과",
        "학점수","강좌설명"};
        String[][] data = {{"","","","",""},{"","","","",""}};
        JTable table = null;
        table = new JTable(data,headings);
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(600,300));
        
        panel.add(sp);
        String[][] dataStudentArray = null;
        ///////////////   
        File file = new File("lecture.txt");
        try{
            BufferedReader bufReader = new BufferedReader(new FileReader(file));
            String line = "";
            int i = 0;
            int num = 0;

            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");
               // if(!splitedStr[1].equals("0")){       
                    num++;
                   // break;
                //}
          
            }       
            
 dataStudentArray = new String[num][5];
 
  
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
        
        try{
            BufferedReader bufReader = new BufferedReader(new FileReader(file));
            String line = "";
            int i = 0;
     while((line = bufReader.readLine()) != null){
            String[] splitedStr = line.split("/");
            if(!splitedStr[1].equals("0")){
                for(int j=0; j <5; j++){
                    dataStudentArray[i][j] = splitedStr[j];        
                }
            }
    i++;
 }
  table.setModel(new DefaultTableModel(dataStudentArray, headings));
            

 
  
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
   


       JButton btn5 = new JButton("강좌 수정");
        btn5.setBounds(100,300,100,30);
        panel.add(btn5);
        btn5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Study_openlecture_1 open = new Study_openlecture_1();
                //open.
                LectureModify modify = new LectureModify();
                modify.Modify();
            }
        });
        
        JButton btn4 = new JButton("강좌 개설");
        btn4.setBounds(100,300,100,30);
        panel.add(btn4);
        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Study_openlecture_1 open = new Study_openlecture_1();
                //open.
            }
        });
        
        JButton btn3 = new JButton("강좌 조회");
        btn3.setBounds(100,300,100,30);
        panel.add(btn3);
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //리스트 볼 수 있는 모달창 만들기 
               // new Lecture_search1().setVisible(true);
               Lecture_search1 search = new Lecture_search1();
               search.setVisible(true);
               search.setLocationRelativeTo(null);
            }
        });

        JButton btn2 = new JButton("강좌 삭제");
        btn2.setBounds(100,300,100,30);
        panel.add(btn2);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //리스트 볼 수 있는 모달창 만들기 
                 LectureDelete d = new LectureDelete();
                d.delete();
    
            }
        });
        JButton btn = new JButton("신규강좌등록");
        btn.setBounds(100,300,100,30);
        panel.add(btn);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Study_newstudy_modal study;
                try {
                    study = new Study_newstudy_modal(frame); //,lb,lb2,lb3,lb4,lb5
                    study.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Study.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
    }
    
    
    
}
