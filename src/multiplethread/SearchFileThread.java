package multiplethread;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileThread extends Thread{
    /*
    把练习-查找文件内容 改为多线程查找文件内容
    原练习的思路是遍历所有文件，当遍历到文件是 .java的时候，查找这个文件的内容，查找完毕之后，再遍历下一个文件
    现在通过多线程调整这个思路：
    遍历所有文件，当遍历到文件是.java的时候，创建一个线程去查找这个文件的内容，不必等待这个线程结束，继续遍历下一个文件
     */
    private File file;
    private String search;
    public SearchFileThread(File file,String search){
        this.file=file;
        this.search=search;
    }

    public void run(){
        String fileContet=readFileConent(file);
        if (!fileContet.contains(search)){
            System.out.printf("找到子目标字符串%s,在文件:%s%n",search,file);
        }
    }

    public String readFileConent(File file) {
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
