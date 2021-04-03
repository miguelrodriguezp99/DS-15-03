package e1.Modes;

import e1.EstadoTermostato;
import e1.Termostato;

public class Off implements EstadoTermostato {
    private static final Off instancia = new Off();
    private Off(){};
    public static Off getInstancia() {return instancia; }

    @Override
    public void changeManual(Termostato t){
        t.setEncencida();

        t.setEstado(Manual.getInstancia());
    }

    public void changeTimer(Termostato t, int tiempo){
        t.setTiempo(tiempo);
        if(tiempo > 0) t.setEncencida();
        else t.setApagada();

        t.setEstado(Timer.getInstancia());
    }

    public void changeProgram(Termostato t, float temperatura){
        t.settMin(temperatura);
        if(t.getTemperatura() < temperatura) t.setEncencida();
        else t.setApagada();

        t.setEstado(Program.getInstancia());
    }

    @Override
    public String modeString(Termostato t) {
        return "O";
    }

}
