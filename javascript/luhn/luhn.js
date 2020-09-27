export const valid = (input) => {

    if (input.match(/[^\d\s]+/) || input < 1) {
        return false;
    }
    input = input.replace(/[\s]/g, "");

    let array = [];
    let everySecondCounter = 0;

    for (let i = input.length - 1; i >= 0; i--) {
        if (everySecondCounter % 2 !== 0) {
            let valueToAdd = input[i] * 2;
            if (valueToAdd > 9) {
                array.push(valueToAdd - 9);
            } else {
                array.push(valueToAdd);
            }
        } else {
            array.push(input[i]);
        }
        everySecondCounter++;
    }

    let sum = array.map(element => Number(element)).reduce((v1, v2) => v1 + v2);
    return sum % 10 === 0;
};