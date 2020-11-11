package e1;

public class Orcos extends Bestias{

    public Orcos(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }


    public String getClase(){
        return "Orcos";
    }

    public void fight(int tirada, Hero h){
        int vidaantes = h.getVida();
        h.setHPorcos(tirada);
        System.out.println(vidaantes +" HP de "+ h.getNombre()+ " -------> " + h.getVida());    }

}
