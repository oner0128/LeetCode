import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 */
public class PutApples {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            System.out.println(putApples(m,n));
        }
    }
    public static int putApples(int apples, int baskets){
        if (apples==0||baskets==1)return 1;
        //f(apples,baskets)=f(apples,baskets-1)+f(apples-baskets,baskets)
        //m个苹果放到n个篮子的方法=m个苹果放到n-1个篮子的方法（有一个篮子为空）+m-个苹果放到n个篮子的方法（n个篮子都已有一个苹果）
        if (apples<baskets)return putApples(apples,apples);//若篮子比果多，多的篮子都为空，等价为f(Apple，apple)
        return putApples(apples,baskets-1)+putApples(apples-baskets,baskets);
    }
}
