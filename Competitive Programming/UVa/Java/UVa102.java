import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa102 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int[][] permutations =
                {{0, 1, 2}, {0, 2, 1}, {1, 2, 0}, {1, 0, 2}, {2, 0, 1}, {2, 1, 0}};
        int[][] bottles = new int[3][3];
        char[] bottleType = {'B', 'G', 'C'};

        while ((s = in.readLine()) != null) {
            int min = Integer.MAX_VALUE;
            String result = "";
            StringTokenizer st = new StringTokenizer(s);

            while (st.hasMoreTokens()) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        bottles[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }

            for (int[] permutation : permutations) {
                int movements = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (permutation[j] != k) {
                            movements += bottles[j][k];
                        }
                    }
                }
                String finalMovement = "" + bottleType[permutation[0]] + bottleType[permutation[1]] +
                        bottleType[permutation[2]];
                if (min == Integer.MAX_VALUE || min > movements ||
                        movements == min && finalMovement.compareTo(result) < 0) {
                    min = movements;
                    result = finalMovement;
                }
            }

            System.out.println(result + " " + min);
        }
    }
}
