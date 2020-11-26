package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    Matrix m;
    int[][]mm = {{1,2,3,4,5},{6,7,8,9,0}};
    int[][]mm2 = {{1}};
    Matrix m2;


    @BeforeEach
    void setUp(){
        m = new Matrix(mm);
        m2 = new Matrix(mm2);
    }

    @Test
    void getColumnas() {

        assertEquals(5, m.getColumnas());
    }

    @Test
    void getFilas() {

        assertEquals(2, m.getFilas());

    }

    @Test
    void getValor() {

        assertEquals(9, m.getValor(1,3));

        assertThrows(IllegalArgumentException.class, () -> m.getValor(11,1));

    }

    @Test
    void modificar() {

        m.modificar(1,2, 10);
        assertEquals(10, m.getValor(1,2));

        assertThrows(IllegalArgumentException.class, () -> m.modificar(11,1,2));
        assertThrows(IllegalArgumentException.class, () -> m.modificar(1,11,2));
    }

    @Test
    void returnCopiaBidimensional(){

        assertArrayEquals(mm, m.returnCopiaBidimensional());
    }

    @Test
    void returnCopiaFila() {

        int[] fila = {1,2,3,4,5};
        assertEquals(Arrays.toString(fila), Arrays.toString(m.returnCopiaFila(0)));
    }

    @Test
    void returnCopiaColumna() {

        int[] columna = {1,6};
        assertEquals(Arrays.toString(columna), Arrays.toString(m.returnCopiaColumna(0)));
    }

    @Test
    void returnString() {

        assertEquals("[1, 2, 3, 4, 5]\n[6, 7, 8, 9, 0]\n", m.returnString());

    }

    @Test
    void cambiarIterador() {

        assertSame(m.rowColumnIterator(), m.iterator());
        m.cambiarIterador();
        assertSame(m.columnRowIterator(), m.iterator());
    }

    @Test
    void columnRowIterator() {

        Iterator<Integer> i1 = m.columnRowIterator();
        Iterator<Integer> i2 = m2.columnRowIterator();
        assertThrows(UnsupportedOperationException.class, i1::remove);
        for(int i = 0; i<5; i++){assertTrue(i1.hasNext());}

        assertFalse(i2.hasNext());

        for(int i = 2; i<9; i++) {
            assertEquals(i, i1.next());
        }

    }

    @Test
    void rowColumnIterator() {
        int[][]mm = {{1,2,3,4,5},{6,7,8,9,0}};
        Matrix m = new Matrix(mm);
        Iterator<Integer> i1 = m.rowColumnIterator();
        Iterator<Integer> i2 = m2.rowColumnIterator();
        assertThrows(UnsupportedOperationException.class, i1::remove);


        for(int i = 0; i<5; i++){assertTrue(i1.hasNext());}

        assertFalse(i2.hasNext());

        for(int i = 2; i<9; i++) {
            assertEquals(i, i1.next());
        }

    }

    @Test
    void iterator() {
        int[][]mm = {{1,2,3,4,5},{6,7,8,9,0}};
        Matrix m = new Matrix(mm);

        assertTrue(m.iterator() instanceof Matrix.MiIteratorFilas);
        m.cambiarIterador();
        assertTrue(m.iterator() instanceof Matrix.MiIteratorColumnas);

    }

    @Test
    void MatrixAddition(){
        int[][]mm = {{1,2,3,4},{5,6,7,8}};
        int[][]mm2 = {{2,4,6,8},{10,12,14,16}};
        int[][]mm3 = {{2,4,6,8,3},{10,12,14,16,2}};
        int[][]mnull = null;
        int[][]mnocuadrada = {{2,4,6,8,3,5},{10,12,14,16,2}};
        int[][]mnocuadrada2 = {{2,4,6,8,3},{10,12,14,16,2,8}};
        int[][]mnull2 = {{5,6,7,8},null};

        Matrix m = new Matrix(mm);

        Matrix m2 = new Matrix(mm);
        Matrix m3 = new Matrix(mm3);
        Matrix mt = new Matrix(mm2);
        MatrixAddition matrixAddition = new MatrixAddition();
        assertEquals(mt.returnString(), matrixAddition.SumaMatrix(m,m2).returnString());
        assertThrows(ArithmeticException.class, () -> matrixAddition.SumaMatrix(m,m3));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mnull));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mnocuadrada));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mnocuadrada2));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mnull2));

    }
}