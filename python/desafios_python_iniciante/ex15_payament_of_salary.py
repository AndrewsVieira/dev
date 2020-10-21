# Faça um Programa que pergunte quanto você ganha por hora e o número de horas trabalhadas no mês. Calcule e mostre o total do seu salário no referido mês, sabendo-se que são descontados 11% para o Imposto de Renda, 8% para o INSS e 5% para o sindicato, faça um programa que nos dê:
# salário bruto.
# quanto pagou ao INSS.
# quanto pagou ao sindicato.
# o salário líquido.
# calcule os descontos e o salário líquido, conforme a tabela abaixo:
# + Salário Bruto : R$
# - IR (11%) : R$
# - INSS (8%) : R$
# - Sindicato ( 5%) : R$
# = Salário Liquido : R$
# Obs.: Salário Bruto - Descontos = Salário Líquido.

hour_value = int(input('enter the hour_value: '))
worked_hour = int(input('enter the worked hours in this month: '))

salary = hour_value * worked_hour

inss = 0.08 * salary
ir = 0.11 * salary
sindicato = 0.05 * salary

net_salary = salary - inss - ir - sindicato

print('\n------------------------------\n')
print('\tPAYAMENT OF SALARY')
print('\n------------------------------\n')
print(f'+ Salário Bruto : R$ {salary}')
print(f'- IR (11%) : R$ {ir}')
print(f'- INSS (8%) : R$ {inss}')
print(f'- Sindicato ( 5%) : R$ {sindicato}')
print(f'= Salário Liquido : R$ {net_salary}')
print('\n------------------------------\n')
