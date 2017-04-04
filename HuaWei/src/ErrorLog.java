import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rrr on 2017/3/26.
 */
public class ErrorLog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer>map=new HashMap<>();
        while (scanner.hasNext()) {
            String[] common = scanner.nextLine().split(" ");
            String[] N =common[0].split("\\\\");
            int errorRow=Integer.parseInt(common[1]);
            String fileName=N[N.length-1];
            if (!map.containsKey(fileName))map.put(fileName+" "+errorRow,1);
            else map.put(fileName,map.get(fileName)+1);
        }
//        StringBuilder stringBuilder=new StringBuilder();
//        for (int i = 0; i < 8; i++) {
//            map.get(0);
//        }
        System.out.println(map);
    }
}
