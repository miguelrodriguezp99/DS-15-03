package e2;


public class Code {

    public static boolean isKeypadValid(char[][] keypad) {

        //Comprobación de nulos
        if(keypad == null)
        {
            return false;
        }
        //(int x = 0; x < keypad.length; x++)
        for (char[] chars : keypad) {
            if (chars == null) {
                return false;
            }
            for (int y = 0; y < keypad.length - 1; y++) {
                if (keypad[y] == null) {
                    return false;
                }
            }
        }

        int i = 1, j = 1;
        int il = keypad.length;
        int jl = keypad[0].length;
        int contador = 1;

       if(keypad[0][0]== '1' && keypad.length-1 == 0 && keypad[0].length-1 == 0)
        {
            return true;
        }

        for (i = 0; i < keypad.length; i++) {
            for (j = 0; j < keypad[i].length; j++) {
                System.out.println("");
            }
        }
            //numero esquina super izquierda
            if (keypad[0][0] != '1') {
                return false;
            }

        if (keypad[0].length > 1 && keypad[0][1] == '2') { //En la columna 0 en la fila 2 el valor es dos


                i = 0;
                while (i < keypad.length && contador < 10) {
                    j = 0;

                    while (j < keypad[0].length && contador < 10) {

                        if (keypad[i][j] != (char) (contador + '0')) {
                            return false;
                        } else contador++;
                            j++;
                    }
                    i++;


                }
                i--;

                if (j == jl) {
                    j--;
                }
                if(keypad[il-1][jl-1] == '9')
                {
                    return true;
                }
                if (j == jl-1) {

                    i++;
                    j = 0;
                }
                if (contador == 10 && keypad[i][j] != '0') {
                    return false;
                } else {
                    if (j == jl && i<il-1) {
                        j = 0;
                        i++;
                    }
                    j++;
                    contador = 0;
                    for (; i < keypad.length-1; i++) {
                        for (; j < keypad[0].length-1; j++) {
                            if (keypad[i][j] != (char) (contador + 'A')) {
                                return false;
                            } else contador++;
                        }
                        j = 0;
                    }

                }

                return true;
            } else if (keypad[1][0] == '2') {

                j = 0;
                while (j < keypad[0].length && contador < 10) {
                    i = 0;
                    while (i < keypad.length && contador < 10) {

                        if (keypad[i][j] != (char) (contador + '0')) {
                            return false;
                        } else contador++;
                        i++;
                    }
                    j++;
                }
                j--;


                if (i == il) {
                    i = 0;
                    j++;
                }

                if (contador == 10 && keypad[i][j] != '0') {
                    return false;
                } else {
                    i++;
                    contador = 0;
                    for (; j < keypad[0].length; j++) {
                        for (; i < keypad.length; i++) {
                            if (keypad[i][j] != (char) (contador + 'A')) {
                                return false;
                            } else contador++;
                        }
                        i = 0;
                    }

                }
                return true;
            }
            return true;
        }

         public static String obtainCode ( char [][] keypad , String [] movements ) {

            StringBuilder resultado = new StringBuilder();
            int j = 0;
            int i = 0;
            if(!isKeypadValid(keypad))
            {
                throw new IllegalArgumentException("El keypad no es válido");
            }

            for(String x : movements)
            {
                for(int k =0; k < x.length() ;k++)
                {
                    switch(x.charAt(k))
                    {
                        case 'D':
                            if(i<keypad.length-1)
                            {
                                i++;
                            }
                            break;

                        case 'U':
                            if(i>0)
                            {
                                i--;
                            }

                            break;
                        case 'L':
                            if(j>0)
                            {
                                j--;
                            }

                            break;
                        case 'R':
                            if(j<keypad[0].length-1)
                            {
                                j++;
                            }
                            break;
                        default:
                            System.out.println("Coordenada no válida");
                            break;

                    }


                }
                resultado.append(keypad[i][j]);


            }
            return resultado.toString();
         }

    public static boolean areMovementsValid(String[] movements) {


        if (movements == null)
        {
            return false;
        }
        for(String x : movements)
        {
            if (x == null){
                return false;
            }
        }

        for(String z : movements){
           for(int i=0; i<z.length() ;i++)
           {
               if(z.charAt(i) != 'U' && z.charAt(i) != 'D' && z.charAt(i) != 'L' && z.charAt(i) != 'R')
               {
                   return false;
               }
           }
        }
       return true;
    }

}

