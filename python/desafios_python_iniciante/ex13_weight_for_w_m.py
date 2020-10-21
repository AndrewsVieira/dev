# Tendo como dado de entrada a altura (h) de uma pessoa, construa um algoritmo que calcule seu peso ideal, utilizando as seguintes fórmulas:
# a. Para homens: (72.7*h) - 58
# b. Para mulheres: (62.1*h) - 44.7

height = float(input('enter your height: '))

right_gender = True

while right_gender:
    gender = str(input('what is your gender ? (f/m) '))

    if gender == 'f':
        weight = (62.1*height) - 44.7
        right_gender = False
    elif gender == 'm':
        weight = (72.7 * height) - 58
        right_gender = False
    else:
        print('enter the "f" or "m" for the gender')
        
    
print(f'your ideal weight is {weight}')