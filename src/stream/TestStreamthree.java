package stream;
import java.io.*;

public class TestStreamthree {
    public static void main(String[] args){
        murgeFile("/Users/wulening/Desktop/xyz","lol2.txt");
    }



    /**
     * 合并的思路，就是从eclipse.exe-0开始，读取到一个文件，就开始写出到 eclipse.exe中，直到没有文件可以读
     * @param folder
     *            需要合并的文件所处于的目录
     * @param fileName
     *            需要合并的文件的名称
     * @throws FileNotFoundException
     */

    private static void murgeFile(String folder,String fileName){
        try {
            //合并的目标文件
            File destFile =new File(folder,fileName);
            FileOutputStream fos=new FileOutputStream(destFile);
            int index=0;
            while (true){
                //子文件
                File eachFile=new File(folder,fileName+"-"+index++);
                if (!eachFile.exists())
                    break;
                //读子文件内容
                FileInputStream fis=new FileInputStream(eachFile);
                byte[] eachContent=new byte[(int) eachFile.length()];
                fis.read(eachContent);
                fis.close();

                //子文件内容写出去
                fos.write(eachContent);
                fos.flush();
                System.out.printf("把子文件%s写到目标文件中%n",eachFile);
            }
            fos.close();
            System.out.printf("最后目标文件大小：%d字节",destFile.length());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
