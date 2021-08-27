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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 이혜주
 */
public class Enrolment1 {
    String str1;
    String str2;
    String str3;
    
    public void name(String name){
    //로그인한 학생의 이름을 메모장에 쓰는거  학번 학과 
      //강의 이름 메모장 안에 학생의 이름과 학번 학과 
       //1. 학생 메모장에서 정보 가져오기
       //2. 그 정보를 lecterName? 거기에 넣기 
       String namee = name;
       File file = new File("student.txt");
        try{
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
            String line = "";
            int i = 1;
            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");
                if(splitedStr[0].equals(namee)){

              System.out.println(line);
              System.out.println(splitedStr[0]);
              System.out.println(splitedStr[1]);
              System.out.println(splitedStr[2]);                 
             str1 = splitedStr[0];
             str2 = splitedStr[1];
             str3 = splitedStr[2];
              line=" ";      
              }

            }
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
        //////////// 강좌 이름 메모장에 이름 학번 학과 넣기
      //  FileWriter reader = new FileWriter(lectureName+".txt", true); // 텍스트 파일이 없으면 새로 생성함!

      //reader.write(""); // 파일에 "입출력!"을 저장함.
     // reader.append("\n");
      //reader.close();
    }
}
