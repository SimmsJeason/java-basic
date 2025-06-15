package typicalAlgorithom.ListNode;

import dto.ListNode;

import java.util.Stack;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC445 {

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);//从尾部向前运算就要考虑使用栈
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        //注意循环条件，carry != 0
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();//很巧妙的使用三元运算符
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1= buildStack(l1);
        Stack<Integer> stack2= buildStack(l2);
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            ListNode res;
            int result = stack1.pop() + stack2.pop() + carry;
            if(result >= 10){
                carry = 1;
                result -= 10;
                 res = new ListNode(result);
            }else {
                carry = 0;
                res = new ListNode(result);
            }

            tmp.next = res;
            tmp = tmp.next;
        }


        while(!stack1.isEmpty()){
            ListNode res;
            if(carry != 0){
                res = new ListNode(stack1.pop()+1);
                carry = 0;
            }else {
                res = new ListNode(stack1.pop());
            }

            tmp.next = res;
            tmp = tmp.next;
        }

        while(!stack2.isEmpty()){
            ListNode res;
            if(carry != 0){
                res = new ListNode(stack2.pop()+1);
                carry = 0;
            }else {
                res = new ListNode(stack2.pop());
            }

            tmp.next = res;
            tmp = tmp.next;
        }

        return head.next;
    }



    public Stack<Integer> buildStack(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while(listNode!= null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        return stack;
    }


}
