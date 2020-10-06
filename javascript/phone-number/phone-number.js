export class PhoneNumber {
    constructor(input) {
        this.input = input;
    }

    number() {
        let inputPured = this.input.replace(/[^\d]+/g, "");

        if (inputPured[0] == 1) {
            inputPured = inputPured.substr(1);
        }

        if (inputPured[0] < 2 || inputPured[3] < 2) {
            return null;
        }

        return inputPured.length === 10 ? inputPured : null;
    }
}