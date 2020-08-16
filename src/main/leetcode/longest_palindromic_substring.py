class Solution:
    def longestPalindrome(self, s: str) -> str:
        l =len(s)
        if l<=1:
            return s
        maxl = 0
        answer = s[0]
        palindrome= [[0 for i in range(l)] for j in range(l)]
        for i in range(0, l):
            palindrome[i][i] = 1

        for i in range(0, l):
            for j in range(0, i+1):
                if i <= j:
                    continue
                if s[i] == s[j] and (palindrome[j+1][i-1] == i-j-1 or j==i-1):
                    mid_val = 0 if i == j+1 else palindrome[j+1][i-1]
                    new_val = 2+ mid_val
                    palindrome[j][i] = new_val
                    if new_val > maxl:
                        maxl = new_val
                        answer = s[j:i+1]
                else:
                    palindrome[j][i] = max(palindrome[j+1][i],palindrome[j][i-1])
        return answer

s = Solution()
print(s.longestPalindrome("babad"))