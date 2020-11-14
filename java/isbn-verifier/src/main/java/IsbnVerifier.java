class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String stringToVerifyPured = stringToVerify.replaceAll("-", "");

        if (stringToVerifyPured.length() != 10) {
            return false;
        }

        int verifySum = 0;

        for (int i = 0; i < stringToVerifyPured.length(); i++) {
            if (String.valueOf(stringToVerifyPured.charAt(i)).matches("X")) {
                verifySum += 10;
            } else {
                verifySum += (stringToVerifyPured.length() - i) * (stringToVerifyPured.charAt(i) - 48);
            }
        }

        return verifySum % 11 == 0;
    }
}