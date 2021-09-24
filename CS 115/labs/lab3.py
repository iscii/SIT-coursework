##########################################
# Name: Issac Zheng
# Pledge: I pledge my honor that I have abided by the Stevens Honor System
##########################################

# Import reduce from the functools package
from functools import reduce

#######################################################################################
# Task 1: Use reduce to determine if all elements in a boolean list are true
def all_true(lst):
    # TODO: Implement
    print(reduce(lambda x,y: x and x==y, lst))
#######################################################################################
# Task 1.1: Use reduce to determine if AT LEAST one element in a boolean list is true
# Hint: Should be very similar to the above function
def one_true(lst):
    # TODO: Implement
    print(reduce(lambda x,y: x or y,lst))
#######################################################################################
# Task 2: Use map and reduce to count number of Trues in list
def count_true(lst):
    # TODO: Implement
    def count(e):
        return 1 if e else 0
    print(reduce(lambda x,y: x+y,map(count, lst)))

# This function is provided for you
# Gets a list of strings through the command line
# Input is accepted line-by-line
def getInput():
    lst = []
    txt = input()

    while(len(txt) != 0):
        lst.append(txt)
        txt = input()

    return lst

# Task 3: Get the longest string in the list using map and reduce, and print it out
# 'strings' is a list of input strings e.g. [ 'hello', 'world' ]
# Hint: The 'map' part of your program should take a string s into a length-2 list [len(s), s].
def getLongestString():
    strings = getInput()
    # TODO: ImplementD
    print(reduce(lambda x,y: x if x[0]>y[0] else y, map(lambda s: [len(s), s], strings))[1])
getLongestString()

""" # Task 3: Get the longest string in the list using map and reduce, and print it out
# 'strings' is a list of input strings e.g. [ 'hello', 'world' ]
# Hint: The 'map' part of your program should take a string s into a length-2 list [len(s), s].
def getLongestString():
    strings = getInput()
    # TODO: ImplementD
    # how the heck does lambda iterate through the numbers of each list rather than the lists? x and y pulls out the integers rather than the list from the sequence returned from map.
    #print(reduce(lambda x,y: print(x,y), map(lambda s: [len(s), s], strings))[1])
    def abc(x, y):
        print(x[0], y[0])
        # returning a value is necessary for reduce, otherwise None is passed as x onto the next iteration
        return x if x>y else y
    # python has some special array comparison thing with > and <, cannot find wtf happens here online but yeah it's why the thing somehow works without actually comparing the integers
    print([5, "hel"] > [10, "awdas"], [5, "daw"] == [5, "123"], [5, "hel21312"] < [10, "awdas"])
    print(reduce(abc, map(lambda s: [len(s), s], strings)))
    #print(reduce(lambda x,y: x if x>y else y, map(lambda s: [len(s), s], strings))[1])
getLongestString() """