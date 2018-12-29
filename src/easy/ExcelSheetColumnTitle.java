package easy;

/**
 * Created by rrr on 2018/12/29.
 *
 * •Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder stringBuilder=new StringBuilder();
        while (n>0){
            n-=1;
            stringBuilder.insert(0,(char)(65+n%26));
            n/=26;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println((new ExcelSheetColumnTitle().convertToTitle(8099)));
    }

}
