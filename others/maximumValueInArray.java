import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class maximumValueInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        StringTokenizer st = new StringTokenizer(input);
        List<String> elements = new ArrayList<>();
        while (st.hasMoreTokens()) {
            elements.add(st.nextToken());
        }
        List<Integer> values = new ArrayList<>(elements.size());
        for (String numbers : elements) {
            values.add(Integer.valueOf(numbers));
        }
        System.out.println("Largest in given array is " + largest(values));
    }
    static int largest(List<Integer> arr) {
        int maximum = arr.get(0);
        for (int i = 1; i < arr.size(); i++)
            if (arr.get(i) > maximum) {
                maximum = arr.get(i);
            }
        return maximum;
    }
}
