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

//발급을 한 한 학생을 이름으로 한 파일을 읽어서 거기에 *쓰기!!(청구서 발급 유무 하기 위해서)

public class StudyBill2 {
    StudyBill2(String str){
        System.out.println("============"+str);
         String[] splitedStr = str.split(" : ");

        ////////////////////////변수 파일 읽어오는거
        
       String filename = splitedStr[1];
       try {
        OutputStream output = new FileOutputStream(filename+"bill.txt", true);
        String strr ="*" +"\r\n";
        byte[] by=strr.getBytes();
        output.write(by);
       }catch (Exception ee) {
            ee.getStackTrace();
       }      
    }

}
