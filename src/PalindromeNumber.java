
/**
 * @Classname PalindromeNumber
 * @Description TODO
 * @Date 2020/2/24 23:30
 * @Created by chenqiao
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome(12332));


    }

    public static boolean isPalindrome(int x) {

        boolean result = false;

        if (x < 0) return false;

        if (x == 0) return true;

        StringBuilder stringBuilder = new StringBuilder();
        while (x != 0){
            int a = x % 10;
            stringBuilder.append(""+a);
            x /= 10;
        }

        for (int i = 0; i < stringBuilder.length(); i++){
            if (stringBuilder.charAt(i) != stringBuilder.charAt(stringBuilder.length() - i -1)){
                return false;
            }
            result = true;
        }

        return result;
    }
}
