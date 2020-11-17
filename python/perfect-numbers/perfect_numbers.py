def classify(number):
    divisions = []

    for i in range(1, number):
        if number % i == 0:
            divisions.append(i)

    if sum(divisions) > number:
        return 'abundant'
    if sum(divisions) < number:
        return 'deficient'

    return 'perfect'
