package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchVision {
    /*
    把按钮监听中的按钮上的文字从“隐藏图片” 改为 "显示图片"。
    第一次点击的时候，会使得图片隐藏，第二次点击的时候，会使得图片显示，如此循环下去。
    一旦点击了"隐藏图片"，按钮上的文字就要变成“显示图片” 。。。 如此循环
    提示： 调用JButton对象的setText改变按钮上的文字
     */
    public static void main(String[] args){
        JFrame f=new JFrame("LOL");
        f.setSize(400,300);
        f.setLocation(580,200);
        f.setLayout(null);

        final JLabel l=new JLabel();

        ImageIcon i=new ImageIcon("/Users/wulening/Desktop/timg.jpeg");
        l.setIcon(i);
        l.setBounds(50,50,100,100);

        JButton b=new JButton("隐藏图片");
        b.setBounds(150,200,100,30);

        //按钮监听
        b.addActionListener(new ActionListener() {
            boolean hide=false;
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setVisible(hide);
                hide=!hide;
                b.setText(hide?"显示图片":"隐藏图片");
            }
        });

        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
