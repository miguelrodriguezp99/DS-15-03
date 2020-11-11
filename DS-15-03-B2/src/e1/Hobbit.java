package e1;

public class Hobbit extends Hero{

    protected Hobbit(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }


    public void fight(int tirada, Bestias b){
        int vidaantes = b.getVida();
        System.out.println("Figth between " + getNombre() +"(Energy =" +(getVida()+")"+" and " +b.getNombre() + "(Energy =" +(b.getVida()+")")));

        if(b.getClase().equals("Trasgos")){
            b.setHP((int) (tirada - 100*0.05));
        }
        else
        {
            b.setHP(tirada);
        }

        System.out.println(vidaantes +" HP de "+ b.getNombre()+ " -------> " + b.getVida());    }

}
