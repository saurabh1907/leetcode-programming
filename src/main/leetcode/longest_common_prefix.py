from functools import reduce
from typing import List


class LongestCommonPrefix:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""

        smallest = reduce(lambda x, y: x if len(x) < len(y) else y, strs)
        # if not smallest:
        #     return ""

        for i in range(0,len(smallest)):
            for str in strs:
                if str[i] == smallest[i]:
                    continue
                else:
                    return smallest[0:i]

        return smallest

