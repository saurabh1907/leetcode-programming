# The isBadVersion API is already defined for you.
def isBadVersion(med):
    pass
# @param version, an integer
# @return an integer
# def isBadVersion(version):

class Solution:


    def firstBadVersion(self, n):
        if n == 1: return 1
        tracker = {}
        low = 1
        high = n
        med = int((low + high)/2)
        while(low<=high):
            status_med = tracker[med] if med in tracker else isBadVersion(med)
            tracker[med] = status_med
            if status_med:
                prev = med - 1
                status_prev = tracker[prev] if prev in tracker else isBadVersion(prev)
                tracker[prev] = status_prev

                if not tracker[med-1]:
                    return med
                high = med - 1
            else:
                low = med + 1
            med = int((low + high)/2)


        """
        :type n: int
        :rtype: int
        """
