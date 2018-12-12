package collection;

import java.util.LinkedList;

public class MyHashMap implements IHashMap{
    /*
    根据前面学习的hashcode的原理和自定义hashcode, 设计一个MyHashMap，实现接口IHashMap
    MyHashMap内部由一个长度是2000的对象数组实现。
    设计put(String key,Object value)方法
    首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
    如果该位置没有数据，则把字符串和对象组合成键值对Entry，再创建一个LinkedList，把键值对，放进LinkedList中，最后把LinkedList 保存在这个位置。
    如果该位置有数据，一定是一个LinkedList,则把字符串和对象组合成键值对Entry，插入到LinkedList后面。
    设计 Object get(String key) 方法
    首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
    如果这个位置没有数据，则返回空
    如果这个位置有数据，则挨个比较其中键值对的键-字符串，是否equals，找到匹配的，把键值对的值，返回出去。找不到匹配的，就返回空
     */
    LinkedList<Entry>[] values=new LinkedList[2000];
    @Override
    public void put(String key, Object object) {
        int hashcode=hashCode(key);

        LinkedList<Entry>list=values[hashcode];
        if (null==list){
            list=new LinkedList<>();
            values[hashcode]=list;
        }
        boolean found=false;
        for (Entry entry:list){
            if (key.equals(entry.key)){
                entry.value=object;
                found=true;
                break;
            }
        }

        if (!found){
            Entry entry=new Entry(key,object);
            list.add(entry);
        }
    }

    @Override
    public Object get(String key) {
        return null;
    }


    public static int hashCode(String str){
        if (0==str.length())
            return 0;

        int hashcode=0;
        char[] cs=str.toCharArray();
        for (int i=0;i<cs.length;i++){
            hashcode=hashcode+cs[i];
        }
        hashcode=hashcode*23;
        if (hashcode>1999){
            hashcode=hashcode%2000;
        }

        return hashcode;
    }
}
