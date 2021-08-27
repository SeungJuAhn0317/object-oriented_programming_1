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
public class LectureEval3 {
    String c;
    LectureEval3(String lecture, String c){
        this.c = c;
        String filepath = lecture+"evaluation.txt";
       try {
        OutputStream output = new FileOutputStream(filepath, true);
        byte[] by=c.getBytes();
        output.write(by);
       }catch (Exception ee) {
            ee.getStackTrace();
       }
    }
}
