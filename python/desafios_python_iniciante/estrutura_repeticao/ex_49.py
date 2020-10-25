# Faça um programa que mostre os n termos da Série a seguir:
#  S = 1/1 + 2/3 + 3/5 + 4/7 + 5/9 + ... + n/m. 
string = 'S = 1/1'

n = 2
m = 3

for i in range(100):
    n_str = str(n)
    m_str = str(m)

    string += ' + ' + n_str + '/' + m_str
    n += 1
    m += 2


print(string)


