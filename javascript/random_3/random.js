const generateRandomNumber = (from, to) => {
    return Math.floor(Math.random() * (to - from) + from)
}

const changeDigitsInNumber = (number) => {
    console.log(`Wylosowano liczbę: ${number}`)
    const numberArray = number.toString().split('')
    return numberArray[1] + numberArray[0]
}

console.log(`Odwrócona liczba ma postać: ${changeDigitsInNumber(generateRandomNumber(10, 99))}`)
