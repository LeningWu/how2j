package stream;

import java.io.*;

public class reComments {
    //去java文件的注释
    public static void main(String[] args){
        File javaFile = new File("/Users/wulening/Desktop/how2j/src/digit/CompareString.java");
        System.out.println(javaFile.exists());
        System.out.println(javaFile.length());
        removeComments(javaFile);
    }

    public static void removeComments(File javaFile){
        StringBuffer sb= new StringBuffer();
        //读
        try (FileReader fr=new FileReader(javaFile);
             BufferedReader br=new BufferedReader(fr)){
            while (true){
                String line=br.readLine();
                if (null==line)
                    break;
                if (!line.trim().startsWith("//"))
                    sb.append(line).append("\r\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //写
        try (FileWriter fw=new FileWriter(javaFile);
             PrintWriter pw=new PrintWriter(fw)){
                 pw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
