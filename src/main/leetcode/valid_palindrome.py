class Solution(object):
    def isPalindrome(self, s):
        import math
        """
        :type s: str
        :rtype: bool
        """
        if(len(s) == 0):
            return True
        filtered = ''.join(ch.lower() for ch in s if ch.isalnum())
        fil_len = len(filtered)
        for i in range(0,int(math.ceil(fil_len/2))):
            if filtered[i] != filtered[fil_len-i-1]:
                return False
        return True

s = Solution()
print(s.isPalindrome("A man, a plan, a canal: Panama"))