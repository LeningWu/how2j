public class arrayreverse {
    public static void main(String[] args){
        int a[] = new int[5];
        int b[] = new int[5];
        a[0]=(int)(Math.random()*100);
        a[1]=(int)(Math.random()*100);
        a[2]=(int)(Math.random()*100);
        a[3]=(int)(Math.random()*100);
        a[4]=(int)(Math.random()*100);

        System.out.println("原数组为：");
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
            int j=a.length-i-1;
            b[j]=a[i];
        }
        System.out.println("新数组为：");
        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }


    }
}
