# *****
# Name     : Issac Zheng
# Pledge   : I pledge my honorr that I have abided by the Stevens Honor System.
# *****

class Term:
    '''
    Class to represent a monomial (aka term) k*x^n
    '''
    # TODO

    def __init__(self, k=1, n=0):  # myTerm = Term(...)
        '''
        Term(k, n) creates a new term, representing k*x^n
        '''
        self.coef = k
        self.exp = n

    def __str__(self):  # print(myTerm)
        '''
        Return a human-friendly string for this term
        '''
        return str(self.coef) + '*x^' + str(self.exp)

   # TODO
    def __repr__(self):  # eval(myTerm)
        '''
        Return a string representation of the term
        '''
        return f"Term({self.exp}, {self.exp})"

   # TODO
    def __eq__(self, other):  # myTerm == other
        '''
        Return True if two terms are equal to each other,
        that is, if they have the same coeffiecient and exponent
        '''
        return self.coef == other.coef and self.exp == other.exp

    # TODO
    def __call__(self, val):  # myTerm(x)
        '''
        Evaluate the term k*x^n for x=val
        E.g., Term(2,4)(3) = 2*3^4 = 162
        '''
        return self.coef * (val ** self.exp)

    # TODO
    def __neg__(self):  # otherTerm = -myTerm
        '''
        Return a new term, with same exponent but opposite coeffient
        '''
        return Term(self.coef*-1, self.exp)

    # TODO
    # what is the point of repr if copy exists? or the other way around?
    def copy(self):  # myCopy = myTerm.copy()
        '''
        Make a term with the same values as this object
        '''
        return Term(self.coef, self.exp)

# LinkedPolynomial
# Adapted in java by Antonio Nicolosi from
# https://introcs.cs.princeton.edu/java/92symbolic/LinkedPolynomial.java, (c) 2000-2018
# Adapted to Python by Justin Barish, 2018
# Refactored by Toby Dalton, 2019

class LinkedPolynomial:
    '''
    Class to represent a polynomial c_0 + c_1 x + c_2 x^2 + ... + c_m x^m

    The data is kept as a list of Term's, sorted in (strictly)
    descending order of exponent and with no zero coefficients
    '''

    def __init__(self, polyList=[]):  # myPoly = LinkedPolynomial(...)
        '''
        Create a new LinkedPolynomial
        '''
        self.polyList = polyList.copy()  # deep copy of a list

    # TODO
    def addTerm(self, t):  # myPoly.addterm(Term(coef, exp))
        '''
        Append a given Term to the list for this LinkedPolynomial
        Assume (without checking) that the Term has non-zero coefficient,
        and it comes in the proper spot with respect to exponent order.
        '''
        # what does this comment want us to do? Assume that t's exponent will be larger than all so we just append it to the list? Cos that seems too
        # simple and useless
        """ 
        for i in range(len(self.polyList)):
            if(self.polyList[i].exp == t.exp):myList
                self.polyList[i].coef += t.coef
                break
            if(self.polyList[i].exp < t.exp):
                self.polyList.insert(i, t)
                break
        """
        
        self.polyList.append(t)

    # myPoly2; myPoly2.createListFromNumber(...) # ??? what is this comment and how does it help??
    # TODO
    def createFromNumbers(self, numList):
        '''
        Create a polynomial given a list of (k, n) tuples
        Assume the list to be in the form [(coef1, exp1), (coef2, exp2)...]
        with exponents in descending order and no 0 coefficients. '''
        t=[]
        for i in range(len(numList)):
            t.append(Term(numList[i][0], numList[i][1]))
           
        # yoinked from mult     
        # check if simplified / duplicate terms are combined or not
        def checkSimp(t):
            a = list(map(lambda i: i.exp, t))
            return len(set(a)) == len(a)
        
        # while not simplified, go through each and every term and when two terms with exponents are found, combine them. then check again etc
        while(not checkSimp(t)):
            for i in range(len(t)):
                for j in range(i+1, len(t)):
                    if(t[i].exp == t[j].exp):
                        t[i].coef += t[j].coef
                        del t[j]
                        break # break will prevent issues with iterating through lists being mutated. 
                    
        # sort in descending order
        t.sort(key=lambda x: x.exp, reverse=True)
                        
        self.polyList = t

    # TODO
    def __len__(self):  # len(myPoly)
        ''' Returns the length of the polynomial (number of nonzero term)'''
        return len(self.polyList)        

    def __str__(self):  # print(myPoly)
        '''
        Return a string representation of the polynomial
        '''
        if len(self) == 0:
            ans = "0"
        else:
            ans = str(self.polyList[0])
            for i in range(1, len(self)):
                coef = self.polyList[i].coef
                if coef > 0:
                    ans += " + " + str(self.polyList[i])
                elif coef < 0:
                    ans += " - " + str(-self.polyList[i])
        return ans

    def __add__(self, otherPoly):  # addPoly = myPoly + otherPoly
        '''
        Return a polynomial representing the sum of self and otherPoly 
        Note: If both inputs are properly ordered, so will the outcome be!
        '''
        result = LinkedPolynomial()  # Our sum polynomial
        i = 0  # Tracks where in self we are
        j = 0  # Tracks where in otherPoly we are
        while i < len(self) or j < len(otherPoly):  # Continue until both
            # term lists are exhausted
            if i == len(self):  # self is exhausted: take a term from other
                y = otherPoly.polyList[j]
                result.addTerm(y.copy())
                j += 1
                continue
            if j == len(otherPoly):  # other is exhausted: take a term from self
                x = self.polyList[i]
                result.addTerm(x.copy())
                i += 1
                continue
            # If we get here, there are terms in both lists
            x = self.polyList[i]
            y = otherPoly.polyList[j]
            if x.exp == y.exp:  # Same exponents? Combine!
                coef = x.coef + y.coef
                if (coef != 0):  # Only add if not 0 !
                    result.addTerm(Term(coef, x.exp))
                i += 1
                j += 1
            elif x.exp < y.exp:  # Add only larger exp otherwise
                result.addTerm(y.copy())
                j += 1
            else:
                result.addTerm(x.copy())
                i += 1
        return result

    # TODO
    def __eq__(self, other):  # myPoly == other
        '''
        Check if 2 polynomials are equal.
        Assume that no polynomials have 0-coefficient terms.
        Hint: If two LP are equal, then they will be identical in every way '''
        if(not (len(self) == len(other))): return False
        for i in range(len(self)):
            if(not (self.polyList[i] == other.polyList[i])):
                return False
        return True

    # TODO
    def __call__(self, val):  # myPoly(val)
        '''
        Evaluate self at x=val - should use Term's __call__
        '''
        t=0
        for i in range(len(self)):
            t += self.polyList[i](val)
        return t

    # TODO
    def __neg__(self):  # negPoly = -myPoly
        '''
        Return a *new* LinkedPolynomial representing -1 * self
        (Do NOT modify self while doing this!!)

        Hint: use Term's __neg__
        '''
        return LinkedPolynomial(list(map(lambda x: -x, self.polyList)))

    # TODO
    def __sub__(self, other):  # subPoly = myPoly - other
        '''
        Return a *new* LinkedPolynomial representing self - other
        (Do NOT modify self or other while doing this!!)

        Hint: use __add__ !
        '''
        return self + -other
            

    # Extra Credit (15 pts)
    def __mul__(self, otherPoly):  # mulPoly = myPoly * otherPoly
        '''
        Multiply two polynomials together
        Return a new polynomial, properly ordered,
        without changing self & otherPoly
        Hint: do it on paper first!

        '''
        # nested loop
        # empty list
        # each term coef multiply with other term coef, each term exp add with other term exp
        # combine matching exps, then sort
        
        #this'll be unoptimized af but ec here i come
        t=[]
        for i in range(len(self)):
            for j in range(len(otherPoly)):
                t.append(Term(self.polyList[i].coef * otherPoly.polyList[j].coef, self.polyList[i].exp + otherPoly.polyList[j].exp))
        
        # check if simplified / duplicate terms are combined or not
        def checkSimp(t):
            a = list(map(lambda i: i.exp, t))
            return len(set(a)) == len(a)
        
        # while not simplified, go through each and every term and when two terms with exponents are found, combine them. then check again etc
        while(not checkSimp(t)):
            for i in range(len(t)):
                for j in range(i+1, len(t)):
                    if(t[i].exp == t[j].exp):
                        t[i].coef += t[j].coef
                        del t[j]
                        break # break will prevent issues with iterating through lists being mutated. 
        
        # sort in descending order
        t.sort(key=lambda x: x.exp, reverse=True)
        
        return LinkedPolynomial(t)

""" 
p1 = LinkedPolynomial([Term(5,5), Term(6,7), Term(1,2)])
p2 = LinkedPolynomial([Term(5,5), Term(6,7), Term(1,3)])
p3 = LinkedPolynomial([Term(5,5), Term(6,7), Term(2,3)])

p4 = p1 * p2
p5 = p2 * p3
p6 = p1 * p3

print(p4) # 36*x^14 + 60*x^12 + 31*x^10 + 6*x^9 + 5*x^8 + 5*x^7 + 1*x^5
print(p5) # 36*x^14 + 60*x^12 + 43*x^10 + 15*x^8 + 2*x^6
print(p6) # 36*x^14 + 60*x^12 + 37*x^10 + 6*x^9 + 10*x^8 + 5*x^7 + 2*x^5
"""
""" t1 = Term(1, 2)
t2 = eval(repr(t1))
t3 = Term(3, 2)
t4 = Term(3, 4)
t5 = t1.copy()
t6 = Term(9, 6)
p1 = LinkedPolynomial([t1, t2, t3, t4, t5])
print(p1)
print(len(p1))
p1.addTerm(t6)
print(p1)
p2 = LinkedPolynomial([t1, t2])
p2.createFromNumbers([(5, 5), (6, 7), (1, 2)])
print(p2)
p3 = p1 + p2
print(p3)
print(p1 == p2)
p4 = LinkedPolynomial([Term(5,5), Term(6,7), Term(1,2)])
p5 = LinkedPolynomial([Term(5,5), Term(6,7), Term(1,3)])
p8 = LinkedPolynomial([Term(5,5), Term(6,7), Term(2,3)])
print(p2 == p4)
print(p2 == p5)
print(p2(5))
p6 = -p2
print(p6)
print(p6(5))

p7 = p5-p4
print(p7)
p9 = p8-p5
print(p9) """


""" 
print(t1)
print(t2)
print(t1 == t2)
print(t1 == t3)
print(t1 == t4)
print(t3 == t4)
print(t1(5))
print(t2(5))
print(t3(5))
print(t4(5))
print(-t1)
print(-t1(5))
print(-t3(5))
print(t5)
 """
 
 