package e3;

public class testBehavior implements Behavior {
    int i = 0;

    //Metodo behavior, dependiendo de la accion del rival o de la situacion actual del pistolero, realizará una acción u otra
    //#######################################################################################################################
    @Override
    public GunslingerAction action(Gunslinger g) {

        if (g.getLoads() == 0) {
            if (g.getRivalLoads() == 0) {
                return GunslingerAction.RELOAD;
            }
        }

        if (g.getLoads() == 5) {
            return GunslingerAction.MACHINE_GUN;
        }

        if(i>=3){
            if((g.getRivalActions()).get(i) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT &&
            (g.getRivalActions()).get(i-2) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-3) == GunslingerAction.PROTECT){
                if(g.getLoads() >0){
                    return GunslingerAction.SHOOT;
                }
                else
                {
                    return GunslingerAction.RELOAD;
                }
            }

            if((g.getRivalActions()).get(i) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-1) == GunslingerAction.RELOAD &&
                    (g.getRivalActions()).get(i-2) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-3) == GunslingerAction.RELOAD){
                if(g.getLoads() >0){
                    return GunslingerAction.SHOOT;
                }
                else
                {
                    return GunslingerAction.RELOAD;
                }
            }

        }
            if (i >= 1) {

                if(g.getLoads() == 4 && g.getRivalLoads() > 0){
                    return Math.random() > 0.9 ? GunslingerAction.PROTECT: GunslingerAction.RELOAD;
                }else if (g.getLoads() == 4 && g.getRivalLoads() ==0) return GunslingerAction.RELOAD;


                if((g.getLoads() ==0 && g.getRivalLoads() == 0 &&(g.getRivalActions()).get(i) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT)) {
                    return GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() == 0 &&(g.getRivalActions()).get(i) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT)) {
                    return Math.random() > 0.5 ? GunslingerAction.SHOOT: GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() > 0 &&(g.getRivalActions()).get(i) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT)) {
                    return GunslingerAction.SHOOT;
                }

                if((g.getLoads() ==0 && g.getRivalLoads() == 0 &&(g.getRivalActions()).get(i) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-1) == GunslingerAction.SHOOT)) {
                    return GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() == 0 &&(g.getRivalActions()).get(i) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-1) == GunslingerAction.SHOOT)) {
                    return Math.random() > 0.5 ? GunslingerAction.SHOOT: GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() > 0 &&(g.getRivalActions()).get(i) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-1) == GunslingerAction.SHOOT)) {
                    return GunslingerAction.SHOOT;
                }

                if((g.getLoads() ==0 && g.getRivalLoads() == 0 &&(g.getRivalActions()).get(i) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-1) == GunslingerAction.RELOAD)) {
                    return GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() > 0 &&(g.getRivalActions()).get(i) == GunslingerAction.PROTECT && (g.getRivalActions()).get(i-1) == GunslingerAction.RELOAD)) {
                    return GunslingerAction.SHOOT;
                }

                if((g.getLoads() ==0 && (g.getRivalActions()).get(i) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-1) == GunslingerAction.RELOAD)) {
                    return Math.random() > 0.5 ? GunslingerAction.PROTECT: GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() > 0 &&(g.getRivalActions()).get(i) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-1) == GunslingerAction.RELOAD)) {
                    return GunslingerAction.SHOOT;
                }

                if((g.getLoads() ==0 && g.getRivalLoads() == 0 && (g.getRivalActions()).get(i) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-1) == GunslingerAction.SHOOT)) {
                    return GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() > 0 &&(g.getRivalActions()).get(i) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-1) == GunslingerAction.SHOOT)) {
                    return Math.random() > 0.5 ? GunslingerAction.SHOOT: GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() == 0 &&(g.getRivalActions()).get(i) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-1) == GunslingerAction.SHOOT)) {
                    return Math.random() > 0.5 ? GunslingerAction.SHOOT: GunslingerAction.RELOAD;
                }

                if((g.getLoads() ==0 && (g.getRivalActions()).get(i) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT)) {
                    return Math.random() > 0.5 ? GunslingerAction.PROTECT: GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() > 0 &&(g.getRivalActions()).get(i) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT)) {
                    return Math.random() > 0.5 ? GunslingerAction.SHOOT: GunslingerAction.PROTECT;
                }

                if((g.getLoads() >1 && (g.getRivalActions()).get(i) == GunslingerAction.RELOAD && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT)) {
                    return GunslingerAction.SHOOT;
                }

                if((g.getLoads() ==0 && g.getRivalLoads()==0 && (g.getRivalActions()).get(i) == GunslingerAction.SHOOT && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT)) {
                    return GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() > 0 &&(g.getRivalActions()).get(i) == GunslingerAction.SHOOT && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT)) {
                    return Math.random() > 0.5 ? GunslingerAction.SHOOT: GunslingerAction.PROTECT;
                }

                if((g.getLoads() >0 && g.getRivalLoads() == 0 && (g.getRivalActions()).get(i) == GunslingerAction.SHOOT && (g.getRivalActions()).get(i-1) == GunslingerAction.PROTECT)) {
                    return Math.random() > 0.2 ? GunslingerAction.SHOOT: GunslingerAction.RELOAD;
                }

                if((g.getLoads() ==0 && (g.getRivalActions()).get(i) == GunslingerAction.SHOOT && (g.getRivalActions()).get(i-1) == GunslingerAction.RELOAD)) {
                    return Math.random() > 0.5 ? GunslingerAction.RELOAD: GunslingerAction.PROTECT;
                }

                if((g.getLoads() >0 && g.getRivalLoads() > 0 &&(g.getRivalActions()).get(i) == GunslingerAction.SHOOT && (g.getRivalActions()).get(i-1) == GunslingerAction.RELOAD)) {
                    return Math.random() > 0.5 ? GunslingerAction.SHOOT: GunslingerAction.PROTECT;
                }

                if((g.getLoads() ==0 && g.getRivalLoads()==0 && (g.getRivalActions()).get(i) == GunslingerAction.SHOOT && (g.getRivalActions()).get(i-1) == GunslingerAction.SHOOT)) {
                    return GunslingerAction.RELOAD;
                }

                if((g.getLoads() >0 && g.getRivalLoads() > 0 &&(g.getRivalActions()).get(i) == GunslingerAction.SHOOT && (g.getRivalActions()).get(i-1) == GunslingerAction.SHOOT)) {
                    return Math.random() > 0.5 ? GunslingerAction.SHOOT: GunslingerAction.PROTECT;
                }

                if((g.getLoads() >0 && g.getRivalLoads() == 0 && (g.getRivalActions()).get(i) == GunslingerAction.SHOOT && (g.getRivalActions()).get(i-1) == GunslingerAction.SHOOT)) {
                    return GunslingerAction.RELOAD;
                }

                // ------------------------------------------------------------------------ XXX ---------------------------------------------------------


                if (g.getLoads() == 0 && g.getRivalActions().get(i) == GunslingerAction.RELOAD && g.getRivalActions().get(i - 1) == GunslingerAction.RELOAD) {
                    return GunslingerAction.RELOAD;
                }
                if (g.getLoads() > 0 && g.getRivalActions().get(i) == GunslingerAction.RELOAD && g.getRivalActions().get(i - 1) == GunslingerAction.RELOAD) {

                    return GunslingerAction.SHOOT;
                }
                if ((g.getRivalActions()).get(i) == GunslingerAction.RELOAD
                        && (g.getRivalActions()).get(i-1) == GunslingerAction.RELOAD && g.getRivalLoads() > 0 && g.getLoads() > 0) {
                    return GunslingerAction.SHOOT;
                }
                if(g.getRivalLoads() >= 3 && (g.getRivalActions()).get(i) == GunslingerAction.RELOAD && g.getLoads() >= 1){
                    return GunslingerAction.SHOOT;
                }
            }

            i++;
            if(i==2){
                return GunslingerAction.PROTECT;
            }

           if (g.getLoads() > 0) {
                if (g.getRivalLoads() == 0) {
                    return GunslingerAction.RELOAD;
                }
                if (g.getRivalLoads() == 1) {
                    return GunslingerAction.PROTECT;
                } else {
                    return GunslingerAction.SHOOT;
                }

            }
            else return GunslingerAction.PROTECT;

        }

}
