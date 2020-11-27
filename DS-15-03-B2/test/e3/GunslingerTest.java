package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GunslingerTest {


    public Gunslinger g1 = new Gunslinger();
    public Gunslinger g2 = new Gunslinger();

    @BeforeEach
    void test123(){
        Behavior behavior = new DS_15_03();
        g1.setBehavior(behavior);
        g2.setBehavior(behavior);
    }

    @Test
    void action() {
        assertEquals(GunslingerAction.RELOAD, g1.action());
    }

    @Test
    void getLoads() {
        assertEquals(0, g1.getLoads());
        g1.action();
        assertEquals(1, g1.getLoads());
    }

    @Test
    void rivalAction() {
        g1.rivalAction(GunslingerAction.PROTECT);
        assertEquals(GunslingerAction.PROTECT,g1.getRivalActions().get(0));
        g1.rivalAction(GunslingerAction.SHOOT);
        assertEquals(GunslingerAction.SHOOT,g1.getRivalActions().get(1));
        g1.rivalAction(GunslingerAction.RELOAD);
        assertEquals(GunslingerAction.RELOAD,g1.getRivalActions().get(2));
    }

    @Test
    void getRivalActions() {
        g1.rivalAction(GunslingerAction.PROTECT);
        assertEquals(GunslingerAction.PROTECT,g1.getRivalActions().get(0));
        g1.rivalAction(GunslingerAction.SHOOT);
        assertEquals(GunslingerAction.SHOOT,g1.getRivalActions().get(1));
        g1.rivalAction(GunslingerAction.RELOAD);
        assertEquals(GunslingerAction.RELOAD,g1.getRivalActions().get(2));
    }

    @Test
    void getRivalLoads() {
        g1.rivalAction(g2.action());
        assertEquals(1, g1.getRivalLoads());

    }

}