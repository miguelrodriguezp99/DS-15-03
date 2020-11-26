package e1;

public class Humans extends Hero{

    public Humans(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    public void fight(int tirada, Beasts b){
        int vidaantes = b.getVida();
        System.out.println("Figth between " + getNombre() +"(Energy =" +(getVida()+")"+" and " +b.getNombre() + "(Energy =" +(b.getVida()+")")));
        b.setVida(tirada);
        System.out.println(vidaantes +" HP de "+ b.getNombre()+ " -------> " + b.getVida());   }
}
