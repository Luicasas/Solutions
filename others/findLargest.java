import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class findLargest {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> ts = new TreeSet<>();
        String values = in.readLine();
        StringTokenizer st = new StringTokenizer(values);
        while (st.hasMoreTokens()) {
            ts.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(ts.last());
    }
}
