package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogNotChangeSize {
    /*
    首先设计一个JFrame,上面有一个按钮，文字是 "打开一个模态窗口"。
    点击该按钮后，随即打开一个模态窗口。
    在这个模态窗口中有一个按钮，文本是 "锁定大小", 点击后，这个模态窗口的大小就被锁定住，
    不能改变。 再次点击，就回复能够改变大小
     */
    public static void main(String[] args){
        JFrame f=new JFrame("LOL");
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(null);
        JButton b=new JButton("打开一个模态窗口");
        b.setBounds(50,50,280,30);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 根据外部窗体实例化JDialog
                JDialog d=new JDialog(f);
                // 设置为模态
                d.setModal(true);
                d.setTitle("模态对话框");
                d.setSize(200,150);
                d.setLocationRelativeTo(f);

                JButton b=new JButton("锁定大小");
                b.setBounds(50,50,280,30);
                d.add(b);
                b.addActionListener(new ActionListener() {
                    boolean resizeable=false;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        d.setResizable(resizeable);
                        resizeable=!resizeable;
                        b.setText(resizeable?"解锁大小":"锁定大小");
                    }
                });
                d.setVisible(true);
            }
        });

        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
