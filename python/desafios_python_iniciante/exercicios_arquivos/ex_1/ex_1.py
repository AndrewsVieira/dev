# pegar as linhas do arq.txt e pô-las em uma lista
list_ip_address = open('arq.txt', 'r').readlines()
report = open('relatorio.txt', 'w', encoding='utf8')
report.close()

str_valid = '[ENDEREÇOS VÁLIDOS]\n'
str_invalid = '[ENDEREÇOES INVÁLIDOS]\n'

# vou criar uma regra qualquer para atribuir a um ip válido
# por exemplo: ip válidos são os que começam com números entre 1 e 5

for ip in list_ip_address:
    int_ip = int(ip[0])
    if int_ip >=1 and int_ip <=5:
        str_valid += ip
    else:
        str_invalid += ip

report = open('relatorio.txt', 'r', encoding='utf8')
content = report.readlines() # ler todo o conteúdo do arquivo e coloca-o em uma lista
content.append(str_valid)
content.append(str_invalid)

report = open('relatorio.txt', 'w', encoding='utf8')
report.writelines(content)
report.close()
