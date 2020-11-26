package e3;


import java.util.ArrayList;
import java.util.List;

public class Gunslinger {


    private int loads;
    private Behavior behavior;
    List<GunslingerAction> lista = new ArrayList<>();

    public Gunslinger(){
        loads = 0;
    } //Constructor del gunslinger

    public GunslingerAction action(){ //Metodo action que recibe una accion del behavior y la usa
        GunslingerAction action = behavior.action(this);

        if(action == GunslingerAction.RELOAD){
            loads++;
        }
        if(action == GunslingerAction.SHOOT){
            loads--;
        }

        return action;
    }

    public int getLoads(){
        return loads;
    }

    public void rivalAction(GunslingerAction action){
        lista.add(action);
    }

    public List<GunslingerAction> getRivalActions(){
        return lista;
    }

    public int getRivalLoads(){
    int enemyLoads = 0;
        for (GunslingerAction gunslingerAction : lista) {
            if (gunslingerAction == GunslingerAction.RELOAD) {
                enemyLoads++;
            }
            if (gunslingerAction == GunslingerAction.SHOOT && enemyLoads >= 0) {
                enemyLoads--;
            }
        }
        return enemyLoads;
    }

    public void setBehavior(Behavior behavior){
        this.behavior = behavior;
    }


}
