class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        siz = len(nums)
        for val in nums:
            if val < 0:
                ind = abs(val)
            elif val > siz:
                ind = val - siz
            else:
                ind = val
            if nums[ind - 1] < 0:
                nums[ind-1] =  siz + abs(nums[ind-1])
            else:
                nums[ind-1] *= -1
        return [i+1 for i,val in enumerate(nums) if val > siz]


s = Solution()
print(s.findDuplicates([10,2,5,10,9,1,1,4,3,7]))