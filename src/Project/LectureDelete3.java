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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author 이혜주
 */



public class LectureDelete3 {
    public String delete(String s){
        String str = s;
        String r = null;
        
        ///////////////////////
        
       // File file = new File("lecture.txt");
       String fileName = "lecture.txt";
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
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            
            String line;
            String repline;
            
            String originals = str;
            String replaces = "0"; 
           
           while((line = bufferedReader.readLine()) != null){
                String[] splitedStr = line.split("/");
                
                    
               
                if(str.equals(splitedStr[1])){
                    JOptionPane.showMessageDialog(null,"강좌를 삭제하겠습니다.");
                    repline = line.replaceAll(originals, replaces);
                    bufferedWriter.write(repline);
                    bufferedWriter.newLine();
                    count=count+1;
                    //break;
                }
                else{
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
           result = true;
           if(count==0){
                    JOptionPane.showMessageDialog(null,"조회 실패");     
            }
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
        return null;
    
    }

   
}

