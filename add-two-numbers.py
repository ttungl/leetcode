# https://leetcode.com/problems/add-two-numbers/
# add two numbers
# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # return a list of sum
        head = ListNode(0) # init 
        lst = head 
        car = 0
        while l1 or l2 or car: 
            sum, car = car, 0
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next
            if sum >9:
                car = 1
                sum -=10
            lst.next = ListNode(sum)
            lst = lst.next
        return head.next