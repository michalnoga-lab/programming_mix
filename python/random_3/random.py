import random


def generate_number():
    return random.randint(10, 99)


number = generate_number()
reversed_number = str(number % 10) + str(int(number / 10))

print(f'Wylosowano liczbę: {number}')
print(f'Odwórcona wylosowana liczba ma postać: {reversed_number}')
