####################################################################################
# Name: Issac Zheng 
# Pledge: I pledge my honor that I have abided by the Stevens Honor System.
####################################################################################

# The binary format you'll be working with for this assignment is called R2L,
# as it is a right-to-left representation.
####################################################################################
## Ex: 8 in decimal is 1000 in standard binary (2^3),
## and represented as a list [0, 0, 0, 1] in our R2L representation.
####################################################################################

# Notice that this makes it very easy to work with binary,
# by using num[0] to grab the least significant bit (2^0)!
#
# Please fill out the following 4 functions below using recursion, as specified.

# Given an integer x >= 0, convert it to the R2L binary format.
# Take note that both [] and [0] are used to represent 0 in R2L
def decimalToBinary(x):
   return [] if x==0 else [x%2] + decimalToBinary(x//2)

# Given an R2L formatted number, return the integer it is equivalent to.
# The function should function with both [] and [0] returning 0.
def binaryToDecimal(num):
   return 0 if num==[0] else 1 if num==[1] else num[0] + 2*binaryToDecimal(num[1:])

# Given an R2L formatted number, return an R2L equivalent to num + 1
# If you need to increase the length, do so. Again, watch out for 0
def incrementBinary(num):
   return [0,1] if num==[1] else [0]+incrementBinary(num[1:]) if num[0]==1 else [1]+num[1:]
""" 
def incrementBinary(num):
   print(num)
   if(num==[1]):
      return [0, 1]
   if(num[0]==1):
      return [0] + incrementBinary(num[1:])
   return [1] + num[1:] #if num[0] == 0
 """

# Given 2 R2L numbers, return their sum.
## You MUST implement recursively the algorithm for bit-by-bit addition as taught in class,
## you may NOT do something like decimalToBinary( binaryToDecimal(num1) + binaryToDecimal(num2) ).
# Make sure to figure out what to do when num1 and num2 aren't of the same length!
# (and be sure you can add [] and [0])
## Tip: Try this on paper before typing it up
def addBinary(num1, num2):
   #go through each index (unshift both lists at once upon iteration)
   #how to carry an additional 1 to the next iteration if num1+num2>=2
   sum=(num1[0] if num1!=[] else 0)+(num2[0] if num2!=[] else 0)
   if not (num1 and num2):
      return num1+num2
   if(sum < 2):
      return [sum] + addBinary(n7um1[1:], num2[1:])
   return [sum%2] + addBinary(addBinary(num1[1:], num2[1:]), [1])

#[0,1,1,1,1]
#[1,1,1,1]
#[1,1,1,1]

# 1 0 0 0 1
#[1,0,1,1]
#[0,0,1]   
   
# 0  1
#[1, 0, 0, 0, 1]
#[1, 0, 1, 1]

#       0 1 1
#[1,1,1,1]
#[0,0,0,1,1]
#[1,1,1,0,0,1]
   """ 
   if(num1 == [] and num2 == []):
      return []
   print((num1[0] if num1 != [] else 0) + (num2[0] if num2 != [] else 0), num1, num2)
   if(num1[0] if num1 != [] else 0 + num2[0] if num2 != [] else 0 < 2):
      if(len(num1) >= 2):
         num1[1]+=1
      elif len(num1) >= 2:
         num2[1]+=1
      return [((num1[0] if num1 != [] else 0) + (num2[0] if num2 != [] else 0))%2] + addBinary(num1[1:] if num1 != [] else num1, num2[1:] if num2 != [] else num2)
   "0 or 1"
   return [(num1[0] if num1 != [] else 0) + (num2[0] if num2 != [] else 0)] + addBinary(num1[1:] if num1 != [] else num1, num2[1:] if num2 != [] else num2)
   """

seventeen = [1, 0, 0, 0, 1]
four =      [0, 0, 1]
thirteen =  [1, 0, 1, 1]

print(addBinary(four, thirteen))
print(addBinary(thirteen, four))
print(addBinary(thirteen, seventeen))