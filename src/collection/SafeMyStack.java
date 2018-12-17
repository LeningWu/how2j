package collection;

import charactor.Hero;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SafeMyStack implements Stack{
    //线程安全
    List<Hero> heroes=(List<Hero>) Collections.synchronizedList(new LinkedList<Hero>());
    @Override
    public void push(Hero h) {
        heroes.add(h);
    }

    @Override
    public Hero pull() {
        return heroes.remove(heroes.size()-1);
    }

    @Override
    public Hero peek() {
        return heroes.get(heroes.size()-1);
    }
}
