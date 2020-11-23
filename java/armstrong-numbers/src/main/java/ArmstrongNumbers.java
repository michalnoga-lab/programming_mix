class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int power = String.valueOf(numberToCheck).length();
        int calculationResult = 0;

        for (int i = 0; i < power; i++) {
            int currentNumber = Integer.parseInt(String.valueOf(numberToCheck).substring(i, i + 1));
            calculationResult += Math.pow(currentNumber, power);
        }
        return calculationResult == numberToCheck;
    }
}