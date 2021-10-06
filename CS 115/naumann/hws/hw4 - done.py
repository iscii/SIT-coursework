# Issac Zheng

def pascal_row(n):
    def next_row(arr):
        if(arr == [1]):
            return [1]
        return [arr[0] + arr[1]] + next_row(arr[1:])
    if(n==0):
        return [1]
    return [1] + next_row(pascal_row(n-1))

def pascal_triangle(n):
    if(n==0):
        return [[1]]
    return pascal_triangle(n-1) + [pascal_row(n)]

def test_pascal_row():
    print(pascal_row(0))
    print(pascal_row(1))
    print(pascal_row(2))
    print(pascal_row(3))
    print(pascal_row(4))
    print(pascal_row(5))

def test_pascal_triangle():
    print(pascal_triangle(0))
    print(pascal_triangle(1))
    print(pascal_triangle(2))
    print(pascal_triangle(3))
    print(pascal_triangle(4))
    print(pascal_triangle(5))