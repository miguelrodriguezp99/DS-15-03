package e2;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void getColumnas() {
        int[][]mm = {{1,2,3,4,5},{6,7,8,9,0}};
        Matrix m = new Matrix(mm);
        assertEquals(5, m.getColumnas());
    }

    @Test
    void getFilas() {
    }

    @Test
    void getValor() {
    }

    @Test
    void modificar() {
    }

    @Test
    void returnCopiaBidimensional() {
    }

    @Test
    void returnCopiaFila() {
    }

    @Test
    void returnCopiaColumna() {
    }

    @Test
    void returnString() {
    }

    @Test
    void cambiarIterador() {
    }

    @Test
    void columnRowIterator() {

        int[][]mm = {{1,2,3,4,5},{6,7,8,9,0}};
        Matrix m = new Matrix(mm);
        Iterator<Integer> i1 = m.columnRowIterator();
        assertThrows(UnsupportedOperationException.class, () -> i1.remove());

    }

    @Test
    void rowColumnIterator() {
        int[][]mm = {{1,2,3,4,5},{6,7,8,9,0}};
        Matrix m = new Matrix(mm);
        Iterator<Integer> i1 = m.rowColumnIterator();
        assertThrows(UnsupportedOperationException.class, () -> i1.remove());

    }

    @Test
    void iterator() {
        int[][]mm = {{1,2,3,4,5},{6,7,8,9,0}};
        Matrix m = new Matrix(mm);

        assertTrue(m.iterator() instanceof Matrix.MiIteratorColumnas);
        m.cambiarIterador();
        assertTrue(m.iterator() instanceof Matrix.MiIteratorFilas);

    }

    @Test
    void MatrixAddition(){
        int[][]mm = {{1,2,3,4},{5,6,7,8}};
        int[][]mm2 = {{2,4,6,8},{10,12,14,16}};
        Matrix m = new Matrix(mm);
        Matrix m2 = new Matrix(mm);
        Matrix mt = new Matrix(mm2);
        MatrixAddition matrixAddition = new MatrixAddition();
        assertEquals(mt.returnString(), matrixAddition.SumaMatrix(m,m2).returnString());

    }
}