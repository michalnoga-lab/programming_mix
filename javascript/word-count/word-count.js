export class Words {
    count(input) {
        let array = input.toLowerCase().trim().split(/\s+|\n|\t/);
        let occurrences = Object.create(null);

        array.forEach(element => {
            occurrences[element] === undefined ? occurrences[element] = 1 : occurrences[element]++;
        });

        return occurrences;
    }
}