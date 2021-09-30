# Issac Zheng
# Lab 5
# I pledge my honor that I have abided by the Stevens Honor System.

def getLen(L):
    return 0 if not L else 1 + getLen(L[1:])

def dotProduct(L, K):
    return 0.0 if getLen(L)==0 else L[0]*K[0] if getLen(L)==1 else L[0]*K[0] + dotProduct(L[1:], K[1:])

def removeAll(e, L):
    return [L[0]] if getLen(L)==1 and L[0]!=e else [] if getLen(L)==0 else [L[0]] + removeAll(e, L[1:]) if L[0]!=e else removeAll(e, L[1:])

def geometricSeq(n, f, b):
    return b if n==1 else f*geometricSeq(n-1, f, b)

def deepReverse(L):
    return [] if getLen(L)==0 else [deepReverse(L[getLen(L)-1])] + deepReverse(L[:getLen(L)-1]) if isinstance(L[getLen(L)-1], list) else [L[0]] if getLen(L)==1 else [L[getLen(L)-1]] + deepReverse(L[:getLen(L)-1])

# The actually readable functions are down here, I compact them cos it's cool
""" 
def getLen(L):
    if(not L):
        return 0
    return 1 + getLen(L[1:])
#print(getLen([5,4,26,2,3,4])) # 6

def dotProduct(L, K):
    if(getLen(L) == 0):
        return 0.0
    if(getLen(L) == 1):
        return L[0]*K[0]
    return L[0]*K[0] + dotProduct(L[1:], K[1:])
#print(dotProduct([5,3],[6,4])) # 42

def removeAll(e, L):
    if(getLen(L) == 0):
        return []
    if(getLen(L) == 1 and L[0] != e):
        return [L[0]]
    return [L[0]] + removeAll(e, L[1:]) if L[0] != e else removeAll(e, L[1:])
#print(removeAll(42,[55,77,42,11,42,88])) # [55, 77, 11, 88]
#print(removeAll(42,[55,[77,42],[11,42],88])) # [55, [77, 42], [11, 42], 88]
#print(removeAll([77,42],[55,[77,42],[11,42],88])) # [55, [11, 42], 88]

def geometricSeq(n, f, b):
    if(n==1):
        return b
    return f*geometricSeq(n-1, f, b)
#print(geometricSeq(1,2,5))
#print(geometricSeq(3,3,1))
#print(geometricSeq(3,2,10))

def deepReverse(L):
    if(getLen(L) == 0):
        return []
    if(isinstance(L[getLen(L)-1], list)):
        return [deepReverse(L[getLen(L)-1])] + deepReverse(L[:getLen(L)-1])
    # back to front appending
    if(getLen(L) == 1):
        return [L[0]]
    return [L[getLen(L)-1]] + deepReverse(L[:getLen(L)-1])
#print(deepReverse([1,2,3])) # [3, 2, 1]
#print(deepReverse([1,[2,3],4])) # [4, [3, 2], 1]
#print(deepReverse([1,[2,[3,4],[5,[6,7],8]]])) # [[[8, [7, 6], 5], [4, 3], 2], 1]
"""