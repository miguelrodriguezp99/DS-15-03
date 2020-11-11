package e2;

import java.util.Iterator;

public class MatrixAddition {

    public Matrix SumaMatrix(Matrix m, Matrix m2){
        if(m.getColumnas() != m2.getColumnas() || m.getFilas() != m2.getFilas())
            throw new ArithmeticException("mery subnormal");

        //constructor de la matriz a devolver con el numero de filas y de columnas adecuado
        Matrix mt = new Matrix(m.getColumnas(), m.getFilas());

        //Creamos los iteradores //uno para cada matriz
        Iterator<Integer> i1 = m.rowColumnIterator();
        Iterator<Integer> i2 = m2.rowColumnIterator();


        mt.modificar(0,0, m2.getValor(0,0) + m.getValor(0,0));

        int j = 1;
        for(int i = 0; i < m.getFilas(); i++){
            for (; j < m.getColumnas(); j++) {

                //System.out.println("[" + i + "]" + "[" + j + "] : " + m.getValor(j,i) );

                mt.modificar(i,j,i1.next() + i2.next());

            }
            j = 0;
        }

        return mt;
    }


    public static void main(String[] args) {
        int[][]mm = {{1,2,3,4,5},{6,7,8,9}};
        Matrix m = new Matrix(mm);
        Matrix m2 = new Matrix(mm);

        MatrixAddition matrixAddition = new MatrixAddition();
        System.out.println("resultante: \n " + (matrixAddition.SumaMatrix(m,m2)).returnString());
    }

}


