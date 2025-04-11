/**
 * clase que representa un paciente con nombre sintoma y codigo de emergencia
 * implementa comparable para ordenar por prioridad
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    /**
     * constructor que asigna los datos del paciente
     * @param nombre nombre del paciente
     * @param sintoma sintoma que presenta el paciente
     * @param codigoEmergencia letra que representa la prioridad
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /** @return nombre del paciente */
    public String getNombre() { return nombre; }

    /** @return sintoma del paciente */
    public String getSintoma() { return sintoma; }

    /** @return codigo de emergencia del paciente */
    public char getCodigoEmergencia() { return codigoEmergencia; }

    /**
     * convierte el codigo de emergencia en un numero de prioridad
     * @return prioridad numerica del paciente
     */
    public int getPrioridad() { return codigoEmergencia - 'A'; }

    /**
     * compara dos pacientes segun su codigo de emergencia
     * @param otro otro paciente a comparar
     * @return entero que indica la prioridad relativa
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    /** @return representacion en texto del paciente */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}