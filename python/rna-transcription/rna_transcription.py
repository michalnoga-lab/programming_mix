def to_rna(dna_strand):
    output = ''

    for nucleotide in dna_strand:
        output += (translate(nucleotide))
    return output


def translate(nucleotide):
    switcher = {
        'G': 'C',
        'C': 'G',
        'T': 'A',
        'A': 'U'
    }
    return switcher.get(nucleotide)
