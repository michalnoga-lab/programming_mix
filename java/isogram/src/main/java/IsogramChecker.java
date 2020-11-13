class IsogramChecker {

    boolean isIsogram(String phrase) {

        for (int i = 0; i < phrase.length(); i++) {
            if (arrayContainsElement(phrase.substring(i + 1), phrase.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean arrayContainsElement(String phrase, char letter) {
        return phrase.toLowerCase().replaceAll("-", "").replaceAll("\\s", "")
                .contains(String.valueOf(letter).toLowerCase());
    }
}