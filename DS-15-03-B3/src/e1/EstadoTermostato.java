package e1;

public interface EstadoTermostato {

    default void changeOff(Termostato t){throw new UnsupportedOperationException();}
    default void changeManual(Termostato t){throw new UnsupportedOperationException();}
    default void changeTimer(Termostato t, int tiempo){throw new UnsupportedOperationException();}
    default void changeProgram(Termostato t, float tMin){throw new UnsupportedOperationException();}
    default void newTemperature(Termostato t, float temperatura){
        t.setTemperatura(temperatura);
    }
    String modeString(Termostato t);

}
