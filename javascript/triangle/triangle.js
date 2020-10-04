export class Triangle {
    constructor(side1, side2, side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    kind() {
        if (this.side1 <= 0 || this.side2 <= 0 || this.side3 <= 0
            || (this.side1 + this.side2 < this.side3)
            || (this.side2 + this.side3 < this.side1)
            || (this.side3 + this.side1 < this.side2)) {
            throw new Error('Incorrect length');
        }

        let array = [this.side1, this.side2, this.side3];
        array = array.sort(function (a, b) {
            return b - a
        });

        if (array[0] === array[1] && array[1] === array[2]) {
            return 'equilateral';
        } else if (array[0] === array[1]) {
            return 'isosceles';
        } else {
            return 'scalene';
        }
    }
}