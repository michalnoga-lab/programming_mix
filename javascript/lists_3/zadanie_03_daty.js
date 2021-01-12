// Napisz program, w którym przygotujesz listę napisów pobieraną od
// użytkownika. Kolejne elementy listy to daty, które wprowadza
// użytkownik. Zadbaj o walidację daty, którą aplikacja pobiera od
// użytkownika. Powinna ona mieć przykładowy format 2011-02-04. Na
// podstawie pobranej listy napisów przygotuj dwie listy. Pierwsza lista
// to lista dat (elementy tupu LocalDate), które udało się prawidłowo
// przekonwertować z pobieranej listy napisów. Druga lista to lista
// napisów, która zawiera te napisy, które prezentują nieprawidłową datę
// z pierwszej kolekcji. Przykładem takiej daty może być 2011-02-31.
// Z listy prawidłowo przekonwertowanych dat wypisz daty najpóźniejszą,
// najwcześniejszą oraz różnicę między nimi w dniach, godzinach oraz
// sekundach.

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
            validDates.push(date)
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
        }
    }
}

const datesValidator = dataValidator(dates)

console.log(`Prawidłowe daty: ${datesValidator.getValidDates()}`)
console.log(`Błędne daty: ${datesValidator.getInvalidDates()}`)
