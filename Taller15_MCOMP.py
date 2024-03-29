import numpy as np

def inversa(A):

  tamaño = np.shape(A)
  n = tamaño[0]
  identidad = np.identity(n)

  AB = np.concatenate((A,identidad),axis=1)
  AB0 = np.copy(AB)

  tamaño = np.shape(AB)
  n = tamaño[0]
  m = tamaño[1]

  for i in range(0,n-1,1):

      columna = abs(AB[i:,i])
      max = np.argmax(columna)
      
      if (max !=0):

          temporal = np.copy(AB[i,:])
          AB[i,:] = AB[max+i,:]
          AB[max+i,:] = temporal
  AB1 = np.copy(AB)

  for i in range(0,n-1,1):
      pivote = AB[i,i]
      adelante = i+1
      for k in range(adelante,n,1):
          factor = AB[k,i]/pivote
          AB[k,:] = AB[k,:] - AB[i,:]*factor
  AB2 = np.copy(AB)

  ultfila = n-1
  ultcolumna = m-1
  for i in range(ultfila,0-1,-1):
      pivote = AB[i,i]
      atras = i-1 
      for k in range(atras,0-1,-1):
          factor = AB[k,i]/pivote
          AB[k,:] = AB[k,:] - AB[i,:]*factor
      AB[i,:] = AB[i,:]/AB[i,i]

  inversa = np.copy(AB[:,n:])
  return inversa

A = np.array([[3,2,2],
              [3,1,-3],
              [1,0,-2]], dtype=float)
x = inversa(A)
print('Inversa de A: ')
print(x)

B = np.array([[1,2,0,4],
              [2,0,-1,-2],
              [1,1,-1,0],
              [0,4,1,0]], dtype=float)
y = inversa(B)
print('Inversa de B: ')
print(y)
