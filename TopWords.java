import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // Указываем путь к текстовому файлу
        String filePath = "svo.txt";

        // Создаем объект File для чтения файла
        File file = new File(filePath);

        // Создаем Map для хранения слов и их частоты
        Map<String, Integer> wordCount = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            // Читаем файл по словам
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", "");
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        // Создаем список из элементов Map для сортировки
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());

        // Сортируем по убыванию частоты
        sortedWords.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        // Выводим топ-10 слов
        System.out.println("Топ-10 самых частых слов:");
        for (int i = 0; i < Math.min(10, sortedWords.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
