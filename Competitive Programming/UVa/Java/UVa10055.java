import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa10055 {

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String ln;

        while ((ln = in.readLine()) != null ) {
            StringTokenizer st = new StringTokenizer(ln);
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            System.out.println(Math.abs(y - x));

        }


    }

}
