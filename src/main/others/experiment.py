def solution(N, artifacts, searched):
    # write your code in Python
    artifacts_list = artifacts.split(",")
    searched = searched.split(" ")
    table = {}
    full = 0
    partial = 0
    for i in artifacts_list:
        table[i] = 0
    table_list = list(table.keys())
    for i in searched:
        for key in table_list:
            if contains(i, key):
                table[key] += 1
    for key in table_list:
        if table[key] == artifact_size(key):
            full +=1
        elif table[key]>0:
            partial +=1
    return [full, partial]

def contains(item, dimensions):
    val = dimensions.split(" ")
    tx = ord(val[0][-1])-ord('A')
    ty = int(val[0][0:len(val[0])-1]) -1
    bx = ord(val[1][-1])- ord('A')
    by = int(val[1][0:len(val[1])-1]) -1

    x = ord(item[-1])-ord('A')
    y = int(item[0:len(item)-1]) -1
    if(x>=tx and y>=ty and x<=bx and y<=by):
        return True
    else:
        return False

def artifact_size(dimensions):
    val = dimensions.split(" ")
    tx = ord(val[0][-1])-ord('A')
    ty = int(val[0][0:len(val[0])-1]) -1
    bx = ord(val[1][-1])- ord('A')
    by = int(val[1][0:len(val[1])-1]) -1
    return (bx-tx +1)*(by-ty+1)

print(solution(12, '1A 2A,12A 12A', '12A'))