import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */

/**
 * @author sathp
 *
 */
public class WebScraper {
    /**
     * @param args
     */
    public static void main(final String[] args) {
        String str = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(countWords(str));
        System.out.println(findWord(str, "prince") + findWord(str, "Prince"));
    }

    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.split("\\s+");
        return words.length;
    }

    public static int findWord(String input, String word) {
        if (input.contains(word) == false) {
            return 0;
        }
        String[] instances = input.split(word);
        return instances.length;
    }

    /**
     * @param url
     * @return
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
