package e1;

public abstract class Hero {
    private final String nombre;
    private int vida;
    private final int armadura;
    private boolean done = false;


    public abstract void fight(int tirada, Beasts b);

    protected Hero(String nombre, int vida, int armadura) {
        if(nombre == null || vida == 0){
            throw new IllegalArgumentException("El nombre o la vida no pueden ser null");
        }
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
    }

    void setVida(int danho){
        if(danho > this.armadura){
            this.vida = this.vida - (danho-armadura);
        }
    }

    void setvidaOrcos(int danho) { //Metodo para hacer update a la vida cuando ataca un orco
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
