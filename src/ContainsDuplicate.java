import java.util.HashSet;
import java.util.Set;

/**
 * Created by rrr on 2017/2/14.
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> integers=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i]))return true;
            integers.add(nums[i]);
        }
        return false;
    }
    //优化：可减少一行代码，利用Set.add的返回值进行作为判断值
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> integers=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!integers.add(nums[i]))return true;
        }
        return false;
    }
}
