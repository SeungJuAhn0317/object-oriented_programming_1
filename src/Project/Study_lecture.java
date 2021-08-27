/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;

/**
 *
 * @author 이혜주
 */
public class Study_lecture {
    
    public void info(String str1, String str2, String str3, String str4, String str5){
        String s1, s2, s3, s4, s5;
        s1 = str1;
        s2 = str2;
        s3 = str3;
        s4 = str4;
        s5 = str5;

        String ss = "/";
        
        StringBuilder sb = new StringBuilder(s1);
        sb.append(ss);
        sb.append(s2);
        sb.append(ss);        
        sb.append(s3);
        sb.append(ss);
        sb.append(s4);
        sb.append(ss);        
        sb.append(s5);    
       
       try {
        OutputStream output = new FileOutputStream("lecture.txt", true);
        String str =sb +"\r\n";
        byte[] by=str.getBytes();
        output.write(by);
       }catch (Exception ee) {
            ee.getStackTrace();
       }
    }
}

