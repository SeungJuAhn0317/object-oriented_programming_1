/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 이혜주
 */
public class CheckLogin {
    
    String pass;
    public void check(String id, String password){
        File file = new File("login.txt");
        String i = id;
        String p = password;
        
        int count =0 ;
        try{
           //BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));

           BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
            String line = "";
            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");
                System.out.println(line);
              
                
                if((i.equals(splitedStr[1]))&& (p.equals(splitedStr[2]))){
                    
                    char c = i.charAt(0);
                    String n = splitedStr[0]; // 이름
                    String num = splitedStr[1]; // 번호
                   
                 
                    JOptionPane.showMessageDialog(null,"로그인 성공");
                    
                    switch(c){
                        case 'S':
                        case 's':
                        Student student = new Student();
                        student.setVisible(true);
                        student.setLocationRelativeTo(null);
                        student.setResizable(false);
                        student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        student.setTitle("학생용");
                        student.name(n,num);
                        pass = p; 
                    System.out.println("dndndndn"+pass);
                       
                        break;
                        case 'P':
                        case 'p':
                        Professor pro = new Professor();
                        pro.setVisible(true);
                        pro.setLocationRelativeTo(null);
                        pro.setResizable(false);
                        pro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        pro.setTitle("교수용");
                        pro.name(n,num);
                        break;
                        
                        case 'H':
                        case 'h':
                        Study_main study = new Study_main();
                        study.setVisible(true);
                        study.setLocationRelativeTo(null);
                        study.setResizable(false);
                        study.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        study.setTitle("수업담당자용");
                        study.info(n,num);
                        break;
                        
                        case 'g':
                        case 'G':
                        Class_main cp = new Class_main();
                        cp.setVisible(true);
                        cp.setLocationRelativeTo(null);
                        cp.setResizable(false);
                        cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        cp.setTitle("학사담당자용");
                        cp.info(n,num);
                        break;
                    }
                    count = count + 1;

                }
            }
            if(count==0){
                 JOptionPane.showMessageDialog(null,"로그인 실패");
            }
            
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }

    }
   
   
}
