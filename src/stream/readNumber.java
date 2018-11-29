package stream;

import java.io.*;

public class readNumber {
    /**
     * 第一种方式： 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，然后转换为两个数字。
     注： 两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，
     那么就是3115，读取出来就无法识别到底是哪两个数字。 使用分隔符31@15能解决这个问题。

     第二种方式： 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连续读取两个数字
     */
    static File f=new File("/Users/wulening/Desktop/xyz/data.txt");
    static int x=31;
    static int y=25;

    public static void main(String[] args){
        method1();//缓存流方式
        method2();//数据流方式
    }

    public static void method2(){
        try (FileInputStream fis=new FileInputStream(f);
             DataInputStream dis=new DataInputStream(fis);
             FileOutputStream fos=new FileOutputStream(f);
             DataOutputStream dos=new DataOutputStream(fos)){
            dos.writeInt(x);//数据流写入
            dos.writeInt(y);

            int x=dis.readInt();//数据流读
            int y=dis.readInt();
            System.out.printf("数据流读出的数据x为%d y为%d%n:",x,y);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method1(){
        StringBuffer sb=new StringBuffer();
        try (FileWriter fw=new FileWriter(f);
            PrintWriter pw=new PrintWriter(fw);
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr)){
            pw.write(x+"@"+y);//写入
            pw.flush();//
            String str=br.readLine();//读
            String[] ss =str.split("@");
            int x = Integer.parseInt(ss[0]);
            int y = Integer.parseInt(ss[1]);
            System.out.printf("使用缓存流读取出的x是 %d y是 %d%n",x,y);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}