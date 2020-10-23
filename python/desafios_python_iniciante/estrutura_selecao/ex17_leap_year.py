# Faça um Programa que peça um número correspondente a um determinado ano e em seguida informe se este ano é ou não bissexto.


bi_year = False
year = int(input('enter a year: '))

bi_year = (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)

if bi_year:
    print(f'{year} is a leap year')
else:
    print(f'{year} is not a leap year')