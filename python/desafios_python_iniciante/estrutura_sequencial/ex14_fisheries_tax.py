# João Papo-de-Pescador, homem de bem, comprou um microcomputador para controlar o rendimento diário de seu trabalho. Toda vez que ele traz um peso de peixes maior que o estabelecido pelo regulamento de pesca do estado de São Paulo (50 quilos) deve pagar uma multa de R$ 4,00 por quilo excedente. João precisa que você faça um programa que leia a variável peso (peso de peixes) e calcule o excesso. Gravar na variável excesso a quantidade de quilos além do limite e na variável multa o valor da multa que João deverá pagar. Imprima os dados do programa com as mensagens adequadas.

fish_weight = float(input('enter the fish weight: '))

FISH_WEIGHT_LIMIT = 50.0

RATE = 4.00

if fish_weight > FISH_WEIGHT_LIMIT:
    total_rate_pay =  RATE * (fish_weight - FISH_WEIGHT_LIMIT)
else:
    total_rate_pay = 0.0

print('\n------------------------------\n')
print('\tFISHERIES TAX')
print('\n------------------------------\n')
print(f"fish weight\t\t{fish_weight}\nlimit weight\t\t{FISH_WEIGHT_LIMIT}\ntotal your's rate pay\t{total_rate_pay}")
print('\n------------------------------\n')

