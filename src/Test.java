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
interface SimpleInterface {
    public void doSomeWork();

    //A default method in the interface created using "default" keyword
    //使用default关键字创在interface中直接创建一个default方法，该方法包含了具体的实现代码
    default public void doSomeOtherWork(){
        System.out.println("DoSomeOtherWork implementation in the interface");
    }
}

class SimpleInterfaceImpl implements SimpleInterface{
    @Override
    public void doSomeWork() {
        System.out.println("Do Some Work implementation in the class");
    }

    @Override
    public void doSomeOtherWork() {
        System.out.println("Override DoSomeOtherWork ");
    }
    /*
   * Not required to override to provide an implementation
   * for doSomeOtherWork.
   * 在SimpleInterfaceImpl里，不需要再去实现接口中定义的doSomeOtherWork方法
   */

    public static void main(String[] args) {
        SimpleInterfaceImpl simpObj = new SimpleInterfaceImpl();
        simpObj.doSomeWork();
        simpObj.doSomeOtherWork();
    }
}