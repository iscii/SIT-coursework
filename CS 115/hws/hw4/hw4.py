# Issac Zheng
# I pledge my honor that I have abided by the Stevens Honor System.

from importlib import reload as Rfrsh
import hmmm

# Fibonacci! You've already done it in Lab 9
# Now however, you are to do hmmmonacci with
# recursion, & you MUST do so for any credit
# The tests are still the same as from Lab 9
# Tests: f(2) = 1, f(5) = 5, f(9) = 34
RecFibSeq = """
00  setn r15 42
01  read r>
02  jeqzn r1 09     #case 0 
03  copy r3 r1
04  addn r3 -1
05  setn r13 1
06  jeqzn r3 09     #case 1
07  addn r1 1
08  calln r14 11
09  write r13
10  halt
11  setn r13 0  
12  copy r2 r1
13  addn r2 -1
14  jgtzn r2 17
15  add r13 r13 r1
16  jumpn 24
17  pushr r1 r15
18  pushr r14 r15
19  addn r1 -1
20  copy r2 r1
21  addn r2 -1
22  setn r14 29
23  jumpn 14
24  popr r14 r15
25  popr r1 r15
26  addn r1 -2
27  copy r2 r1
28  addn r2 -1
29  jgtzn r2 37
30  add r13 r13 r1
31  popr r14 r15
32  popr r1 r15
33  addn r1 -2
34  copy r2 r1
35  addn r2 -1
36  jumpr r14:
37  jumpn 12
"""

# Change doDebug to false to turn off debugs
runThis = RecFibSeq
doDebug = False

# Note: main() in the shell to easily reload
def main(runArg=runThis, debugArg=doDebug):
    Rfrsh(hmmm); hmmm.main(runArg, debugArg)

if __name__ == "__main__" :
    main()
