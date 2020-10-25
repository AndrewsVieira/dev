# Sendo H= 1 + 1/2 + 1/3 + 1/4 + ... + 1/N, Faça um programa que calcule o valor de H com N termos.

number = int(input('enter a number: '))

string = 'H = 1'
n = 1
result = 0


for i in range(number):
    n_str = str(n)

    if n >= 2:
        string += ' + 1/' + n_str
    
    result += 1/n
    n += 1

result_str = str(result)
string += '\nH = ' + result_str

print(string)


