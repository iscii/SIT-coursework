def test(x,y):
    if(x or y):
        if(not(x and y)):
            return 1
    return 0
"""         
test(0,0)
test(1,0)
test(0,1)
test(1,1)
"""

def test2(z,x,y):
    if(z or test(x,y)):
        if(not (z and test(x,y))):
            print(z, x, y)
            print("ho")

test2(0,0,0)
test2(0,0,1)
test2(0,1,0)
test2(0,1,1)
test2(1,0,0)
test2(1,0,1)
test2(1,1,0)
test2(1,1,1)