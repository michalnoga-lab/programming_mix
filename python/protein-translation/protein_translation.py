def proteins(strand):
    array = []

    for i in range(0, len(strand), 3):
        if strand[i: i + 3] == 'UAA' or strand[i: i + 3] == 'UAG' or strand[i: i + 3] == 'UGA':
            break
        array.append(translate(strand[i: i + 3]))
    return array


def translate(sample):
    switcher = {
        'AUG': "Methionine",
        'UUU': 'Phenylalanine',
        'UUC': 'Phenylalanine',
        'UUA': 'Leucine',
        'UUG': 'Leucine',
        'UCU': 'Serine',
        'UCC': 'Serine',
        'UCA': 'Serine',
        'UCG': 'Serine',
        'UAU': 'Tyrosine',
        'UAC': 'Tyrosine',
        'UGU': 'Cysteine',
        'UGC': 'Cysteine',
        'UGG': 'Tryptophan'
    }
    return switcher.get(sample)
