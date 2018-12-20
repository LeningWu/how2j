package multiplethread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileTask implements Runnable {

    private File file;
    private String search;
    public SearchFileTask(File file,String search){
        this.file=file;
        this.search=search;
    }

    @Override
    public void run() {
        String fileContet=readFileConent(file) ;
        if (!fileContet.contains(search)){
            System.out.printf("找到子目标字符串%s,在文件:%s%n",search,file);
        }
    }

    private String readFileConent(File file) {
        try (FileReader fr=new FileReader(file)){
            char[] all=new char[(int)(file.length())];
            fr.read(all);
            return new String(all);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
