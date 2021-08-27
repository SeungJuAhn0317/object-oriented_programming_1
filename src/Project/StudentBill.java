/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author 이혜주
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


//여기는 학생이 청구서 발급 버튼을 눌렀을때 나오는 창 
//만약 해당 학생 이름의 파일을 열었을때 파일안에 *가 없으면 청구서 발급을 할 수없다 라고 창 메시지 띄우고
//만약 *가 있다면 새 프레임 창을 띄어서 듣는 과목이랑 총 학점수 같은거 나오고 강의 돈 나오게 하기 
//수강료는 한강의당 5만원으로 하기

public class StudentBill {
    StudentBill(String name){
        //학생 이름 받아오는거 성공
        // 학생이름의 파일을 열어야됨 그래서 *가 있는지 없는지 확인하기

        int count = 0;

        String filePath = name+"bill.txt";
        File file = new File(filePath);
        System.out.println(filePath);
        
        try{
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
            String line = "";
            while((line = bufReader.readLine()) != null){
                System.out.println(line);
                if(line.equals("*")){
                    System.out.println("별있음!");
                    JOptionPane.showMessageDialog(null,"청구서 발급 창으로 이동합니다.");
                    //new LectureModify4(line);
                    new StudentBill2(name);
                    count=count+1;
                    break;
                }
                
            }
           if(count==0){
                    JOptionPane.showMessageDialog(null,"청구서를 발급받을 수 없습니다.\n수업관리자에게 문의바랍니다.");     
            }
            
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
