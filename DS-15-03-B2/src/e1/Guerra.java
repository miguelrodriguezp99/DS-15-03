package e1;

import java.util.ArrayList;

public class Guerra {
    private final ArrayList<Hero> arrayHeroes = new ArrayList<>();
    private final ArrayList<Beasts> arrayBestias = new ArrayList<>();
    public Dados dadoHero;
    public Dados dadoBeast;

    public Guerra(Dados dado1, Dados dado2){
        this.dadoHero = dado1;
        this.dadoBeast = dado2;
    }

    public void addHero(Hero b){
        arrayHeroes.add(b);
    }

    public void addBeasts(Beasts b){
        arrayBestias.add(b);
    }

    public String guerra(){

    while(!arrayHeroes.isEmpty() && !arrayBestias.isEmpty()){ //Mientras los dos arrays contengan elementos sigue la guerra
        int y = 0;
        for(Hero x : arrayHeroes){ //Un heroe pelea contra el correspondiente en el orden (lo marco con la y, que se actualiza cuando tiene que luchar el siguiente heroe)
            if(y < arrayBestias.size()){
                Beasts b = arrayBestias.get(y); //cogemos la bestia correspondiente a la posicion del heroe
                x.fight(dadoHero.tirarDadosHero(x), b); //lanzamos el fight y los dados
                b.fight(dadoBeast.tirarDadosBestia(b), x);
                if(x.getVida() <= 0){ //Informamos de si muere alguno este turno
                    System.out.println(x.getNombre()+ " ha muerto");
                }
                if(b.getVida() <= 0){
                    System.out.println(b.getNombre() + " ha muerto");
                }
            }
            y++;
        } //Termina el primer turno
        System.out.println("-----------------x--------------");
        arrayBestias.removeIf(x->x.getVida()<=0); //Eliminamos del array todos los que hayan muerto
        arrayHeroes.removeIf(x->x.getVida()<=0);
    } //Repetimos hasta que se vacíe uno de los dos, o los dos

        //Ifs para saber quien ha ganado
        if(arrayBestias.isEmpty() && arrayHeroes.isEmpty()){
            return "TIE";
        }
        else if(arrayBestias.isEmpty())
            return "HEROES WINS";
        else
            return "BEASTS WINS";
    }

}
