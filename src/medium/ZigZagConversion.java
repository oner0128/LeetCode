package medium;

/**
 * Created by rrr on 2017/4/19.
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:
 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    //数学方法
    public String convert(String s, int numRows) {
        if (numRows<2||numRows>=s.length())return s;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int k=0;
            int distance;
            for (int j = i; j < s.length(); j+=distance,k++) {
                stringBuilder.append(s.charAt(j));
                if (i==numRows-1){distance=i*2;continue;}
                if (k%2==0||i==0)distance=(numRows-1-i)*2;//关键
                else distance=i*2;//关键
            }
        }
        return stringBuilder.toString();
    }
    //LeetCode解法 easy to understand 1. vertically down 2. obliquely up
    public String convert2(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING",1));
    }
}
