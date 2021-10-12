
def test(x, n):
    if(n==0):
        result=1
    else:
        result=x*test(x, n-1)
    return result

print(test(2, 0))