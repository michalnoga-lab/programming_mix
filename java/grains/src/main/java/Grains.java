import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.IntStream;

class Grains {

    BigInteger computeNumberOfGrainsOnSquare(final int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.valueOf(2).pow(square - 1);
    }

    BigInteger computeTotalNumberOfGrainsOnBoard() {
        return BigInteger.valueOf(2).pow(64).subtract(BigInteger.ONE);
    }
}