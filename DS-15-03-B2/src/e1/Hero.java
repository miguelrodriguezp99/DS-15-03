package e1;

import java.util.Random;

public abstract class Hero {
    private final String nombre;
    private int vida = 0;
    private int armadura;
    private boolean done = false;


    public abstract void fight(int tirada, Bestias b);

    protected Hero(String nombre, int vida, int armadura) {
        if(nombre == null || vida == 0){
            throw new IllegalArgumentException("El nombre o la vida no pueden ser null");
        }
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
    }

    void setHP(int danho){
        if(danho > this.armadura){
            this.vida = this.vida - (danho-armadura);
        }
    }

    void setHPorcos(int danho) {
        int armor=this.armadura;
        if(!done){
        armor = (int) (armadura - armadura * 0.10);
        done = true;
    }
        if(danho > armor){
            this.vida = this.vida - (danho-armor);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }
}
