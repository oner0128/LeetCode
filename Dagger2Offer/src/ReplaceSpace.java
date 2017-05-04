/**
 * Created by rrr on 2017/5/3.
 */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int i=0;
        while (i<str.length()){
            if (str.charAt(i)==' '){
                str.deleteCharAt(i);
                str.insert(i,"%20");
                i+=3;
            }else i++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer(" We Are Happy")));
    }
}
