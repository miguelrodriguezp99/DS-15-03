package e4;

public class Tiempo {


    public static void times() {

        if (TrafficJunction.north == TrafficJunction.Ciclo.Green) {
            TrafficJunction.time = TrafficJunction.time + 1;
            if (TrafficJunction.time == 16) {
                TrafficJunction.north = TrafficJunction.Ciclo.Amber_OFF;
                TrafficJunction.time = 0;
            }

        } else if (TrafficJunction.north == TrafficJunction.Ciclo.Amber_OFF) {
            TrafficJunction.time = TrafficJunction.time + 1;
            if (TrafficJunction.time == 6) {
                TrafficJunction.north = TrafficJunction.Ciclo.Red;
                TrafficJunction.time = 0;
                TrafficJunction.South = TrafficJunction.Ciclo.Green;
            }

        } else if (TrafficJunction.South == TrafficJunction.Ciclo.Green) {
            TrafficJunction.time = TrafficJunction.time + 1;
            if (TrafficJunction.time == 16) {
                TrafficJunction.South = TrafficJunction.Ciclo.Amber_OFF;
                TrafficJunction.time = 0;
            }
        } else if (TrafficJunction.South == TrafficJunction.Ciclo.Amber_OFF) {
            TrafficJunction.time = TrafficJunction.time + 1;
            if (TrafficJunction.time == 6) {
                TrafficJunction.South = TrafficJunction.Ciclo.Red;
                TrafficJunction.time = 0;
                TrafficJunction.East = TrafficJunction.Ciclo.Green;
            }
        } else if (TrafficJunction.East == TrafficJunction.Ciclo.Green) {
            TrafficJunction.time = TrafficJunction.time + 1;
            if (TrafficJunction.time == 6) {
                TrafficJunction.East = TrafficJunction.Ciclo.Amber_OFF;
                TrafficJunction.time = 0;
            }
        } else if (TrafficJunction.East == TrafficJunction.Ciclo.Amber_OFF) {
            TrafficJunction.time = TrafficJunction.time + 1;
            if (TrafficJunction.time == 21) {
                TrafficJunction.East = TrafficJunction.Ciclo.Red;
                TrafficJunction.time = 0;
                TrafficJunction.West = TrafficJunction.Ciclo.Green;
            }
        }else if (TrafficJunction.West == TrafficJunction.Ciclo.Green){
            TrafficJunction.time = TrafficJunction.time + 1;
            if (TrafficJunction.time == 16) {
                TrafficJunction.West = TrafficJunction.Ciclo.Amber_OFF;
                TrafficJunction.time = 0;
            }
        }else if (TrafficJunction.West == TrafficJunction.Ciclo.Amber_OFF) {
            TrafficJunction.time = TrafficJunction.time + 1;
            if (TrafficJunction.time == 6) {
                TrafficJunction.West = TrafficJunction.Ciclo.Red;
                TrafficJunction.time = 0;
                TrafficJunction.north = TrafficJunction.Ciclo.Green;
            }
        }
    }

    public static void amber(boolean active){
        if(active){
            TrafficJunction.West = TrafficJunction.Ciclo.Amber_ON;
            TrafficJunction.South = TrafficJunction.Ciclo.Amber_ON;
            TrafficJunction.north = TrafficJunction.Ciclo.Amber_ON;
            TrafficJunction.East = TrafficJunction.Ciclo.Amber_ON;
        }
        else{
            TrafficJunction.north = TrafficJunction.Ciclo.Green;
            TrafficJunction.West = TrafficJunction.Ciclo.Red;
            TrafficJunction.South = TrafficJunction.Ciclo.Red;
            TrafficJunction.East = TrafficJunction.Ciclo.Red;
        }
    }

    public static String aString(){
        StringBuilder sb = new StringBuilder();
        switch (TrafficJunction.north) {
            case Green -> {
                sb.append("[NORTH: GREEN " + TrafficJunction.time + "]");
            }
            case Red -> {
                sb.append("[NORTH: RED]");
            }
            case Amber_OFF -> {
                sb.append("[NORTH: AMBER OFF " + TrafficJunction.time + "]");
            }

            case Amber_ON -> {
                sb.append("[NORTH: AMBER ON]");
            }
        }
        switch (TrafficJunction.South) {
            case Green -> {
                sb.append("[SOUTH: GREEN " + TrafficJunction.time + "]");
            }
            case Red -> {
                sb.append("[SOUTH: RED]");
            }
            case Amber_OFF -> {
                sb.append("[SOUTH: AMBER OFF " + TrafficJunction.time + "]");
            }

            case Amber_ON -> {
                sb.append("[SOUTH: AMBER ON]");
            }

        }

        switch (TrafficJunction.East) {
            case Green -> {
                sb.append("[EAST: GREEN " + TrafficJunction.time + "]");
            }
            case Red -> {
                sb.append("[EAST: RED]");
            }
            case Amber_OFF -> {
                sb.append("[EAST: AMBER OFF " + TrafficJunction.time + "]");
            }

            case Amber_ON -> {
                sb.append("[EAST: AMBER ON]");
            }
        }
        switch (TrafficJunction.West) {
            case Green -> {
                sb.append("[WEST: GREEN " + TrafficJunction.time + "]");
            }
            case Red -> {
                sb.append("[WEST: RED]");
            }
            case Amber_OFF -> {
                sb.append("[WEST: AMBER OFF " + TrafficJunction.time + "]");
            }

            case Amber_ON -> {
                sb.append("[WEST: AMBER ON]");
            }
        }
        return sb.toString();
    }

}


