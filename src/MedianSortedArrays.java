/**
 *
 * 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Classname MedianSortedArrays
 * @Description TODO
 * @Date 2020-01-03 10:43
 * @Created by chenqiao
 */
public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int la = A.length;//数组 A 的长度
        int lb = B.length;//数组 B 的长度

        if (la > lb) {//如果数组 A 比较长，则交换 A、B 数组
            int[] temp = A;
            A = B;
            B = temp;

            int tempL = la;
            la = lb;
            lb = tempL;
        }

        int aMin = 0;     //A 数组折半查找左边界
        int aMax = la;    //A 数组折半查找右边界

        // halfLen 的作用就是中点坐标，当 A 数组中折半查找向右移动时，B 数组以 halfLen 为相对点向左移动，以保持始终均分
        int halfLen = (la + lb + 1) >> 1;
        //二分查找

        //情况一: A 数组为空，中位数在 B 数组
        //情况二: A 数组较短
        //  1) A 数组元素都较小，中位数在B数组
        //  2) A 数组元素都较大，中位数在B数组
        //  3) A、B 元素大小分布基本相当，中位数为被分割的两数组左半部分较大的那一个和右半部分较小的那一个之和的一半
        //情况三: A、B 等长
        //  1) A 数组元素都比B数组元素小，中位数为 A 数组尾元素和B数组首元素之和的一半
        //  2) B 数组元素都比A数组元素小，中位数为 B 数组尾元素和A数组首元素之和的一半
        //  3) A、B 元素大小分布基本相当，中位数为被分割的两数组左半部分较大的那一个和右半部分较小的那一个之和的一半
        while (aMin <= aMax) {
            int aIndex = (aMin + aMax) >> 1;  //A数组中分割点
            int bIndex = halfLen - aIndex;  //B数组中分割点

            //数组 A 分割点相邻左边那个元素比数组 B 分割点相邻右边那个元素大，则应该将数组 A 分割点向右移，数组 B 分割点向左移
            //数组 A 分割点有向左移趋势，需检查左边界
            if (aIndex > aMin && A[aIndex - 1] > B[bIndex]) {
                aMax = aIndex - 1;
                //数组 A 分割点相邻右边那个元素比数组 B 分割点相邻左边那个元素大，则应该将数组 A 分割点向左移，数组 B 分割点向右移
                //数组 A 分割点有向右移趋势，需检查右边界
            } else if (aIndex < aMax && B[bIndex - 1] > A[aIndex]) {
                aMin = aIndex + 1;
                //得出结果
            } else {

                int leftPart = 0;
                //情况一,情况二2，情况三2
                if (aIndex == 0) {
                    leftPart = B[bIndex-1];
                    //情况三1
                } else if (bIndex == 0) {
                    leftPart = A[la - 1];
                    //情况二1,情况二3,情况三3
                } else {
                    leftPart = Math.max(A[aIndex - 1], B[bIndex-1]);
                }

                //元素个数总和为奇数
                if ((la + lb) % 2 == 1) {
                    return leftPart;
                }

                //情况一: A 数组为空，中位数在 B 数组
                //情况二: A 数组较短
                //  1) A 数组元素都较小，中位数在B数组
                //  2) A 数组元素都较大，中位数在B数组
                //  3) A、B 元素大小分布基本相当，中位数为被分割的两数组左半部分较大的那一个和右半部分较小的那一个之和的一半
                //情况三: A、B 等长
                //  1) A 数组元素都比B数组元素小，中位数为 A 数组尾元素和B数组首元素之和的一半
                //  2) B 数组元素都比A数组元素小，中位数为 B 数组尾元素和A数组首元素之和的一半
                //  3) A、B 元素大小分布基本相当，中位数为被分割的两数组左半部分较大的那一个和右半部分较小的那一个之和的一半

                //元素个数总和为偶数
                int rightPart = 0;
                //情况一,情况二1
                if (aIndex == la) {
                    rightPart = B[bIndex];
                    //情况三2
                } else if (bIndex == lb) {
                    rightPart = A[0];
                    //情况二2、3，情况三1、3
                }else {
                    rightPart = Math.min(A[aIndex], B[bIndex]);
                }
                return (leftPart + rightPart) / 2.0;
            }

        }
        return 0;
    }

}
