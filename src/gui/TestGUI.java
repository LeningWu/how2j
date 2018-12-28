package gui;

import javax.swing.*;
import java.io.*;

/*public class TestGUI {
    public static void main(String[] args){
        //主窗体
        JFrame f=new JFrame("LOL");
        // 主窗体设置大小
        f.setSize(400,300);
        // 主窗体设置位置
        Point p=getPointFormLocationFile();
        if (p!=null)
            f.setLocation(p.x,p.y);
        else
            f.setLocation(200,200);
        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);
        // 按钮组件
        JButton b=new JButton("一键秒");
        // 同时设置组件的大小和位置
        b.setBounds(50,50,280,30);
        // 把按钮加入到主窗体中
        f.add(b);
        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);

        new SavingPostionThread(f).start();
    }

    static class Point{
        int x;
        int y;
    }

    public static Point getPointFormLocationFile(){
        File file=new File("/Users/wulening/Desktop/xyz/location.txt");
        Point p=null;
        try (FileInputStream fis=new FileInputStream(file);
             DataInputStream dis=new DataInputStream(fis)){
            int x=dis.readInt();
            int y=dis.readInt();
            p=new Point();
            p.x=x;
            p.y=y;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestGUI {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("/Users/wulening/Desktop/timg.jpeg");
        l.setIcon(i);
        l.setBounds(50, 50, 50, 50);

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);

        // 给按钮 增加 监听
        b.addActionListener(new ActionListener() {

            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);
            }
        });

        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}

/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestGUI {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("/Users/wulening/Desktop/timg.jpeg");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        // 增加键盘监听
        f.addKeyListener(new KeyListener() {

            // 键被弹起
            public void keyReleased(KeyEvent e) {

                // 39代表按下了 “右键”
                if (e.getKeyCode() == 39) {
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX() + 10, l.getY());
                }
            }

            //键被按下
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            // 一个按下弹起的组合动作
            public void keyTyped(KeyEvent e) {

            }
        });

        f.add(l);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestGUI {
    public static void main(String[] args) {

        final JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("/Users/wulening/Desktop/timg.jpeg");
        l.setIcon(i);
        l.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());

        f.add(l);

        l.addMouseListener(new MouseListener() {

            // 释放鼠标
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            // 按下鼠标
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            // 鼠标退出
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            // 鼠标进入
            public void mouseEntered(MouseEvent e) {

                Random r = new Random();

                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());

                l.setLocation(x, y);

            }

            // 按下释放组合动作为点击鼠标
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}*/
