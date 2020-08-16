class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        if len(J) == 0 or len(S) == 0:
            return 0
        memory = set()
        for c in J:
            memory.add(c)
        count = 0
        for c in S:
            if c in memory:
                count +=1
        return count