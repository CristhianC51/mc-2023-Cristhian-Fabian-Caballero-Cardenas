import numpy as np

A = [[1, 0, 1], [3, 4, 3], [4, 1, 0]]
b = [2.5, 11.5, 15]

A = np.array(A)
b = np.array(b)

Ab = np.column_stack((A, b))

n, m = Ab.shape
for i in range(n):
    
    Ab[i] = Ab[i] / Ab[i, i]
    
    for j in range(n):
        if j != i:
            Ab[j] = Ab[j] - Ab[j, i] * Ab[i]

x = Ab[:, -1]

print("La solución del sistema es:")
print("x1 =", x[0])
print("x2 =", x[1])
print("x3 =", x[2])