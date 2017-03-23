import java.util.Scanner;

/**
 * Created by rrr on 2017/3/23.
 * 题目描述
 有一个数据表格为二维数组（数组元素为int类型），行长度为ROW_LENGTH,列长度为COLUMN_LENGTH。对该表格中数据的操作可以在单个单元内，也可以对一个整行或整列进行操作，操作包括交换两个单元中的数据；插入某些行或列。
 请编写程序，实现对表格的各种操作，并跟踪表格中数据在进行各种操作时，初始数据在表格中位置的变化轨迹。
 */
public class DimensionalArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String firstString = scanner.next().toLowerCase();
            String secondString = scanner.next().toLowerCase();
            int firstStringLength = firstString.length(), secondStringLength = secondString.length();
            if (firstStringLength <= secondStringLength)
                System.out.println(dimensionalArrayOperations(firstString, secondString));
            else System.out.println(dimensionalArrayOperations(secondString, firstString));
        }
    }

    public static int dimensionalArrayOperations(String firstString, String secondString) {
        int firstStringLength = firstString.length();
        for (int i = firstStringLength; i > 0; i--) {
            for (int j = 0; (j + i) <= firstStringLength; j++) {
                if (secondString.contains(firstString.substring(j, j + i))) return i;
            }
        }
        return 0;
    }
}
