# Faça um Programa que pergunte quanto você ganha por hora e o número de horas trabalhadas no mês. Calcule e mostre o total do seu salário no referido mês.

hour_value = int(input('enter the hour_value: '))
worked_hour = int(input('enter the worked hours in this month: '))

salary = hour_value * worked_hour

print(f'your salary in this month is $ {salary}')

