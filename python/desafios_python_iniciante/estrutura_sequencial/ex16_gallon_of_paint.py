# Faça um programa para uma loja de tintas. O programa deverá pedir o tamanho em metros quadrados da área a ser pintada. Considere que a cobertura da tinta é de 1 litro para cada 3 metros quadrados e que a tinta é vendida em latas de 18 litros, que custam R$ 80,00. Informe ao usuário a quantidades de latas de tinta a serem compradas e o preço total.


area = float(input('what is the area of the paint: '))
paint = area / 3
amount_gallon = round(paint / 18 + 0.5) # tem que arredondar pra cima
price = amount_gallon * 80

print(f'you need {amount_gallon} gallon of paint')
print(f'the purchase price is $ {price}')

