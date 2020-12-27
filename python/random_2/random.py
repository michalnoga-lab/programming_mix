import random


def generate_number(minimum, maximum):
    return random.randint(minimum, maximum)


number_1 = generate_number(5, 231)
number_2 = generate_number(5, 231)
number_3 = generate_number(5, 231)


def get_numbers_in_order(num_1, num_2, num_3):
    min_value = min(num_1, num_2, num_3)
    max_value = max(num_1, num_2, num_3)
    mid_value = num_1 + num_2 + num_3 - min_value - max_value
    return min_value, mid_value, max_value


(min_v, mid_v, max_v) = get_numbers_in_order(number_1, number_2, number_3)


def get_average(num_1, num_2, num_3):
    all_numbers = get_numbers_in_order(num_1, num_2, num_3)
    return (all_numbers[1] + int(str(all_numbers[0])[-1]) + int(str(all_numbers[2])[-1])) / 2


print(f'Największa z wylosowanych liczb to: {get_numbers_in_order(number_1, number_2, number_3)[2]}')
print(f'Najmniejsza z wylosowanych liczb to: {get_numbers_in_order(number_1, number_2, number_3)[0]}')
print(f'Średnia wynosi: {get_average(number_1, number_2, number_3)}')
