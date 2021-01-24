fs = require('fs')

let text = fs.readFileSync('./pliki/example_data.csv').toString('UTF-8')
console.log(text)

const findOnlyUpperCaseSentences = text => {
    let output = [];
    text.split('\n').forEach(line => {
        let lineArray = line.split(',')
        for (let sentence of lineArray) {
            if (sentence.match(/^[A-Z\s]+$/) && sentence.split('\s').length) {
                output.push(sentence)
            }
        }
    })
    return output
}

const countVowels = sentence => {
    return [...sentence].length - sentence.replace(/[aeouiy]+/gi, '').length
}

const sortByVowelsNumber = text => {
    let output = new Map;
    [...text.toString().split('\r')].forEach(line => {
        output.set(line, countVowels(line))
    })

    return new Map([...output.entries()].sort((a, b) => {
        if (a[1] < b[1]) {
            return 1
        } else if (a[1] > b[1]) {
            return -1
        } else {
            return 0
        }
    }))
}

const removeSentenceShorterThan = (minAllowedLength, sentences) => {
    let output = new Map();
    [...sentences.entries()].forEach(entry => {
        if (entry[0].length > minAllowedLength) {
            output.set(entry[0], entry[1])
        }
    })
    return output
}

let onlyUppercaseSentences = findOnlyUpperCaseSentences(text)
let sentencesSortedByVowelsNumber = sortByVowelsNumber(onlyUppercaseSentences)
let sentencesLongerThan = removeSentenceShorterThan(15, sentencesSortedByVowelsNumber)

console.log(`Napisy tylko dużymi literami:`);
[...onlyUppercaseSentences].forEach(line => console.log(line))
console.log(`Napisy posortowane wg ilości samogłosek malejąco: `);
for (let entry of sentencesSortedByVowelsNumber) {
    console.log(entry)
}
console.log(`Napisy po usunięciu, krótszych niż 15 znaków: `)
console.log(typeof sentencesLongerThan)

for (let sentence of sentencesLongerThan) {
    console.log(sentence)
}
