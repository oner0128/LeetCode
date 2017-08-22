import java.text.NumberFormat;

/**
 * Created by rrr on 2017/7/11.
 */
public class Test {
    //    public Test(int i){}
    public static void main(String[] args) {


        System.out.println("test main".indexOf('t',1));
        System.out.println("test main".substring(0,2));
        System.out.println(Integer.toString(5, 2));
    }
}

class Test2 extends Test {
    static {
        System.out.println("test2 static block");
    }

    {
        System.out.println("test2 non-static block");
    }

    private static int i = 0;

    public Test2() {


    }

    public static void main(String[] args) {
        System.out.println("test2 main");
        String s = "";
        System.out.println(s.isEmpty());
    }
}
