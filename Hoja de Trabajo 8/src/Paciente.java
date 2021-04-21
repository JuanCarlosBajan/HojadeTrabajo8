public class Paciente implements Comparable<Paciente>{

    private String prioridad;
    private String descripcion;
    private String nombre;

    public Paciente(String n, String d, String p){
        prioridad=p;
        descripcion=d;
        nombre=n;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Paciente o) {
        return prioridad.compareTo(o.getPrioridad());
    }

    @Override
    public String toString() {
        return nombre + ", "+ descripcion + ", " + prioridad;
    }
}
