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
  opeacion = (pow(numero,potencia)/factorial(valor))
  e -= operacion
  print(e)
  iteraciones += 1
  ea = abs(((e-ea)/e)*100)
  valor += 1
  potencia += 1
  #nueva iteracion
  op2 = (pow(numero,potencia)/factorial(valor))
  e2 = e + op2
  print(e2)
  iteraciones += 1
  ea = abs(((e2-e)/e2)*100)
  valor += 1
  potencia += 1
else:
  print("valor estimado: ", e2)
  print("error aproximado porcentual: ", ea, "%")
  print("iteraciones: ", iteraciones)
