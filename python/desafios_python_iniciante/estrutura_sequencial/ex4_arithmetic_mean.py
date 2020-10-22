# Faça um Programa que peça as 4 notas bimestrais e mostre a média.
note1 = 0
note2 = 0
note3 = 0
note4 = 0

note1 = float(input(f'enter to te note 1: '))
note2 = float(input(f'enter to te note 2: '))
note3 = float(input(f'enter to te note 3: '))
note4 = float(input(f'enter to te note 4: '))
    
arithmetic_mean = (note1 + note2 + note3 + note4) / 4

text = f'the arithmetic mean of notes is {arithmetic_mean}'

print(text)
    