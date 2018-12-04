package stream;

import java.io.File;

public class copyTheFolder extends CopyTheFile{
    /*
    复制文件夹,实现如下方法，把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)

    public static void copyFolder(String srcFolder, String destFolder){

    }
     */
    public static void copyFolder(String srcFolder, String destFolder){
        File srcPath=new File(srcFolder);
        File destPath=new File(destFolder);

        if(!destPath.exists())
            destPath.mkdirs();

        File[] files=srcPath.listFiles();
        for (File srcFile:files){
            if (srcFile.isFile()){
                File newDestFile=new File(destPath,srcFile.getName());
                copyFile(srcFile.getAbsolutePath(),newDestFile.getAbsolutePath());
            }

            if (srcFile.isDirectory()){
                File newDestFolder=new File(destPath,srcFile.getName());
                copyFolder(srcFile.getAbsolutePath(),newDestFolder.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args){
        copyFolder("/Users/wulening/Desktop/xyz/srcFolder","/Users/wulening/Desktop/xyz/destFolder");
    }
}
