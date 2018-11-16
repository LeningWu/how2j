import java.util.Arrays;

public class sort2arrey {
    public static void main(String[] args) {
        int a[][] = new int[5][8];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int) (Math.random() * 100);
            }
        }

        System.out.println("打印二维数组");
        for (int[] i : a) {
            System.out.println(Arrays.toString(i));
        }

        // 把二维数组复制到一维数组
        int b[] = new int[a.length * a[0].length];
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, b, i * a[i].length, a[i].length);
        }
        // 对一维数组进行排序
        Arrays.sort(b);
        // 把一维数组复制到二维数组
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(b, a[i].length * i, a[i], 0, a[i].length);
        }
        System.out.println("打印排序后的二维数组");
        for (int[] i : a) {
            System.out.println(Arrays.toString(i));
        }

    }
}


