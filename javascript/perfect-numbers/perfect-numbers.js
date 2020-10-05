export const classify = (input) => {
    if (input <= 0) {
        throw Error('Classification is only possible for natural numbers.');
    }
    let divisions = [0];

    for (let i = 1; i < Math.floor(input / 2 + 1); i++) {
        if (input % i === 0) {
            divisions.push(i);
        }
    }

    let divisionsSum = divisions.reduce((previousValue, currentValue) => previousValue + currentValue);

    return divisionsSum === input ? 'perfect' : divisionsSum < input ? 'deficient' : 'abundant';
};