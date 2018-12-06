package collection;

import charactor.Hero;

import java.util.LinkedList;

public class MyStack implements Stack {

    LinkedList<Hero> heroes=new LinkedList<>();

    @Override
    public void push(Hero h) {  ////把英雄推入到最后位置
        heroes.addLast(h);
    }

    @Override
    public Hero pull() { ////把最后一个英雄取出来
        return heroes.removeLast();
    }

    @Override
    public Hero peek() { ////查看最后一个英雄
        return heroes.getLast();
    }

    public static void main(String[] args){
        MyStack heroStack=new MyStack();
        for (int i=0;i<10;i++){
            Hero h=new Hero("hero name "+i);
            System.out.println("压入："+h);
            heroStack.push(h);
        }

        for (int i=0;i<10;i++){
            Hero h=heroStack.pull();
            System.out.println("弹出："+h);
            System.out.println("查看"+heroStack.peek());
        }
    }
}
