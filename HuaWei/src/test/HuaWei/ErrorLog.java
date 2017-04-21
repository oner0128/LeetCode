package test.HuaWei;


import java.util.*;

/**
 * Created by rrr on 2017/4/12.
 */
public class ErrorLog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("#")) break;
            String[] file = s.split("\\\\");
            String fileName = file[file.length - 1];
            String row = scanner.next();
//            String str=scanner.nextLine();
//            if (str.equals("#")) break;
//            String[]strings=str.split(" ");
//            String[] file=strings[0].split("\\\\");
//            String fileName = file[file.length - 1];
//            String row = strings[1];
            String key = fileName + " " + row;
            if (!map.containsKey(key)) map.put(key, 1);
            else map.put(key, map.get(key) + 1);
        }
        scanner.close();
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, comparator);
        int k = 1;
        for (Map.Entry<String, Integer> entry : list) {
            String[] key = entry.getKey().split(" ");
            String name = key[0];
            String row = key[1];
            int value = entry.getValue();
            if (name.length() > 16) name = name.substring(name.length() - 16, name.length());
            System.out.println(name + " " + row + " " + value);
            if (k++ == 8) break;
        }

    }
}
