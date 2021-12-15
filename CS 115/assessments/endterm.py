""" def f(x, y, z):
    return 1 if (x and y) < z else 0

print(f(0,0,0))
print(f(0,0,1))
print(f(0,1,0))
print(f(0,1,1))
print(f(1,0,0))
print(f(1,0,1))
print(f(1,1,0))
print(f(1,1,1)) """
""" 
def count_max(L):
    ans = 0
    cmax = float('-infinity')
    for i in range(len(L)):
        if L[i] > cmax:
            cmax = L[i]
            ans=1
        elif L[i] == cmax:
            ans=ans+1
    return ans

print(count_max([]))
print(count_max([10]))
print(count_max([3,15,3]))
print(count_max([10,4,10]))
print(count_max([3,15,3,15,3])) """

#print(0<3<5)

class InvalidTriangleError(ValueError):
    def __init__(self):
        super().__init__("Invalid")
        
class Triangle():
    def __init__(self, s1=1, s2=2, s3=3):
        self.side1=s1
        self.side2=s2
        self.side3=s3
        if not self.validate():
            raise InvalidTriangleError()
    def validate(self):
        return 0 < self.side1 < self.side2 + self.side3