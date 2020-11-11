package e1;

public class Elfo extends Hero{

    private Object Orcos;
    private Object Bestias;

    protected Elfo(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    public void fight(int tirada, Bestias b){
        int vidaantes = b.getVida();
        System.out.println("Figth between " + getNombre() +"(Energy =" +(getVida()+")"+" and " +b.getNombre() + "(Energy =" +(b.getVida()+")")));

        if(b.getClase().equals("Orcos")){
            System.out.println("Hello");
            b.setHP((int)(100*0.10 + tirada));
        }
        else
        {
            b.setHP(tirada);
        }

        System.out.println(vidaantes +" HP de "+ b.getNombre()+ " -------> " + b.getVida());
    }



}
