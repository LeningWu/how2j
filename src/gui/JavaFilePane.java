package gui;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaFilePane {
    /*
    首先准备一个JavaFilePane 专门用于显示文件内容的Panel
    然后在TestGUI中遍历e:/project/j2se/jdbc 下的文件，并根据这些文件生成JavaFilePane 。
    接着把这些JavaFilePane 插入到TabbedPanel中即可
     */
    public static void main(String[] args){
        JFrame f=new JFrame("lol");
        f.setSize(800,600);
        f.setLocation(200,200);
        f.setLayout(null);

        JTabbedPane tp=new JTabbedPane();
        showJavaFile(new File("/Users/wulening/Desktop/how2j/src/JDBC"),tp);
        f.setContentPane(tp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static int count=0;
    public static void showJavaFile(File file,JTabbedPane tp){
        File[] files=file.listFiles();
        for (File b:files){
            if (b.isFile()){
                if (b.getName().toLowerCase().endsWith(".java")){
                    try (FileReader fr=new FileReader(b)){
                        char[] readbuff=new char[(int)b.length()];
                        fr.read(readbuff);
                        JTextArea tx=new JTextArea();
                        tx.append(String.valueOf(readbuff));
                        tx.setLineWrap(true);
                        JScrollPane sp=new JScrollPane(tx);
                        tp.add(sp);
                        tp.setTitleAt(count,b.getName());
                        ImageIcon i=new ImageIcon("/Users/wulening/Desktop/pics/j.png");
                        tp.setIconAt(count,i);
                        count++;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
