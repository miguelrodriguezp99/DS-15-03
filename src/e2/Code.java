package e2;


public class Code {
    /**
     * Determines whether a keypad is valid . To do this , it must be a rectangle and
     * the numbers must follow the alphanumeric sequence indicated . If the array
     * (or any of its subarrays ) is null it will be returned false .
     *
     * @param keypad The keypad to be analyzed .
     * @return true if it is valid , false otherwise .
     */
    public static boolean isKeypadValid(char[][] keypad) {


        if(keypad == null)
        {
            return false;
        }
        //Show del pad
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
                System.out.println(""); //creo el array
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
                    //System.out.println("V. Finish(numbers): ("+i+")"+"("+j+")"+"keypad:" + keypad[i][j]);

                }

                if (i < il) {
                    i--;
                }
                //System.out.println("V. Finish(numbers): ("+i+")"+"("+j+")"+"keypad:" + keypad[i][j]);

                //System.out.println("V. FFFFFFF(numbers): ("+i+")"+"("+j+")"+" keypad:" + keypad[i][j]);

                if (i == il) {
                    i--;
                }
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

                // 1 3 5 7
                // 2 4 6 8
                //i = filas
                //j = columnas
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
                // System.out.println("V. Finish(numbers): ("+i+")"+"("+j+")"+"keypad:" + keypad[i][j]);
                j--;
                //System.out.println("V. FFFFFFF(numbers): ("+i+")"+"("+j+")"+" keypad:" + keypad[i][j]);

                if (i == il) {
                    i = 0;
                    j++;
                }
                //System.out.println("V. AAAAAA(numbers): (" + i + ")" + "(" + j + ") " + keypad[i][j] + " contador: " + contador);


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
                // }

                // 1 2 3 4
                // 5 6 7 8
                //Comprobacion rectangulo

            }


            /**
             * Given a keypad and an array of movements , it returns a String with the code
             * resulting from applying the movements on the keypad .
             * @param keypad alphanumeric keypad .
             * @param movements Array with the different movements to be made for each
            number of the key .
             * @return Resulting code .
             * @throws IllegalArgumentException if the keypad of the movements are invalid .
             */
            return true;
        }

         public static String obtainCode ( char [][] keypad , String [] movements ) {

            StringBuilder resultado = new StringBuilder();
            int lm = movements.length;
            int j = 0;
            int i = 0;
             int il = keypad.length;
             int jl = keypad[0].length;
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


    /**
     * Checks if an array of movements is valid when obtaining a key on a keypad .
     * An array of movements is valid if it is formed by Strings that only have the
     * four capital letters U, D, L and R. If the array of Strings or any of the
     * Strings is null it will be returned false .
     * @param movements Array of Strings representing movements .
     * @return true if it is valid , false otherwise .
     */
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

    public static void main(String[] args) {
        //char[][] matriz = {{'1'}, {'2'}, {'3'}, {'4'}, {'5'}, {'6'}, {'7'}, {'8'}, {'9'}, {'0'}, {'A'}, {'B'}};
       /* char[][] matriz
                = {{'1', '5', '9', 'C'},
                   {'2', '6', '0', 'D'},
                   {'3', '7', 'A', 'E'},
                   {'4', '8', 'B', 'F'}};*/
               /* char[][] matriz
                = {{'1', '4', '7', '0'},
                   {'2', '5', '8', 'A'},
                   {'3', '6', '9', 'B'}};*/
              /* char[][] matriz
                = {{'1', '3', '5', '7','9','A'},
                   {'2', '4', '6', '8','0','B'}};*/
           /*     char[][] matriz
                = {{'1', '2', '3', '4'},
                   {'5', '6', '7', '8'},
                   {'9', '0', 'A', 'B'}};*/
     /*  char[][] matriz
                = {{'1', '2', '3', '4'},
                   {'5', '6', '7', '8'},
                   {'9', '0', 'A', 'B'},
                   {'C', 'D', 'E', 'F'}}; */

     /*  char[][] matriz
                = {{'1', '2', '3'},
                {'4', '5', '6',},
                {'7', '8', '9',},
                {'0', 'A', 'B',}};
                */

         /* char[][] matriz
                = {{'1', '2'},
                {'3', '4'},
                {'5', '6'},
                {'7', '8'},
                {'9', '0'},
                {'A', 'B'}};
          */

        /*char[][] matriz = {{'1'},
                {'2'},
                {'3'},
                {'4'},
                {'5'},
                {'6'},
                {'7'},
                {'8'},
                {'9'},
                {'0'},
                {'A'}};*/

        char[][] matriz  = {{'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'0', 'A', 'B'}};

        String [] movements = {"RURU","DL","D","R"};
        System.out.println(areMovementsValid(movements));
       // System.out.println(isKeypadValid(matriz));
        System.out.println(obtainCode(matriz, movements));

    }


}

