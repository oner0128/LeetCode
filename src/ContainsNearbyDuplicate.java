import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rrr on 2017/2/14.
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]) && ((i - map.get(nums[i])) <= k)) return true;
            map.put(nums[i],i);
        }
        return false;
    }
    //更快的算法：要求为i-j<=k，因此Set中只需要保持k个数即可，在Set中个数少时查找时间更短。
    // 因此当i>k时Set中的数目为k,可以以前第一个元素。
    // 在add时正好是i-j=k,因此在利用add的返回值进行判断。
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,5,2,3,5};
        System.out.println(containsNearbyDuplicate2(nums,2));
    }

}
