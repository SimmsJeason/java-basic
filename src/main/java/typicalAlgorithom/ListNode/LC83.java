package typicalAlgorithom.ListNode;

import dto.ListNode;

import java.util.HashMap;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */

public class LC83 {

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }



    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> time = new HashMap<>();
        ListNode tmp = head.next;
        ListNode pre = head;
        while (tmp != null){
            if(time.get(tmp.val) != null){
                if(tmp.next != null){
                    tmp.next = tmp.next.next;
                }else {
                    pre.next = null;
                }

            }else {
                time.put(tmp.val, 1);
            }
            tmp = tmp.next;
            pre = pre.next;
        }
        return head;
    }


}
