import re


def get_user_input():
    user_input = input('Podaj liczbę naturalną: ')

    while not re.match('^[0-9]+$', user_input):
        user_input = input('Podaj liczbę naturalną: ')
    return int(user_input)


def print_fibonacci_sequence(num):
    if num == 0:
        print([0])
    elif num == 1:
        print([0, 1])
    else:
        result = [0, 1]
        for x in range(2, num):
            result.append(result[-2] + result[-1])
        return result


if __name__ == '__main__':
    input_from_user = get_user_input()
    print(print_fibonacci_sequence(input_from_user))
