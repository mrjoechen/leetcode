/**
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Classname AddTwoNumbers
 * @Description TODO
 * @Date 2019-12-31 16:42
 * @Created by chenqiao
 */
public class AddTwoNumbers {

    public static void main(String[] args) {


        ListNode listNodea1 = new ListNode(8);
        ListNode listNodea2 = listNodea1.next = new ListNode(4);
        ListNode listNodea3 = listNodea2.next = new ListNode(3);


        ListNode listNodeb1 = new ListNode(2);
        ListNode listNodeb2 = listNodeb1.next = new ListNode(4);
        ListNode listNodeb3 = listNodeb2.next = new ListNode(3);
        ListNode listNodeb4 = listNodeb3.next = new ListNode(3);

        ListNode listNode = addTwoNumbers(listNodea1, listNodeb1);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


//        if (l1 == null && l2 == null){
//            return null;
//        }else {
//            if (l1 == null) return l2;
//            if (l2 == null) return l1;
//        }

        ListNode p = l1;
        ListNode q = l2;


        ListNode listNode = new ListNode(0);
        ListNode l = listNode;
        int t = 0;

        while (p != null || q != null){

            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = t + x + y;
            t = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;

        }

        if (t > 0) {
            listNode.next = new ListNode(t);
        }

        return l.next;
    }


     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
