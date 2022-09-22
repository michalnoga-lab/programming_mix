public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();

        System.out.println("Converted binary number 100100100 in decimal system is " + converter.convertNumber(100100100, 2));
        System.out.println("Converted octal number 333 in decimal system is " + converter.convertNumber(333, 8));
        System.out.println("Converted 4 system number 555 in decimal system is " + converter.convertNumber(555, 4));
        System.out.println("Converted hexadecimal number 2AF7 in decimal system is " + converter.convertNumber("2AF7", 16));
        System.out.println("Converted hexadecimal number 1AAFFD0 in decimal system is " + converter.convertNumber("1AAFFD0", 16));
        System.out.println("Converted 7 system number 63565 in decimal system is " + converter.convertNumber(63565, 7));
    }
}