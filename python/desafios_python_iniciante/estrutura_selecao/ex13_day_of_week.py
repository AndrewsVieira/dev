# Faça um Programa que leia um número e exiba o dia correspondente da semana. (1-Domingo, 2- Segunda, etc.), se digitar outro valor deve aparecer valor inválido.

# usarei dicionário ao invés de if-elif-else
week_days = {
    1:'sunday',
    2:'monday',
    3:'tuesday',
    4:'wednesday',
    5:'thursday',
    6:'friday',
    7:'saturday'
}

# verificação - se o dia é consistente

number = 0
true_day = False

while not true_day:
    number = int(input('enter a number for day of the week: '))
    true_day = number >= 1 and number <= 7 # será True appenas se o number estiver detro deste intervalo
    if not true_day:
        print('enter a valid number')

chose_day = week_days.get(number)

print(f'the day you chose was {chose_day}')