package e1;

import java.util.ArrayList;

public class Guerra {
    public ArrayList<Hero> arrayHeroes = new ArrayList<>();
    public ArrayList<Bestias> arrayBestias = new ArrayList<>();
    public Dados dadoHero;
    public Dados dadoBeast;

    public Guerra(Dados dado1, Dados dado2){
        this.dadoHero = dado1;
        this.dadoBeast = dado2;
    }

    public String guerra(){

    while(!arrayHeroes.isEmpty() && !arrayBestias.isEmpty()){
        int y = 0;
        for(Hero x : arrayHeroes){
            if(y < arrayBestias.size()){
                Bestias b = arrayBestias.get(y);
                x.fight(dadoHero.tirarDadosHero(x), b);
                b.fight(dadoBeast.tirarDadosBestia(b), x);
                if(x.getVida() <= 0){
                    System.out.println(x.getNombre()+ " ha muerto");
                }
                if(b.getVida() <= 0){
                    System.out.println(b.getNombre() + " ha muerto");
                }
            }
            y++;

        }
        System.out.println("-----------------x--------------");
        arrayBestias.removeIf(x->x.getVida()<=0);
        arrayHeroes.removeIf(x->x.getVida()<=0);


    }
        if(arrayBestias.isEmpty() && arrayHeroes.isEmpty()){
            return "TIE";
        }
        else if(arrayBestias.isEmpty())
            return "HEROES WINS";
        else
            return "BEASTS WINS";
    }

}
