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
public class Study_lecture_open {
    public void info(String str1, String str2, String str3, String str4){
        String s1 = str1; // 담당 교수
        String s2 = str2; // 최대
        String s3 = str3; // 최소
        String s4 = str4; // 강좌 정보 
        
        String ss = "/";
        
        StringBuilder sb = new StringBuilder(s1);
        sb.append(ss);
        sb.append(s2);
        sb.append(ss);        
        sb.append(s3);
        sb.append(ss);
        sb.append(s4);
        sb.append("/0");
       
       try {
        OutputStream output = new FileOutputStream("openlecture.txt", true);
        String str =sb +"\r\n";
        byte[] by=str.getBytes();
        output.write(by);
       }catch (Exception ee) {
            ee.getStackTrace();
       }
    }
}
