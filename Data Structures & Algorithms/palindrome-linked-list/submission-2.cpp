class Solution {
public:

    ListNode* reverseList(ListNode* head)
    {
        ListNode* prev = NULL;
        ListNode* next = NULL;
        ListNode* temp = head;

        while(temp != NULL)
        {
            next = temp->next;
            temp->next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    ListNode* middleNode(ListNode* head)
    {
        ListNode* slow = head;
        ListNode* fast = head;

        while(fast->next != NULL && fast->next->next != NULL)
        {
            slow = slow->next;
            fast = fast->next->next;
        }

        return slow;
    }

    bool isPalindrome(ListNode* head) {

        if(head == NULL || head->next == NULL)
        {
            return true;
        }

        ListNode* middle = middleNode(head);

        ListNode* newHead = middle->next;

        middle->next = NULL;

        newHead = reverseList(newHead);

        ListNode* h1 = head;
        ListNode* h2 = newHead;

        while(h2 != NULL)
        {
            if(h1->val != h2->val)
            {
                return false;
            }

            h1 = h1->next;
            h2 = h2->next;
        }

        return true;
    }
};