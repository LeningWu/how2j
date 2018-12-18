package multiplethread;

public class ConsumerThread extends Thread{
    /*
    提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
     */
    private MyStack<Character> stack;

    public ConsumerThread(MyStack<Character> stack,String name){
        super(name);
        this.stack=stack;
    }

    public void run(){
        while (true){
            char c=stack.pull();
            System.out.println(this.getName()+" 弹出: " + c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
