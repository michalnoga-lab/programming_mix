export class HighScores {
    constructor(input) {
        this.input = input;
    }

    get scores() {
        return this.input;
    }

    get latest() {
        return this.input[this.input.length - 1];
    }

    get personalBest() {
        return Math.max(...this.input);
    }

    get personalTopThree() {
        return [...this.input].sort((x, y) => x - y).reverse().slice(0, 3);
    }
}