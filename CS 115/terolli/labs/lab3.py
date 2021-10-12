# Issac Zheng

def change(n, arr):
    # helper function to return list of lists of all possible change combos
    # change will iterate through the entire list at the end and pluck out the smallest element index 0 (number of coins) and return that.
    if(n==0):
        return 0
    if(arr==[]):
        return float("inf")
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
    return len(a[0])

print(change(0,[]))
print(change(1,[]))
print(change(1,[1,5,10]))
print(change(7,[1,5,10]))
print(change(29, [1, 5, 10, 20, 50, 100]))