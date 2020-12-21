import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(printFibonacciSequence(30));
    }

    private static List<Integer> printFibonacciSequence(int toNumber) {
        List<Integer> result = new ArrayList<>(List.of(0, 1));
        if (toNumber == 0) {
            return result.subList(0, 1);
        } else if (toNumber == 1) {
            return result.subList(0, 2);
        } else {
            for (int i = 0; i < toNumber + 1; i++) {
                result.add(result.get(result.size() - 2) + result.get(result.size() - 1));
            }
        }
        return result;
    }
}