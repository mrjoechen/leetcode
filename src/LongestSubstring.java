import java.util.*;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Classname LongestSubstring
 * @Description TODO
 * @Date 2020-01-02 08:58
 * @Created by chenqiao
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int abcde = lengthOfLongestSubstring("abcabcdeabcddefghijklmnopdabcdefgh");
        System.out.println("\n LongestSubstring : "+abcde);

    }



    public static int lengthOfLongestSubstring(String s) {


        if (s == null || s.length() <= 0){
            return -1;
        }


        Map<Integer, Character> stringMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        int longestLength = 0;

        for (int i = 0; i < s.length(); i++){

            char value = s.charAt(i);

            if (!stringMap.containsValue(value)) {
                stringMap.put(i, value);
                if (stringMap.size() > longestLength){
                    longestLength = stringMap.size();
                }
            }else{
//                stringMap.clear();
                Iterator<Map.Entry<Integer, Character>> iterator = stringMap.entrySet().iterator();
                while (iterator.hasNext() && stringMap.containsValue(value)){
                    iterator.next();
                    iterator.remove();
                }

                stringMap.put(i, value);
            }

            printMap(stringMap);
        }

        return longestLength;

    }


    static void printMap(Map<Integer, Character> map){
        if (map == null) return;
        for (Map.Entry entry : map.entrySet()){
            System.out.print(entry.getKey() +":" + entry.getValue() + "  ");
        }

        System.out.println("");
    }

}
