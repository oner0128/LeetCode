package NiuKe.WangYi;

import java.util.*;

/**
 * Created by rrr on 2017/4/12.
 */
public class RemoveDupli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
            map.put(nums[i],i);
            set.add(nums[i]);
        }
        int[]res=new int[map.size()];
        int[]sortNum=new int[map.size()];
        int index=0;
        for (Map.Entry<Integer,Integer>entry:map.entrySet()) {
            sortNum[index++]=entry.getValue();
        }
        Arrays.sort(sortNum);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < map.size() - 1; i++) {
            stringBuilder.append(nums[sortNum[i]] + " ");
        }
        stringBuilder.append(nums[sortNum[map.size() - 1]]);
        System.out.println(stringBuilder.toString());
    }
}
