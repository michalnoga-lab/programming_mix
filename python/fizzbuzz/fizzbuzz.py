def fizz_buzz():
    numbers = list(range(101))
    for idx in numbers:
        if numbers[idx] % 15 == 0:
            print(f'{numbers[idx]} -> FizzBuzz')
        elif numbers[idx] % 5 == 0:
            print(f'{numbers[idx]} -> Buzz')
        elif numbers[idx] % 3 == 0:
            print(f'{numbers[idx]} -> Fizz')


fizz_buzz()
