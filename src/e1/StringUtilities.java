package e1;


import java.util.Random;

public class StringUtilities {

    String a = "Bye";
    String b = "World";
    /**
     * Checks if a given string is a valid c of two others . That is , it contains
     * all characters of the other two and order of all characters in the individual
     * strings is preserved .
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @param c Mix of the two other Strings
     * @return true if the c is valid , false otherwise
     */

    /**
     * Generates a random valid mix for two Strings
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @return A String that is a random valid mix of the other two .
     */
    public static boolean isValidMix ( String a , String b , String c ) {

    char [] a1 = a.toCharArray();
    char [] b1 = b.toCharArray();
    char [] c1 = c.toCharArray();
    
    boolean result = true ;

    int x=0; //tocho
    int y=0; //bye
    int z=0; //world
        if(c.length() > a.length() + b.length())
        {
            return false;
        }
        if(c.length() < a.length() + b.length())
        {
            return false;
        }

    while(x<a.length() + b.length() && result){
        if (y<a.length() && c1[x] == a1[y] ){
            x++;
            y++;
        }
        else if(z<b.length()&& c1[x]==b1[z]){
            x++;
            z++;
        }else {
            result = false;
        }
    }

    return result;
    /**
     * Generates a random valid mix for two Strings
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @return A String that is a random valid mix of the other two .
     */
    }
    public static String generateRandomValidMix (String a , String b) {


        Random random = new Random();
        int ap = a.length(),bp = b.length();
        StringBuilder sb = new StringBuilder(ap+bp);
        int i=0;
        int c1 = 0, c2=0;


        while(i<ap+bp)
        {
            if(random.nextInt()%2==0&& c1<ap){
                sb.append(a.charAt(c1));
                c1++; i++;
            }
            if (c2<bp){
                sb.append(b.charAt(c2));
                c2++; i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(isValidMix("Bye","World",generateRandomValidMix("Bye", "World")));

        System.out.println(generateRandomValidMix("Bye", "World"));

    }
}




