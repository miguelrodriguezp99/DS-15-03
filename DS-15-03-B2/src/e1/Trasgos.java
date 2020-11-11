package e1;

public class Trasgos extends Bestias{
    public Trasgos(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    public String getClase(){
        return "Trasgos";
    }



    public void fight(int tirada, Hero b){
        int vidaantes = b.getVida();
        b.setHP(tirada);
        System.out.println(vidaantes +" HP de "+ b.getNombre()+ " -------> " + b.getVida());    }

}
