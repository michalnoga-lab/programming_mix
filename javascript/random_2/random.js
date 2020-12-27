const generateRandomNumber = (from, to) => {
    return Math.floor(Math.random() * (to - from) + from)
}

const first = generateRandomNumber(5, 231)
const second = generateRandomNumber(5, 231)
const third = generateRandomNumber(5, 231)

const findBiggestNumber = (first, second, third) => {
    return Math.max(first, second, third)
}

const findSmallestNumber = (first, second, third) => {
    return Math.min(first, second, third)
}

const findMiddleNumber = (first, second, third) => {
    return (first + second + third) - findBiggestNumber(first, second, third) - findSmallestNumber(first, second, third)
}

const calculateAverage = (first, second, third) => {
    const middleNumber = findMiddleNumber(first, second, third)
    const smallest = findSmallestNumber(first, second, third).toString()
    const biggest = findBiggestNumber(first, second, third).toString()
    
    return (middleNumber
        + parseInt(smallest.split('')[smallest.length - 1])
        + parseInt(biggest.split('')[biggest.length - 1])) / 2
}

console.log(`Wylosowano liczby ${first}, ${second}, ${third}.`)

console.log(`Największa z wylosowanych liczb to: ${findBiggestNumber(first, second, third)}`)
console.log(`Najmniejsza z wylosowanych liczb to: ${findSmallestNumber(first, second, third)}`)
console.log(`Średnia wynosi: ${calculateAverage(first, second, third)}`)
