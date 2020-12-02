import java.util.Arrays;
import java.util.stream.IntStream;

class DifferenceOfSquaresCalculatorFirstSolution {

    int computeSquareOfSumTo(int input) {
        return (int) Math.pow(Arrays.stream(createArray(input)).sum(), 2);
    }

    int computeSumOfSquaresTo(int input) {
        return Arrays.stream(createArray(input))
                .map(element -> (int) Math.pow(element, 2))
                .sum();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

    private int[] createArray(int maxElement) {
        return IntStream.range(1, maxElement + 1).toArray();
    }
}