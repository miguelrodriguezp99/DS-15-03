package e1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class GuerraTest {

    Dados d;
    Dados d2;
    public Guerra g;
    private Beasts b;

/*    @BeforeEach
    void setUp(){
        d = new Dados(100,10,20);
        d2 = new Dados (0,100,20);
        g = new Guerra(d,d2);
    }*/


    @Test
    void Dados(){

        assertThrows(IllegalArgumentException.class, () -> d = new Dados(100,10));
        assertThrows(IllegalArgumentException.class, () -> d = new Dados(100,10,20));

    }

    @Test
    void Bestias(){
        assertThrows(IllegalArgumentException.class, () ->  b = new Orcos("", 0, 0));
    }

    @Test
    void guerra() {
        d = new Dados(0,100,20);
        d2 = new Dados (0,100,20);
        g = new Guerra(d,d2);

        assertThrows(IllegalArgumentException.class, () -> g.addHero(new Elfo("", 0, 20)));
        assertEquals("TIE", g.guerra());

        g.addHero(new Humans("John", 100, 10));
        assertEquals("HEROES WINS", g.guerra());

        Guerra w = new Guerra(d,d2);
        w.addBeasts(new Orcos("Cheff",200,10));
        assertEquals("BEASTS WINS", w.guerra());

        Guerra v = new Guerra(d,d2);
        v.addHero(new Elfo("Mery", 100, 101));
        v.addHero(new Humans("John", 90, 10));
        v.addHero(new Hobbit("Legolas", 100, 50));
        v.addBeasts(new Trasgos("Yago",100,0));
        v.addBeasts(new Orcos("Cheff",200,10));
        assertEquals("HEROES WINS", v.guerra());

        Dados dd = new Dados(90,100);
        Dados dd2 = new Dados (90,100);
        Guerra y = new Guerra(dd,dd2);
        y.addBeasts(new Orcos("BEAST",20000,100));
        y.addHero(new Elfo("HERO", 10, 10));
        assertEquals("BEASTS WINS", y.guerra());

        d = new Dados(0,100,20);
        d2 = new Dados (0,100,20);
        Guerra z = new Guerra(d,d2);
        z.addHero(new Hobbit("Legolas", 100, 200));
        z.addBeasts(new Trasgos("Yago",100,0));
        assertEquals("HEROES WINS", z.guerra());

        Guerra p = new Guerra(d,d2);
        p.addHero(new Hobbit("Legolas", 10000, 0));
        p.addBeasts(new Trasgos("Yago",100,0));
        assertEquals("HEROES WINS", p.guerra());


        d = new Dados(0,100);
        d2 = new Dados (0,100);
        Guerra u = new Guerra(d,d2);
        u.addHero(new Hobbit("Legolas", 110, 0));
        u.addHero(new Hobbit ("Gandalf",110,0));
        u.addHero(new Hobbit ("Frodo",10000,100));
        u.addBeasts(new Orcos("Lurtz",1100,0));
        u.addBeasts(new Orcos("Mauhur",1100,0));

        assertEquals("HEROES WINS", u.guerra());

    }

    @Test
    void Trasgos()
    {
        Trasgos t = new Trasgos("Yago", 100, 100);
        assertEquals("Yago", t.getNombre());

    }
}