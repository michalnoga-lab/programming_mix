import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class zadanie_03_daty {
    public static void main(String[] args) {
        List<String> dataFromUser = getDatesFromFile("example_dates.csv");
        List<LocalDate> validDates = new ArrayList<>();
        List<String> invalidDates = new ArrayList<>();

        dataFromUser
                .forEach(date -> {
                    try {
                        validDates.add(LocalDate.parse(date));
                    } catch (Exception e) {
                        invalidDates.add(date);
                    }
                });

        System.out.println(dataFromUser);
        System.out.println(validDates);
        System.out.println(invalidDates);

        Optional<LocalDate> earliestDateOptional = findEarliestDate(validDates);
        System.out.println(earliestDateOptional.map(localDate -> "Najwcześniejsza prawidłowa data to: " + localDate)
                .orElse("Nie podano żdanej prawidłowej daty."));

        Optional<LocalDate> latestDate = findLatestDate(validDates);
        System.out.println(latestDate.map(localDate -> "Najpóźniejsza prawidłowa data to: " + localDate)
                .orElse("Nie podano żadnej prawidłowej daty"));

        Optional<Long> differenceInDays = calculateDifferenceInDays(validDates);
        System.out.println(differenceInDays.map(difference -> "Różnica w dniach wynosi: " + difference)
                .orElse("Nie podano żadnej prawidłowej daty"));

        System.out.println(differenceInDays.map(difference -> "Różnica w godzinach wynosi: " + difference * 24)
                .orElse("Nie podano żadnej prawidłowej daty"));

        System.out.println(differenceInDays.map(difference -> "Różnica w sekundach wynosi: " + difference * 24 * 60 * 60)
                .orElse("Nie podano żadnej prawidłowej daty"));
    }

    private static List<String> getDatesFromFile(String fileName) {
        List<String> output = new ArrayList<>();
        try {
            Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.dir") + "/src/" + fileName));
            stream
                    .forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    private static Optional<LocalDate> findEarliestDate(List<LocalDate> dates) {
        return dates
                .stream()
                .min(Comparator.comparing(date -> date));
    }

    private static Optional<LocalDate> findLatestDate(List<LocalDate> dates) {
        return dates
                .stream()
                .max(Comparator.comparing(date -> date));
    }

    private static Optional<Long> calculateDifferenceInDays(List<LocalDate> dates) {
        Optional<LocalDate> earliestDate = findEarliestDate(dates);
        Optional<LocalDate> latestDate = findLatestDate(dates);

        return earliestDate.isPresent() && latestDate.isPresent() ?
                Optional.of(ChronoUnit.DAYS.between(earliestDate.get(), latestDate.get())) : Optional.empty();
    }
}