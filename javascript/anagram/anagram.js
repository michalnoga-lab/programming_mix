export class Anagram {

    constructor(word) {
        this.word = word;
    }

    matches(array) {
        return array
            .filter(item => this.word.toLowerCase() !== item.toLowerCase() && prepareString(item) === prepareString(this.word));
    }
}

const prepareString = function (input) {
    return input.toLowerCase().split('').sort((a, b) => a.localeCompare(b)).join('');
};