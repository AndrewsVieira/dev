from support import *

users_txt = open('users.txt', 'r').readlines()
# print(txt)

list_names_sizes = []

for text in users_txt:
    name = text[0:text.index(' ')]
    # -1 representa o último elemento já que o 0 é o primeiro
    size = text[16:-1]

    # lista criada apenas para preencher a lista principal "list_names_sizes"
    list_temporary = [size, name]

    list_names_sizes.append(list_temporary)

string = '\nACME Inc.\t\t\tUso do espaço em disco pelos usuários\n'
string += '------------------------------------------------------------------------\n'
string += '{:<10s}{:<15s}{:<20s}{:<10s}\n\n'.format(
    'Nr.', 'Usuário', 'Espaço utilizado', '% do uso')

# variáveis da tabela
user = ''
size = 0
percent = 0.0
total_size = 0
count = 0

for i in list_names_sizes:
    i[0] = int(i[0])
    total_size += i[0]

total_size = convert_to_megabyts(total_size)

list_names_sizes = order_list(list_names_sizes)

for i in list_names_sizes:
    i[0] = int(i[0])

    user = i[1]
    size = convert_to_megabyts(i[0])
    percent = percentage(size, total_size)
    index = count + 1

    string += '{:<10d}{:<15s}{:>10.2f} MB {:>15.2f} %\n'.format(
        index, user, size, percent)

    count += 1

string += '\nEspaço total ocupado: {:.2f} MB\n'.format(total_size)
string += 'Espaço médio ocupado: {:.2f} MB\n'.format(total_size/(count))

# criando e escrevendo em um arquivo txt

report = open('relatorio.txt', 'w', encoding='utf8')

report.write(string)

report.close()
