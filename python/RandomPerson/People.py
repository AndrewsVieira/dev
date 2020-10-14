import random

people_number = int(input('Digite o número de pessoas: '))

count = 0
list = []

while count < people_number:
    person = str(input(f'Digite o nome da {count + 1}ª pessoa: '))
    list.insert(count, person)
    count += 1

choised = random.choice(list)

print(f'A pessoa sorteada foi --> {choised}')

