const dates = ['2010-01-01', '2010-02-01', '2012-02-04', '2010-02-31', '2020-03-11', '2019-09-30', '2020-12-32', '2019-06-06', '2015-08-01',
    '2009-07-28', '2019-11-11', '2025-06-06', '2020-08-31', '2021-13-01']

console.log(`Wprowadzono daty: ${dates}`)

const dataValidator = function (inputDates) {
    let validDates = []
    let invalidDates = []

    for (let date of inputDates) {
        let tempDate = new Date(date)
        let tempDateArray = date.split('-')

        if (tempDate.getTime() === new Date(date).getTime() && tempDate.getMonth() === tempDateArray[1] - 1) {
            validDates.push(new Date(date))
        } else {
            invalidDates.push(date)
        }
    }

    return {
        getValidDates: function () {
            return validDates
        },
        getInvalidDates: function () {
            return invalidDates
        },
        getEarliestDate: function () {
            return [...validDates].sort(function (a, b) {
                return a - b
            })
        },
        getLatestDate: function () {
            return [...validDates].sort(function (a, b) {
                return b - a
            })
        }
    }
}

const datesValidator = dataValidator(dates)

console.log(`Prawidłowe daty: ${datesValidator.getValidDates()}`)
console.log(`Błędne daty: ${datesValidator.getInvalidDates()}`)
console.log(`Najwcześniejsza data to: ${datesValidator.getEarliestDate()[0]}`)
console.log(`Najpóźniejsza data to: ${datesValidator.getLatestDate()[0]}`)
console.log(`Róznica pomiędzy najpóźniejszą i najwcześniejszą datą wynosi ${
    Math.round((datesValidator.getLatestDate()[0] - datesValidator.getEarliestDate()[0]) / (1000 * 60 * 60 * 24))} dni`)
console.log(`Róznica pomiędzy najpóźniejszą i najwcześniejszą datą wynosi ${
    Math.round((datesValidator.getLatestDate()[0] - datesValidator.getEarliestDate()[0]) / (1000 * 60 * 60))} godzin`)
console.log(`Róznica pomiędzy najpóźniejszą i najwcześniejszą datą wynosi ${
    Math.round((datesValidator.getLatestDate()[0] - datesValidator.getEarliestDate()[0]) / (1000 * 60))} sekund`)
