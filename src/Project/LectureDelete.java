/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 이혜주
 */
public class LectureDelete {
     public void delete(){
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(280,300);
        frame.setLocationRelativeTo(null);
        frame.setTitle("삭제");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBounds(0,0,280,300);
        frame.add(panel);
        panel.setLayout(null);
        
        JLabel label = new JLabel("삭제하고 싶은 강좌명을 입력하세요");
        label.setBounds(30,20,300,100);
        panel.add(label);
        
        JTextField field = new JTextField();
        field.setBounds(60,100,140,30);
        panel.add(field);
        
        JButton b = new JButton("검색");
        b.setBounds(100,150,60,50);
        panel.add(b);
        
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ee){
                
                String str = field.getText();
                LectureDelete2 m = new LectureDelete2();
               String str2 =  m.Confirm(str);
                //String str2 = m.confirm(str);
            }
        });
        
        frame.setVisible(true);
             
        
    }

}
