package gui;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args){
        JFrame f=new JFrame("计算器");
        f.setSize(322,272);
        f.setLocation(200,200);
        f.setLayout(new GridLayout(4,5,8,8));

        f.add(new JButton("7"));
        f.add(new JButton("8"));
        f.add(new JButton("9"));
        f.add(new JButton("/"));
        f.add(new JButton("sq"));
        f.add(new JButton("4"));
        f.add(new JButton("5"));
        f.add(new JButton("6"));
        f.add(new JButton("*"));
        f.add(new JButton("%"));
        f.add(new JButton("1"));
        f.add(new JButton("2"));
        f.add(new JButton("3"));
        f.add(new JButton("-"));
        f.add(new JButton("1/x"));
        f.add(new JButton("0"));
        f.add(new JButton("+/-"));
        f.add(new JButton("."));
        f.add(new JButton("+"));
        f.add(new JButton("="));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
