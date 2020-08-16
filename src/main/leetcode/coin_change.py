import sys


class Solution(object):
    @staticmethod
    def coinChange(coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """

        d = []
        d.insert(0,0)
        for i in range(1, amount +1):
            bestN = sys.maxsize
            candidate = 0
            for c in coins:
                if(c > i):
                    continue
                candidate = 1 + d[i-c]
                if(candidate < bestN):
                    bestN = candidate
            d.insert(i,bestN)

        return d[amount]


print(Solution.coinChange([1,5,7,10], 12))