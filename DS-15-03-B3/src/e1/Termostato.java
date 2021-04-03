package e1;

import e1.Modes.Off;
import e1.Observers.Subject;

import java.util.ArrayList;
import java.util.List;

public class Termostato extends Subject {
    EstadoTermostato estado = Off.getInstancia();
    private final List<String> logInfo = new ArrayList<>();

    float temperatura;
    int tiempo;
    boolean encendida = false;
    float tMin;

    public Termostato() {
        this.setEstado(estado);
        this.temperatura = 20;
}

    public void addToLog(String info){
        logInfo.add(info);
    }

    public void printLog(){
        for(String info : logInfo){
            System.out.println(info + "\r");
        }
    }

    public String getLog(){
        return logInfo.toString();
    }

    public float gettMin() {
        return tMin;
    }

    public void settMin(float tMin) {
        this.tMin = tMin;
    }

    public boolean getEncendida(){
        return encendida;
    }

    public void setEncencida(){
       encendida = true;
    }

    public void setApagada(){
        encendida = false;
    }

    public EstadoTermostato getEstado(){
        return estado;
    }

    public float getTemperatura(){
        return temperatura;
    }

    public void setTemperatura(float temperatura){ this.temperatura = temperatura; }

    public int getTiempo(){
        return tiempo;
    }

    public void setTiempo(int tiempo){
        this.tiempo = tiempo;
    }

    public void setEstado (EstadoTermostato estado){
        this.estado = estado;
        notifyObservers();
    }

    public void changeManual(){
        estado.changeManual(this);
    }

    public void changeOff(){
        estado.changeOff(this);
    }

    public void changeTimer(int tiempo){
        estado.changeTimer(this, tiempo);
    }

    public void changeProgram(float tMin){
        estado.changeProgram(this, tMin);
    }

    public void newTemperature(float currentTemperature){
        estado.newTemperature(this, currentTemperature);
        notifyObservers();
    }

    public String screenInfo(){ return temperatura + " " + (encendida? "ON " : "OFF") + " " + estado.modeString(this); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Termostato)) return false;

        Termostato that = (Termostato) o;

        if (Float.compare(that.getTemperatura(), getTemperatura()) != 0) return false;
        if (getTiempo() != that.getTiempo()) return false;
        if (getEncendida() != that.getEncendida()) return false;
        if (Float.compare(that.gettMin(), gettMin()) != 0) return false;
        return getEstado().equals(that.getEstado());
    }

    @Override
    public int hashCode() {
        int result = getEstado().hashCode();
        result = 31 * result + (getTemperatura() != +0.0f ? Float.floatToIntBits(getTemperatura()) : 0);
        result = 31 * result + getTiempo();
        result = 31 * result + (getEncendida() ? 1 : 0);
        result = 31 * result + (gettMin() != +0.0f ? Float.floatToIntBits(gettMin()) : 0);
        return result;
    }
}
