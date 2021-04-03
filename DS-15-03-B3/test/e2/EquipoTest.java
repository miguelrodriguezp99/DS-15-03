package e2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {

    //Equipos
    public Equipo tutifruti = new Equipo("Tutifruti");
    public Equipo losgolosos = new Equipo("Los Golosos");
    public Equipo doom = new Equipo("Doom");

    //Empleados
    public Empleado alejandro = new Empleado("Alejandro", 10);
    public Empleado marta = new Empleado("Marta", 12);
    public Empleado maria = new Empleado("Maria", 9);
    public Empleado miguel = new Empleado("Miguel", 10);
    public Empleado francisco = new Empleado("Francisco", 10);
    public Empleado antonio = new Empleado("Antonio", 11);

    //Proyectos
    public Project projectx = new Project(tutifruti, "PROJECT X");
    public Project projecty = new Project(losgolosos, "PROJECT Y");
    public Project projectv = new Project(doom, "ProjectV");

    @BeforeEach
    public void beforeTest(){
        tutifruti.add(losgolosos);
        tutifruti.add(alejandro);
        losgolosos.add(marta);
        losgolosos.add(maria);
        losgolosos.add(miguel);
        losgolosos.add(doom);
        doom.add(francisco);
        doom.add(antonio);

    }

    @Test
    void getName() {
        assertEquals("Tutifruti", tutifruti.getName());
        assertEquals("Alejandro", alejandro.getName());
        assertEquals("PROJECT X", projectx.getName());
    }

    @Test
    void getProject(){
        assertEquals("Alejandro: PROJECT X 0.0", alejandro.getProject());
    }

    @Test
    void add() {
        Empleado prueba = new Empleado("Prueba", 10);
        doom.add(prueba);

        assertEquals("Francisco Antonio Prueba", doom.getWorkers());
        //assertEquals("Prueba: PROJECT X 0.0", prueba.getProject());
    }

    @Test
    void sumarHoras(){
        antonio.sumarHoras(projectx, 10);
        assertEquals(10, antonio.getHours(projectx));
        antonio.sumarHoras(projecty, 30);
        assertEquals(30, antonio.getHours(projecty));
        //Probamos a hacer print de ambos
        projectx.print();
        projecty.print();
        projectx.print();

        assertEquals( "Tutifruti: 10.0, 110.0 €\n  Los Golosos: 10.0, 110.0 €\n    Marta: 0.0, 0.0 €\n    Maria: 0.0, 0.0 €" +
                "\n    Miguel: 0.0, 0.0 €\n    Doom: 10.0, 110.0 €\n      Francisco: 0.0, 0.0 €\n      Antonio: 10.0, 110.0 €\n  Alejandro: 0.0, 0.0 €\n", projectx.print());
    }

    @Test
    void getSalary() {
        antonio.sumarHoras(projectx, 10);
        francisco.sumarHoras(projectx, 35);

        assertEquals(10, antonio.getHours(projectx));
        assertEquals(110, antonio.getSalary(projectx));
        assertEquals(460, doom.getSalary(projectx));
    }

    @Test
    void getHours() {
        alejandro.sumarHoras(projectx, 20);
        alejandro.sumarHoras(projecty, 25);

        antonio.sumarHoras(projectx, 20);
        antonio.sumarHoras(projecty, 30);
        marta.sumarHoras(projectx, 20);

        assertEquals(20, alejandro.getHours(projectx));
        assertEquals(25, alejandro.getHours(projecty));

        //Alejandro + LosGolosos(Marta + Antonio) Suman un total de 60 horas para project X
        assertEquals(60, tutifruti.getHours(projectx));

        //Marta + Antonio en project X suman 40 horas
        assertEquals(40, losgolosos.getHours(projectx));

        //Antonio suma 30 horas para Project Y
        assertEquals(30, losgolosos.getHours(projecty));
    }

    @Test
    void print() {
        antonio.sumarHoras(projectx, 10);
        assertEquals(10, antonio.getHours(projectx));
        antonio.sumarHoras(projecty, 30);
        assertEquals(30, antonio.getHours(projecty));

        assertEquals( "Tutifruti: 10.0, 110.0 €\n  Los Golosos: 10.0, 110.0 €\n    Marta: 0.0, 0.0 €\n    Maria: 0.0, 0.0 €" +
                "\n    Miguel: 0.0, 0.0 €\n    Doom: 10.0, 110.0 €\n      Francisco: 0.0, 0.0 €\n      Antonio: 10.0, 110.0 €\n  Alejandro: 0.0, 0.0 €\n", projectx.print());
    }

    @Test
    public void CoWorkers(){
        assertEquals("[Trabajador: Marta, Trabajador: Maria, Trabajador: Miguel, Trabajador: Francisco, Trabajador: Antonio, Trabajador: Alejandro]",
                alejandro.listCoWorkers(projectx).toString());

        assertEquals("[Trabajador: Marta, Trabajador: Maria, Trabajador: Miguel, Trabajador: Francisco, Trabajador: Antonio, Trabajador: Alejandro]",
                tutifruti.listCoWorkers(projectx).toString());

        assertEquals("[Trabajador: Marta, Trabajador: Maria, Trabajador: Miguel, Trabajador: Francisco, Trabajador: Antonio]",
                doom.listCoWorkers(projecty).toString());

        assertEquals("[Trabajador: Marta, Trabajador: Maria, Trabajador: Miguel, Trabajador: Francisco, Trabajador: Antonio, Trabajador: Alejandro]",
                projectx.coWorkers().toString());

        assertEquals("[Trabajador: Marta, Trabajador: Maria, Trabajador: Miguel, Trabajador: Francisco, Trabajador: Antonio]",
                projecty.coWorkers().toString());
    }

    @Test
    public void ProjectComponent(){
    assertThrows(UnsupportedOperationException.class, () -> alejandro.add(doom));
    }

    @Test
    public void getProjects(){
        assertEquals("Project: PROJECT X", projectx.toString());

        assertEquals("[Project: PROJECT Y, Project: PROJECT X]", losgolosos.getProjects());

        assertEquals("Equipo Doom", doom.toString());

        assertThrows(UnsupportedOperationException.class, () -> tutifruti.add(losgolosos));
    }

    @Test
    public void hashCodeTest(){

        Empleado hash = new Empleado("Hash", 10);
        Empleado hash2 = new Empleado("Hash", 10);

        assertEquals(hash.hashCode(), hash2.hashCode());
        assertEquals(hash2, hash);

    }



}