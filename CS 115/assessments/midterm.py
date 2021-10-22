import functools

from functools import reduce

def harmonicMean(L):
    '''
    Compute the harmonic mean of the numbers in L using a map-reduce
    approach.
    The harmonic mean equals the length of the list divided by the 
    sum of the reciprocals of the items in the list. 
    You may assume that L is not empty, and that all the values in L are
    positive.  You may (in fact, have to) use the 'len' function to get
    the length of L.
  
    Sample input/output pairs:
     * harmonicMean([1, 2]) --> 1.333333...
     * harmonicMean([2, 3]) --> 2.4
     * harmonicMean([1, 2, 3]) --> 1.636363...
     * harmonicMean([2, 4, 6]) --> 3.272727...
     '''
    return len(L)/reduce(lambda x,y: x+y, map(lambda x: (1/x), L))
# type your code for the body of this function 
# in the textbox below.

#print(harmonicMean([1, 2]))
#print(harmonicMean([2, 3]))
#print(harmonicMean([1, 2, 3]))
#print(harmonicMean([2, 4, 6]))

#print(head)
#print(tail)

#2, [4,2], [2]

def deep_min(L):    
    print("hi", L)
    head, tail = L[0], L[1:r]
    head_min = deep_min(head) if isinstance(head, list) else head
    if not tail:
        r = head_min
    else:
        tail_min = deep_min(tail)
        r = head_min if head_min < tail_min else tail_min
    return r
print(deep_min([3,[4,2]]))