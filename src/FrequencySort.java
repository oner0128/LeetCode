import java.util.*;

/**
 * Created by rrr on 2017/3/6.
 * 451. Sort Characters By Frequency
 * 自己的思路：利用HashMap建立<char，integer>键值表，然后放入优先队列中，
 * 每次取一个最大值，然后利用迭代器逐个逐个比较哪个char的值与其相等，
 * 然后删除该字符，避免两字符的值相等时只输出前一个找到的值
 * 时间复杂度O（N^2）
 * ——————————————————
 * 正确思路:利用ascii表ascii 256个对应字符的值建立字符出现频率的数组freq[char];
 * 然后将freq[char]>0的字符放入TreeMap中，依次取出最大的值的字符放入StringBuilder中
 * 时间复杂度O（N）空间复杂度O（N）
 * ---------------------------------------------------------------
 * 最优算法：不使用TreeMap做字符数量大小排序，而是使用桶排序。
 *frequencySort3
 */
public class FrequencySort {
    //自己的思路
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else
                map.put(s.charAt(i), 1);
        }
        System.out.println(map);
        Comparator<Integer> cmp;
        cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(cmp);
        Set<Character> characterSet = map.keySet();
        System.out.println(characterSet);
        Iterator<Character> iterator = characterSet.iterator();
        int charNums=characterSet.size();
        for (char a : characterSet) {
            heap.add(map.get(a));
        }
        System.out.println(heap);
        StringBuffer sb = new StringBuffer(s.length());
        for (int i = 0; i < charNums; i++) {
            int tmp = heap.remove();
            while (iterator.hasNext()) {
                char a= iterator.next();
                if (tmp == map.get(a)) {
                    for (int j = 0; j < tmp; j++) {
                        sb.append(a);
                        System.out.println(sb.toString());
                    }
                    map.remove(a);
                    break;
                }
            }
            iterator = characterSet.iterator();
        }
        return sb.toString();
    }
    public String frequencySort2(String s) {
        int[] freq = new int [256];
        for (char ch: s.toCharArray()) freq[ch]++;
        TreeMap<Integer, List<Character>> tree = new TreeMap<Integer, List<Character>>();
        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (!tree.containsKey(freq[i])) {
                    tree.put(freq[i], new LinkedList<Character>());
                }
                tree.get(freq[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(tree.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            for (Character ch: entry.getValue()) {
                sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
            }
        }
        return sb.toString();
    }
    //利用桶排序
    public String frequencySort3(String s) {
        if(s.length() < 3)
            return s;
        int max = 0;
        int[] map = new int[256];
        for(char ch : s.toCharArray()) {
            map[ch]++;
            max = Math.max(max,map[ch]);
        }
        String[] buckets = new String[max + 1]; // create max buckets
        for(int i = 0 ; i < 256; i++) { // join chars in the same bucket
            String str = buckets[map[i]];
            if(map[i] > 0)
                buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
        }
        StringBuilder strb = new StringBuilder();
        for(int i = max; i >= 0; i--) { // create string for each bucket.
            if(buckets[i] != null)
                for(char ch : buckets[i].toCharArray())
                    for(int j = 0; j < i; j++)
                        strb.append(ch);
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("trreesss"));
    }
}
