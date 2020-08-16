class Solution:
    def minMoves(self, nums: List[int]) -> int:
        minimum = min(nums)
        answer = 0
        for num in nums:
            answer = answer + (num - minimum)
        return answer