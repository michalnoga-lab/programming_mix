class LargestSeriesProductCalculator {
    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        } else if (numberOfDigits == 0) {
            return 1;
        } else if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        } else if (!inputNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        long biggestSeriesValue = 0;

        for (int i = 0; i < inputNumber.length() - numberOfDigits + 1; i++) {
            long temporaryBiggest =
                    inputNumber.substring(i, i + numberOfDigits)
                            .chars()
                            .map(el -> el - 48)
                            .reduce((i1, i2) -> i1 * i2)
                            .orElseThrow();

            if (temporaryBiggest > biggestSeriesValue) {
                biggestSeriesValue = temporaryBiggest;
            }
        }
        return biggestSeriesValue;
    }
}