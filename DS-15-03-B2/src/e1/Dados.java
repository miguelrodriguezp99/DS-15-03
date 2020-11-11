package e1;

import java.util.Random;

public class Dados {
    private final int minimo;
    private final int maximo;
    private final Random random = new Random();
    public boolean seed = false;
    public int numseed;

    public Dados(int minimo, int maximo) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public Dados(int minimo, int maximo, int seed) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        this.minimo = minimo;
        this.maximo = maximo;
        this.seed = true;
        this.numseed = seed;

    }

    int tirarDadosHero(Hero b){
        if(seed) {
            random.setSeed(numseed);
        }
        int tirada = (random.nextInt(maximo - minimo +1 ) + minimo);
       // System.out.println(tirada + " TIRADAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        int tirada2 = (random.nextInt(maximo - minimo +1 ) + minimo);
        //System.out.println(tirada2 + " TIRADAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(Math.max(tirada2, tirada) + " TIRADA " + b.getNombre());
        return Math.max(tirada2, tirada);
    }

    int tirarDadosBestia(Bestias b){
        if(seed){
            random.setSeed(numseed);
        }
        int tirada = (random.nextInt(maximo - minimo +1 ) + minimo);
        System.out.println(tirada + " TIRADA " + b.getNombre());
        //System.out.println(tirada + " TIRADAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return tirada;

    }


}
