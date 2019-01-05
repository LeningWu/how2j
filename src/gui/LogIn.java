package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LogIn {
    /*
    准备两个JTextFiled,一个用于输入账号，一个用于输入密码。
    再准备一个JButton，上面的文字是登陆
    点击按钮之后，首先进行为空判断，如果都不为空，则把账号和密码，
    拿到数据库中进行比较(SQL语句判断账号密码是否正确)，根据判断结果，使用JOptionPane进行提示。
     */
    public static void main(String[] args){
        JFrame f=new JFrame("LOL");
        f.setSize(800,600);
        f.setLocation(200,200);
       // f.setLayout(new FlowLayout());

        JPanel pNorth = new JPanel();
        pNorth.setLayout(new FlowLayout());
        JPanel pCenter = new JPanel();

        JLabel LName=new JLabel("账号: ");
        JTextField tfName=new JTextField();
       // tfName.setText("");
        tfName.setPreferredSize(new Dimension(120,40));

        JLabel LPassword=new JLabel("密码: ");
        JPasswordField tfPassowrd=new JPasswordField();
       // LPassword.setText("");
        tfPassowrd.setPreferredSize(new Dimension(120,40));

        pNorth.add(LName);
        pNorth.add(tfName);
        pNorth.add(LPassword);
        pNorth.add(tfPassowrd);

        JButton b=new JButton("登录");
        pCenter.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=tfName.getText();
                String password=new String(tfPassowrd.getPassword());
                if (name.isEmpty()){
                    JOptionPane.showMessageDialog(f,"用户名不能为空");
                }
                if (password.isEmpty()){
                    JOptionPane.showMessageDialog(f,"密码不能为空");
                }
                if (check(name,password)){
                    JOptionPane.showMessageDialog(f, "登陆成功");
                }
                else {
                    JOptionPane.showMessageDialog(f, "密码错误");
                }
            }
        });

        f.setLayout(new BorderLayout());
        f.add(pNorth,BorderLayout.NORTH);
        f.add(pCenter,BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }

    public static boolean check(String name,String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        boolean result=false;

       try (Connection c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
               "root","root");
            Statement s=c.createStatement()){
            String sql="select * from user where name = '" + name +"' and password = '" + password+"'";

           ResultSet rs=s.executeQuery(sql);

           if (rs.next()){
               result=true;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return result;
    }
}