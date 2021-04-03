package e1.Modes;

import e1.*;

public class Manual implements EstadoTermostato {
    private static final Manual instancia = new Manual();
    private Manual(){};
    public static Manual getInstancia() {return instancia; }

    @Override
    public void changeOff(Termostato t){
        t.setApagada();
        t.setEstado(Off.getInstancia());
    }

    public void changeTimer(Termostato t, int tiempo){
        t.setTiempo(tiempo);

        if(tiempo > 0) t.setEncencida();
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
        return "M";
    }


}
