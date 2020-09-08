def is_armstrong_number(number):
    total = 0
    array = [int(x) for x in str(number)]
    length = len(array)

    for i in range(length):
        total += array[i] ** length

    return total == number
