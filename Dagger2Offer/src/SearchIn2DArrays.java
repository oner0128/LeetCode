/**
 * Created by rrr on 2017/5/3.
 */
public class SearchIn2DArrays {
    public static boolean Find(int target, int [][] array) {
        if (array==null)return false;
        int i=array.length-1;
        int j=0;
        while (i>=0&&j<array[0].length){
            if (array[i][j]==target)return true;
            if (array[i][j]>target)i--;
            else j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][]arrays={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(1,arrays));
    }
}
