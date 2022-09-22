from converter import convert, convertHex

if __name__ == '__main__':
    number1: int = 100100100
    number2: int = 4444
    number3: int = 354
    number4: str = '1AAB1'
    print(f'Converted binary number {number1} in decimal is: {int(convert(number1, 2))}')
    print(f'Converted octal number {number2} in decimal is: {int(convert(number2, 8))}')
    print(f'Converted 4 digit system number {number3} in decimal is: {int(convert(number3, 4))}')
    print(f'Converted hexadecimal number {number4} in decimal is: {int(convertHex(number4, 16))}')
