# Issac Zheng
# I pledge my honor that I have abided by the Stevens Honor System.

import random

def shuffledNumbers(n):
    if(n<0): return []
    out = list(range(0, n))
    for i in range(n-1, 1, -1):
        j = random.randint(0, i)
        if(j<i):
            t = out[i]
            out[i] = out[j]
            out[j] = t
    return out

def string_times(s, n):
    t=""
    for i in range(n):
        t += s
    return t

def front_times(s, n):
    t=""
    for i in range(n):
        t += s[0:3]
    return t

def string_splosion(s):
    t=""
    for i in range(len(s)+1):
        t+=s[0:i]
    return t

def array_count9(arr):
    t=0
    for i in range(len(arr)):
        if(arr[i]==9):
            t+=1
    return t

def array123(arr):
    n=1
    for i in range(len(arr)):
        if(n==arr[i]):
            if(n==3):
                return True
            n+=1
    return False
