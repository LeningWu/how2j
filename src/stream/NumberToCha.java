package stream;

import java.io.UnsupportedEncodingException;

public class NumberToCha {
    //找出 E5 B1 8C 这3个十六进制对应UTF-8编码的汉字
    public static void main(String[] args) throws UnsupportedEncodingException{
        byte[] bs = new byte[3];
        bs[0] = (byte) 0xE5;
        bs[1] = (byte) 0xB1;
        bs[2] = (byte) 0x8C;

        String str =new String(bs,"UTF-8");
        System.out.println("E5 B1 8C 对应的字符是:"+str);
    }
}
