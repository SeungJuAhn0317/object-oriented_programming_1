/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author 이혜주
 */
public class ChangePassword4 {
    public void modify(String origin,String change){ // 원래 비밀번호, 바꿀 비밀번호 
        String str1 = origin; //원래
        String str2 = change; //바꿀 
        String r = null;

       String fileName = "login.txt";
        File inputFile = new File(fileName);
        File outputFile = new File(fileName+".temp");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        boolean result = false;
        int count = 0;
        try{
            fileInputStream = new FileInputStream(inputFile);
            fileOutputStream = new FileOutputStream(outputFile);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream,"UTF-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream,"UTF-8"));
            
            String line;
            String repline;
           
           while((line = bufferedReader.readLine()) != null){
                    repline = line.replaceAll(str1, str2);
                    bufferedWriter.write(repline);
                    bufferedWriter.newLine();

            }
           result = true;
            JOptionPane.showMessageDialog(null,"수정 성공"); 

        } catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
               bufferedReader.close();
            }
            catch(IOException ex1){
                ex1.printStackTrace();
            }
            try{
                bufferedWriter.close();
            } catch(IOException ex2){
                ex2.printStackTrace();
            }
            if(result){
                inputFile.delete();
                outputFile.renameTo(new File(fileName));
            }
        }
    }
}
