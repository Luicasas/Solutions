import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVa10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text;
        TreeSet<String> set = new TreeSet<>();
        while ((text = in.readLine()) != null) {
            text = removeCharacters(text);
            text = text.toLowerCase();
            StringTokenizer st = new StringTokenizer(text);
            while (st.hasMoreTokens()) {
                set.add(st.nextToken());
            }
        }
        for (String word : set) {
            System.out.println(word);
        }
    }
    public static String removeCharacters(String text) {
        return text.replaceAll("[^a-zA-Z]+", " ");
    }
}