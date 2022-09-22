public class Converter {

    protected int convertNumber(int number, int base) {
        int output = 0;
        int power = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            output += lastDigit * Math.pow(base, power);
            number /= 10;
            power++;
        }
        return output;
    }

    protected int convertNumber(String number, int base) {
        int output = 0;
        int power = 0;
        char[] numberArray = number.toCharArray();

        for (int i = numberArray.length - 1; i >= 0; i--) {
            int currentNumber = numberArray[i];
            if (currentNumber - 48 <= 9) {
                output += (currentNumber - 48) * Math.pow(base, power);
            } else {
                output += (currentNumber - 55) * Math.pow(base, power);
            }
            power++;
        }
        return output;
    }
}