package e1;

import static org.junit.jupiter.api.Assertions.*;

import e1.Modes.Manual;
import e1.Modes.Off;
import e1.Modes.Program;
import e1.Modes.Timer;
import e1.Observers.Observer;
import e1.Observers.ObserverMode;
import e1.Observers.ObserverTemperature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermostatoTest {

    Termostato t = new Termostato();
    Observer o1 = new ObserverMode();
    Observer o2 = new ObserverTemperature();
    @BeforeEach

    void beforeTest(){
    t.attach(o1);
    t.attach(o2);
    t.setTemperatura(20);
    //t.setEstado();

    }

    @Test
    void changeManual() {
        assertEquals(Off.getInstancia(),t.getEstado());
        t.changeManual();
        assertThrows(UnsupportedOperationException.class, () -> t.changeManual());
        assertEquals(Manual.getInstancia(),t.getEstado());

        t.changeTimer(20);
        assertEquals(Timer.getInstancia(), t.getEstado());

        t.changeManual();
        assertEquals(Manual.getInstancia(), t.getEstado());
        assertEquals("M", t.getEstado().modeString(t));

        t.changeOff();
        assertEquals(Off.getInstancia(), t.getEstado());

        //Cambiamos de manual a programa con una temperatura actual mayor que la minima
        t.changeManual();
        t.newTemperature(25);
        t.changeProgram(20);
        assertFalse(t.getEncendida()); //Comprobamos que la calefaccion está apagada

    }

    @Test
    void changeOff() {
        //t.changeOff();
        assertThrows(UnsupportedOperationException.class, () -> t.changeOff());
        assertEquals(Off.getInstancia(), t.getEstado());
        assertEquals("O", t.getEstado().modeString(t));

        t.newTemperature(25);
        t.changeProgram(20);
        assertFalse(t.getEncendida());
        assertEquals(Program.getInstancia(), t.getEstado());

        t.changeOff();

        t.changeTimer(0);
        assertFalse(t.getEncendida());

        t.newTemperature(22);
        assertEquals(Off.getInstancia(), t.getEstado());
    }

    @Test
    void changeTimer() {
        t.changeTimer(20);
        assertThrows(UnsupportedOperationException.class, () -> t.changeTimer(20));
        assertThrows(UnsupportedOperationException.class, () -> t.changeProgram(25));

        assertEquals("  T 20", t.getEstado().modeString(t));
        assertEquals(Timer.getInstancia(), t.getEstado());
        assertEquals(20, t.getTiempo());

        t.newTemperature(22);
        assertEquals(15, t.getTiempo());

    }

    @Test
    void changeProgram() {
        assertEquals(Off.getInstancia(), t.getEstado());
        t.changeProgram(25);

        assertThrows(UnsupportedOperationException.class, () -> t.changeTimer(20));
        assertThrows(UnsupportedOperationException.class, () -> t.changeProgram(25));

        assertEquals(Program.getInstancia(), t.getEstado());
        assertEquals(25, t.gettMin());

        t.newTemperature(26);
        assertEquals(26, t.getTemperatura());
        assertFalse(t.getEncendida());

        t.newTemperature(20);
        assertTrue(t.getEncendida());
        assertEquals("P 25.0", t.getEstado().modeString(t));

        t.changeManual();
        assertEquals(Manual.getInstancia(), t.getEstado());

    }

    @Test
    void newTemperature() {
        t.newTemperature(20);
        assertEquals(20, t.getTemperatura());
        t.newTemperature(22);
        assertEquals(22, t.getTemperatura());
    }

    @Test
    void screenInfo() {
        t.changeTimer(5);
        assertEquals("20.0 ON    T 5", t.screenInfo());
        t.newTemperature(22);
        assertEquals("22.0 OFF O", t.screenInfo());
    }

    @Test
    void main(){
        //Compruebo que el si establezco el modo timer, cada vez que ejecuto temperatura baja el tiempo, se actualiza la temperatura y que
        //Si llega a cero se desactive el modo timer y establezca el modo OFF.

        t.changeTimer(15);
        t.newTemperature(22);
        t.newTemperature(23);
        t.newTemperature(24);
        //Compruebo que una vez apagado sea off y la temperatura sea 24

        assertEquals(Off.getInstancia(), t.getEstado());
        assertEquals(24, t.getTemperatura());

        //Pasamos de Off a manual
        t.changeManual();
        //Comprobamos que ahora está encendida la calefaccion
        assertTrue(t.getEncendida());

        t.newTemperature(22);
        assertEquals(22, t.getTemperatura());

        //Cambiamos a Program con temperatura minima 24, teniendo una temperatura actual de 22
        t.changeProgram(24);
        assertTrue(t.getEncendida()); //Comprobamos que como la temperatura minima es mayor que la temperatura actual entonces la calefaccion está encendida

        t.newTemperature(25); //Subimos la temperatura a 25 y comprobamos que la calefaccion ahora está apagada
        assertFalse(t.getEncendida());

        t.changeOff();
        assertEquals(Off.getInstancia(), t.getEstado());

        Observer o1 = new ObserverMode();
        t.detach(o1);
    }

    @Test
    public void hashTestCode(){

        //Pruebo hashes con diferentes estados del termostato.

        Termostato hash = new Termostato();
        Termostato hash2 = new Termostato();

        assertEquals(hash.hashCode(), hash2.hashCode());
        assertEquals(hash2, hash);

        hash.changeManual();

        assertNotEquals(hash.hashCode(), hash2.hashCode());
        assertNotEquals(hash2, hash);

        hash2.changeManual();

        assertEquals(hash.hashCode(), hash2.hashCode());
        assertEquals(hash2, hash);

        hash.changeTimer(20);

        assertNotEquals(hash.hashCode(), hash2.hashCode());
        assertNotEquals(hash2, hash);

        hash2.changeTimer(15);

        assertNotEquals(hash.hashCode(), hash2.hashCode());
        assertNotEquals(hash2, hash);

        hash2.setTiempo(20);

        assertEquals(hash.hashCode(), hash2.hashCode());
        assertEquals(hash2, hash);
    }


    @Test
    public void Observers(){
        t.changeManual();
        t.changeOff();

        //Comprobamos que el log del observador de estados funciona correctamente.
        assertEquals("[Se activa el modo Manual., Se activa el modo Off.]", o1.getObserverList());

        t.newTemperature(21);


        //Comprobamos que el log del estado de la calefaccion funciona correctamente
        assertEquals("[20.0 Modo Manual - Calefacción encendida., 21.0 Modo Off - Calefacción apagada.]", o2.getObserverList());


        //Usamos el printLog y comprobamos por pantalla que el log del Termostato incluye ambos logs de los observadores por orden.
        //Este metodo es para que se asimile al log indicado en el boletín ya que si lo devuelvo como Strings de una lista es complicado.
        t.printLog();

        //Testeamos con String
        assertEquals("[Se activa el modo Manual., 20.0 Modo Manual - Calefacción encendida., Se activa el modo Off., 21.0 Modo Off - Calefacción apagada.]", t.getLog());

        t.changeTimer(20);
        assertEquals("[Se activa el modo Manual., Se activa el modo Off., Se activa el modo Timer 20 minutos.]", o1.getObserverList());
        assertEquals("[20.0 Modo Manual - Calefacción encendida., 21.0 Modo Off - Calefacción apagada., 21.0 Modo Timer (faltan 20 minutos) - Calefacción encendida.]", o2.getObserverList());

        //Comprobamos una vez mas si modificamos bien el tiempo y la temperatura, el modo timer etc.
        t.newTemperature(21.5f);
        assertEquals("[20.0 Modo Manual - Calefacción encendida., 21.0 Modo Off - Calefacción apagada.," +
                " 21.0 Modo Timer (faltan 20 minutos) - Calefacción encendida., 21.5 Modo Timer (faltan 15 minutos) - Calefacción encendida.]", o2.getObserverList());


        //Comprobamos otra vez el log total
        assertEquals("[Se activa el modo Manual., " +
                "20.0 Modo Manual - Calefacción encendida.," +
                " Se activa el modo Off., 21.0 Modo Off - Calefacción apagada.," +
                " Se activa el modo Timer 20 minutos.," +
                " 21.0 Modo Timer (faltan 20 minutos) - Calefacción encendida.," +
                " 21.5 Modo Timer (faltan 15 minutos) - Calefacción encendida.]", t.getLog());

        //Hacemos que pasen 15 minutos para que se desactive el timer y comprobamos una ultima vez
        t.newTemperature(22);
        t.newTemperature(23);
        t.newTemperature(23.5f);

        assertEquals("[Se activa el modo Manual., " +
                "20.0 Modo Manual - Calefacción encendida., " +
                "Se activa el modo Off., 21.0 Modo Off - Calefacción apagada., " +
                "Se activa el modo Timer 20 minutos., " +
                "21.0 Modo Timer (faltan 20 minutos) - Calefacción encendida., " +
                "21.5 Modo Timer (faltan 15 minutos) - Calefacción encendida., " +
                "22.0 Modo Timer (faltan 10 minutos) - Calefacción encendida., " +
                "23.0 Modo Timer (faltan 5 minutos) - Calefacción encendida., " +
                "Se desactiva el modo Timer., 23.5 Modo Off - Calefacción apagada.]", t.getLog());
    }

}