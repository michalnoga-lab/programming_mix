def distance(strand_a, strand_b):
    if len(strand_a) != len(strand_b):
        raise ValueError('ValueError')

    diff_counter = 0

    for a, b in zip(strand_a, strand_b):
        if a != b:
            diff_counter += 1

    return diff_counter
