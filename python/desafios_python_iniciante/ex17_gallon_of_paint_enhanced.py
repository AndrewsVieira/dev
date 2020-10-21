# Faça um Programa para uma loja de tintas. O programa deverá pedir o tamanho em metros quadrados da área a ser pintada. Considere que a cobertura da tinta é de 1 litro para cada 6 metros quadrados e que a tinta é vendida em latas de 18 litros, que custam R$ 80,00 ou em galões de 3,6 litros, que custam R$ 25,00.

# Informe ao usuário as quantidades de tinta a serem compradas e os respectivos preços em 3 situações:
# a. comprar apenas latas de 18 litros;
# b. comprar apenas galões de 3,6 litros;
# c. misturar latas e galões, de forma que o desperdício de tinta seja menor. Acrescente 10% de folga e sempre arredonde os valores para cima, isto é, considere latas cheias.

area = float(input('what is the area of the paint: '))
paint = area / 6
big_amount_gallon = round(paint / 18 + 0.5) # tem que arredondar pra cima

price_big_gallon = big_amount_gallon * 80

amount_gallon = round(paint / 3.6 + 0.5)
price_amount_gallon = amount_gallon * 25

# economizar tinta

big_gallon = round(paint / 18 - 0.5)
little_gallon = round((paint % 18) / 3.6 + 0.5)
paint_economy_mode = (big_gallon * 80) + (little_gallon * 25)


# a. comprar apenas latas de 18 litros;

print(f'if you will prefer buy only gallons of 18 l, the price is $ {price_big_gallon}')

# b. comprar apenas galões de 3,6 litros;

print(f'if you will prefer buy only gallons of 3.6 l, the price is $ {price_amount_gallon}')

# c. misturar latas e galões, de forma que o desperdício de tinta seja menor. Acrescente 10% de folga e sempre arredonde os valores para cima, isto é, considere latas cheias.

print(f'if you want to buy in a way that saves ink, the price is $ {paint_economy_mode}')