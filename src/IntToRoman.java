/**
 * @Classname IntToRoman
 * @Description TODO
 * @Date 2020/3/16 18:20
 * @Created by chenqiao
 *
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class IntToRoman {


    public static void main(String[] args) {
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {

        StringBuilder res = new StringBuilder();

        if (num < 1 || num > 3999 ) return null;

        int temp = 0;

        int M = num / 1000;
        for (int i = 0; i < M; i++){
            res.append("M");
        }

        temp = num - M * 1000;

        M = temp / 100;

        if (M == 9){
            res.append("CM");
        }else if (M == 4){
            res.append("CD");
        }else if (M == 5){
            res.append("D");
        }else if (M > 5){
            res.append("D");
            for (int i = 0; i < M - 5; i++){
                res.append("C");
            }
        }else {
            for (int i = 0; i < M; i++){
                res.append("C");
            }
        }

        temp = temp - M * 100;


        M = temp / 10;
        if (M == 9){
            res.append("XC");
        }else if (M == 4){
            res.append("XL");
        }else if (M == 5){
            res.append("L");
        }else if (M > 5){
            res.append("L");
            for (int i = 0; i < M - 5; i++){
                res.append("X");
            }
        }else {
            for (int i = 0; i < M; i++){
                res.append("X");
            }
        }

        temp = temp - M * 10;


        M = temp;
        if (M == 9){
            res.append("IX");
        }else if (M == 4){
            res.append("IV");
        }else if (M == 5){
            res.append("V");
        }else if (M > 5){
            res.append("V");
            for (int i = 0; i < M - 5; i++){
                res.append("I");
            }
        }else {
            for (int i = 0; i < M; i++){
                res.append("I");
            }
        }


        return res.toString();


    }

}
