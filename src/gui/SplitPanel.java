package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplitPanel {
    /*
    设计一个像SplitPanel的左右风格的SplitPanel
    左边放3个按钮，上面的文字分别是: 盖伦，提莫，安妮
    右边默认显示盖伦
    当左边按钮点击的时候，右边就会显示对应的图片
     */
    public static void main(String[] args){
        JFrame f=new JFrame("LOL");
        f.setSize(400,300);
        f.setLocation(200,200);

        f.setLayout(null);

        JPanel pLeft=new JPanel();
        pLeft.setBounds(50,50,300,60);

        pLeft.setBackground(Color.LIGHT_GRAY);

        pLeft.setLayout(new FlowLayout());

        JButton b1=new JButton("盖伦");
        JButton b2=new JButton("提莫");
        JButton b3=new JButton("安妮");

        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);

        JPanel pRight=new JPanel();
        JLabel Lpic=new JLabel("");

      //  ImageIcon i=new ImageIcon("/Users/wulening/Desktop/pics/gareen.jpg");
      //  Lpic.setIcon(i);

        pRight.add(Lpic);

        pRight.setBackground(Color.LIGHT_GRAY);
        pRight.setBounds(10,150,300,60);

        JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pLeft,pRight);

        sp.setDividerLocation(80);

        f.setContentPane(sp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        switchPic(b1,"gareen",Lpic);
        switchPic(b2,"teemo",Lpic);
        switchPic(b3,"annie",Lpic);

    }

    private static void switchPic(JButton b1,String fileName,JLabel Lpic){
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon i=new ImageIcon("/Users/wulening/Desktop/pics/"+fileName+".jpg");
                Lpic.setIcon(i);
            }
        });
    }
}
