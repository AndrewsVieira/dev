users_txt = open('users.txt', 'r').readlines()
# print(txt)

list_names_sizes = []

for text in users_txt:
    name = text[0:text.index(' ')]
    # -1 representa o último elemento já que o 0 é o primeiro
    size = text[16:-1]

    # lista criada apenas para preencher a lista principal "list_names_sizes"
    list_temporary = [name, size]

    list_names_sizes.append(list_temporary)

string = '\nACME Inc.\t\t\tUso do espaço em disco pelos usuários\n'
string += '------------------------------------------------------------------------\n'
string += '{:<10s}{:<15s}{:<20s}{:<10s}\n\n'.format(
    'Nr.', 'Usuário', 'Espaço utilizado', '% do uso')

# variáveis da tabela
user = ''
size = 0
percentage = 0.0
total_size = 0
count = 0

for i in list_names_sizes:
    i[1] = int(i[1])
    total_size += i[1]

total_size = total_size/1024/1024

for i in list_names_sizes:
    i[1] = int(i[1])

    user = i[0]
    size = i[1]/1024/1024
    percentage = (size / total_size)*100
    index = count + 1

    string += '{:<10d}{:<15s}{:>10.2f} MB {:>15.2f} %\n'.format(
        index, user, size, percentage)

    count += 1

string += '\nEspaço total ocupado: {:.2f} MB\n'.format(total_size)
string += 'Espaço médio ocupado: {:.2f} MB\n'.format(total_size/(count))

# criando e escrevendo em um arquivo txt

report = open('relatorio.txt', 'w', encoding='utf8')

report.write(string)

report.close()
