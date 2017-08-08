import base.TreeNode;
import medium.ValidateBinarySearchTree;

/**
 * Created by rrr on 2017/7/11.
 */
public class Test {
    public static void main(String[] args) {
//        Integer a=1;
//        Integer b=2;
//        Integer c=3;
//        Integer d=3;
//        Integer e=127;
//        Integer f=127;
//        Integer h=128;
//        Integer i=128;
//        Long g=3l;
//        System.out.println(c==d);
//        System.out.println(e==f);System.out.println(h==i);
//        System.out.println(c==(a+b));
//        System.out.println(c.equals(a+b));
//        System.out.println(g==(a+b));
//        System.out.println(g.equals(a+b));
//        System.out.println(new UniqueBinarySearchTreesII().generateTrees(3));
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new ValidateBinarySearchTree().isValidBST4(root));
        boolean isZ=true;
        System.out.println(!isZ);
        System.out.println(isZ);
    }
}

class Test2 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 127;
        Integer f = 127;
        Integer h = 128;
        Integer i = 128;
        Long g = 3l;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(h == i);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
