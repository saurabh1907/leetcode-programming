class Solution:
    def firstUniqChar(self, s: str) -> int:
        if len(s) == 1:
            return 0
        mem = dict()
        for c in s:
            if c in mem:
                mem[c] = mem[c] + 1
            else:
                mem[c] = 1
        for i in range(0, len(s)):
            if mem[s[i]] < 2:
                return i
        return -1