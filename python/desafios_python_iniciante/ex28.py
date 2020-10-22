# O Hipermercado Tabajara está com uma promoção de carnes que é imperdível. Confira:
#                       Até 5 Kg           Acima de 5 Kg
# File Duplo      R$ 4,90 por Kg          R$ 5,80 por Kg
# Alcatra         R$ 5,90 por Kg          R$ 6,80 por Kg
# Picanha         R$ 6,90 por Kg          R$ 7,80 por Kg
# Para atender a todos os clientes, cada cliente poderá levar apenas um dos tipos de carne da promoção, porém não há limites para a quantidade de carne por cliente. Se compra for feita no cartão Tabajara o cliente receberá ainda um desconto de 5% sobre o total da compra. Escreva um programa que peça o tipo e a quantidade de carne comprada pelo usuário e gere um cupom fiscal, contendo as informações da compra: tipo e quantidade de carne, preço total, tipo de pagamento, valor do desconto e valor a pagar.


class Cliente:
    def __init__(self, cartao, tipoCarne, quantidadeCarne):
        self.cartao = bool(cartao)
        self.promocao = Promocao(tipoCarne, quantidadeCarne)
    
    def darDesconto(self):
        if self.cartao:
            return 0.05
        else:
            return 0.00


class Promocao:
    tiposCarne = {
            1: 'File Duplo',
            2: 'Alcatra', 
            3: 'Picanha'
        }

    def __init__(self, tipoCarne, quantidadeCarne):
        
        self.quantidadeCarne = quantidadeCarne if quantidadeCarne > 0.0  else 0.0
        
        self.tipoCarne = self.tiposCarne.get(tipoCarne) if tipoCarne >= 1 and tipoCarne <= 3 else 'tipo inválido'

    def darPreco(self):
        precos = {
            'File Duplo':   4.9 if (self.quantidadeCarne < 5) else 5.8,
            'Alcatra':      5.9 if (self.quantidadeCarne < 5) else 6.8,
            'Picanha':      6.9 if (self.quantidadeCarne < 5) else 7.8
        }
        return precos.get(self.tipoCarne)
        

##########################################################################################################

cliente = Cliente(True, 1, 7)

quantidadeCliente = cliente.promocao.quantidadeCarne
precoTotalCliente = cliente.promocao.darPreco() * quantidadeCliente
precoDescontoClinte = cliente.darDesconto() * precoTotalCliente
valorTotalCliente = precoTotalCliente - precoDescontoClinte

print('\n-----------------------')
print('CUMPOM FISCAL')
print('-----------------------\n')
print('PRODUTO: ', cliente.promocao.tipoCarne)
print('QUANTIDADE: ', quantidadeCliente, ' kg')
print('PREÇO: ', precoTotalCliente)
print('FORMA DE PAGAMENTO: ', 'Cartão Tabajara' if cliente.cartao else 'Outro')
print('DESCONTO: ', precoDescontoClinte)
print('TOTAL: ', valorTotalCliente)
print('\n-----------------------\n')










