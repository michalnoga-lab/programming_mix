fs = require('fs')

const CATEGORY = new Map
CATEGORY.set(0, 'NO_CATEGORY')
CATEGORY.set(1, 'SMARTPHONES')
CATEGORY.set(2, 'TABLETS')
CATEGORY.set(3, 'PC')

class Product {
    constructor(name, category, price) {
        this.name = name
        this.category = category
        this.price = price
    }
}

const getProductsFromFile = () => {
    const content = fs.readFileSync('./products.csv').toString('UTF-8')

    return {
        addToSet: function () {
            let output = new Set();
            [...content.split('\n')]
                .forEach(line => {
                    let lineSplit = line.split(',')
                    output.add(new Product(lineSplit[1], lineSplit[2], lineSplit[3]))
                })
            return output
        }
    }
}

const createCategoryProductsMap = productsList => {

    return {
        create: function () {
            let output = new Map();

            CATEGORY.forEach((value, key, map) => {
                output.set(value, [])
            })

            productsList.forEach((value, key, map) => {
                let temp = ''
                switch (value.category) {
                    case 'SMARTPHONES':
                        temp = output.get('SMARTPHONES')
                        temp.push(value)
                        output.set('SMARTPHONES', temp);
                        break
                    case 'TABLETS':
                        temp = output.get('TABLETS')
                        temp.push(value)
                        output.set('TABLETS', temp)
                        break
                    case 'PC':
                        temp = output.get('PC')
                        temp.push(value)
                        output.set('PC', temp)
                        break
                    default:
                        output.set('NO_CATEGORY')
                }
            })
            return output
        }
    }
}

const findAveragePrice = products => {
    let pricesSum = 0
    let length = 0

    for (let idx in products) {
        pricesSum += parseInt(products[idx].price)
        length += 1
    }
    return (pricesSum / length).toFixed(2)
}

const findHighestAveragePriceInCategory = categoriesMap => {
    let highestPrice = new Map()

    categoriesMap.forEach(function (value, key) {
        highestPrice.set(key, findAveragePrice(value))
    })
    return [...highestPrice.entries()].sort(function (a, b) {
        if (a[1] > b[1]) {
            return -1
        } else if (a[1] < b[1]) {
            return 1
        } else return 0
    })
        .filter(function (params) {
            return params[1] !== 'NaN'
        })[0]
}

let products = getProductsFromFile().addToSet()
let categoryMap = createCategoryProductsMap(products).create()

console.log('All products:')
console.log(products)
console.log('Products by category:')
console.log(categoryMap)
console.log(`Największą średnią cen ma kateogoria ${findHighestAveragePriceInCategory(categoryMap)} PLN`)
