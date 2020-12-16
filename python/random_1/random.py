import random


def generate_number(minimum, maximum):
    return random.randint(minimum, maximum)


number_1 = generate_number(10, 30)
number_2 = generate_number(10, 30)


def check_numbers(num_1, num_2):
    print(num_1)
    print(num_2)

    num_1_first = int(num_1 / 10)
    mum_1_second = num_1 % 10
    num_2_first = int(num_2 / 10)
    num_2_second = num_2 % 10

    output = (
            (num_1_first > num_2_first and mum_1_second > num_2_second)
            or
            (num_1_first < num_2_first and mum_1_second < num_2_second)
    )

    print("TAK" if output is True else "NIE")


check_numbers(number_1, number_2)
