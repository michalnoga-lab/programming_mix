public class Main {
    public static void main(String[] args) {

        int first = generateRandomNumber(10, 30);
        int second = generateRandomNumber(10, 30);

        System.out.println("Wylosowano liczbę: " + first);
        System.out.println("Wylosowano liczbę: " + second);

        System.out.println(checkNumbers(first, second) ? "TAK" : "NIE");
    }

    private static int generateRandomNumber(int from, int to) {
        return (int) Math.floor(Math.random() * (to - from) + from);
    }

    private static boolean checkNumbers(int first, int second) {
        String[] firstArray = String.valueOf(first).split("");
        String[] secondArray = String.valueOf(second).split("");

        return Integer.parseInt(firstArray[0]) > Integer.parseInt(secondArray[0]) &&
                Integer.parseInt(firstArray[1]) > Integer.parseInt(secondArray[1]);
    }
}