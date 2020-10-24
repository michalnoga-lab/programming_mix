class RaindropConverter {

    String convert(int number) {
        StringBuilder stringBuilder = new StringBuilder();

        if (isFactor(number, 3)) {
            stringBuilder.append("Pling");
        }
        if (isFactor(number, 5)) {
            stringBuilder.append("Plang");
        }
        if (isFactor(number, 7)) {
            stringBuilder.append("Plong");
        }
        if (stringBuilder.length() > 0) {
            return stringBuilder.toString();
        }
        return String.valueOf(number);
    }

    private boolean isFactor(int numberToTest, int factor) {
        return numberToTest % factor == 0;
    }
}