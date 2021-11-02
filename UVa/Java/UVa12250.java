import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa12250 {
    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s;
        int tc = 1;

        while ((s = in.readLine()) != null && !s.equals("#")) {
            if (s.equals("HELLO")) {
                System.out.println("Case " + tc++ + ": ENGLISH");
            } else if (s.equals("HOLA")){
                System.out.println("Case " + tc++ + ": SPANISH");
            } else if (s.equals("HALLO")){
                System.out.println("Case " + tc++ + ": GERMAN");
            } else if (s.equals("BONJOUR")) {
                System.out.println("Case " + tc++ + ": FRENCH");
            } else if (s.equals("CIAO")) {
                System.out.println("Case " + tc++ + ": ITALIAN");
            } else if (s.equals("ZDRAVSTVUJTE")) {
                System.out.println("Case " + tc++ + ": RUSSIAN");
            } else {
                System.out.println("Case " + tc++ + ": UNKNOWN");
            }
        }

    }
}
