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
import javax.swing.JOptionPane;

/**
 *
 * @author 이혜주
 */
public class LectureModify3 {
    public String modify(String s){
        String str = s;
        String result = null;
        
        ///////////////////////
        
        File file = new File("lecture.txt");
       
        int count = 0;
        try{
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");

                if(str.equals(splitedStr[1])){
                    JOptionPane.showMessageDialog(null,"강좌를 수정하겠습니다.");
                  //  LectureModify4 m = new LectureModify4();
                    
                    new LectureModify4(line);
                    count=count+1;
                    
                    break;
                }
            }
           if(count==0){
                    JOptionPane.showMessageDialog(null,"조회 실패");     
            }
            
            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
        
        return result;
    }
}
