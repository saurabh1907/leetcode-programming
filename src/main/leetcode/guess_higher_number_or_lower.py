# The guess API is already defined for you.
def guess():
    pass
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        low = 0
        high = n
        g = int((high + low)/2)
        while(True):
            if guess(g) == 0:
                return g
            elif guess(g) == 1:
                low = g + 1
                g = int((high + low)/2)
            else:
                high = g - 1
                g = int((high + low)/2)

