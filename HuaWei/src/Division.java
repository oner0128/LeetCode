/**
 * Created by rrr on 2017/3/9.
 */
public class Division {
    public static String division(int i,int j){
        String result=null;
        Double tmp=(double)i/j;
        System.out.println(tmp.isInfinite());
        System.out.println(tmp.isNaN());
        result= tmp.toString();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(division(1,9));
        System.out.println(division(2,9));
        System.out.println(division(14,13));
    }
}
