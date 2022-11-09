import java.util.*;
import java.io.*;

public class T5_MEJORADO {
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

        BufferedReader inputFile = new BufferedReader(fi);

        String textLine = null;

        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";

        ArrayList<String> list = new ArrayList<String>();

        try {//lee de renglón a renglón
            while ((textLine = inputFile.readLine()) != null) {

                if (textLine.trim().length() == 0) {
                    continue;
                }
                //palabras en un renglón
                String[] words = textLine.split(delimiters);
                //en palabra en palabra en cada renglón/agarra las palabras de cada renglón
                for (String theWord : words) {
                    //convierte todas las palabras a minúsculas y quita los espacios
                    theWord = theWord.toLowerCase().trim();

                    list.add(theWord);
                }
            }

            Scanner tc = new Scanner(System.in);
            System.out.print("Escriba la palabra que busca: ");
            String palabra;
            palabra = tc.nextLine();
            int veces=0;
            //int veces = Collections.frequency(list, palabra);

            for (String loquesea:list) {
                if (loquesea.equals(palabra)) {
                    veces++;
                }
            }
            if (veces==1){
                System.out.println("Se repite una vez");
            } else if (list.contains(palabra)) {
                    System.out.print("La palabra \"" + palabra + "\" se repite " + veces + " veces");
            } else {
                    System.out.println("La palabra no aparece en el texto");
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}