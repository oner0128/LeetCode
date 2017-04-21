import java.util.*;

/**
 * Created by rrr on 2017/4/21.
 * 题目描述
 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
*/
public class ReverseSentence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
           String sentence=input.nextLine();
            String[]strings=sentence.split(" ");
            StringBuilder sb=new StringBuilder();
            for (int i = strings.length-1; i >=0; i--) {
                sb.append(strings[i]+" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
