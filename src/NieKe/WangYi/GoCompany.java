package NieKe.WangYi;

import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class GoCompany {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int[]x=new int[num];
        int[]y=new int[num];
        for (int i = 0; i <num ; i++) {
            x[i]=scanner.nextInt();
        }
        for (int i = 0; i <num ; i++) {
            y[i]=scanner.nextInt();
        }
        int gx=scanner.nextInt();
        int gy=scanner.nextInt();
        int walkT=scanner.nextInt();
        int taxiT=scanner.nextInt();
        int minTime=(Math.abs(gx)+Math.abs(gy))*walkT;
        for (int i = 0; i < num; i++) {
            int walkToTaxi=(Math.abs(x[i])+Math.abs(y[i]))*walkT;
            int taxiToCom=(Math.abs(x[i]-gx)+Math.abs(y[i]-gy))*taxiT;
            minTime=Math.min(minTime,walkToTaxi+taxiToCom);
        }
        System.out.println(minTime);
    }
}
