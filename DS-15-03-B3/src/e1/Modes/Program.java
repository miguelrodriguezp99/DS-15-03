package e1.Modes;

import e1.EstadoTermostato;
import e1.Termostato;

public class Program implements EstadoTermostato {
    private static final Program instancia = new Program();
    private Program(){};
    public static Program getInstancia() {return instancia; }

    @Override
    public void changeOff(Termostato t){
        t.setEstado(Off.getInstancia());
        t.setApagada();
    }

    public void changeManual(Termostato t){
        t.setEstado(Manual.getInstancia());
        t.setEncencida();
    }

    public void newTemperature(Termostato t, float temperatura){
        t.setTemperatura(temperatura);

        if(temperatura >= t.gettMin()) t.setApagada();
        else t.setEncencida();
    }

    @Override
    public String modeString(Termostato t) {
        return "P " + t.gettMin();
    }
}
