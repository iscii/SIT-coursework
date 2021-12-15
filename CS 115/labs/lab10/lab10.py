# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Name    : Issac Zheng
# Pledge  : I pledge my honor that I have abided by the Stevens Honor System.
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Max:
#  Write a hmmm function that gets two numbers,
#   then prints the larger of the two.
#  Assumptions: Both inputs are any integers
Max = """
0   read r1
1   read r2
2   sub r3 r1 r2
3   jltzn r3 6
4   write r1
5   halt
6   write r2
7   halt
"""


# Power:
#  Write a hmmm function that gets two numbers,
#   then prints (No.1 ^ No.2).
#  Assumptions: No.1 is any integer, No.2 >= 0
Power = """
0   read r1
1   read r2
2   copy r3 r1
3   setn r4 1
4   jeqzn r2 11     # if exponent is 0, return 1 
5   sub r2 r2 r4
6   sub r2 r2 r4    # start of loop
7   mul r1 r1 r3
8   jgtzn r2 6
9   write r1
10  halt
11  write r4
12  halt
"""


# Fibonacci
#  Write a hmmm function that gets one number,
#   then prints the No.1st fibonacci number.
#  Assumptions: No.1 >= 0
#  Tests: f(2) = 1
#         f(5) = 5
#         f(9) = 34

# set r2 equal to 0
# check if r1 equals 0. if so, jump to write and halt.
# add 1 to r2. subtract 1 from r1. check if r1 equals 0. if so, jump to write and halt.
# set r3 equal to 0. set r4 equal to r3 + r2. subtract 1 from r1. check if r1 equals 0. if so, jump to write and halt.
    # otherwise, set r2 to r3 and r3 to r4. jump to set r4 equal to r3 + r2
    # ^^ this was wrong. set r3 equal to r2 and r2 equal to r4. jump to set r4 equal to r3 + r2


Fibonacci = """
0   read r1         # counter number
1   setn r2 0       
2   jeqzn r1 14
3   setn r9 1       # decrementer
4   add r2 r2 r9
5   sub r1 r1 r9
6   jeqzn r1 14
7   setn r3 0
8   add r4 r3 r2
9   sub r1 r1 r9
10  jeqzn r1 16
11  copy r3 r2
12  copy r2 r4
13  jumpn 8
14  write r2
15  halt   
16  write r4
17  halt
"""

# ~~~~~ Running ~~~~~~
import hmmm
import importlib

runThis = Max  # Change to the function you want to run
doDebug = False # Change to turn debug mode on/off

# call main() from the command line to run the program again
def main(runArg = runThis, debugArg = doDebug):
    importlib.reload(hmmm)
    hmmm.main(runArg, debugArg)

if __name__ == "__main__" : 
    main()

