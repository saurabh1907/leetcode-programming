class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        memory = {}
        for c in magazine:
            if c in memory:
                memory[c] = memory[c] + 1
            else:
                memory[c] = 1

        for c in ransomNote:
            if c in memory:
                memory[c] = memory[c] - 1
                if memory[c] == 0:
                    del memory[c]
            else:
                return False
        return True
