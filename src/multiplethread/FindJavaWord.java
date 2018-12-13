package multiplethread;

import java.io.File;

public class FindJavaWord {
    public static void search(File file,String search){
        if (file.isFile()){
            if (file.getName().toLowerCase().endsWith(".java")){
                new SearchFileThread(file,search).start();
            }
        }
        if (file.isDirectory()){
            File[] fs=file.listFiles();
            for (File f:fs){
                search(f,search);
            }
        }
    }

    public static void main(String[] args){
        File folder=new File("/Users/wulening/Desktop/how2j/src");
        search(folder,"File");
    }
}
