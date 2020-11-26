package e1;

public abstract class Beasts {
    private final String nombre;
    private int vida;
    private final int armadura;

    public abstract void fight(int tirada, Hero b); // Metodo fight
    public abstract String getClase(); // Metodo que devuelve si es un Orco o un Trasgo para aplicar las diferenciaciones al atacar

    public Beasts(String nombre, int vida, int armadura) { //Constructor
        if(nombre == null || vida == 0){
            throw new IllegalArgumentException("El nombre o la vida no pueden ser null");
        }
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
    }

    void setVida(int danho){ //Metodo para actualizar la vida
        if(danho > this.armadura){
            this.vida = this.vida - (danho-armadura);
        }
    }

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }

}
