# Faça um programa que leia uma quantidade indeterminada de números positivos e conte quantos deles estão nos seguintes intervalos: [0-25], [26-50], [51-75] e [76-100]. A entrada de dados deverá terminar quando for lido um número negativo.

valid_number = True
count1 = 0
count2 = 0
count3 = 0
count4 = 0

while valid_number:
    if valid_number: 
        number = float(input('enter a number positive for operation or negative for quit the program: '))
        
        if number >= 0 and number < 26:
            count1 += 1
        elif number >= 26 and number < 51:
            count2 += 1
        elif number >= 51 and number < 76:
            count3 += 1
        elif number >=76:
            count4 += 1
    
    valid_number = number >= 0

print(f'{count1} numbers are in the range [0-25]')
print(f'{count2} numbers are in the range [26-50]')
print(f'{count3} numbers are in the range [51-75]')
print(f'{count4} numbers are in the range [76-100]')
