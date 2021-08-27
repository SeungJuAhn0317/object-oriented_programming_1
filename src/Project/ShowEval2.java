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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author 이혜주
 */
public class ShowEval2 {
    String name;
    JFrame frame = new JFrame();
    ShowEval2(String name){
        this.name = name;
        String filepath = name+"evaluation.txt";//evaluation.txt
        File file = new File(filepath);
        System.out.println(filepath);
        JLabel text = new JLabel();
        text.setBounds(30,60,200,150);
        frame.add(text);
        
        try{
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while((line = bufReader.readLine()) != null){
               text.setText(line);
            }
            bufReader.close();
        } catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"강의평가 내용이 존재하지 않습니다.");

        }catch(IOException e){
            System.out.println(e);
        }
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true); 
        frame.setLocationRelativeTo(null);
    }
}
