package collection;

import charactor.Hero;

import java.util.ArrayList;

public class FindEqual {
    public static void main(String[] args){
        ArrayList heros=new ArrayList();

        for (int i=0;i<5;i++){
            heros.add(new Hero("hero "+i));
        }

        Hero specialHero=new Hero("special hero");
        heros.add(specialHero);
        String name="hero 1";
        for (int i=0;i<heros.size();i++){
            Hero h=(Hero) heros.get(i);
            if (name.equals(h.name)){
                System.out.printf("找到了");
                break;
            }
        }
    }
}
