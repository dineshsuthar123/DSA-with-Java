# def fact(n):
#     if n == 1:
#         return 1
#     return n * fact(n - 1)

# n = int(input("Enter n: "))
# fac = fact(n)
# print(fac)


def fibo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    return fibo(n - 1) + fibo(n - 2)

n = int(input("Enter n: "))
fibo(n)
for i in range(n):
    print(fibo(i), end = " ")