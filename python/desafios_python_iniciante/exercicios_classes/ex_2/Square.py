# Classe Quadrado: Crie uma classe que modele um quadrado:

# a. Atributos: Tamanho do lado
# b. Métodos: Mudar valor do Lado, Retornar valor do Lado e calcular Área;

class Square:
    def __init__(self, side):
        self.setSide(side)

    def setSide(self, side):
        self.side = side if side > 0 else 0

    def getSide(self):
        return self.side  

    def Area(self):
        return self.side ** 2