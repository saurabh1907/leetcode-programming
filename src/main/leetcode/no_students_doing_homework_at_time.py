from typing import List


class Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        count = 0
        for i in range(0,len(startTime)):
            if startTime[i] <= queryTime and queryTime <= endTime[i]:
                count = count + 1
        return count
