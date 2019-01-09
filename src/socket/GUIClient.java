package socket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class GUIClient {
    public static void main(String[] args) throws IOException {
        JFrame f=new JFrame("client");
        f.setSize(400,300);
        f.setLocation(100,200);
        f.setLayout(null);

        JButton b=new JButton("send");
        b.setBounds(10,10,80,30);
        f.add(b);

        JTextField tf=new JTextField();
        tf.setBounds(10,110,80,30);
        f.add(tf);

        JTextArea ta=new JTextArea();
        ta.setBounds(110,10,200,300);
        f.add(ta);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        Socket s=new Socket("127.0.0.1",8888);

        new Thread(){
            public void run(){
                while (true){
                    try {
                        DataInputStream dis=new  DataInputStream(s.getInputStream());
                        String text=dis.readUTF();
                        ta.append(text+"\r\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text=tf.getText();
                ta.append(text+"\r\n");

                try {
                    OutputStream os=s.getOutputStream();
                    DataOutputStream dos=new DataOutputStream(os);
                    dos.writeUTF(text);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        });
    }
}
