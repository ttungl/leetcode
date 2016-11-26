# https://leetcode.com/problems/median-of-two-sorted-arrays/
# Median of Two Sorted Arrays

# There are two sorted arrays nums1 and nums2 of size m and n respectively.
# Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

# Example 1:
# nums1 = [1, 3]
# nums2 = [2]

# The median is 2.0
# Example 2:
# nums1 = [1, 2]
# nums2 = [3, 4]

# The median is (2 + 3)/2 = 2.5

# ---------------------------------
## Tung Thanh Le (ttungl@gmail.com)
## Detailed submission of this code
## 		2080 / 2080 test cases passed.
## 		Runtime: 95ms
####

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        ## Description:
        ## 	+ Merge sort of two arrays
        ## 	+ Get the median of the merged array
        ####
        l1 = list(nums1) ## clone
        l2 = list(nums2)
        l1.extend(l2)
        l3 = sorted(l1)
        lenl3 = len(l3)
        if (lenl3%2==1):
            index = (lenl3+1)/2 ## index
            median = l3[index-1] ## since array starts at zero.
        else:
            index1 = lenl3/2
            index2 = index1 + 1
            sum = (l3[index1-1] + l3[index2-1])
            median = float(sum)/2
            
        return median