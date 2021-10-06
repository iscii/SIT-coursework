####################################################################################
# Name: Issac Zheng
# Pledge: I pledge my honor that I have abided by the Stevens Honor System.
####################################################################################
# Lab 6: Recursion 2
# Demonstrate recursion as an algorithm design technique for the problem of 
# computing the (length of the) longest common subsequence of two given strings
#
# Note: Using anything other than recursion will result in a penalty
#####################################################################################

##############################################################################
# Example: The longest common subsequence of "helllowo_rld" and "!helloabcworld!"
# is "helloworld", and it has a length of 10.
#
# Therefore LLCS("helllowo_rld", "!helloabcworld!") returns 10, and
# LCS("helllowo_rld", "!helloabcworld!") returns "helloworld"
##############################################################################

def LLCS(S1, S2):
    '''
    Return the length of the longest common subsequence (LLCS) of strings S1 and S2
    '''
    # cycle through each letter of S1; if compareString(S1[i]) is true, add 1 and go next. else just go next.
    # for LCS, just add the letter to a string concatted in the return function
    def getCount(c, S):
        if(not S):
            return 0
        return (1 if c==S[0] else 0) + getCount(c, S[1:])
    def compareString(c1, S2):
        '''Returns true if the letter exists in both strings'''
        if(not S2):
            return False
        #print(c1, S1)
        #print(getCount(c1, S2)==getCount(c1, S1))
        """ 
        As a poor attempt to explain this conditional, S1 will be substringed in LLCS to check for each character of S1 existing in S2. 
        If the character exists in S2 while the count of the character is the same in both strings, then that character is a common 
        subcharacter of the strings. If the character exists in S2 but the count of the character is different in both strings,
        that means there is (or are) extra characters of that letter in S1 and therefore it will be skipped; it is not a common
        subcharacter off the strings. The print statements above may help, but they are not clear since compareString is called
        per iteration of LLCS and itself.
        """
        return True if c1==S2[0] and getCount(c1, S2)==getCount(c1, S1) else compareString(c1, S2[1:])
    if(not S1):
        return 0
    return (1 if compareString(S1[0], S2) else 0) + LLCS(S1[1:], S2)

##############################################################################
# Instead of returning the length of the longest common substring, this task
# asks you to return the string itself.
##############################################################################
# Tip: You may find it helpful to copy your solution to LLCS and edit it
# to solve this problem
##############################################################################

def LCS(S1, S2):
    '''return the longest common subsequence (LCS) between strings S1 and S2'''
    def getCount(c, S):
        if(not S):
            return 0
        return (1 if c==S[0] else 0) + getCount(c, S[1:])
    def compareString(c1, S2):
        '''Returns true if the letter exists in both strings'''
        if(not S2):
            return False
        return True if c1==S2[0] and getCount(c1, S2)==getCount(c1, S1) else compareString(c1, S2[1:])
    if(not S1):
        return ""
    return (S1[0] if compareString(S1[0], S2) else "") + LCS(S1[1:], S2)

""" 
print(LLCS("hellowo_rld", "!hellllloabcworld!"))
print(LCS("hellowo_rld", "!hellllloabcworld!"))
print(LLCS("helowo_rld", "!helloabcworld!"))
print(LCS("helowo_rld", "!helloabcworld!"))
print(LLCS("helllowo_rld", "!helloabcworld!"))
print(LCS("helllowo_rld", "!helloabcworld!"))
print(LLCS("helllowo_rldd", "!helloaabcwoorldd!"))
print(LCS("helllowo_rldd", "!helloaabcwoorldd!"))
 """