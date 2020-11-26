package e1;

import java.util.Random;

public class Dados {
    private final int minimo;
    private final int maximo;
    private final Random random = new Random();
    private boolean seed = false;
    private int numseed;

    public Dados(int minimo, int maximo) { //Constructor de los dados sin seed
        if (minimo > maximo) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public Dados(int minimo, int maximo, int seed) { //Constructor de los dados con seed
        if (minimo > maximo) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        this.minimo = minimo;
        this.maximo = maximo;
        this.seed = true;
        this.numseed = seed;
    }

    int tirarDadosHero(Hero b){  //Metodo para lanzar los dados del heroe
        if(seed) random.setSeed(numseed); //Si tiene seed se la aplicamos antes de lanzar el dado

        int tirada = (random.nextInt(maximo - minimo +1 ) + minimo);
        int tirada2 = (random.nextInt(maximo - minimo +1 ) + minimo);
        System.out.println("Tirada de " + b.getNombre() +": " +Math.max(tirada2, tirada));
        return Math.max(tirada2, tirada);
    }

    int tirarDadosBestia(Beasts b){ //Metodo para lanzar el dado de la bestia
        if(seed) random.setSeed(numseed); //Si tiene seed se la aplicamos antes de lanzar el dado

        int tirada = (random.nextInt(maximo - minimo +1 ) + minimo);
        System.out.println("Tirada de " + b.getNombre()+ ": " + tirada);
        return tirada;
    }


}
