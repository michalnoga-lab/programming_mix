import java.util.stream.IntStream;

class Hamming {

    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.isEmpty() && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftStrand.length() > 0 && rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.left = leftStrand;
        this.right = rightStrand;
    }

    long getHammingDistance() {

        return IntStream.range(0, left.length())
                .filter(idx -> left.charAt(idx) != right.charAt(idx))
                .count();
    }
}