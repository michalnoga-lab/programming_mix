let fs = require('fs')
let buffer = fs.readFileSync('./sentences.txt')
let text = buffer.toString('UTF-8')
let textArray = text.split('\n')

const findVowels = text => {
    return text.replace(/[^a-z]/gim, '').replace(/[^aeouiy]/gim, '')
}

const findConsonants = text => {
    return text.replace(/[^a-z]/gim, '').replace(/[aeouiy]/gim, '')
}

const findKeysLengthsEqualValuesLengths = map => {
    let counter = 0
    Array.from(map, ([key, value]) => {
        if (key.length === value.length) {
            counter++
        }
    })
    return counter
}

const findSmallestKeyValueLengthDifference = map => {
    let result = [...map.entries()].sort(function (a, b) {
        let aDifference = Math.abs(a[0].length - a[1].length)
        let bDifference = Math.abs(b[0].length - b[1].length)

        if (aDifference > bDifference) {
            return 1
        } else if (aDifference < bDifference) {
            return -1
        } else {
            return 0
        }
    })
    return result[0][0].length + result[0][1].length
}

const findBiggestKeyValueLengthDifference = map => {
    let result = [...map.entries()].sort(function (a, b) {
        let aDifference = Math.abs(a[0].length - a[1].length)
        let bDifference = Math.abs(b[0].length - b[1].length)

        if (aDifference > bDifference) {
            return -1
        } else if (aDifference < bDifference) {
            return 1
        } else {
            return 0
        }
    })
    return result[0][0].length + result[0][1].length
}

const vowelsConsonantsMap = new Map()

for (let sentence of textArray) {
    vowelsConsonantsMap.set(findVowels(sentence), findConsonants(sentence))
}

console.log(`Ilość par w mapie, które mają długość klucza taką samą jak długość wartości: ${findKeysLengthsEqualValuesLengths(vowelsConsonantsMap)}`)
console.log(`Najmniejsza różnica w długości klucz wartość to: ${findSmallestKeyValueLengthDifference(vowelsConsonantsMap)}`)
console.log(`Największa różnica w długości klucz wartość to: ${findBiggestKeyValueLengthDifference(vowelsConsonantsMap)}`)
