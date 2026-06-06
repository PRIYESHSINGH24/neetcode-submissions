class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != null){
            lenA++;
            tempA = tempA.next;
        }

        while(tempB != null){
            lenB++;
            tempB = tempB.next;
        }

        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}