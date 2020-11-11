package e1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GuerraTest {

    Dados d;
    Dados d2;
    public Guerra g;
    private Bestias b;

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

        assertThrows(IllegalArgumentException.class, () -> g.arrayHeroes.add(new Elfo("", 0, 20)));
        assertEquals("TIE", g.guerra());

        g.arrayHeroes.add(new Humans("John", 100, 10));
        assertEquals("HEROES WINS", g.guerra());

        Guerra w = new Guerra(d,d2);
        w.arrayBestias.add(new Orcos("Cheff",200,10));
        assertEquals("BEASTS WINS", w.guerra());

        Guerra v = new Guerra(d,d2);
        v.arrayHeroes.add(new Elfo("Mery", 100, 101));
        v.arrayHeroes.add(new Humans("John", 90, 10));
        v.arrayHeroes.add(new Hobbit("Inma", 100, 50));
        v.arrayBestias.add(new Trasgos("Yago",100,0));
        v.arrayBestias.add(new Orcos("Cheff",200,10));
        assertEquals("HEROES WINS", v.guerra());

        Dados dd = new Dados(90,100);
        Dados dd2 = new Dados (90,100);
        Guerra y = new Guerra(dd,dd2);
        y.arrayBestias.add(new Orcos("BEAST",20000,100));
        y.arrayHeroes.add(new Elfo("HERO", 10, 10));
        assertEquals("BEASTS WINS", y.guerra());

        d = new Dados(0,100,20);
        d2 = new Dados (0,100,20);
        Guerra z = new Guerra(d,d2);
        z.arrayHeroes.add(new Hobbit("Inma", 100, 200));
        z.arrayBestias.add(new Trasgos("Yago",100,0));
        assertEquals("HEROES WINS", z.guerra());

        Guerra p = new Guerra(d,d2);
        p.arrayHeroes.add(new Hobbit("Inma", 10000, 0));
        p.arrayBestias.add(new Trasgos("Yago",100,0));
        assertEquals("HEROES WINS", p.guerra());


        d = new Dados(0,100);
        d2 = new Dados (0,100);
        Guerra u = new Guerra(d,d2);
        p.arrayHeroes.add(new Hobbit("Inma", 10000, 0));
        p.arrayBestias.add(new Orcos("Yago",100,0));
        assertEquals("HEROES WINS", p.guerra());

    }

    @Test
    void Trasgos()
    {
        Guerra v = new Guerra(d,d2);
        Trasgos t = new Trasgos("Yago", 100, 100);
        assertEquals("Yago", t.getNombre());

    }
}