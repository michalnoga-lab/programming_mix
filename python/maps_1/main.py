# Przygotuj kolekcję 20 liczb całkowitych bez powtórzeń, które wylosujesz
# z przedziału <10, 30>. Następnie na podstawie kolekcji wygeneruj mapę,
# której kluczem będzie kolejna z wylosowanych liczb, natomiast wartością
# suma parzystych cyfr tej liczby. Wyznacz z mapy parę o największej
# wartości. Wyznacz największą i najmniejszą wartość klucza. Posortuj
# mapę malejąco według stosunku klucz / wartość.

import random


def generate_number(min_number, max_number):
    return random.randint(min_number, max_number)


def generate_array(length):
    output = set()

    while len(output) < length:
        output.add(generate_number(10, 99))
    return output


def sum_digits(number):
    output = 0
    numbers = [int(x) for x in str(number)]

    for digit in numbers:
        if digit % 2 == 0:
            output += digit

    return output


def convert_set_to_map(input_set):
    output = dict()

    for element in input_set:
        output[element] = sum_digits(element)
    return output


def find_biggest_pair(input_map):
    return sorted(input_map.items(), key=lambda entry: entry[0] + entry[1], reverse=True)[0]


def find_biggest_key(input_map):
    return sorted(input_map.items(), key=lambda entry: entry[0], reverse=True)[0][0]


def find_smallest_key(input_map):
    return sorted(input_map.items(), key=lambda entry: entry[0])[0][0]


def sort_ascending(input_map):
    return sorted(input_map.items(), key=lambda entry: entry[0])


def sort_descending(input_map):
    return sorted(input_map.items(), key=lambda entry: entry[0], reverse=True)


unique_numbers = generate_array(20)
map_from_unique_set = convert_set_to_map(unique_numbers)

print(f'Wylosowano wartości: {unique_numbers}')
print(f'Wygenerowano mapę: {map_from_unique_set}')
print(f'Największa para to: {find_biggest_pair(map_from_unique_set)}')
print(f'Największa wartość klucza to: {find_biggest_key(map_from_unique_set)}')
print(f'Najmniejsza wartość klucza to: {find_smallest_key(map_from_unique_set)}')
print(f'Mapa posortowana rosnąco: {sort_ascending(map_from_unique_set)}')
print(f'Mapa posortowana malejąco: {sort_descending(map_from_unique_set)}')
