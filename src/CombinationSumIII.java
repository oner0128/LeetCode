import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrr on 2017/3/26.
 * 216. Combination Sum III
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 Example 1:
 Input: k = 3, n = 7
 Output:
 [[1,2,4]]

 Example 2:
 Input: k = 3, n = 9
 Output:
 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        getResults2(results,cur,k,n,1);
        return results;
    }
   //错误代码，题目规定只能由1~9的数相加
    private static void getResults(List<List<Integer>> results, List<Integer> cur, int k, int n, int start) {
        //if (n==0&&k==0){results.add(cur);return;} 错误代码，如果add(cur)，再回溯中cur.remove后，results中的cur也被改变
        if (n==0&&k==0){results.add(new ArrayList<Integer>(cur));return;}
        else if (k>0)for (int i  = start; i <= n-k+1; i++) {
            cur.add(i);
            getResults(results,cur,k-1,n-i,i+1);
            cur.remove(cur.size()-1);
        }
    }private static void getResults2(List<List<Integer>> results, List<Integer> cur, int k, int n, int start) {
        //if (n==0&&k==0){results.add(cur);return;} 错误代码，如果add(cur)，再回溯中cur.remove后，results中的cur也被改变
        if (n==0&&k==0){results.add(new ArrayList<Integer>(cur));return;}
        else if (k>0)for (int i  = start; i <= 9; i++) {//题目规定只能由1~9的数相加
            cur.add(i);
            getResults2(results,cur,k-1,n-i,i+1);
            cur.remove(cur.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9)); System.out.println(combinationSum3(2, 17));
    }
}
