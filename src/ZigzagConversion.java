import java.util.ArrayList;

/**
 * @Classname ZigzagConversion
 * @Description TODO
 * @Date 2020/2/22 23:39
 * @Created by chenqiao
 *
 *
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagConversion {

    public static void main(String[] args) {

        convert("LEETCODEISHIRING", 2);
        convert("LEETCODEISHIRING", 4);

    }

    public static String convert(String s, int numRows) {


        if (s.length() <= numRows){
            return s;
        }

        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();

        for (int i = 0; i < numRows; i++){
            stringBuilders.add(new StringBuilder());
        }

        int middleSize = numRows > 2 ? numRows - 2 : 0;

        int roundSize = numRows + middleSize;

        for (int a = 0; a < s.length(); a++){
            int t = a % roundSize;

            if (t < numRows){
                stringBuilders.get(t).append(s.charAt(a));
            }else {
                stringBuilders.get(stringBuilders.size() -1 - (t - numRows + 1)).append(s.charAt(a));
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sss : stringBuilders){
            System.out.println(sss);
            result.append(sss);
        }
        System.out.println(result);
        return result.toString();
    }



}
