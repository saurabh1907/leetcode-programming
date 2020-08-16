class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        k = 0
        i=0
        for num in nums:
            if num != val:
                nums[k] = nums[i]
                k = k + 1
            i = i + 1
        return k
