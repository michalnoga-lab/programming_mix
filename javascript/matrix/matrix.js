export class Matrix {

    constructor(matrix) {
        this.matrix = matrix.split('\n').map(row => {
            return row.split(' ').map(Number);
        });
    }

    get rows() {
        return this.matrix;
    }

    get columns() {
        return this.matrix[0].map((firstElement, columnIndex) => this.matrix.map(row => row[columnIndex]));
    }
}