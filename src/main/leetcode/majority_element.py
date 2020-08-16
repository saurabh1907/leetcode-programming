from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        mem = dict()
        el = None
        max_c = 0
        for num in nums:
            if num in mem:
                count = mem[num] + 1
                mem[num] = count
                if count > max_c:
                    el = num
                    max_c = count
            else:
                mem[num] = 1
        return el
