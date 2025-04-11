/**
 * clase principal que ejecuta el programa y permite elegir el tipo de estructura
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Heap<Paciente> heap = new Heap<>();
        java.util.PriorityQueue<Paciente> jcf = new java.util.PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        // pregunta al usuario que estructura desea usar
        System.out.println("¿Qué implementacion desea usar?\n1. Heap personalizado\n2. PriorityQueue de Java");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        boolean heapPersonal = opcion == 1;

        // lee los pacientes del archivo y los agrega a la estructura correspondiente
        List<Paciente> pacientes = Lector.leerPacientes("pacientes.txt");
        for (Paciente p : pacientes) {
            if (heapPersonal) {
                heap.insert(p, p.getPrioridad());
            } else {
                jcf.add(p);
            }
        }

        // imprime los pacientes segun el orden de prioridad
        System.out.println("\nPacientes en orden de prioridad:");
        while (heapPersonal ? !heap.isEmpty() : !jcf.isEmpty()) {
            Paciente paciente = heapPersonal ? heap.remove().value : jcf.poll();
            System.out.println(paciente);
        }
    }
}