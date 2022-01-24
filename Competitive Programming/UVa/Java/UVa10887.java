import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        int tCases = 0;

        while (t-- > 0) {
            ArrayList<String> A = new ArrayList<>();
            ArrayList<String> B = new ArrayList<>();
            ArrayList<String> result = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int i = 0; i < a; i++) {
                A.add(in.readLine());
            }
            for (int i = 0; i < b; i++) {
                B.add(in.readLine());
            }
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    result.add(A.get(i) + B.get(j));
                }
            }
            TreeSet<String> ans = new TreeSet<>(result);
            tCases += 1;
            System.out.println("Case " + tCases + ":" + " " + ans.size());
        }
    }
}
