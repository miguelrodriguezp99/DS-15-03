package e3;

import java.security.PrivilegedActionException;

public class Clock {

    private int hours;
    private int minutes;
    private int seconds;


    public enum Period { AM, PM, Null };
    Period period = Period.Null;

    public Clock (String s) {


        char[] c = s.toCharArray();
        int i = 0;
        while (i < c.length) {
            if (c[0] > '2' || c[0] == '2' && c[1] > '4') {
                throw new IllegalArgumentException("Hora no valida");
            }
            if (c[3] > '6' && c[4] > '0') {
                throw new IllegalArgumentException("Hora no valida");
            }
            if (c[6] > '6' && c[7] > '0') {
                throw new IllegalArgumentException("Hora no valida");
            }


            StringBuilder sb = new StringBuilder();
            sb.append(c[0]);
            sb.append(c[1]);
            hours = Integer.parseInt(sb.toString());
            sb.delete(0, 2);
            sb.append(c[3]);
            sb.append(c[4]);
            minutes = Integer.parseInt(sb.toString());
            sb.delete(0, 2);
            sb.append(c[6]);
            sb.append(c[7]);
            seconds = Integer.parseInt(sb.toString());

            if (hours > 12) {
                period = Period.AM;
            }

        }

    }
/*
    }

    /**
     * Creates a clock given the values in 24h format .
     * @param hours Hours in 24h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */

    public Clock (int hora,int minutos,int segundos ) {

        if(hours > 23 || minutes > 59 || seconds > 59 || hours <0 || minutes < 0 || seconds < 0)
        {
            throw new IllegalArgumentException("Hora no valida");
        }

        this.hours = segundos;
        this.minutes = segundos;
        this.seconds = segundos;

    }

    /**
     * Creates a clock given the values in 12h format . Period is a enumeration
     * located inside the Clock class with two values : AM and PM.
     * @param hours Hours in 12h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @param period Period used by the Clock ( represented by an enum ).
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */
    public Clock ( int hours , int minutes , int seconds , Period period ) {

        if(period == period.AM && hours > 11 || minutes > 59 || seconds > 59 || hours <0 || minutes < 0 || seconds < 0)
        {
            throw new IllegalArgumentException("Hora no valida");
        }

        if(period == period.PM && hours > 23 || minutes > 59 || seconds > 59 || hours <0 || minutes < 0 || seconds < 0)
        {
            throw new IllegalArgumentException("Hora no valida");
        }

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

    }


    public int getHours24 () {
        if(period == period.AM || period == period.PM)
        {
            return this.hours + 12;
        }
        else
        {
            return hours;
        }
    }

    public int getHours12 () {
     if(hours > 11 && period != period.AM && period != period.PM)
     {
         return hours -12;
     }
     else
     {
         return hours;
     }
    }


    /**
     * Returns the hours of the clock in 12h format
     * @return the hours in 12h format
     */



    public static void main(String[] args) {
        String reloj = "17:25:15";
    }


}
