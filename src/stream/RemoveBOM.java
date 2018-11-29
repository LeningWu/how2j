package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class RemoveBOM {
    //去除BOM
    public static void main(String[] args){
        File f=new File("/Users/wulening/Desktop/xyz/numberToChe.txt");
        try (FileInputStream fis =new FileInputStream(f)){
            byte[] all=new byte[(int)f.length()];
            fis.read(all);
            System.out.println("确认UTF-8识别出来没");
            String str=new String(all,"UTF-8");
            System.out.println(str);
            System.out.println("根据前面的所学，知道'中'字对应的UTF-8编码是：e4 b8 ad");
            System.out.println("打印出文件里所有的数据的16进制是：");
            for (byte b:all){
                int i=b&0xff;
                System.out.print(Integer.toHexString(i)+" ");
            }
            System.out.println();
            System.out.println("通过观察法得出 UTF-8的 BOM 是 ef bb bf");
            byte[] BOM=new byte[3];
            BOM[0]=(byte) 0xef;
            BOM[1]=(byte) 0xbb;
            BOM[2]=(byte) 0xbf;
            byte[] withoutBOM = removeBOM(all,BOM);
            System.out.println("去掉了BOM之后的数据的16进制是：");
            for (byte b:withoutBOM){
                int i=b&0xff;
                System.out.print(Integer.toHexString(i)+" ");
            }
            System.out.println();
            System.out.println("对应的字符串就没有问号了：");
            String strWithoutBOM=new String(withoutBOM,"UTF-8");
            System.out.println(strWithoutBOM);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] removeBOM(byte[] all, byte[] BOM){
        return Arrays.copyOfRange(all,BOM.length,all.length);
    }
}
