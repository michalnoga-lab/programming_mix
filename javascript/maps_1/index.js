const generateNumber = (from, to) => {
    return Math.floor(Math.random() * (to - from) + from)
}

const computeEvenDigitsSum = (number) => {
    const numberArray = number.toString().split('')
    let evenDigits = numberArray
        .map(element => parseInt(element))
        .filter(element => element % 2 === 0)
    return evenDigits.reduce(function (previousValue, currentValue, index, array) {
        return previousValue + currentValue
    }, 0)
}

const generateCollection = function () {
    let set = new Set()
    let map = new Map()
    return {
        create: function (howManyElements) {
            while (set.size < howManyElements) {
                set.add(generateNumber(10, 30))
            }
        },
        get: function () {
            return set
        },
        display: function () {
            console.log(`--------------------------------------------------`)
            set
                .forEach(element => console.log(element))
            console.log(`--------------------------------------------------`)
        },
        generateMap: function () {
            set.forEach(element => {
                map.set(element, computeEvenDigitsSum(element))
            })
        },
        displayMap: function () {
            console.log(`--------------------------------------------------`)
            map
                .forEach(function (value, key) {
                    console.log(`${key} : ${value}`)
                })
            console.log(`--------------------------------------------------`)
        },
        getMap: function () {
            return map
        },
        getHighestKeyValueFromMap: function () {
            return [...map.entries()]
                .sort((e1, e2) => {
                    if (e1[0] + e1[1] > e2[0] + e2[1]) {
                        return -1
                    } else if (e1[0] + e1[1] < e2[0] + e2[1]) {
                        return 1
                    } else {
                        return 0
                    }
                })[0]

        },
        findSmallestKey: function () {
            return Math.min(...map.keys())
        },
        findBiggestKey: function () {
            return Math.max(...map.keys())
        }, sortByKeys: function () {
            return [...map.entries()].sort(function (a, b) {
                return a[0] - b[0]
            })
        },
        sortByValues: function () {
            return [...map.entries()].sort(function (a, b) {
                return a[1] - b[1]
            })
        }
    }
}

const generatedCollection = generateCollection()
generatedCollection.create(20)
generatedCollection.generateMap()
generatedCollection.displayMap()
console.log(`Największa para klucz-wartość to: ${generatedCollection.getHighestKeyValueFromMap()}`)
console.log(`Najmniejszy klucz w mapie to: ${generatedCollection.findSmallestKey()}`)
console.log(`Największy klucz w mapie to: ${generatedCollection.findBiggestKey()}`)
console.log(`Mapa posortowana po kluczach: ${generatedCollection.sortByKeys()}`)
console.log(`Mapa posortowana po wartościach: ${generatedCollection.sortByValues()}`)
