class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        arr = s.split()
        l = len(arr)
        if l==0:
            return 0
        else:
            return len(arr[l-1])

s = Solution()
print(s.lengthOfLastWord("hello thereaa"))