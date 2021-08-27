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
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author 이혜주
 */
public class StudentConfirm2 {
    String lecture;
   StudentConfirm2(String name,String lecture){ // 학생 이름, 강의 이름 
       //강의 이름 파일에서 학생 이름 찾아서 점수 출력해야 함.
       this.lecture = lecture;
       String filepath = lecture+".txt";
        File file = new File(filepath);
        int count = 0;
        try{
            //BufferedReader bufReader = new BufferedReader(new FileReader(file));
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
            String line = "";
            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");

              System.out.println(line);
              if(splitedStr[0].equals(name)){
                  JOptionPane.showMessageDialog(null,splitedStr[1]);
              line=" ";      
              }
              else{
                  JOptionPane.showMessageDialog(null,"해당사항없음!");
              }

            }
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
   }
}
