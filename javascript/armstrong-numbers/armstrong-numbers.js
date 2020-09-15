export const validate = (input) => {
    let inputLength = String(input).length;

    return [...String(input)]
        .map(element => Math.pow(element, inputLength))
        .reduce((el1, el2) => el1 + el2) === input;
};