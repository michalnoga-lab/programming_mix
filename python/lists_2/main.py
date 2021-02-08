import random
import math


def generate_number(min_num, max_num):
    return random.randint(min_num, max_num)


def generate_array():
    return [generate_number(10, 100) for x in range(generate_number(10, 100))]


def is_prime(number):
    for i in range(2, number):
        if number % i == 0:
            return False
    return True


def get_primes_only(input_array):
    return [x for x in input_array if is_prime(x)]


def write_bigger_digit_as_text(input_array):
    output = []

    for number in input_array:
        first_digit = math.floor(number / 10)
        second_digit = number % 10
        bigger_digit = first_digit if first_digit > second_digit else second_digit

        if bigger_digit == 1:
            output.append('JEDEN')
        elif bigger_digit == 2:
            output.append('DWA')
        elif bigger_digit == 3:
            output.append('TRZY')
        elif bigger_digit == 4:
            output.append('CZTERY')
        elif bigger_digit == 5:
            output.append('PIEC')
        elif bigger_digit == 6:
            output.append('SZESC')
        elif bigger_digit == 7:
            output.append('SIEDEM')
        elif bigger_digit == 8:
            output.append('OSIEM')
        elif bigger_digit == 9:
            output.append('DZIEWIEC')
        else:
            output.append('ZERO')
    return output


array = generate_array()
prime_array = get_primes_only(array)
text_array = write_bigger_digit_as_text(prime_array)

print(f'Wylosowano tablicę liczb: {array}')
print(f'Tablica tylko z liczbami pierwszymi: {prime_array}')
print(f'Tablica z zapisem większej cyfry jako tekstu {text_array}')

file = open('sentences.txt', 'w')
file.write(str(text_array))
file.close()
