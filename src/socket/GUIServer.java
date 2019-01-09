package socket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GUIServer {
    public static void main(String[] args) throws IOException {
        JFrame f=new JFrame("server");
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

        ServerSocket ss=new ServerSocket(8888);

        System.out.println("监听在端口号8888");
        Socket s=ss.accept();

        new Thread(){
            public void run(){
                while (true){
                    try {
                        DataInputStream dis= new DataInputStream( s.getInputStream());
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
