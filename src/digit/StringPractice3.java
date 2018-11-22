package digit;

public class StringPractice3 {
    //把 lengendary 改成间隔大写小写模式，即 LeNgEnDaRy
    public static void main(String[] args){
        String str="lengendary";
        char[] c=str.toCharArray();
        for (int i=0;i<c.length;i++){
            if(i%2==0){
                c[i]=Character.toUpperCase(c[i]);
            }
            else{
                c[i]=Character.toLowerCase(c[i]);
            }
        }
        str=new String(c);
        System.out.println(str);
    }
}
