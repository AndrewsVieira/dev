# Faça um programa que peça o tamanho de um arquivo para download (em MB) e a velocidade de um link de Internet (em Mbps), calcule e informe o tempo aproximado de download do arquivo usando este link (em minutos).

file_size = 1024 * 4 # 4GB
velocity_internet = 44.2 # mbps

time = (file_size / velocity_internet) / 60 # '/ 60' para converter o tempo para minutos

print(time)