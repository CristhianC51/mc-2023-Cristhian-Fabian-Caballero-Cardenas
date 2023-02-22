import math
from math import factorial

es = 0.5 *  10**-8 * 100
ea = 100

entrada = int(input("Indicame el valor en grados: "))
num = entrada * math.pi / 180.0 #Deg to Rad
print("valor en radianes: ", num)
potencia = 2
valor = 2
iteraciones = 1
cos = 1
while ea >= es:
  op = (pow(num,potencia)/factorial(valor))
  cos -= op
  iteraciones += 1
  ea = abs(((cos-ea)/cos)*100)
  valor += 2
  potencia += 2
  op2 = (pow(num,potencia)/factorial(valor))
  cos2 = cos + op2
  iteraciones += 1
  ea = abs(((cos2-cos)/cos2)*100)
  valor += 2
  potencia += 2
else:
  print("valor estimado: ", cos)
  print("error aproximado porcentual: ", ea, "%")
  print("iteraciones: ", iteraciones)
