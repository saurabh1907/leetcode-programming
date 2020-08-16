class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        if word.upper() == word or word.lower() == word:
            return True
        else:
            word_first = word[0:1]
            word_rest = word[1::]
            if word_first == word_first.upper() and word_rest == word_rest.lower():
                return True
            else:
                return False

s= Solution()
print(s.detectCapitalUse("ABCD"))