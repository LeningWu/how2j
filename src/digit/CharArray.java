package digit;

import java.util.Scanner;

public class CharArray {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("please input string:");
        String str=sc.next();

        char[] cs=str.toCharArray();
        for (int i=0;i<str.length();i++){
            System.out.println(cs[i]);
        }


    }
}
