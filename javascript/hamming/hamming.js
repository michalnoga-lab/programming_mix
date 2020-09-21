export const compute = (strand1, strand2) => {
    if (strand1.length === 0 && strand2.length === 0) {
        return 0;
    } else if (strand1.length === 0) {
        throw Error('left strand must not be empty');
    } else if (strand2.length === 0) {
        throw Error('right strand must not be empty');
    } else if (strand1.length !== strand2.length) {
        throw Error('left and right strands must be of equal length');
    }
    let counter = 0;

    for (let i = 0; i < strand1.length; i++) {
        if (strand1[i] !== strand2[i]) {
            counter++;
        }
    }
    return counter;
};