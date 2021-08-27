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
public class LectureModify2 {
    public String Confirm(String str){
        String s = str;
        String result = null;
        
        ///////////////////////
        
        File file = new File("openlecture.txt");
       
        int count = 0;
        try{
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while((line = bufReader.readLine()) != null){
                String[] splitedStr = line.split("/");

                if(s.equals(splitedStr[4])){
                    JOptionPane.showMessageDialog(null,"개설된 강좌는 수정할 수 없습니다. ");
                    count=count+1;
                    break;
                }
                else {
                    ///수정하러 가야즤!
                    LectureModify3 m3 = new LectureModify3();
                    String ss = m3.modify(s);
                    count = count + 1;
                    break;
                }
            }

            bufReader.close();
        } catch(FileNotFoundException e){

        }catch(IOException e){
            System.out.println(e);
        }
        
        return result;
    }
    
    
}
