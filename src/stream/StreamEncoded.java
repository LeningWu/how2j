package stream;

import java.io.*;

public class StreamEncoded {
    /**
     * 解密在文件加密中生成的文件。
     设计一个方法
     public static void decodeFile(File decodingFile, File decodedFile);
     在这个方法中把decodingFile的内容进行解密，然后保存到decodedFile文件中。
     解密算法：
     数字：
     如果不是0的数字，在原来的基础上减1，比如6变成5, 4变成3
     如果是0的数字，变成9
     字母字符：
     如果是非a字符，向左移动一个，比如e变成d, H变成G
     如果是a，a->z, A-Z。
     字符需要保留大小写
     非字母字符：
     比如',&^ 保留不变，中文也保留不变
     */
    public static void main(String[] args){
        File decodingFile = new File("/Users/wulening/Desktop/xyz/decodingFile.txt");
        File decodedFile = new File("/Users/wulening/Desktop/xyz/decodedFile.txt");
        decodeFile(decodingFile,decodedFile);
    }

    public static void decodeFile(File decodingFile, File decodedFile){
        try (FileReader fr= new FileReader(decodingFile); FileWriter fw=new FileWriter(decodedFile)){
            char[] fileContect=new char[(int) decodingFile.length()];
            fr.read(fileContect);
            System.out.println("解密前的内容为：");
            System.out.println(new String(fileContect));
            //解密
            decode(fileContect);
            System.out.println("解密后内容为：");
            System.out.println(new String(fileContect));
            fw.write(fileContect);//写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decode(char[] fileContect){
        for (int i=0;i<fileContect.length;i++){
            if (fileContect[i]>48&&fileContect[i]<=57||fileContect[i]>65&&fileContect[i]<=90||fileContect[i]>97&&fileContect[i]<=122)
                fileContect[i]= (char) (fileContect[i]-1);
            if (fileContect[i]==48)
                fileContect[i]='9';
            if (fileContect[i]==65)
                fileContect[i]='Z';
            if (fileContect[i]==97)
                fileContect[i]='z';
        }
    }
}
