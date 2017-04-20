package easy;

/**
 * Created by rrr on 2017/4/19.
 * 434. Number of Segments in a String
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 Please note that the string does not contain any non-printable characters.
 Example:
 Input: "Hello, my name is John"
 Output: 5
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (s==null||s.length()==0)return 0;
        String[]str=s.toLowerCase().split(" ");
        int count=0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length()!=0)count++;
        }
        return count;
    }
    public int countSegments2(String s) {
        String trimmed = s.trim();
        if (trimmed.length() == 0) return 0;
        else return trimmed.split("\\s+").length;
    }
    public static void main(String[] args) {
        System.out.println(new NumberOfSegmentsInAString().countSegments("Hello,,,,my name is John"));
        System.out.println(new NumberOfSegmentsInAString().countSegments("Hello   my name is John"));
        System.out.println(new NumberOfSegmentsInAString().countSegments("love live! mu'sic forever"));
    }
}
