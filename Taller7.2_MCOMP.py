import math
from math import factorial

es = 0.5 *  10**-8 * 100
ea = 100

numero = 0.85
potencia = 1
valor = 1
iteraciones = 1
e = 1
while ea >= es:
  operacion = (pow(numero,potencia)/factorial(valor))
  e += operacion
  e2 = 1/e
  print(e2)
  iteraciones += 1
  ea = abs(((e2-ea)/e2)*100)
  valor += 1
  potencia += 1
  #nueva iteracion
  operacion = (pow(numero,potencia)/factorial(valor))
  e += operacion
  e3 = 1/e
  print(e3)
  iteraciones += 1
  ea = abs(((e3-e2)/e2)*100)
  valor += 1
  potencia += 1
else:
  print("valor estimado: ", e3)
  print("error aproximado porcentual: ", ea, "%")
  print("iteraciones: ", iteraciones)
