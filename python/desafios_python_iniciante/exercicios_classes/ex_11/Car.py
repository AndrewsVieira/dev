# Classe carro: Implemente uma classe chamada Carro com as seguintes propriedades:

# a. Um veículo tem um certo consumo de combustível (medidos em km / litro) e uma certa quantidade de combustível no tanque.
# b. O consumo é especificado no construtor e o nível de combustível inicial é 0.
# c. Forneça um método andar( ) que simule o ato de dirigir o veículo por uma certa distância, reduzindo o nível de combustível no tanque de gasolina.
# d. Forneça um método obterGasolina( ), que retorna o nível atual de combustível.
# e. Forneça um método adicionarGasolina( ), para abastecer o tanque. Exemplo de uso:
#   meuFusca = Carro(15);           # 15 quilômetros por litro de combustível.
#   meuFusca.adicionarGasolina(20); # abastece com 20 litros de combustível.
#   meuFusca.andar(100);            # anda 100 quilômetros.
#   meuFusca.obterGasolina()        # Imprime o combustível que resta no tanque.

class Car:
    def __init__(self, fuel_consum):
        self.fuel_consum = fuel_consum
        self.fuel_amount = 0

    def setFuelAmount(self, fuel_amount):
        self.fuel_amount = fuel_amount

    def getFuelAmount(self):
        return self.fuel_amount

    def move(self, distance):
        print(f'the vehicle moved {distance} kilometer(s)')
        self.consum = distance / self.fuel_consum
        print(f'the fuel consulmed was {self.consum} liter(s)')
        self.fuel_amount -= self.consum
        print(f'new autonomy: {self.fuel_amount * self.fuel_consum} kilometer(s)')

    def toFuel(self, fuel_amount):
        self.setFuelAmount(fuel_amount)

    def toString(self):
        return '{}: fuel amount of {} liters'.format(Car.__name__, self.getFuelAmount())