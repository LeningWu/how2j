package digit;

public class StringPractice4 {
    //把 lengendary 最后一个字母变大写
    public static void main(String[] args){
        String str="lengendary";
        char[] c=str.toCharArray();

        int b=c.length;
        c[b-1]=Character.toUpperCase(c[b-1]);
        str=new String(c);
        System.out.println(str);

    }
}
