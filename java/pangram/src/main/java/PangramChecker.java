public class PangramChecker {

    public boolean isPangram(String input) {

        for (int i = 97; i <= 122; i++) {
            char currentChar = (char) i;

            if (!input.toLowerCase().contains(String.valueOf(currentChar))) {
                return false;
            }
        }
        return true;
    }
}