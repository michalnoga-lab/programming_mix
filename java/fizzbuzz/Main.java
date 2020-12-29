public class Main {
    public static void main(String[] args) {

        printFizzBuzz(100);
    }

    private static void printFizzBuzz(int toNumber) {
        for (int i = 1; i < toNumber + 1; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}