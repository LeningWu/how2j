package digit;
import java.lang.String;

public class Random {
/*    public static String rs(){
        char[] str=new char[5];
        int d=0;
        for (int i=0;i<5;i++){
            for(;;){
                int c= (int) (Math.random()*74+48);
                if((c>=48&&c<=57)||(c>=65&&c<=90)||(c>=97&&c<=122))
                    d=c;
                    break;
            }
            str[i]=(char)d;
        }
        String a=new String(str);
        return a;
    }

    public static void sortstr(String[] s){
        String[] str=new String[8];
        for (int i=0;i<8;i++){
            str[i]=s[i].toUpperCase();
        }
        for(int i=0;i<=7;i++){
            for(int j=0;j<7-i;j++){
                if(str[j].compareTo(str[j+1])==-1){
                    String temp=str[j];
                    str[j]=str[j+1];
                    str[j+1]=temp;

                    String temp2=s[j];
                    s[j]=s[j+1];
                    s[j+1]=temp2;
                }
            }
        }
    }

    public static void main(String[] args){
        String[] mystr=new String[8];
        for (int i=0;i<8;i++){
            mystr[i]=rs();
        }

        for (String a:mystr){
            System.out.println(a);
        }

        System.out.println("---------------------");
        sortstr(mystr);

        for (String a:mystr){
            System.out.println(a);
        }
    }

}*/

        /*
         * 创建一个长度是8的字符串数组
         * 使用8个长度是5的随机字符串初始化这个数组对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)
         * 注1： 不能使用Arrays.sort() 要自己写
         * 注2： 无视大小写，即 Axxxx 和 axxxxx 没有先后顺序
        */
        public static String rs(){
            char[] str=new char[5];
            int d=0;
            for (int i=0;i<5;i++){
                for(;;){
                    int c= (int) (Math.random()*74+48);
                    if((c>=48&&c<=57)||(c>=65&&c<=90)||(c>=97&&c<=122))
                        d=c;
                    break;
                }
                str[i]=(char)d;
            }
            String a=new String(str);
            return a;
        }

        public static void main(String[] args){
            String[] strArr=new String[8];
            for(int i=0;i<strArr.length;i++){
                strArr[i]=rs();
            }
            //首字母排序
            for (int j=0;j<strArr.length;j++){

            }

        }
}