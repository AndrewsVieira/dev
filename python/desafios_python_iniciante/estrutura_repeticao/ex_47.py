'''Em uma competição de ginástica, cada atleta recebe votos de sete jurados. A melhor e a pior nota são eliminadas. A sua nota fica sendo a média dos votos restantes. Você deve fazer um programa que receba o nome do ginasta e as notas dos sete jurados alcançadas pelo atleta em sua apresentação e depois informe a sua média, conforme a descrição acima informada (retirar o melhor e o pior salto e depois calcular a média com as notas restantes). As notas não são informados ordenadas. Um exemplo de saída do programa deve ser conforme o exemplo abaixo:
Atleta: Aparecido Parente
Nota: 9.9
Nota: 7.5
Nota: 9.5
Nota: 8.5
Nota: 9.0
Nota: 8.5
Nota: 9.7

Resultado final:
Atleta: Aparecido Parente
Melhor nota: 9.9
Pior nota: 7.5
Média: 9,04'''

name = input("enter the name of athlete: ")
notes = []
count = 1

while count <= 7:
    note = float(input('enter with the note: '))
    notes.append(note)
    count += 1


print(max(notes))
print(min(notes))
print(sum(notes))

print(f"athlete: {name}")

for i in notes:
    print(f"note: {i}")
    
total = sum(notes) - max(notes) - min(notes)
average = total / 5

print(f'Final result:\n'
    f'Athlete: {name}\n'
    f'Best note: {max(notes)}\n'
    f'Worst note: {min(notes)}\n'
    f'Average: {average}\n')
