package e2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Matrix implements Iterable<Integer>{

    public int [][] m;
    private boolean change = false;
    Iterator<Integer> i1;
    Iterator<Integer> i2;

    public Matrix(int columnas, int filas){  //Constructor
        m = new int [filas][columnas];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = 0;
            }
        }

        i1 = new MiIteratorFilas();
        i2 = new MiIteratorColumnas();
    }

    public Matrix(int[][] matriz){ //Constructor

        if(matriz == null)
        {
            throw new IllegalArgumentException("Matriz vacía");
        }

        int tamano = matriz[0].length;

        for (int[] ints : matriz) {
            if (ints == null) {
                throw new IllegalArgumentException("No es cuadrado");
            }
            if(tamano != ints.length){
                throw new IllegalArgumentException("No es cuadrado");
            }
        }

        m = matriz;
        i1 = new MiIteratorFilas();
        i2 = new MiIteratorColumnas();
    }
    

    public int getColumnas(){
        return m[0].length;

    }

    public int getFilas(){
        return m.length;

    }


public int getValor(int fila, int columna){ //GetValor de una coordenada

    if(columna > m[0].length || fila > m.length)
        throw new IllegalArgumentException("Fuera de rango");

    return m[fila][columna];

}

public void modificar(int fila, int columna, int valor){//

        if(columna >= m[0].length){
            throw new IllegalArgumentException("Coordenada no valida");
        }
        if(fila >= m.length){
            throw new IllegalArgumentException("Coordenada no valida");
        }

        m[fila][columna] = valor;
}

public int[][] returnCopiaBidimensional(){
        return m;
}

public int[] returnCopiaFila(int fila){
    return m[fila].clone();
}

public Integer[] returnCopiaColumna(int columna){
    ArrayList<Integer> list = new ArrayList<>();

    for (int[] ints : m) {
        list.add(ints[columna]);
    }
    Integer[] arrayColumna = new Integer[list.size()];
    list.toArray(arrayColumna);
    return arrayColumna;
}

public String returnString(){
        StringBuilder sb = new StringBuilder();
        for (int [] f : m) {
           sb.append(Arrays.toString(f)).append("\n");
        }

    return sb.toString();
}

    public Iterator<Integer> rowColumnIterator() {
        return i1;
    }
    public Iterator<Integer> columnRowIterator() {
        return i2;
    }

    public void cambiarIterador(){
        change = !change;
    }

    @Override
    public Iterator<Integer> iterator() {
        if(!change){
            return i1;
        }
        else
        {
            return i2;
        }
    }

    protected class MiIteratorFilas implements Iterator<Integer> {

        private int columna=0;
        private int fila=0;
        protected int posicionarray;
        public MiIteratorFilas()   {
            posicionarray = 0;
        }

        public boolean hasNext() {

            if(columna+1 < m[0].length){
             return true;
            }
            return columna + 1 >= m[0].length && fila + 1 < m.length;
        }

        public Integer next() {
            if(columna+1 < m[0].length) columna++;
            else {
                columna = 0;
                fila++;
            }
            return m[fila][columna];
        }

        public void remove(){
            throw new UnsupportedOperationException("No soportado.");
        }
    }



    protected class MiIteratorColumnas implements Iterator<Integer> {
        private int columna;
        private int fila;

        public MiIteratorColumnas()   {
            columna = 0;
            fila = 0;
        }
        public boolean hasNext() {

            if(columna+1 < m[0].length){
                return true;
            }
            return columna + 1 >= m[0].length && fila + 1 < m.length;
        }

        public Integer next() {
            if(columna+1 < m[0].length) columna++;
            else {
                columna = 0;
                fila++;
            }
            return m[fila][columna];
        }

        public void remove(){
            throw new UnsupportedOperationException("No soportado.");
        }
    }

}
