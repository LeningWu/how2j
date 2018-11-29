package stream;
import charactor.Hero;

import java.io.*;

public class ObjectHero {
    /*
    准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组

    然后把该数组序列化到一个文件heros.lol

    接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样

     */
    public static void main(String[] args){
        Hero h[]=new Hero[10];
        for (int i=0;i<10;i++){
            h[i]=new Hero();
            h[i].name="hero"+i;
        }

        File f=new File("/Users/wulening/Desktop/xyz/heros.lol");
        try (FileOutputStream fos=new FileOutputStream(f);
             ObjectOutputStream oos=new ObjectOutputStream(fos);
             FileInputStream fis=new FileInputStream(f);
             ObjectInputStream ois=new ObjectInputStream(fis)){

             oos.writeObject(h);
             Hero[] h2=(Hero[])ois.readObject();
             for (Hero hero:h2)
                 System.out.printf(hero.name+"%n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
