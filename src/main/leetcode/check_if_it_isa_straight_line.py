class Solution(object):
    def checkStraightLine(self, coordinates):
        """
        :type coordinates: List[List[int]]
        :rtype: bool
        """
        previous_coordinate = None
        slope = None
        for coordinate in coordinates:
            if previous_coordinate == None:
                previous_coordinate = coordinate
                continue
            if coordinate[0] == previous_coordinate[0]:
                new_slope = sys.maxsize
            else:
                new_slope = (coordinate[1] - previous_coordinate[1])/(coordinate[0] - previous_coordinate[0])
            if slope==None:
                slope = new_slope
            if new_slope != slope:
                return False
            previous_coordinate = coordinate
        return True

s = Solution()
print(s.checkStraightLine([[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]))