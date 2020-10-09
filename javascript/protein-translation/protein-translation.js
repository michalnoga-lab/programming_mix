export const translate = (inputCode = '') => {
    let output = [];

    if (inputCode.isNullOrUndefined || inputCode.length === 0) {
        return output;
    }

    for (let i = 0; i < inputCode.length; i += 3) {
        let translatedCode = codons[inputCode.substring(i, i + 3)];
        if (translatedCode === undefined) {
            throw Error('Invalid codon');
        }

        if (translatedCode === 'STOP') {
            break
        }
        output.push(translatedCode);
    }
    return output;
};

const codons = {
    'AUG': 'Methionine',
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
    'UGG': 'Tryptophan',
    'UAA': 'STOP',
    'UAG': 'STOP',
    'UGA': 'STOP'
}