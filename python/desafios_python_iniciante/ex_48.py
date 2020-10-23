# Faça um programa que peça um numero inteiro positivo e em seguida mostre este numero invertido.
# Exemplo:
#   12376489
#   => 98467321

number = int(input('enter a integer number: '))

numbers = list(str(number))
size_numbers = len(numbers)
string = ''
for i in range(size_numbers):
    i_inverse = -(int(i) - size_numbers + 1)
    string += numbers[i_inverse]
    
print('the number as opposed to that number is' ,string)



