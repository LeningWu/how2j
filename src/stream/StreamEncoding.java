package stream;

import java.io.*;

/**
 * 在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
 加密算法：
 数字：
 如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
 如果是9的数字，变成0
 字母字符：fileContect[i]>=65&&fileContect[i]<90
 如果是非z字符，向右移动一个，比如d变成e, G变成H
 如果是z，z->a, Z-A。
 字符需要保留大小写
 非字母字符
 比如',&^ 保留不变，中文也保留不变
 */

public class StreamEncoding {
    public static void main(String[] args){
        File encodingFile=new File("/Users/wulening/Desktop/xyz/encodingFile.txt");
        File encodedFile=new File("/Users/wulening/Desktop/xyz/encodedFile.txt");
        encodeFile(encodingFile,encodedFile);
    }

    public static void encodeFile(File encodingFile, File encodedFile){
        try (FileReader fr=new FileReader(encodingFile); FileWriter fw=new FileWriter(encodedFile)){
            //读原文件
            char[] fileContect=new char[(int)encodingFile.length()];
            fr.read(fileContect);
            System.out.println("加密前内容：");
            System.out.println(new String(fileContect));

            //开始加密,用加密函数
            encode(fileContect);
            //加密结束后写入新文件
            System.out.println("加密后内容");
            System.out.println(new String(fileContect));
            fw.write(fileContect);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encode(char[] fileContect){
        for (int i=0;i<fileContect.length;i++){
            if (fileContect[i]>=48&&fileContect[i]<57||fileContect[i]>=65&&fileContect[i]<90||fileContect[i]>=97&&fileContect[i]<122)
                fileContect[i]= (char) (fileContect[i]+1);
            if (fileContect[i]==57)
                fileContect[i]='0';
            if (fileContect[i]==90)
                fileContect[i]='A';
            if (fileContect[i]==122)
                fileContect[i]='a';

        }
    }
}
