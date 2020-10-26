# Classe Bichinho Virtual:Crie uma classe que modele um Tamagushi (Bichinho Eletrônico):

# a. Atributos: Nome, Fome, Saúde e Idade 
# b. Métodos: Alterar Nome, Fome, Saúde e Idade; Retornar Nome, Fome, Saúde e Idade 
# Obs: Existe mais uma informação que devemos levar em consideração, o Humor do nosso tamagushi, este humor é uma combinação entre os atributos Fome e Saúde, ou seja, um campo calculado, então não devemos criar um atributo para armazenar esta informação por que ela pode ser calculada a qualquer momento.

class VirtualPet:
    def __init__(self, name):
        self.setName(name)
        self.hunger = 1
        self.life = 100
        self.age = 0

    def setName(self, name):
        self.name = name

    def getName(self):
        return self.name

    def setHunger(self, hunger):
        self.hunger = hunger if hunger > 0 and hunger < 100 else 0

    def getHunger(self):
        return self.hunger

    def setLife(self, life):
        self.life = life if life > 0 and life < 100 else 0

    def getLife(self):
        return self.life

    def setAge(self, age):
        self.age = age if age > 0 else 0

    def getAge(self):
        return self.age

    def getMood(self):
        return self.life / self.hunger