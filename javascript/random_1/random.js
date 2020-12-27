const generateRandomNumber = (from, to) => {
    return Math.floor(Math.random() * (to - from) + from)
}

const checkNumbers = (first, second) => {
    console.log(`Pierwsza wylosowana liczba to: ${first}`)
    console.log(`Druga wylolsowana liczba to ${second}`)
    return Math.floor(first / 10) > Math.floor(second / 10) && first % 10 > second % 10
}

const first = generateRandomNumber(10, 30)
const second = generateRandomNumber(10, 30)

onsole.log(checkNumbers(first, second) ? `Pierwsza wylosowana liczba ma cyfrę dziesiątek oraz jedności większą od drugiej wylosowanej liczby.` :
    `Pierwsza wylosowana liczba nie ma cyfry dziesiątek oraz jedności większych od drugiej wylosowanej liczby.`)
