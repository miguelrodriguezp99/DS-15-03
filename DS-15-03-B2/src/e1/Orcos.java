package e1;

public class Orcos extends Beasts {

    public Orcos(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }


    public String getClase(){
        return "Orcos";
    }

    public void fight(int tirada, Hero h){
        int vidaantes = h.getVida();
        h.setvidaOrcos(tirada);
        System.out.println(vidaantes +" HP de "+ h.getNombre()+ " -------> " + h.getVida());
    }
}
