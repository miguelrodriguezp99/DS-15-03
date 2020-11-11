package e2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Matrix implements Iterable<Integer>{

    public int [][] m;
    private boolean change = false;

    public Matrix(int columnas, int filas){

    m = new int [filas][columnas];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = 0;
            }
        }
    }

    public Matrix(int[][] matriz){

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


    }
    
//Leer matriz
    public int getColumnas(){
        return m[0].length;

    }

    public int getFilas(){
        return m.length;

    }
/*public void readMatrix() {
    int i;
    int j = 0;
    for (i = 0; i < m.length; i++) {
        for (j = 0; j < m[0].length; j++) {
            System.out.println();
        }
    }

}*/

public int getValor(int columna, int fila){

    if(columna > m[0].length || fila > m.length)
        throw new IllegalArgumentException("Fuera de rango");

    return m[fila][columna];

}

public void modificar(int fila, int columna, int valor){

        if(columna >= m[0].length){
            throw new IllegalArgumentException("Coordenada no valida");
        }
        if(fila >= m.length){
            throw new IllegalArgumentException("Coordenada no valida");
        }

        m[fila][columna] = valor;
}

public int[][] returnCopiaBidimensional(){
        int [][] c;
        c = this.m;
        return c;
}

public int[] returnCopiaFila(int fila){
    return m[fila].clone();
}

public Integer[] returnCopiaColumna(int columna){
    ArrayList<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < m.length; i++) {

      list.add(m[i][columna]);
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

    public void cambiarIterador(){
        change = !change;
    }

    public Iterator<Integer> columnRowIterator() {
        return new MiIteratorColumnas();
    }

    public Iterator<Integer> rowColumnIterator() {
        return new MiIteratorFilas();
    }

    @Override
    public Iterator<Integer> iterator() {
        if(!change){
            return new MiIteratorColumnas();
        }
        else
        {
            return new MiIteratorFilas();
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
            if(columna+1 >= m[0].length && fila+1 < m.length){
                return true;
            }
            return false;
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
            if(columna+1 >= m[0].length && fila+1 < m.length){
                return true;
            }
            return false;
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



    public static void main(String[] args) {
        int [][] matriz123 = {{1,3,4,5},{6,7,8,9}};
        Matrix m = new Matrix(matriz123);
        // System.out.println(m.returnString());
        // System.out.println(Arrays.toString(m.returnCopiaFila(0)));
        //System.out.println(Arrays.toString(m.returnCopiaColumna(1)));


    }


}
