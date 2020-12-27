def sieve_of_eratosthenes(to_number):
    numbers = [x for x in range(2, to_number + 1)]
    output = []
    counter = 0
    while counter < len(numbers):
        if numbers[counter] != 0:
            length = len(numbers)
            jump = numbers[counter]
            for i in range(counter, length, jump):
                if i != counter:
                    numbers[i] = 0
                else:
                    output.append(numbers[i])
        counter += 1
    return output


result = sieve_of_eratosthenes(100)
print(f'Znaleziono {len(result)} liczb pierwszych. Lista liczb: {result}')
