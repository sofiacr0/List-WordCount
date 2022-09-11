import java.util.*;
import java.io.*;
import static java.util.Collections.frequency;

public class T5 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Falta el nombre de archivo");
            System.exit(0);
        }

        FileReader fi = null;
        try {
            fi = new FileReader(args[0]);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }

        //Usar para leer linea x linea el archivo
        BufferedReader inputFile = new BufferedReader(fi);

        String textLine = null;

        int lineCount = 0;
        int wordCount = 0;
        int numberCount = 0;

        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";


        // Lista con todas las palabras diferentes
        /*Scanner tc = new Scanner(System.in);
        String[] palabra= new String[0];
        int veces=0;
        for (int i=0;i<palabra.length;i++){
            palabra[i] = tc.nextLine();
            veces++;
        }*/


        ArrayList<String> list = new ArrayList<String>();

        // Tiempo inicial
        long startTime = System.currentTimeMillis();
        try {
            while ((textLine = inputFile.readLine()) != null) {
                lineCount++;

                if (textLine.trim().length() == 0) {
                    continue; // la linea esta vacia, continuar
                }

                // separar las palabras en cada linea
                String[] words = textLine.split(delimiters);

                wordCount += words.length;

                for (String theWord : words) {

                    theWord = theWord.toLowerCase().trim();

                    boolean isNumeric = true;

                    // verificar si el token es un numero
                    try {
                        Double num = Double.parseDouble(theWord);
                    } catch (NumberFormatException e) {
                        isNumeric = false;
                    }

                    // Si el token es un numero, pasar al siguiente
                    if (isNumeric) {
                        numberCount++;
                        continue;
                    }

                    // si la palabra no esta en la lista, agregar a la lista
                    if ( !list.contains(theWord) ) {
                        list.add(theWord);
                    }
                }
            }

            /*Scanner tc = new Scanner(System.in);
            String[] palabra= new String[0];
            int veces=0;
            for (int i=0;i<palabra.length;i++){
                palabra[i] = tc.nextLine();
                veces++;
            }*/

            Scanner tc = new Scanner(System.in);
            System.out.print("Escriba la palabra que busca: ");
            String palabra;
            palabra = tc.nextLine();

            int veces = frequency(list, palabra);

            if (list.contains(palabra)) {
                System.out.print("La palabra \"" + palabra + "\" se repite " + veces + " veces");
            } else {
                System.out.println("La palabra no aparece en el texto");
            }

            /*for (String word : list) {
                System.out.println(word);
            }*/

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
