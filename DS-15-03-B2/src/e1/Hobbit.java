package e1;

public class Hobbit extends Hero{

    public Hobbit(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }


    public void fight(int tirada, Beasts b){
        int vidaantes = b.getVida();
        System.out.println("Figth between " + getNombre() +"(Energy =" +(getVida()+")"+" and " +b.getNombre() + "(Energy =" +(b.getVida()+")")));

        if(b.getClase().equals("Trasgos"))
            b.setVida((int) (tirada - 100*0.05));
        else
            b.setVida(tirada);


        System.out.println(vidaantes +" HP de "+ b.getNombre()+ " -------> " + b.getVida());    }

}
