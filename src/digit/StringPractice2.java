package digit;

public class StringPractice2 {
    /*英文绕口令
    peter piper picked a peck of pickled peppers
    统计这段绕口令有多少个以p开头的单词
    */
    public static void main(String[] args){
        String sentense="peter piper picked a peck of pickled peppers";
        int count=0;
        char a;
        String first;
        String subSentenses[]=sentense.split(" ");
        for(String sub:subSentenses){
            first=sub.substring(0,1);
            //System.out.println(first);
            a=first.charAt(0);
            if(a=='p'){
                count++;
            }
        }
        System.out.println(count);
    }

}
