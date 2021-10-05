import java.io.*;

public class UVa272 {
    public static void main(String[] args) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s;
        boolean v = true;
        while ((s = in.readLine()) != null) {
            for (int i = 0; i < s.length(); i++) {
                if (v) {
                    if (s.charAt(i) == '"') {
                        v = false;
                        System.out.print("``");
                        continue;
                    }
                } else {
                    if (s.charAt(i) == '"') {
                        v = true;
                        System.out.print("''");
                        continue;
                    }
                }
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }
        in.close();
    }
}