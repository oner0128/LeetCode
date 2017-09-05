import java.text.NumberFormat;
import java.util.Arrays;

/**
 * Created by rrr on 2017/7/11.
 */
public class Test {

    //    public Test(int i){}
    public static void main(String[] args) {

        int num =10;
        System.out.println(test(num));
        System.out.println(Arrays.toString("test main".split("e|a")));
        System.out.println("test main".substring(0,2));
        System.out.println(Integer.toString(5, 2));
    }
    public static int test(int num){
        try {
            num+=10;
            return num;
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            num+=10;
            return num;
        }
    }
}

abstract interface  tess{
     abstract void sds();
}