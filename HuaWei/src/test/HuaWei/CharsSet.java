package test.HuaWei;

import java.util.*;

/**
 * Created by rrr on 2017/4/21.
 */
public class CharsSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] chars = scanner.next().toCharArray();
            LinkedHashSet<Character>linkedHashSet=new LinkedHashSet<>();
            for (char c:chars)linkedHashSet.add(c);
            Iterator<Character>iterator=linkedHashSet.iterator();
            StringBuilder sb=new StringBuilder();
            while (iterator.hasNext())sb.append(iterator.next());
            System.out.println(sb.toString());
        }
    }
}
