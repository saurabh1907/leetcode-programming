class Solution:
    def findComplement(self, num: int) -> int:
        bin_string = bin(num)[2:]
        ch = ['0','b']
        for c in bin_string:
            if c=='0':
                ch.append('1')
            else:
                ch.append('0')
        return int(''.join(ch), 2)

        