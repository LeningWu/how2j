package digit;

public class TestExchange {
    public static void main(String[] args){
        double a=3.14;
        String s2="3.1a4";

        String ss=String.valueOf(a);
        System.out.println(ss);

        double b=Double.parseDouble(ss);
        System.out.println(b);

        double c=Double.parseDouble(s2);

    }
}
