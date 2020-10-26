# 7. Classe Bichinho Virtual:Crie uma classe que modele um Tamagushi (Bichinho Eletrônico):

# a. Atributos: Nome, Fome, Saúde e Idade
# b. Métodos: Alterar Nome, Fome, Saúde e Idade; Retornar Nome, Fome, Saúde e Idade
# Obs: Existe mais uma informação que devemos levar em consideração, o Humor do nosso tamagushi, este humor é uma combinação entre os atributos Fome e Saúde, ou seja, um campo calculado, então não devemos criar um atributo para armazenar esta informação por que ela pode ser calculada a qualquer momento.

# 15. Classe Bichinho Virtual++: Melhore o programa do bichinho virtual, permitindo que o usuário especifique quanto de comida ele fornece ao bichinho e por quanto tempo ele brinca com o bichinho. Faça com que estes valores afetem quão rapidamente os níveis de fome e tédio caem.
from time import sleep


class VirtualPet:
    def __init__(self, name):
        self.setName(name)
        self.hunger = 1
        self.life = 100
        self.age = 0
        print(
            f'{self.getName()}\nage: {self.getAge()}\nlife: {self.getLife()}\nhuger: {self.getHunger()}\nmood: {self.getMood()}'
        )
        self.playGame()

    def setName(self, name):
        self.name = name

    def getName(self):
        return self.name

    def setHunger(self, hunger):
        if hunger > 0:
            if hunger <= 100:
                self.hunger = hunger
            else:
                self.hunger = 100
        else:
            self.hunger = 1

    def getHunger(self):
        return self.hunger

    def setLife(self, life):
        if life > 0:
            if life <= 100:
                self.life = life
            else:
                self.life = 100
        else:
            self.life = 0

    def getLife(self):
        return self.life

    def setAge(self, age):
        self.age = age if age >= 0 else 0

    def getAge(self):
        return self.age

    def getMood(self):
        return self.life / (self.hunger / 100)

    def giveFood(self, food_amount):
        self.setHunger(self.getHunger() - food_amount)

    def playWithPet(self, time):
        self.setLife(self.getLife() + time)

    def timer(self):
        sleep(1)
        print('a minute passed')
        self.giveFood(-1)
        self.playWithPet(-1)

    '''def checkAge(self):
        aux = 1.0
        if self.getAge() == aux:
            return True
            aux += 1
        else:
            return False'''

    def playGame(self):
        petAlive = self.life > 0 and self.hunger < 100
        while petAlive:
            print()
            self.timer()
            print(
                f'{self.getName()}\nage: {self.getAge()}\nlife: {self.getLife()}\nhuger: {self.getHunger()}\nmood: {self.getMood()}'
            )
            if self.getMood() < 200:
                time = int(
                    input('how long would you like to play with your pet? '))
                self.playWithPet(time)
            if self.getLife() < 30 or self.hunger > 50:
                food = int(input(f'how much do you want to feed the {self.getName()}? '))
                self.giveFood(food)
            self.setAge(round((self.getAge() + 0.1), 2))
            '''if self.checkAge():
                print(
                    f'wish your pet a happy birthday, because he just turned {self.getAge()} year(s) old')'''
