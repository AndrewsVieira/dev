# A conversão da espaço ocupado em disco, de bytes para megabytes deverá ser feita através de uma função separada, que será chamada pelo programa principal.

def convert_to_megabyts(bytes):
    return bytes / 1024 / 1024

# O cálculo do percentual de uso também deverá ser feito através de uma função, que será chamada pelo programa principal.

def percentage(part, total):
    return (part / total) * 100

# ** Ordenar os usuários pelo percentual de espaço ocupado;

def order_list(mylist):
    return sorted(mylist, reverse = True)
