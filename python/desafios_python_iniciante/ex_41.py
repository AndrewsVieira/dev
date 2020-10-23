# Faça um programa que receba o valor de uma dívida e mostre uma tabela com os seguintes dados: valor da dívida, valor dos juros, quantidade de parcelas e valor da parcela.
# Os juros e a quantidade de parcelas seguem a tabela abaixo:
# Quantidade de Parcelas  % de Juros sobre o valor inicial da dívida
# 1       0
# 3       10
# 6       15
# 9       20
# 12      25
# Exemplo de saída do programa:
# Valor da Dívida Valor dos Juros Quantidade de Parcelas  Valor da Parcela
# R$ 1.000,00     0               1                       R$  1.000,00
# R$ 1.100,00     100             3                       R$    366,00
# R$ 1.150,00     150             6                       R$    191,67

import locale

locale.setlocale(locale.LC_MONETARY, 'en_US.UTF-8')

debit = float(input('enter the devit value: $ '))
str_debit = locale.currency(debit, grouping=True)
print('Valor da Dívida\tValor dos Juros\tQuantidade de Parcelas\tValor da Parcela')
print(f'{str_debit}\t$0.00\t\t1\t\t\t{str_debit}')
count_plot = 3
count_interest = 10

while count_plot <= 12:

    interest = count_interest * debit / 100 
    pay_plot = (debit + interest) / count_plot

    interest = locale.currency(interest, grouping=True)
    pay_plot = locale.currency(pay_plot, grouping=True)
    
    print(f'{str_debit}\t{interest}\t\t{count_plot}\t\t\t{pay_plot}')

    count_plot += 3 
    count_interest += 5






