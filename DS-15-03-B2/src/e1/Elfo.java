package e1;

public class Elfo extends Hero{

    public Elfo(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    public void fight(int tirada, Beasts b){
        int vidaantes = b.getVida();
        System.out.println("Figth between " + getNombre() +"(Energy =" +(getVida()+")"+" and " +b.getNombre() + "(Energy =" +(b.getVida()+")")));

        if(b.getClase().equals("Orcos"))
            b.setVida((int)(100*0.10 + tirada));
        else
            b.setVida(tirada);

        System.out.println(vidaantes +" HP de "+ b.getNombre()+ " -------> " + b.getVida());
    }
}
