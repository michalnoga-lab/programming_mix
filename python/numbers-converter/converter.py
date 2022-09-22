import math


def convert(number: int, base: int) -> int:
    output: int = 0
    power: int = 0

    while number > 0:
        current_digit: int = number % 10
        output += current_digit * math.pow(base, power)
        power += 1
        number = int(number / 10)

    return output


def convertHex(number: str, base: int) -> int:
    output: int = 0
    power: int = 0

    for digit in reversed(number):
        current_number = ord(digit) - 48 if digit.isdigit() else ord(digit) - 55
        output += current_number * math.pow(base, power)
        power += 1

    return output
