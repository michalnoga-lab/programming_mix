const sieveOfEratosthenes = (toNumber) => {
    const allNumbers = []
    const output = []
    for (let i = 2; i < toNumber; i++) {
        allNumbers.push(i)
    }
    let counter = 0

    while (counter < allNumbers.length) {
        if (allNumbers[counter]!==0) {
            let jump = allNumbers[counter]
            let length = allNumbers.length
            for (let i = counter; i < length; i += jump) {
                if (i !== counter) {
                    allNumbers[i] = 0
                } else {
                    output.push(allNumbers[i])
                }
            }
        }
        counter++
    }
    return output
}

const result = sieveOfEratosthenes(100)
console.log(`Znaleziono ${result.length} liczb pierwszych. List liczb: ${result}`)
