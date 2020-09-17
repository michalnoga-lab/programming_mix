export class Squares {
    constructor(input) {
        this.input = input;
    }

    get sumOfSquares() {
        return this.input * (this.input + 1) * (2 * this.input + 1) / 6;
    }

    get squareOfSum() {
        return Math.pow((this.input * (this.input + 1)) / 2, 2);
    }

    get difference() {
        return this.squareOfSum - this.sumOfSquares;
    }
}