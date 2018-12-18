package multiplethread;

public class ProducerThread extends Thread{
    /*
     提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
     */
    private MyStack<Character> stack;

    public ProducerThread(MyStack<Character> stack,String name){
        super(name);
        this.stack=stack;
    }

    public void run(){
        while (true){
            char c=randomChar();
            System.out.println(this.getName()+"压入"+c);
            stack.push(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public char randomChar(){
        return (char)(Math.random()*('Z'+1-'A')+'A');
    }
}