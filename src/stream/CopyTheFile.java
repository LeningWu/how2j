package stream;

import java.io.*;

public class CopyTheFile {
    /*
    复制文件是常见的IO操作，设计如下方法，实现复制源文件srcFile到目标文件destFile

    public static void copyFile(String srcFile, String destFile){
    }
     */
    public static void copyFile(String srcFile, String destFile){
        File srcPath=new File(srcFile);
        File destPath=new File(destFile);
        byte[] buffer=new byte[1024];
        try (FileInputStream fis=new FileInputStream(srcPath);
             FileOutputStream fos=new FileOutputStream(destPath)){
            while (true){
                int actuallyReaded=fis.read(buffer);
                if(-1==actuallyReaded)
                    break;
                fos.write(buffer,0,actuallyReaded);
                fos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        copyFile("/Users/wulening/Desktop/xyz/srcFile.txt","/Users/wulening/Desktop/xyz/destFile.txt");
    }
}
