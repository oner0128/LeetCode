import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by rrr on 2017/4/21.
 */
public class MergeTableRecord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int m = input.nextInt();
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            for (int i = 0; i < m; i++) {
                int key = input.nextInt();
                int value = input.nextInt();
                if (!tree.containsKey(key)) tree.put(key, value);
                else tree.put(key, tree.get(key) + value);
            }
            while (tree.size() > 0) {
                Map.Entry<Integer,Integer>entry=tree.pollFirstEntry();
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }
}
