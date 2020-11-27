package e3;

public class Gunfight {

    public static void duel(Gunslinger g1, Gunslinger g2){
         boolean duel= false;
         boolean duel2= false;
         GunslingerAction action1;
         GunslingerAction action2;
         int round =1;

        while(!duel && !duel2 && round < 100) //duel y duel2 sirven para saber quien ha muerto, true = muerto
        {
            System.out.println("Round " +round+ "-----------------");
            System.out.println("(LOADS G1: " + g1.getLoads() +" = " + g2.getRivalLoads() + " ) " + g2.getRivalActions().toString());
            System.out.println("(LOADS G2: " + g2.getLoads() +" = " + g1.getRivalLoads() + " ) " + g1.getRivalActions().toString());

            action1 = g1.action(); //cogemos la accion que le corresponde al g1 llamando al action, que a su vez llama a behavior
            g2.rivalAction(action1); //introducimos la accion del g1 en la lista de acciones del g2
            action2 = g2.action();
            g1.rivalAction(action2);

            System.out.println("Gunslinger 1: " +action1);
            System.out.println("Gunslinger 2: " +action2);

            //condiciones de lucha
            if(action1 == GunslingerAction.MACHINE_GUN && action2 == GunslingerAction.MACHINE_GUN){duel=true; duel2 =true;}
            if(action1 == GunslingerAction.MACHINE_GUN) {duel = true; break;}
            if(action2 == GunslingerAction.MACHINE_GUN) {duel2 = true; break;}
            if(action1 == GunslingerAction.SHOOT && action2 != GunslingerAction.PROTECT) duel=true;
            if(action2 == GunslingerAction.SHOOT && action1 != GunslingerAction.PROTECT) duel2=true;

            round++;
        }

        //Condiciones para saber quien ha ganado
        if(duel && duel2)
            System.out.println("TIE");
        else if(duel)
            System.out.println("Winner: Gunslinger 1");
        else
            System.out.println("Winner: Gunslinger 2");
    }

  /* public static void main(String[] args){
            Gunslinger g1 = new Gunslinger();
            Gunslinger g2 = new Gunslinger();

            Behavior behavior = new DS_15_03();
            Behavior behavior2 = new DS_15_03();

            g1.setBehavior(behavior);
            g2.setBehavior(behavior2);

                Gunfight.duel(g1, g2);

    }*/

}

