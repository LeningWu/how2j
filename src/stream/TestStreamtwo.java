package stream;

import java.io.*;
import java.util.Arrays;

public class TestStreamtwo {
    public static void main(String[] args){
        int eachSize=1;
        File srcFile=new File("/Users/wulening/Desktop/xyz/lol2.txt");
        splitFile(srcFile,eachSize);
    }

    /**
     * 拆分的思路，先把源文件的所有内容读取到内存中，然后从内存中挨个分到子文件里
     * @param srcFile 要拆分的源文件
     * @param eachSize 按照这个大小，拆分
     */
    private static void splitFile(File srcFile,int eachSize){
        if (srcFile.length()==0)
            throw new RuntimeException("文件长度为0，不需要拆分");

        byte[] fileContent=new byte[(int)srcFile.length()];
        //先把文件读取到数组中

        try {
            FileInputStream fis=new FileInputStream(srcFile);//创建基于文件的输入流
            fis.read(fileContent);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //计算要分成多少片
        int fileNumber;
        // 文件是否能被整除得到的子文件个数是不一样的
        // (假设文件长度是25，每份的大小是5，那么就应该是5个)
        // (假设文件长度是26，每份的大小是5，那么就应该是6个)
        if (fileContent.length%eachSize==0)
            fileNumber=(int) (fileContent.length/eachSize);
        else
            fileNumber=(int)(fileContent.length/eachSize)+1;

        for (int i=0;i<fileNumber;i++){
            String eachFileName=srcFile.getName()+"-"+i;
            File eachFile=new File(srcFile.getParent(),eachFileName);
            byte[] eachContect;
            // 从源文件的内容里，复制部分数据到子文件
            // 除开最后一个文件，其他文件大小都是100k
            // 最后一个文件的大小是剩余的

            if (i!=fileNumber-1){  //不是最后一个
                eachContect= Arrays.copyOfRange(fileContent,eachSize*i,eachSize*(i+1));
            }
            else {
                eachContect=Arrays.copyOfRange(fileContent,eachSize*i,fileContent.length);
            }

            try {
                FileOutputStream fos=new FileOutputStream(eachFile);
                fos.write(eachContect);
                fos.close();
                System.out.printf("输出子文件%s,大小 %d字节%n",eachFile.getAbsoluteFile(),eachFile.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
