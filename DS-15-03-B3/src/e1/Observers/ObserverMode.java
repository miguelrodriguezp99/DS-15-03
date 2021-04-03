package e1.Observers;

import e1.*;
import e1.Modes.Manual;
import e1.Modes.Off;
import e1.Modes.Program;
import e1.Modes.Timer;

import java.util.ArrayList;
import java.util.List;

public class ObserverMode implements Observer {
    EstadoTermostato estado = Off.getInstancia();
    private final List<String> obsMode = new ArrayList<>();


    //Este observador se encarga de notificar si el estado del termostato ha cambiado
    @Override
    public String update(Subject s) {
        Termostato t = (Termostato) s;

        //Si el estado del termostato es el mismo entonces este observador no hace nada.
        if(t.getEstado() == estado) return null;

        //Si ha cambiado entonces añadimos a la lista el mensaje correspondiente
        if(estado instanceof Timer && t.getEstado() instanceof Off) {
            obsMode.add("Se desactiva el modo Timer.");
            estado = t.getEstado();
        }

        if (estado != t.getEstado()){

            estado = t.getEstado();

            if(estado instanceof Off) obsMode.add("Se activa el modo Off.");
            if(estado instanceof Program) obsMode.add("Se activa el modo Program a " + t.gettMin() + " grados.");
            if(estado instanceof Manual) obsMode.add("Se activa el modo Manual.");
            if(estado instanceof Timer) obsMode.add("Se activa el modo Timer " + t.getTiempo() + " minutos.");
        }

        t.addToLog(obsMode.get(obsMode.size()-1));

        return obsMode.size() > 0 ? obsMode.get(obsMode.size()-1) : null;
    }

    @Override
    public String getObserverList() {
        return obsMode.toString();
    }
}