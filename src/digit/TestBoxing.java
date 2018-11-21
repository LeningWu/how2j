package digit;

public class TestBoxing {
    public static void main(String[] args) {
        //测试自动拆箱装箱
        byte b = 5;
        short s = 5;
        float f = 5;
        double d = 5;
        int i=5;
        //自动装箱
        Byte b2 = b;
        Short s2 = s;
        Float f2 = f;
        Double d2 = d;
        //自动拆箱
        byte b3 = b2;
        short s3 = s2;
        float f3 = f2;
        double d3 = d2;

        System.out.println(Byte.MAX_VALUE);
        System.out.println((Byte.MIN_VALUE));

        //Integer i2=b2;
    }

}
