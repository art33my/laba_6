import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SalesTracker {
    private final ConcurrentHashMap<String, Integer> sales = new ConcurrentHashMap<>();

    // Добавить продажу товара
    public void addSale(String product, int quantity) {
        sales.merge(product, quantity, Integer::sum);
    }

    // Показать все товары и их количество продаж
    public void showSales() {
        sales.forEach((product, quantity) -> 
            System.out.println("Товар: " + product + ", Продажи: " + quantity));
    }

    // Посчитать общую сумму продаж
    public int getTotalSales() {
        return sales.values().stream().mapToInt(Integer::intValue).sum();
    }

    // Найти наиболее популярный товар
    public String getMostPopularProduct() {
        return sales.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет продаж");
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addSale("Яблоки", 10);
        tracker.addSale("Бананы", 5);
        tracker.addSale("Яблоки", 15);
        tracker.addSale("Виноград", 7);

        System.out.println("Список продаж:");
        tracker.showSales();

        System.out.println("\nОбщая сумма продаж: " + tracker.getTotalSales());
        System.out.println("Самый популярный товар: " + tracker.getMostPopularProduct());
    }
}
