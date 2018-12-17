package multiplethread;

public class DeadLock {
    public static void main(String[] args){
        Object a=new Object();
        Object b=new Object();
        Object c=new Object();

        Thread t1=new Thread(){
          public void run(){
              synchronized (a){
                  System.out.println(this.getName()+"占有了a");
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("thread1 试图占有b");
                  System.out.println("thread1 试图占有b 等待中。。。。。。。");
                  synchronized (b){
                    //  System.out.println("do something");
                      synchronized (c){

                      }
                  }
              }
          }
        };

        Thread t2=new Thread(){
            public void run(){
                synchronized (b){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a){
                        synchronized (c){

                        }
                    }
                }
            }
        };


        Thread t3=new Thread(){
            public void run(){
                synchronized (c){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a){
                        synchronized (c){

                        }
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}
