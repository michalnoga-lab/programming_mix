// Napisz program, w którym wylosujesz do listy n liczb całkowitych.
// Wartość zmiennej n oraz elementy kolekcji losowane są z przedziału
// <10, 100>. Następnie zaimplementuj nową listę, w której z wygenerowanej
// wcześniej listy umieścisz tylko te elementy, które są liczbami
// pierwszymi. Na koniec utwórz listę napisów. Element listy napisów na
// i-tej pozycji powstaje jako słowna reprezentacja
// największej z cyfr i-tego elementu listy liczb pierwszych. Przykładowo
// jeżeli w liście liczb pierwszych mamy liczbę 31, to jej słowna
// reprezentacja w liście napisów to TRZY, ponieważ 3 jest największą
// cyfrą liczby 31. Zapisz otrzymaną listę napisów do pliku tekstowego o
// wybranej przez Ciebie nazwie. // <------------- TODO zapis

fs = require('fs')

const generateNumber = (from, to) => {
    return Math.floor(Math.random() * (to - from) + from)
}

const generateList = (howMayElementsInList) => {
    let list = []
    for (let i = 0; i < howMayElementsInList; i++) {
        list.push(generateNumber(10, 101))
    }
    return list
}

let list = generateList(generateNumber(10, 100))

console.log(`Wygenerowano listę elementów: ${list}`)

const isPrime = (number) => {
    for (let i = 2; i < number; i++) {
        if (number % i === 0) {
            return false
        }
    }
    return true
}

const leaveOnlyPrimes = (inputList) => {
    return inputList.filter(element => isPrime(element))
}

primeList = leaveOnlyPrimes(list)
console.log(`Liczby pierwsze w liście to: ${primeList}`)

const convertDigitsToSentences = (digit) => {
    switch (digit) {
        case 1:
            return 'JEDEN'
        case 2:
            return 'DWA'
        case 3:
            return 'TRZY'
        case 4:
            return 'CZTERY'
        case 5:
            return 'PIEC'
        case 6:
            return "SZESC"
        case 7:
            return 'SIEDEM'
        case 8:
            return 'OSIEM'
        case 9:
            return 'DZIEWIEC'
        default:
            return 'ZERO'
    }
}

const saveDigitsAsStrings = (list) => {
    let output = []
    for (let element of list) {
        output.push(convertDigitsToSentences(Math.max(parseInt(element.toString().split('')[0]),
            parseInt(element.toString().split('')[1]))))
    }
    return output
}

let finalList = saveDigitsAsStrings(primeList)
console.log(`Przekonwertowana lista: ${finalList}`)

fs.writeFile('./pliki/output', finalList, 'utf-8', function (){}
)
