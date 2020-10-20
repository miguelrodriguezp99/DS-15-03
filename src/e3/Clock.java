package e3;

import javax.crypto.spec.PSource;
import javax.swing.*;
import java.security.PrivilegedActionException;

public class Clock {

    private int hours;
    private int minutes;
    private int seconds;


    public enum Period { AM, PM, Null };
    Period period = Period.Null;

    public Clock (String s) {


        char[] c = s.toCharArray();
            if (c[0] > '2' || c[0] == '2' && c[1] > '4') {
                throw new IllegalArgumentException("Hora no valida");
            }
            if (c[3] > '6' && c[4] > '0') {
                throw new IllegalArgumentException("Hora no valida");
            }
            if (c[6] > '6' && c[7] > '0') {
                throw new IllegalArgumentException("Hora no valida");
            }

            if(c.length>8)
            {
                if(c[9] != 'A' && c[9] != 'P')
                {
                    throw new IllegalArgumentException("Hora no valida");
                }
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
            int x = 9;
            while(x < c.length-1)
            {
                if(c[x] == 'P')
                {
                    period = Period.PM;
                    x++;
                }
                else
                {
                    period = Period.AM;
                    x++;
                }
            }


            if (hours > 11 && period != Period.AM) {
                period = Period.PM;
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

        this.hours = hora;
        this.minutes = minutos;
        this.seconds = segundos;

        if (hours > 11) {
            period = Period.PM;
            this.hours = hours - 12;
        }


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

        if(period == Period.AM && hours > 12 || minutes > 59 || seconds > 59 || hours <0 || minutes < 0 || seconds < 0 || period == Period.PM && hours > 24)
        {

            throw new IllegalArgumentException("Hora no valida");
        }


        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.period = period;

    }


    public int getHours24 () {


        if(hours == 12 && period == Period.AM)
        {
            hours = 00;
            return hours;
        }
        if(period == Period.PM || period == Period.AM)
        {
            hours = hours + 12;
            return hours;
        }
        else
        {
            return hours;
        }
    }

    public int getHours12 () {

        if(hours == 12 && period == Period.AM)
        {
            return hours;
        }
        if(hours > 11)
        {
            hours = hours -12;
            return this.hours;
        }

     if(hours > 11 && period != Period.AM && period != Period.PM)
     {
         return hours -12;
     }
     else
     {
         return hours;
     }
    }

    public int getMinutes () {
        return minutes;
    }
    /**
     * Returns the seconds of the clock .
     * @return the seconds .
     */
    public int getSeconds () {
        return seconds;
    }

    public Period getPeriod () {
        if(hours > 11 && period == Period.Null)
        {
            return Period.PM;
        }
        else if(period == Period.AM || period == Period.PM){
            return period;
        }
        else
        {
            return period;
        }

    }

    public String printHour24 () {


        String horas = null;
        String minutos = null;
        String segundos;
        this.hours = getHours24();
        this.minutes = getMinutes();
        this.seconds = getSeconds();

        if(this.hours<10){
            horas = "00";
        }
        else
        {
            horas = Integer.toString(this.hours);
        }

        if(this.minutes<10){
            minutos = "0" + this.minutes;
        }
        else
        {
            minutos = Integer.toString(this.minutes);
        }
        if(this.seconds<10){
            segundos = "0" + this.seconds;
        }
        else
        {
            segundos = Integer.toString(this.seconds);
        }
        if(getHours24() == 24)
        {
            horas = "00";
        }

        return horas +":" + minutos +":" + segundos;


    }


    public String printHour12 () {

        String horas = null;
        String minutos = null;
        String segundos;
        this.hours = getHours12();
        this.minutes = getMinutes();
        this.seconds = getSeconds();

        if(this.hours<10){
            horas = "0" + this.hours;
        }
        else
        {
            horas = Integer.toString(this.hours);
        }
        if(this.minutes<10){
            minutos = "0" + this.minutes;
        }
        else
        {
            minutos = Integer.toString(this.minutes);
        }
        if(this.seconds<10){
            segundos = "0" + this.seconds;
        }
        else
        {
            segundos = Integer.toString(this.seconds);
        }

        return horas +":" + minutos +":" + segundos + " " + period;



    }



/*  Clock c1 = new Clock(17, 30, 30);
    Clock c2 = new Clock( 5, 30, 30, Clock.Period.PM);
    Clock c3 = new Clock( 5 ,30, 30, Clock.Period.AM);

    assertEquals(c2, c1);
    assertEquals(c1, c2);*/

    @Override
    public boolean equals (Object obj) {

        if(((Clock) obj) == null)
        {
            return false;
        }
        if(this.getPeriod() != ((Clock) obj).getPeriod())
        {
            return false;
        }
        if(this == obj) {return true;}
        if(obj == null) {return false;}
        if (this.getClass() != obj.getClass()) { return false; }

        if(this.period != Period.Null && ((Clock) obj).period == Period.Null)
        {
            if(this.hours == 24) { this.hours = 0; }
            this.hours = hours - 12;
            return this.hours == ((Clock) obj).hours && this.minutes == ((Clock) obj).minutes && this.seconds == ((Clock) obj).seconds;
        }
        else
        {
            if(this.hours == ((Clock) obj).hours && this.minutes == ((Clock) obj).minutes && this.seconds == ((Clock) obj).seconds)
            {
                return true;
            }
        }
        return false;
    }


    @Override
    public int hashCode () {
        int result;
        long temp;

        result = getHours12();
        result = 31 * result + minutes;
        result = 31 * result + seconds;
        if(period == Period.PM)
        {
            result = 31 * result + 100;
        }
        else
        {
            result = 31 * result + 1000;
        }
        return result;
    }













    /**
     * Returns the hours of the clock in 12h format
     * @return the hours in 12h format
     */



    public static void main(String[] args) {
        String reloj = "17:25:15";
    }


}
