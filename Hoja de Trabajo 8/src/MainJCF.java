import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MainJCF {
    public static void main(String[] args) {

        PriorityQueue<Paciente> pq = new PriorityQueue<>();

        try {
            File myObj = new File("pacientes.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splited = data.split(", ");
                Paciente p = new Paciente(splited[0],splited[1],splited[2]);
                pq.add(p);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        print(pq);

    }
    public static void print(PriorityQueue<Paciente> pq){
        int initialSize = pq.size();
        for (int i = 0; i<initialSize;i++){
            System.out.println(pq.peek().toString());
            pq.remove();
        }
    }


}
