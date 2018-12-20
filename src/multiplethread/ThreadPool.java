package multiplethread;

import java.util.LinkedList;

public class ThreadPool {
    int threadPoolSize;

    LinkedList<Runnable> tasks=new LinkedList<>();

    public ThreadPool(){
        threadPoolSize=10;

        synchronized (tasks){
            for (int i=0;i<10;i++){
                new TaskComsumeThread("任务消费者线程"+i).start();
            }
        }
    }

    public void add(Runnable r){
        synchronized (tasks){
            tasks.add(r);
            tasks.notifyAll();
        }
    }

    class TaskComsumeThread extends Thread{

        public TaskComsumeThread(String name) {
            super(name);
        }

        Runnable task;

        public void run(){
            while (true){
                synchronized (tasks){
                    while (tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task=tasks.removeLast();
                    tasks.notifyAll();
                }
                task.run();
            }
        }
    }
}
