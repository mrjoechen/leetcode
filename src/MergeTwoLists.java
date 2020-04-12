public class MergeTwoLists {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode list = mergeTwoLists1(listNode1, listNode2);

        while (list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }



    //递归
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    //迭代
//    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        else if (l2 == null) {
//            return l1;
//        }
//
//
//    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
