import java.util.Scanner;

/**
 * Created by rrr on 2017/7/8.
 */
public class IPClassify {
    public enum Category {
        A,
        B,
        C,
        D,
        E,
        ERROR,
        PRIVATE_IP,
        DEFAULT;

        int valueOf() {
            int value = 0;
            switch (this) {
                case A:
                    value = 0;
                    break;
                case B:
                    value = 1;
                    break;
                case C:
                    value = 2;
                    break;
                case D:
                    value = 3;
                    break;
                case E:
                    value = 4;
                    break;
                case ERROR:
                    value = 5;
                    break;
                case PRIVATE_IP:
                    value = 6;
                    break;
                default:
                    value = -1;
                    break;
            }
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] result = new int[7];
        while (scanner.hasNext()) {
            String address = scanner.nextLine();
            String[] str = address.split("~");
            Category[] categoryIP = calssify(str[0]);
            Category categoryMask = calssifyMask(str[1]);
            if (categoryIP[0].valueOf() != -1) result[categoryIP[0].valueOf()]++;
            if (categoryIP[1].valueOf() != -1) result[categoryIP[1].valueOf()]++;
            if (categoryMask.valueOf() != -1) result[categoryMask.valueOf()]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) stringBuilder.append(result[i]);
            else stringBuilder.append(result[i] + " ");
        }
        System.out.println(stringBuilder.toString());
        scanner.close();
    }

    public static Category calssifyMask(String maskAddress) {
        String[] maskStr = maskAddress.split(".");
        String strMask = "";
        for (int i = 0; i < maskStr.length; i++)
            if (Integer.valueOf(maskStr[i]) > 255 || Integer.valueOf(maskStr[i]) < 0) return Category.ERROR;
            else strMask += Integer.toBinaryString(Integer.valueOf(maskStr[i]));
        int i = 0;
        while (i < strMask.length() && strMask.charAt(i) == '1') i++;
        while (i < strMask.length() && strMask.charAt(i) == '0') i++;
        return i == strMask.length() ? Category.DEFAULT : Category.ERROR;
    }

    public static Category[] calssify(String address) {
        Category[] result = new Category[2];
        String[] ipStr = address.split(".");
        int[] ip = new int[4];
        for (int i = 0; i < ipStr.length; i++)
            if (Integer.valueOf(ipStr[i]) > 255 || Integer.valueOf(ipStr[i]) < 0) {
                return new Category[]{Category.ERROR, Category.DEFAULT};
            } else ip[i] = Integer.valueOf(ipStr[i]);

        if (ip[0] <= 127 && ip[0] >= 1) result[0] = Category.A;
        else if (ip[0] <= 191 && ip[0] >= 128) result[0] = Category.B;
        else if (ip[0] <= 223 && ip[0] >= 192) result[0] = Category.C;
        else if (ip[0] <= 239 && ip[0] >= 224) result[0] = Category.D;
        else if (ip[0] <= 240 && ip[0] >= 255) result[0] = Category.E;

        if (ip[0] == 10) result[1] = Category.PRIVATE_IP;
        else if (ip[0] == 172 && ip[1] >= 16 && ip[1] <= 33) result[1] = Category.PRIVATE_IP;
        else if (ip[0] == 192 && ip[1] == 168) result[1] = Category.PRIVATE_IP;
        return result;
    }
}
