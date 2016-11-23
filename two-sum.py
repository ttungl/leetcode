## https://leetcode.com/problems/two-sum/
## two sum
# example:
# Given nums = [2, 7, 11, 15], target = 9,
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].

## space and time complex: O(n)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        looktable = {} # initial table
        for i, num in enumerate(nums): # index (i) and value (num) of array nums
            if(target-num in looktable): # check diff:(target-value) in looktable
                return [looktable[target-num], i] 
            looktable[num] = i
        return []