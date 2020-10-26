# Classe Bola: Crie uma classe que modele uma bola:

# a. Atributos: Cor, circunferência, material
# b. Métodos: trocaCor e mostraCor

class Ball:
    # defição do construtor
    def __init__(self, collor, circumference, material):
        self.setCollor(collor)
        self.__circunference = circumference if circumference > 0 else 0
        self.__material = material

    def setCollor(self, collor):
        self.__collor = collor

    def getCollor(self):
        return self.__collor
