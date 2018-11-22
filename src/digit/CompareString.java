package digit;

import static java.lang.Math.random;

public class CompareString {
    /*
    创建一个长度是100的字符串数组
    使用长度是2的随机字符填充该字符串数组
    统计这个字符串数组里重复的字符串有多少种
     */
    public static String ramdom(){
        char[] s=new char[2];
        int d=0;
        for (int i=0;i<s.length;i++){
            for (;;){
                int c=(int)(Math.random()*74+48);
                if((c>=48&&c<=57)||(c>=65&&c<=90)||(c>=97&&c<=122))
                    d=c;
                    break;
            }
            s[i]=(char)d;
        }
        String strx=new String(s);
        return strx;
    }

    public static void main(String[] args){
        String[] str=new String[100];
        int count=0;
        String tip="";
        for (int i=0;i<str.length;i++){
            str[i]=ramdom();
            if (i%20 == 0){
                System.out.println();
            }
            System.out.format(str[i]+"  ");
        }
        for (int i=0;i<str.length;i++){
            for (int j=1;j<i;j++){
                if (str[i].equalsIgnoreCase(str[j])){
                    count++;
                    tip=tip+str[i]+" ";
                }
            }
        }
        System.out.println("\n"+"一共有"+count+"重复"+"\n"+"分别为："+tip);
    }
}
