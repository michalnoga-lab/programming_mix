package KM_MAPY1_3;

// Przygotuj klasę Product o polach składowych name, category, price.
// Niech category będzie wartością przygotowanego przez Ciebie typu
// wyliczeniowego Category. Zaimplementuj kolekcję bez duplikatów
// przechowującą obiekty klasy Product. Kolekcję wypełnij przykładowymi
// danymi. Na podstawie kolekcji wygeneruj mapę, której kluczem jest pole
// typu Category, natomiast wartością kolekcja bez powtórzeń obiektów
// klasy Product, które posiadają pole category, takie jak klucz, któremu
// je przyporządkowano. Na podstawie mapy znajdź kategorię, dla której
// średnia cena produktów jest największa.

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final String PATH = System.getProperty("user.dir") + "\\src\\main\\java\\KM_MAPY1_3\\";

    public static void main(String[] args) {
        Set<Product> products = getProductsFromFile("products");
        Map<Category, Set<Product>> productsByCategory = groupProductsByCategory(products);

        Optional<Category> categoryWithHighestPriceAverage = findBiggestAveragePrice(productsByCategory);
        System.out.println(categoryWithHighestPriceAverage.map(category -> "Kategoria z najwyższą średnią ceną to: " + category)
                .orElse("Brak danych do wyświetlenia"));
    }

    private static Set<Product> getProductsFromFile(String fileName) {
        Set<Product> products = new HashSet<>();

        try {
            Stream<String> stream = Files.lines(Paths.get(PATH + fileName + ".csv"));
            stream
                    .forEach(line -> {
                        String[] lineSplit = line.split(",");
                        Product product = Product.builder()
                                .name(lineSplit[1])
                                .category(Category.valueOf(lineSplit[2]))
                                .price(BigDecimal.valueOf(Long.parseLong(lineSplit[3])))
                                .build();
                        products.add(product);
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private static Map<Category, Set<Product>> groupProductsByCategory(Set<Product> products) {
        return products
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new HashSet<>(entry.getValue()),
                        (v1, v2) -> v1,
                        HashMap::new
                ));
    }

    private static BigDecimal calculateAverage(Set<Product> products) {
        BigDecimal productsNumber = BigDecimal.valueOf(products.size());

        BigDecimal sum = products
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        return sum.divide(productsNumber, RoundingMode.HALF_UP);
    }

    private static Optional<Category> findBiggestAveragePrice(Map<Category, Set<Product>> products) {
        return products
                .entrySet()
                .stream()
                .max(Comparator.comparing(entry -> calculateAverage(entry.getValue())))
                .map(Map.Entry::getKey);
    }

}