package e1;

public abstract class Bestias {
    private final String nombre;
    private int vida;
    private final int armadura;

    public abstract void fight(int tirada, Hero b);
    public abstract String getClase();

    public Bestias(String nombre, int vida, int armadura) {

        if(nombre == null || vida == 0){
            throw new IllegalArgumentException("El nombre o la vida no pueden ser null");
        }

        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
    }




    void setHP(int danho){
        if(danho > this.armadura){
            System.out.println(" DANHO A LA BESTIA :" +danho);
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
