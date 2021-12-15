""" 
# given a number 0, return 0
# given a number 1, return 1
# given a number 2, return 0 + 1
# given a number 3, return 0 + 1 + (0 + 1)
# given a number 4, return (0 + 1) + (0 + 1 + (0 + 1))
# given a number 5, return (0 + 1 + (0 + 1)) + ((0 + 1) + (0 + 1 + (0 + 1)))
"""
def fibonacci(n):
    if n<=1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

num = int(input("enter n: "))
print(fibonacci(num)) 

#! implement storing r1 when recursing, and popr it when jumpring
#* current method: recurse through all n-1, and then all n-2. Then add it all up.

# create a stack   
# input
# create flag
# add r14 to stack
#exit condition: 
# if r1 = 1, add it to the stack.
# if r1 = 0, jump to adding up everything in the stack.
    # r1 - 1. if r1 = 1, jump to adding up everything in the stack.
    # if r1 - 1 is not = 1, r1 - 2 is not = 0. so keep subtracting
    # if r1 - 2 = 0, jump to adding eerything in the stack.
    # else keep going, basically.
#if not exit condition
# calln x y
# r1 - 1
# jumpr x
# r1 - 2
# jumpr x
#add everything in stack
# pop stack
# add r1 to r13

"""
0   setn r15 42
1   read r1
2   calln r14 5		#!
3   write r13
4   halt
5	copy r2 r1
6	addn r2 -1
7	write r2
8	jnezn r2 13		#!
9	write r1
10	pushr r1 r15
11	popr r14 r15
12	jumpr r14
13	pushr r14 r15
14  jeqzn r1 19		#!
15	addn r1 -1
16	calln r14 5
17	addn r1 -2
18	calln r14 5
19	popr r14 r15
20	popr r1 r15
21	add r13 r13 r1
22	jumpr r14
"""


""" factorial:
00 setn r15 42
01 read r1
02 calln r14 5
03 write r13
04 halt
05 jnezn r1 8
06 setn r13 1
07 jumpr r14
08 pushr r1 r15
09 pushr r14 r15
10 addn r1 -1
11 calln r14 5
12 popr r14 r15
13 popr r1 r15
14 mul r13 r13 r1
15 jumpr r14
"""


""" # Attempt 1
    setn r15 42
    read r1         # n
    setn r13 0
    calln r14 4
    write r13
    halt
    jeqzn r1 a      # if n==0, add r1 to the stack
    copy r2 r1   
    addn r2 -1
    jeqzn r2 a      # if n==1, add r1 to the stack
    copy r3 r1
    addn r3 -2
    pushr r1 r15    # line x: pushes r1 to the stack
    pushr r3 r15
    pushr r14 r15
    calln r14 4
    popr r14 r15
    popr r1 r15
    add r13 r13 r1  # a add and return somehow
    jumpr r14
"""