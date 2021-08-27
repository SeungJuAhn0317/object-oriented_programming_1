/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author 이혜주
 */
public class FinalScore {
    String title;
    String name;
    String score;
    
    FinalScore(String title,String name,String score){
        this.title = title;
        this.name = name;
        this.score = score;
        
        String ss = ":";
        
        StringBuilder sb = new StringBuilder(name);
        sb.append(ss);
        sb.append(score);
       System.out.println(title);
        String filepath = title+".txt";
               System.out.println(filepath);

       try {
        OutputStream output = new FileOutputStream(filepath, true);
        String str =sb +"\r\n";
        byte[] by=str.getBytes();
        output.write(by);
       }catch (Exception ee) {
            ee.getStackTrace();
       }
    }
}
