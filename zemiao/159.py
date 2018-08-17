def solution(A):
    types = set()
    res, temp = 0, 0
    lastType, tempLastType = -1,0
    for t in A:
        if t in types or len(types) < 2:
            temp += 1
            types.add(t)
            if lastType == -1:
                lastType = t
            if t == lastType:
                tempLastType += 1
            else:
                lastType = t
                tempLastType = 1
        else:
            # new
            types = set([lastType,t])
            temp = tempLastType+1
            lastType,tempLastType = t,1
        res = max(res,temp)
    return res