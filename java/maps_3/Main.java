import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final String PATH = System.getProperty("user.dir") + "\\src\\main\\java\\";

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