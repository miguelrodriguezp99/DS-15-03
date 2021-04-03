package e1.Observers;

import e1.Modes.Manual;
import e1.Modes.Off;
import e1.Modes.Program;
import e1.Modes.Timer;
import e1.Termostato;

import java.util.ArrayList;
import java.util.List;

public class ObserverTemperature implements Observer {
    int timer = Integer.MIN_VALUE;
    float temperature = Integer.MAX_VALUE;
    private final List<String> obsTemp = new ArrayList<>();


    //Este observador se encargar de actualizar si la calefaccion está encendida o apagada
    @Override
    public String update(Subject s) {
        Termostato t = (Termostato) s;

        //Si el tiempo o la temperatura no se han modificado entonces este observador no hace nada
        if(t.getTiempo() == timer && t.getTemperatura() == temperature) return null;

        timer = t.getTiempo();
        temperature = t.getTemperatura();

        if(t.getEstado() instanceof Timer) obsTemp.add(t.getTemperatura() + " Modo Timer " + "(faltan " +t.getTiempo() + " minutos) - Calefacción encendida.");

        if(t.getEstado() instanceof Off){
            if(t.getEncendida()) obsTemp.add(t.getTemperatura() + " Modo Off - Calefacción encendida.");
            else obsTemp.add(t.getTemperatura() + " Modo Off - Calefacción apagada.");
        }

        if(t.getEstado() instanceof Manual) obsTemp.add(t.getTemperatura() + " Modo Manual - Calefacción encendida.");

        if(t.getEstado() instanceof Program){

            if(t.getEncendida()) obsTemp.add(t.getTemperatura() + " Modo Program - Calefacción encendida.");
            else obsTemp.add(t.getTemperatura() + " Modo Program" + " (a " + t.getTemperatura() + " grados) - Calefacción apagada.");
        }

        t.addToLog(obsTemp.get(obsTemp.size()-1));

        return obsTemp.size() > 0 ? obsTemp.get(obsTemp.size()-1) : null;

    }

    @Override
    public String getObserverList() {
        return obsTemp.toString();
    }
}

