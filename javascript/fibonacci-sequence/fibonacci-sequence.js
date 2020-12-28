// Napisz program, w którym przyjmujesz lub pobierasz liczbę od użytkownika.
// Następnie wypisz na ekranie n elementów ciągu Fibonacciego.

const fibonacciSequence = (checkTo) => {
    if (checkTo === 0) {
        return [0]
    } else if (checkTo === 1) {
        return [0, 1]
    } else {
        let result = [0, 1]
        for (let i = 0; i <= checkTo; i++) {
            result.push(result[result.length - 2] + result[result.length - 1])
        }
        return result
    }
}

console.log(fibonacciSequence(50))
