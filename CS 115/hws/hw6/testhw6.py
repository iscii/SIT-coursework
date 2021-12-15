import unittest
from hw6 import *

class TestPoly(unittest.TestCase):
    def setUp(self):
        self.p1 = LinkedPolynomial()
        self.p1.createFromNumbers([(2,3), (3,2), (1,2), (2,1)])

        self.p2 = LinkedPolynomial([Term(2,3), Term(4,2), Term(2, 1)])

        self.p3 = LinkedPolynomial([Term(4,3), Term(8,2), Term(4,1)])

        self.p4 = LinkedPolynomial()
        self.p4.createFromNumbers([(4,4),(2,3), (3,2), (1,2), (2,1)])

        self.p5 = LinkedPolynomial()
        self.p5.createFromNumbers([(4,4),(4,3), (6,2), (2,2), (4,1)])

        self.p6 = LinkedPolynomial()
        self.p6.createFromNumbers([(4, 2), (16, 3), (24, 4), (24, 5), (20, 6), (8, 7)])

    def testPolyFunc(self):
        # print(self.p1)
        # print(self.p2)
        self.assertEqual(self.p2, self.p2)
        self.assertEqual(self.p1+self.p4, self.p5) # diff length polys
        self.assertEqual(self.p1+self.p2, self.p3)
        self.assertNotEqual(self.p1, self.p3)
        self.assertEqual(self.p1-self.p2, LinkedPolynomial()) #p1 - p2 == 0
        self.assertEqual(self.p1(2), 36)
        self.assertEqual(str(self.p1), '2*x^3 + 4*x^2 + 2*x^1')
        
        #Extra Credit: multiplication
        self.assertEqual(self.p1*self.p4, self.p6)


main = unittest.main 

if __name__ == "__main__":
    main()