package e3;

import javax.crypto.spec.PSource;

public class Prueba {

    public static void main(String[] args) {

        String s = "17:25:15";
        char [] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(c[0]); sb.append(c[1]);
        int hours = Integer.valueOf(sb.toString());
       // sb = sb.append(c[1]);
        System.out.println(sb);
        System.out.println(hours);
        sb.delete(0,2);
        System.out.println(sb);
        sb.append(c[3]); sb.append(c[4]);
        System.out.println(hours + " horas");
        int minutes = Integer.parseInt(sb.toString());
        System.out.println(minutes + " minutos");
        sb.delete(0,2); sb.append(c[6]); sb.append(c[7]);
        int segundos = Integer.parseInt(sb.toString());
        System.out.println(segundos + " segundos");
    }
}
