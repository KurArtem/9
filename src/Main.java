import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    protected static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        var key = -1;
        while (key != -2) {
            key = Integer.parseInt(scanner.nextLine());
            RussianTranslation russianTranslation = new RussianTranslation(key);
            EnglishTranslation englishTranslation = new EnglishTranslation(key);
            Thread ru = new Thread(russianTranslation);
            Thread en = new Thread(englishTranslation);

            ru.start();
            en.start();

            Thread output = new Thread(() -> {
                out.printf("Русский: %s%n", russianTranslation.rT);
                out.printf("English: %s%n", englishTranslation.eT);
            });

            ru.join();
            en.join();
            output.start();
        }
    }
}
