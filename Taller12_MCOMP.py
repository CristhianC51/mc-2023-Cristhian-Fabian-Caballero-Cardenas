import math
from math import factorial
from math import e
from decimal import Decimal, getcontext

ea = 0
xi = 0.45
h = 0.005
getcontext().prec = 50

iteraciones = 1
potencia = 1
valor = Decimal(math.e**-xi)
signo = -1
print("ORDEN 0:")
print(valor)
print("ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ")
for iteraciones in range(1,16):
  valor_ant = Decimal(valor)
  op = signo*(Decimal(valor)/Decimal(factorial(iteraciones)))*(Decimal(pow(h,potencia)))
  valor += Decimal(op)
  ea = abs((Decimal(valor)-Decimal(valor_ant))/Decimal(valor))*100
  potencia += 1
  signo *= -1
  print("ORDEN", iteraciones , ":")
  print("valor estimado: ", valor)
  print("error aproximado porcentual: ", ea, "%")
  print("ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ")