package e4;

public class TrafficJunction {
    public static Ciclo north;
    public static Ciclo South;
    public static Ciclo East;
    public static Ciclo West;
    public static int time;
    public enum Ciclo {Green, Amber_ON, Amber_OFF, Red};

    public TrafficJunction() {
        north = Ciclo.Green;
        West = Ciclo.Red;
        East = Ciclo.Red;
        South = Ciclo.Red;
    }
    public void timesGoesBy() {
        Tiempo.times();
    }

    public void amberJunction(boolean active) {
        Tiempo.amber(active);
    }
    @Override
    public String toString() {
        return Tiempo.aString();
    }
}

