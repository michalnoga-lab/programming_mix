public class Main {
    public static void main(String[] args) {

        int first = generateNumber(10, 99);
        int second = reverseNumber(first);

        System.out.println("Wylosowano liczbę: " + first);
        System.out.println("Wygenerowano liczbę: " + second);

    }

    private static int generateNumber(int from, int to) {
        return (int) Math.floor(Math.random() * (to - from) + from);
    }

    private static int reverseNumber(int number) {
        String[] numberArray = String.valueOf(number).split("");
        return Integer.parseInt(numberArray[1] + numberArray[0]);
    }
}