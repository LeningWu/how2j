package collection;

import java.util.HashMap;
import java.util.Set;

public class SwapHash {
    /*
    使用如下键值对，初始化一个HashMap：
    adc - 物理英雄
    apc - 魔法英雄
    t - 坦克

    对这个HashMap进行反转，key变成value,value变成key
    提示： keySet()可以获取所有的key, values()可以获取所有的value
     */
    public static void main(String[] args){
        HashMap<String,String>map=new HashMap<>();
        HashMap<String,String>temp=new HashMap<>();
        map.put("adc","物理英雄");
        map.put("apc","魔法英雄");
        map.put("t","坦克");

        System.out.println("初始化后的Map:");
        System.out.println(map);
        Set<String>keys=map.keySet();

        for (String key:keys){
            String value=map.get(key);
            temp.put(value,key);
        }

        map.clear();
        map.putAll(temp);

        System.out.println("反转后的Map:");
        System.out.println(map);
    }
}
