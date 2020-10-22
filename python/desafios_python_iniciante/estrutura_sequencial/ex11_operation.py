# Faça um Programa que peça 2 números inteiros e um número real. Calcule e mostre:

num1 = int(input("enter a number: "))
num2 = int(input("enter a other number: "))
num3 = float(input("enter a more number: "))

# a. o produto do dobro do primeiro com metade do segundo .

a = (2*num1) * (num2/1)
print(f'the first operation: {a}')

# b. a soma do triplo do primeiro com o terceiro.

b = (3*num1) + (num3)
print(f'the second operation: {b}')

# c. o terceiro elevado ao cubo.

c = (num3 ** 3)
print(f'the third opetation: {c}')
