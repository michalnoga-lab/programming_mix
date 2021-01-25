const generateNumber = (from, to) => {
    return Math.floor(Math.random() * (to - from) + from)
}

const generateSentence = () => {
    let sentenceLength = generateNumber(10, 41)
    let maxCharacterRepetition = generateNumber(3, 5)
    let outputSentence = ''

    while (outputSentence.length < sentenceLength) {
        let char = String.fromCharCode(generateNumber(65, 91))
        if (outputSentence.split(char).length < maxCharacterRepetition) {
            outputSentence += char
        }
    }

    return outputSentence
}

const calculateLongestCharactersDifference = sentence => {
    let longestDistance = 0;
    let character = ''

    for (let i in sentence) {
        let first = sentence.indexOf(sentence[i])
        let last = sentence.lastIndexOf(sentence[i])

        if (last - first > longestDistance) {
            longestDistance = last - first
            character = sentence[i]
        }
    }
    return [character, longestDistance]
}

const calculateDistanceToMoveCharactersToLeft = (sentence, character) => {
    let totalDistance = 0

    if (!sentence.includes(character)) {
        return 0
    }

    for (let idx in sentence) {
        if (sentence[idx] === character) {
            totalDistance += Number.parseInt(idx)
        }
    }

    return totalDistance
}

const calculateSymmetricalSentence = sentence => {
    let symmetricalSentence = ''

    for (let char of sentence) {
        symmetricalSentence += String.fromCharCode(90 - (char.charCodeAt(0) - 65))
    }
    return symmetricalSentence
}

let generatedSentence = generateSentence()
let longestDistance = calculateLongestCharactersDifference(generatedSentence)
let distanceToMoveCharactersToLeft = calculateDistanceToMoveCharactersToLeft(generatedSentence, 'A')
let symmetricalSentence = calculateSymmetricalSentence(generatedSentence)

console.log(generatedSentence)
console.log(`Suma odległości wystąpień jest najdłuższa dla znaku: ${longestDistance[0]} i wynosi ${longestDistance[1]}`)
console.log(`Należy przesunąć się o ${distanceToMoveCharactersToLeft} pozycji aby wszystkie wystąpienia znaku znalazły się po lewej stronie napisu.`)
console.log(`Napis symetryczny do ${generatedSentence} to ${symmetricalSentence}`)

