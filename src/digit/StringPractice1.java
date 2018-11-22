package digit;

public class StringPractice1 {
    /*给出一句英文句子： "let there be light"
      得到一个新的字符串，每个单词的首字母都转换为大写
    */
    public static void main(String[] args){
        String sentens="let there be light";
        String subSentences[]=sentens.split(" ");
        String newstring = new String();
        String first;
        for (String sub:subSentences){
            first=sub.substring(0,1);
            newstring=newstring+first.toUpperCase()+sub.substring(1)+" ";
        }
        System.out.println(newstring);
    }
}
