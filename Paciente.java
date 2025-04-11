public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia; // A-E

    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    public String getNombre() { 
        return nombre; 
    }

    public String getSintoma() { 
        return sintoma; 
    }

    public char getCodigoEmergencia() { 
        return codigoEmergencia; 
    }

    public int getPrioridad() { 
        return codigoEmergencia - 'A'; 
    } // A=0, B=1, ..., E=4

    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }
}