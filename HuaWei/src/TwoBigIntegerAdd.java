import java.util.Scanner;

/**
 * Created by rrr on 2017/3/25.
 * 题目描述
 请设计一个算法完成两个超长正整数的加法。
 接口说明
 /*
 请设计一个算法完成两个超长正整数的加法。
 输入参数：
 String addend：加数
 String augend：被加数
 返回值：加法结果
 */
public class TwoBigIntegerAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String addend = scanner.nextLine();String augend = scanner.nextLine();
            System.out.println(AddLongInteger(addend,augend));
            System.out.println(AddLongInteger2(addend,augend));
        }
        scanner.close();
    }
    public static String AddLongInteger(String addend, String augend){
        char[] addends=addend.toCharArray();
        char[] augends=augend.toCharArray();
        int addLength=addend.length();
        int augLength=augend.length();
        int i=0,j=0;
        StringBuilder stringBuilder=new StringBuilder();
        int carry=0;
        int add,aug,sum,mod;
        while (i<addLength&&j<augLength){
            add=(int)addends[addLength-i-1]-48;i++;
            aug=(int)augends[augLength-j-1]-48;j++;
            sum=add+aug+carry;
            mod=sum%10;
            carry=sum/10;
            stringBuilder.insert(0,mod);
        }
        while (i<addLength){
            add=(int)addends[addLength-i-1]-48;i++;
            sum=add+carry;
            mod=sum%10;
            carry=sum/10;
            stringBuilder.insert(0,mod);
        }
        while (j<augLength){
            aug=(int)augends[augLength-j-1]-48;j++;
            sum=aug+carry;
            mod=sum%10;
            carry=sum/10;
            stringBuilder.insert(0,mod);
        }
        if (carry==1)stringBuilder.insert(0,carry);
        return stringBuilder.toString();
    }
    //只遍历一遍,代码更简洁
    public static String AddLongInteger2(String addend, String augend){
        char[] addends=addend.toCharArray();
        char[] augends=augend.toCharArray();
        int addLength=addend.length();
        int augLength=augend.length();
        StringBuilder stringBuilder=new StringBuilder();
        int carry=0;
        int add,aug,sum,mod;
        int n=addLength>augLength?addLength:augLength;
        for (int i = 0; i < n; i++) {
            add=i<addLength?(int)addends[addLength-i-1]-48:0;
            aug=i<augLength?(int)augends[augLength-i-1]-48:0;
            sum=add+aug+carry;
            mod=sum%10;
            carry=sum/10;
            stringBuilder.insert(0,mod);
        }
        if (carry==1)stringBuilder.insert(0,carry);
        return stringBuilder.toString();
    }
}