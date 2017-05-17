package test.moni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rrr on 2017/5/17.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        scanner.close();
        int k=list.remove(list.size()-1);
        Collections.sort(list);StringBuilder sb=new StringBuilder();
        for (int i = 0; i < k; i++) {
           sb.append(list.get(i)+" ");
        }

        System.out.println(sb.toString().trim());
    }
}
