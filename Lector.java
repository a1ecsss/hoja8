/**
 * clase que lee pacientes desde un archivo de texto plano
 */
import java.io.*;
import java.util.*;
public class Lector {
    /**
     * lee un archivo y convierte sus lineas en objetos paciente
     * @param root nombre del archivo
     * @return lista de pacientes leidos del archivo
     */
    public static List<Paciente> leerPacientes(String root) {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(root))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    Paciente p = new Paciente(partes[0].trim(), partes[1].trim(), partes[2].trim().charAt(0));
                    pacientes.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + root);
        }
        return pacientes;
    }
}