package gui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMove {
    /*
    把键盘监听中的代码完善，使得由当前的只能向右移动，完善为上下左右移动都可以。
    提示：keyCode与方向的对应关系
    38 上
    40 下
    37 左
    39 右
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

        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==39){
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX() + 10, l.getY());
                }
                if (e.getKeyCode()==37){
                    //图片向左移动 （y坐标不变，x坐标减小）
                    l.setLocation(l.getX()-10,l.getY());
                }
                if (e.getKeyCode()==40){
                    //图片向下移动 （y坐标减小，x坐标不变）
                    l.setLocation(l.getX(),l.getY()+10);
                }
                if (e.getKeyCode()==38){
                    //图片向左移动 （y坐标增加，x坐标不变）
                    l.setLocation(l.getX(),l.getY()-10);
                }
            }
        });

        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
