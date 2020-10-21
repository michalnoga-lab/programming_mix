def slices(series, length):
    if length > len(series) or len(series) == 0 or length <= 0:
        raise ValueError('ValueError')
    output = []

    for i in range(len(series)):
        if i + length > len(series):
            break
        output.append((series[i: i + length]))

    return output
