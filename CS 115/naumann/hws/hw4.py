
def pascal_row(n):
    def next_row(arr):
        if(arr == [1]):
            return [1]
        return [arr[0] + arr[1]] + next_row(arr[1:])
    if(n==0):
        return [1]
    return [1] + next_row(pascal_row(n-1))

print(pascal_row(0))
print(pascal_row(1))
print(pascal_row(2))
print(pascal_row(3))
print(pascal_row(4))
print(pascal_row(5))
print(pascal_row(6))
print(pascal_row(7))
print(pascal_row(8))
print(pascal_row(9))

"""
print([1] + next_row([1,2,1]))
print([1] + next_row([1,3,3,1]))
print([1] + next_row([1,4,6,4,1])) 
"""
