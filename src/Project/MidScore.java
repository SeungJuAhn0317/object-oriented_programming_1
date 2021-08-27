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
public class MidScore {
    String title;
    String name;
    String score;
    String str;
    MidScore(String title,String name,String score){ //강의제목,이름,성적
        this.title = title;
        this.name = name;
        this.score = score;
        
        String ss = ":";
        if(score.equals("A")){
            str = "4.0";
        }
        else if(score.equals("B")){
            str = "3.0";
        }
        else if(score.equals("C")){
            str = "2.0";
        }
        else if(score.equals("D")){
            str = "1.0";
        }
        StringBuilder sb = new StringBuilder(name);
        sb.append(ss);
        sb.append(str);
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
