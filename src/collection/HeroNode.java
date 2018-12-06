package collection;

import charactor.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {
    /*
    根据上面的学习和理解，设计一个Hero二叉树，HeroNode.
    可以向这个英雄二叉树插入不同的Hero对象，并且按照Hero的血量"倒排序"  左大右小。
    随机生成10个Hero对象，每个Hero对象都有不同的血量值，插入这个HeroNode后，把排序结果打印出来。
     */
    public HeroNode leftNode;

    public HeroNode rightNode;

    public Hero value;

    public void add(Hero v){
        if (null==value)
            value=v;
        else {
            if (v.hp>value.hp){
                if (null==leftNode)
                    leftNode=new HeroNode();
                leftNode.add(v);
            }

            else {
                if (null==rightNode)
                    rightNode=new HeroNode();
                rightNode.add(v);
            }
        }
    }

    public List<Object>values(){
        List<Object>values=new ArrayList<>();

        if (null!=leftNode)
            values.addAll(leftNode.values());

        values.add(value);

        if (null!=rightNode)
            values.addAll(rightNode.values());

        return values;
    }

    public static void main(String[] args){
        List<Hero>hs=new ArrayList<>();
        for (int i=0;i<10;i++){
            Hero h=new Hero();
            h.name="hero "+i;
            h.hp=(float) (Math.random() * 900 + 100);
            hs.add(h);
        }

        System.out.println("初始化10个Hero");
        System.out.println(hs);

        HeroNode tree=new HeroNode();
        for (Hero hero:hs){
            tree.add(hero);
        }
        System.out.println("根据血量倒排序后的Hero");
        List<Object>treesort=tree.values();
        System.out.println(treesort);
    }
}
