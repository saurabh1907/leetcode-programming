class Solution:
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        if len(matrix) == 0:
            return []
        answer = []
        toggle = False
        for col in range(len(matrix[0])):
            sublist = []
            for row in range(len(matrix)):
                if col-row>=0:
                    sublist.append(matrix[row][col-row])
            if toggle == True:
                answer += sublist
                toggle = False
            else:
                sublist.reverse()
                answer += sublist
                toggle = True

        for i in range(1, len(matrix)):
            sublist = []
            last_col = len(matrix[i])-1
            for row in range(i,len(matrix)):
                if last_col >=0:
                    sublist.append(matrix[row][last_col])
                    last_col -=1
            if toggle == True:
                answer += sublist
                toggle = False
            else:
                sublist.reverse()
                answer += sublist
                toggle = True

        return answer

s= Solution()
s.findDiagonalOrder([[1,2,3],[4,5,6],[7,8,9]])