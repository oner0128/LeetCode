import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by rrr on 2017/3/10.
 * 451. Sort Characters By Frequency
 */
public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!freqMap.containsKey(nums[i]))
                freqMap.put(nums[i], 1);
            else
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
        }
        System.out.println(freqMap);
        List[] buckets = new ArrayList[nums.length];
        Set<Integer> integerSet = freqMap.keySet();
        for (Integer a : integerSet) {
            if (buckets[freqMap.get(a)] == null)
                buckets[freqMap.get(a)] = new ArrayList();
            buckets[freqMap.get(a)].add(a);
        }
        System.out.println(Arrays.toString(buckets));
        for (int i = nums.length - 1; k > 0 && i > 0; i--) {
            if (buckets[i] == null) continue;
            results.addAll(buckets[i]);
            k = k - buckets[i].size();
        }
        return results;
    }

    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int freqMax = 0;
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            freqMax = Math.max(freqMax, freqMap.get(nums[i]));
        }
        System.out.println(freqMap);
        List[] buckets = new List[freqMax+1];
        Set<Integer> integerSet = freqMap.keySet();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (buckets[entry.getValue()] == null)
                buckets[entry.getValue()] = new LinkedList();
            buckets[entry.getValue()].add(entry.getKey());
        }
        System.out.println(Arrays.toString(buckets));
        for (int i = freqMax ; k > 0 && i > 0; i--) {
            if (buckets[i] != null) {
            results.addAll(buckets[i]);
            k = k - buckets[i].size();}
        }
        return results;
    }
    public static List<Integer> topKFrequent3(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(freqMap);
        List[] buckets = new List[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (buckets[entry.getValue()] == null)
                buckets[entry.getValue()] = new LinkedList();
            buckets[entry.getValue()].add(entry.getKey());
        }
        System.out.println(Arrays.toString(buckets));
        for (int i = nums.length ; k >results.size()  && i > 0; i--) {
            if (buckets[i] != null) {
                results.addAll(buckets[i]);}
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 2, 3, 1, 2};
        int[] nums2 = {1, 2};
        System.out.println(topKFrequent3(nums, 2));
        System.out.println(topKFrequent3(nums2, 1));
    }
}
