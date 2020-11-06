import java.util.ArrayList;
import java.util.List;

class LuhnValidator {

    boolean isValid(String candidate) {
        if (candidate.length() <= 1 || !candidate.matches("[\\d\\s]+") || candidate.startsWith(" ")) {
            return false;
        }
        List<Integer> convertedDigits = new ArrayList<>();
        String candidateToProcess = candidate.replaceAll("[^\\d]", "");

        for (int i = candidateToProcess.length() - 1; i > 0; i -= 2) {
            convertedDigits.add(0, (int) candidateToProcess.charAt(i) - 48);
            convertedDigits.add(0, calculateDigit(candidateToProcess.charAt(i - 1) - 48));
        }

        int sum = convertedDigits
                .stream()
                .reduce(Integer::sum)
                .orElseThrow();

        return sum % 10 == 0;
    }

    private int calculateDigit(int input) {
        int number = input * 2;
        return number > 9 ? number - 9 : number;
    }
}