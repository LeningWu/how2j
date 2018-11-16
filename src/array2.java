public class array2 {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        int max = -1;
        int target_x = -1;
        int target_y = -1;
        int[] b = new int[25];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                a[i][j] = (int) (Math.random() * 100);
            }

        for (int[] row : a) {
            for (int each : row) {
                System.out.print(each + "\t");
            }
            System.out.println();
        }

        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                if (a[i][j]>max){
                    max=a[i][j];
                    target_x=i+1;
                    target_y=j+1;

                }
            }
        }

        System.out.println("max"+max);
        System.out.println("target is:"+target_x+" and "+target_y);
    }
}
