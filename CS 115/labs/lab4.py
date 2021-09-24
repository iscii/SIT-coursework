############################################################
# CS115 Lab 4
# Name: Issac Zheng
# Pledge: I pledge my Honor that I have abided by the Stevens Honor System. 
############################################################

from functools import reduce

# Task 1: Use reduce to add up all elements in a list
"""
Input: A list of numbers
Output A number representing the sum
Example: add_all([1, 2, 3]) = 6
"""
def add_all(lst):
    return reduce(lambda x,y: x+y, lst)  
# add_all([1, 2, 3])

# Task 2: Use map to evaluate a given polynomial at a specific x-value
"""
Input:
  p: A list of coefficients for increasing powers of x
  x: The value of x to evaluate
Output: Number representing the value of the evaluated polynomial
Example: poly_eval([1, 2, 3], 2) = 1(2)^0 + 2(2)^1 + 3(2)^2 = 17
"""
def poly_eval(p, x):
    return reduce(lambda x,y: x+y, map(lambda c, i: c*x**i, p, list(range(len(p)))))
# poly_eval([1, 2, 3], 2)

# poly eval using predefined functions just in case
def poly_eval2(p, x):
    def add(a,b):
        return a+b            
    def mult(a,b):
        return a*b
    idxs = list(range(len(p)))
    def x_powers(i):
        return x**i
    b = map(lambda c, i: mult(c, x_powers(i)), p, idxs)
    print(reduce(add, b))
poly_eval2([1, 2, 3], 2)

# poly eval using enumerate
def poly_eval3(p, x):
    print(reduce(lambda x,y: x+y, map(lambda c: c[1]*x**c[0], enumerate(p))))
poly_eval3([1, 2, 3], 2)