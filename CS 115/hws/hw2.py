# Stevens Institute of Technology, 2021

##########################################
# Name: Issac Zheng
# Pledge: I pledge my honor that I have abided by the Stevens Honor System
##########################################
from math import floor    # E.g., floor(5.3) -> 5, floor(3.9) -> 3

######################################################################
# Task 1: Given an 8-digit decimal number representing the date,
#         calculate the day of the week using Zeller's congruence:
#
#           https://en.wikipedia.org/wiki/Zeller%27s_congruence
#
# Input:  8-digit decimal number in the format of YYYYMMDD
#
# Output: Weekday as a [0-6] number, where 
#         0: Saturday, 1: Sunday, 2: Monday, ..., 6: Friday  
######################################################################

# this function is defined assuming that we will be NORMAL about the date input and not have jan and feb as 13 and 14, respectively. It corrects for a normal input into the wierd input that the algorithm is tailored for.
# it also assumes you are inputting a valid date format
def getWeekday(date):
    q = date%100 # day of month
    mtemp = floor(date%10000/100) # month (jan = 13 of last year, feb = 14 of last year) -> month range = [3,14]
    m = mtemp if mtemp>=3 else 12+mtemp # if 1 (jan) or 2 (feb), turn into 13 and 14
    yeartemp = floor(date/10000) if m<=12 else floor(date/10000)-1
    bigk = yeartemp%100
    bigj = floor(yeartemp/100)
    #print(q, m, bigk, bigj)
    #print(q, (13*(m+1)/5), bigk, (bigk/4), (bigj/4), (2*bigj))

    # values divided will be floored in accordance to the algorithm. Looking at it again, I just noticed that that is quite literally the floor symbol around all divided terms
    gregh = (q+floor((13*(m+1))/5)+bigk+floor(bigk/4)+floor(bigj/4)-(2*bigj))%7
    julh = (q+floor((13*(m+1))/5)+bigk+floor(bigk/4)+5-bigj)%7
    print("Gregorian:", gregh,"\nJulian:", julh)

    return gregh

""" getWeekday(20000101) # 1 January 2000, Saturday (0 gregorian)
getWeekday(20000301) # 1 March 2000, Wednesday (4 gregorian) """

######################################################################
# Task 2: Create two functions, an encoder and a decoder for the
#         Caesar cipher:
#
#           https://en.wikipedia.org/wiki/Caesar_cipher
#
# Note: You can try out this cipher at the link below:
#
#           https://cryptii.com/pipes/caesar-cipher
######################################################################

######################################################################
# This provided helper function may be useful
# Input:  List of ASCII values (Ex: [72, 69, 76, 76, 79])
# Output: String (Ex. 'HELLO')       'H   E   L   L   O'
######################################################################
def asciiToString(asciiList):
    return ''.join(map(chr, asciiList))

######################################################################
# Caesar Encoder
#
# Input: A string (assume all-caps: leave everything else as-is),
#        and a shift value       (Ex. 'HELLO WORLD', 3)
#
# Output: An encoded string      (Ex. 'KHOOR ZRUOG')
#
# Hint: The ord() function converts single-character strings to ASCII
#       (Its inverse, the chr() function, is used in the provided helper)
######################################################################

#input is all caps
def caesarEncoder(str, shift):
    return asciiToString(list(map(lambda x: x if (x < 64 or x > 90) else (90-(64-(x+shift)) if x+shift<65 else 65+(x+shift-91)) if x+shift<65 or x+shift>90 else x+shift, list(map(ord, list(str))))))

print(caesarEncoder("HELLO WORLD", 3))
print(caesarEncoder("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", -3))

""" 
encoder prototype:
def caesarEncoder(str, shift):
    def stringToAscii(str):
        return list(map(ord, list(str))) # returns an array of the ascii for each character of the given string
    def wrap(x):
        return 90-(64-(x+shift)) if x+shift<65 else 65+(x+shift-91)
    encoded = asciiToString(list(map(lambda x: x if (x < 64 or x > 90) else wrap(x) if x+shift<65 or x+shift>90 else x+shift, stringToAscii(str))))
    print(encoded)
    return encoded

wrap prototype:
def wrap(x):
    if(x==32):
        return 32
    if(x+shift<65):
        # right shift 3 an A (gives X [88 = 90-2]); x+shift=65-3=62, 64-62=2; 90-2=88=X
        return 90-(64-(x+shift))
    if(x+shift>90):
        # left shift 3 on Z (gives c [67 = 65+2]); x+shift=90+3=93, 93-91=2; 65+2=67=C
        return 65+(x+shift-91)
    return x+shift 
"""

######################################################################
# Decoder
# Input: A string value with all capital letters (leave everything
#        else as-is) and a shift value (Ex. KHOOR ZRUOG, 3)
# Output: A decoded string             (Ex. HELLO WORLD)
# Hint: The chr() function converts ASCII to a single-character string
######################################################################
def caesarDecoder(str, shift):
    return caesarEncoder(str, shift*-1)

print(caesarDecoder("KHOOR ZRUOG", 3))
print(caesarDecoder("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD", -3))