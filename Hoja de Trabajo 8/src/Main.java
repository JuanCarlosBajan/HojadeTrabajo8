import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        VectorHeap<Paciente> v = new VectorHeap<>();

        try {
            File myObj = new File("pacientes.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splited = data.split(", ");
                Paciente p = new Paciente(splited[0],splited[1],splited[2]);
                v.add(p);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        v.print();

    }

}
