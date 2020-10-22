package e1;


import java.util.Random;

public class StringUtilities {

    public static boolean isValidMix(String a, String b, String c) {

        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        char[] c1 = c.toCharArray();

        boolean result = true;

        int x = 0;
        int y = 0;
        int z = 0;
        if (c.length() > a.length() + b.length()) {
            return false;
        }
        if (c.length() < a.length() + b.length()) {
            return false;
        }

        while (x < a.length() + b.length() && result) {
            if (y < a.length() && c1[x] == a1[y]) {
                x++;
                y++;
            } else if (z < b.length() && c1[x] == b1[z]) {
                x++;
                z++;
            } else {
                result = false;
            }
        }
        return result;
    }

    public static String generateRandomValidMix(String a, String b) {

        Random random = new Random();
        int ap = a.length(), bp = b.length();
        StringBuilder sb = new StringBuilder(ap + bp);
        int i = 0;
        int c1 = 0, c2 = 0;


        while (i < ap + bp) {
            if (random.nextInt() % 2 == 0 && c1 < ap) {
                sb.append(a.charAt(c1));
                c1++;
                i++;
            }
            if (c2 < bp) {
                sb.append(b.charAt(c2));
                c2++;
                i++;
            }
        }

        return sb.toString();
    }
}




