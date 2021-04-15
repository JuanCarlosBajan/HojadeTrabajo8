import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static String currentLanguage;
    public static String newLanguage;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree<Word> bt = new BinaryTree<Word>();
        String ansn = "";
        String ansd = "";


        boolean run = true;
        while (run){
            System.out.println("Por favor indique el lenguaje en el que esta escrito el texto\n");
            System.out.println(" - i para ingles");
            System.out.println(" - e para espanol");
            System.out.println(" - f para frances");
            ansn = sc.nextLine();
            ansn = ansn.toLowerCase();

            if(ansn.equals("i") || ansn.equals("e") || ansn.equals("f")){
                run = false;
            } else {
                System.out.println("Ha ingresado un valor incorrecto.");
            }
        }


        run = true;
        while (run){
            System.out.println("Por favor indique el lenguaje al que quiere traducirlo.");
            System.out.println(" - i para ingles");
            System.out.println(" - e para espanol");
            System.out.println(" - f para frances");
            ansd = sc.nextLine();
            ansd = ansd.toLowerCase();

            if(ansd.equals("i") || ansd.equals("e") || ansd.equals("f")){
                run = false;
            } else {
                System.out.println("Ha ingresado un valor incorrecto.");
            }
        }

        switch (ansn) {
            case "i" -> currentLanguage = "english";
            case "e" -> currentLanguage = "spanish";
            case "f" -> currentLanguage = "french";
        }
        switch (ansd) {
            case "i" -> newLanguage = "english";
            case "e" -> newLanguage = "spanish";
            case "f" -> newLanguage = "french";
        }

        try {
            File myObj = new File("C:\\Users\\juanc\\OneDrive\\Escritorio\\UVG\\Tareas\\Algoritmos y estructura de Datos\\Hoja de Trabajo 7\\src\\Diccionario.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(",");
                Word w = new Word(words[0],words[1],words[2]);
                bt.add(w);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("C:\\Users\\juanc\\OneDrive\\Escritorio\\UVG\\Tareas\\Algoritmos y estructura de Datos\\Hoja de Trabajo 7\\src\\texto.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("\nTexto a traducir:");
                System.out.println(data);
                data=data.replace("*","");
                String[] words = data.split(" ");
                for (int i=0;i<words.length;i++){
                    if (bt.locate(new Word(words[i])) != null){
                        words[i] = bt.locate(new Word(words[i])).value.getWord(newLanguage);
                    }
                }
                data = String.join(" ",words);
                System.out.println("\nTexto traducido:");
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
