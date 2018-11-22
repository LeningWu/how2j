package digit;

public class StringPractice {
    /*Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak
    把最后一个two单词首字母大写*/
    public static void main(String[] args) {
        String sentense = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
        String SubSentense[] = sentense.split(",");
        String a="two";
        int count=0;
       // int j =0;
        for (int i=0;i<SubSentense.length;i++){
            if(SubSentense[i].contains(a)){
                count=i;
            }
        }
        System.out.println(SubSentense[count]);
        SubSentense[count]=SubSentense[count].trim();
        String sub[]=SubSentense[count].split(" ");

        int num=0;
        for (int i=0;i<sub.length;i++){
            if (sub[i].contains(a)){
                num=i;
            }
        }
        char[] c=sub[num].toCharArray();
        c[0]=Character.toUpperCase(c[0]);
        sub[num]=String.valueOf(c);
        SubSentense[count]="";
        for (int i=0;i<sub.length;i++){
            SubSentense[count]=SubSentense[count]+" "+sub[i];
        }


        String str2="";
        for (int i=0;i<SubSentense.length;i++){
            if(i!=SubSentense.length-1)
                str2=str2+SubSentense[i]+",";
            else
                str2=str2+SubSentense[i];
        }
        System.out.println(sentense);
        System.out.println(str2);
    }
}
