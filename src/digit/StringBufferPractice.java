package digit;

public class StringBufferPractice extends Random{
    /*
    String与StringBuffer的性能区别?
    生成10位长度的随机字符串
    然后,先使用String的+,连接10000个随机字符串,计算消耗的时间
    然后,再使用StringBuffer连接10000个随机字符串,计算消耗的时间
    提示: 使用System.currentTimeMillis() 获取当前时间(毫秒)
     */


    public static void useString(){
        String str="";
        long start=System.currentTimeMillis();;
        for (int i=0;i<10000;i++){
            str=str+rs(5);
        }
        long end=System.currentTimeMillis();
        System.out.println("String共耗时："+(end-start));
    }


    public static void useStringBuffer(){
        StringBuffer str=new StringBuffer();
        long start=System.currentTimeMillis();
        int a=1;
        for (int i=0;i<10000;i++){
            str.append(rs(5));
        }
        long end=System.currentTimeMillis();
        System.out.println("StringBuffer共耗时："+(end-start));
    }



    public static void main(String[] args){
        useString();
        useStringBuffer();
    }

}
