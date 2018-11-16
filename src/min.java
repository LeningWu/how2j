public class min {
    public static void main(String[] args){
        int[] a = new int[5];
        a[0]=(int)(Math.random()*100);
        a[1]=(int)(Math.random()*100);
        a[2]=(int)(Math.random()*100);
        a[3]=(int)(Math.random()*100);
        a[4]=(int)(Math.random()*100);

        System.out.println("随机数是:\n");
        for (int i=0;i<a.length;i++)
            System.out.println(a[i]);

        int minnum=a[0];
        for (int i=0;i<a.length;i++){
            if (a[i]<=minnum)
                minnum=a[i];
        }
        System.out.println("\n");
        System.out.println("最小的是"+minnum);

    }
}
