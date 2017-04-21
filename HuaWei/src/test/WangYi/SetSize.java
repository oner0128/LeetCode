package test.WangYi;

import java.util.*;

/**
 * Created by rrr on 2017/4/12.
 */
public class SetSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Double> set = new HashSet<>();
        int w,x,y,z;
        w=scanner.nextInt();x=scanner.nextInt();y=scanner.nextInt();z=scanner.nextInt();
        for (int i = w; i <= x; i++) {
            for (int j = y; j <=z ; j++) {
                set.add((double)i/(double)j);
//                if (i<j)break;
            }
        }
        System.out.println(set.size());
    }
}
