import java.io.*;

public class UVa11661 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int L = Integer.parseInt(in.readLine());
            if (L == 0) break;

            String s = in.readLine();
            int distance = Integer.MAX_VALUE, positionR = -1, positionD = -1, abs;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'Z') {
                    distance = 0;
                    break;
                } else if (s.charAt(i) == 'R') {
                    positionD = i;
                } else if (s.charAt(i) == 'D') {
                    positionR = i;
                } else {
                    continue;
                }
                if (positionR != -1 && positionD != -1) {
                    distance = Math.min(Math.abs(positionD - positionR), distance);
                }
            }
            System.out.println(distance);
        }

    }
}
