package e1.Modes;

import e1.EstadoTermostato;
import e1.Termostato;

public class Timer implements EstadoTermostato {
    private static final Timer instancia = new Timer();
    private Timer(){};
    public static Timer getInstancia() {return instancia; }

    @Override
    public void changeOff(Termostato t){
        t.setApagada();
        t.setEstado(Off.getInstancia());
    }

    public void changeManual(Termostato t){
        t.setEncencida();
        t.setEstado(Manual.getInstancia());
    }

    public void newTemperature(Termostato t, float temperatura){
        t.setTemperatura(temperatura);

        if(t.getTiempo()-5 > 0) {
            t.setTiempo(t.getTiempo()-5);
        }else {
            t.setTiempo(0);
            t.changeOff();
        }

    }

    @Override
    public String modeString(Termostato t) {
        return "  T " + t.getTiempo();
    }
}
