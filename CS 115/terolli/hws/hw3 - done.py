'''
Created on 10/4
@author:   Issac Zheng
Pledge:    I pledge me honor that I have abided by the Stevens Honor System.

CS115 - Hw 3
'''
# Be sure to submit hw3.py.  Remove the '_template' from the file name.

'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
' PROBLEM 0
' Implement the function giveChange() here:
' See the PDF in Canvas for more details.
'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
# your code goes here

# optimization of code is gone here
def giveChange(n, arr):
    # helper function to return list of lists of all possible change combos
    # giveChange will iterate through the entire list at the end and pluck out the smallest element index 0 (number of coins) and return that.
    def getCombo(n, arr):
        if(n==0):
            return []
        return [arr[-1]] + getCombo(n-arr[-1], arr) if n-arr[-1]>=0 else getCombo(n, arr[:-1])
    def getCombos(n, arr):
        if(len(arr) == 1):
            return [getCombo(n, arr)]
        # maybe you can pluck out the arrays by length right here and just return getCombos[biggest] in the outer function
        return [getCombo(n, arr)] + getCombos(n, arr[:-1])
    def optimize(arr):
        if(len(arr) == 1):
            return arr
        if(len(arr[:1][0]) > len(arr[1:2][0])):
            return optimize(arr[1:])
        else:
            return optimize(arr[:1] + arr[2:])
    a=optimize(getCombos(n, arr))
    return [len(a[0])] + a

""" print(giveChange(48, [1, 5, 10, 25, 50]))
print(giveChange(48, [1, 7, 24, 42]))
print(giveChange(35, [1,3,16,30,50])) """

# Here's the list of letter values and a small dictionary to use.
# Leave the following lists in place.
scrabbleScores = \
   [ ['a', 1], ['b', 3], ['c', 3], ['d', 2], ['e', 1], ['f', 4], ['g', 2],
     ['h', 4], ['i', 1], ['j', 8], ['k', 5], ['l', 1], ['m', 3], ['n', 1],
     ['o', 1], ['p', 3], ['q', 10], ['r', 1], ['s', 1], ['t', 1], ['u', 1],
     ['v', 4], ['w', 4], ['x', 8], ['y', 4], ['z', 10] ]

Dictionary = ['a', 'am', 'at', 'apple', 'bat', 'bar', 'babble', 'can', 'foo',
              'spam', 'spammy', 'zzyzva']

'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
' PROBLEM 1
' Implement wordsWithScore() which is specified below.
'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
def wordsWithScore(dct, scores): 
    '''List of words in dct, with their Scrabble score.

    Assume dct is a list of words and scores is a list of [letter,number]
    pairs. Return the dictionary annotated so each word is paired with its
    value. For example, wordsWithScore(Dictionary, scrabbleScores) should
    return [['a', 1], ['am', 4], ['at', 2] ...etc... ]
    '''
    def getScore(word, n):
        if(not word): # if word is empty
            return 0
        if(word[0] == scores[n][0]):
            return scores[n][1] + getScore(word[1:], 0)
        return getScore(word, n+1)
    if(len(dct) == 1):
        return [[dct[0], getScore(dct[0], 0)]]
    return [[dct[0], getScore(dct[0], 0)]] + wordsWithScore(dct[1:], scores)

#print(wordsWithScore(Dictionary,scrabbleScores))

'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
' PROBLEM 2
' For the sake of an exercise, we will implement a function
' that does a kind of slice. You must use recursion for this
' one. Your code is allowed to refer to list index L[0] and
' also use slice notation L[1:] but no other slices.
' (Notice that you cannot assume anything about the length of the list.)
'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
def take(n, L):
    '''Returns the list L[0:n], assuming L is a list and n is at least 0.'''
    return [] if n==0 or not L else [L[0]] + take(n-1, L[1:]) 

#print(take(10,[1,3,4,5,2,5,6,2,4]))

'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
' PROBLEM 3
' Similar to problem 2, will implement another function
' that does a kind of slice. You must use recursion for this
' one. Your code is allowed to refer to list index L[0] and
' also use slice notation L[1:] but no other slices.
'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
def drop(n, L):
    '''Returns the list L[n:], assuming L is a list and n is at least 0.'''
    if(n>0):
        return drop(n-1, L[1:])
    if(not L):
        return []
    return [L[0]] + drop(n, L[1:])
""" 
print(drop(4,[1,3,4,5,2,5,6,2,4]))
print(drop(6,[1,3,4,5,2,5,6,2,4]))
print(drop(10,[1,3,4,5,2,5,6,2,4]))

 """
