import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * pruebas unitarias para verificar el funcionamiento del heap personalizado usando junit y hamcrest
 */
public class HeapTest {

    @Test
    public void testInsertYRemoveConUnPaciente() {
        Heap<Paciente> heap = new Heap<>();
        Paciente p = new Paciente("juan", "fiebre", 'B');
        heap.insert(p, p.getPrioridad());
        Paciente resultado = heap.remove().value;
        assertThat(resultado.getNombre(), is("juan"));
        assertThat(resultado.getCodigoEmergencia(), is('B'));
    }

    @Test
    public void testOrdenDeRemocion() {
        Heap<Paciente> heap = new Heap<>();
        heap.insert(new Paciente("ana", "dolor", 'C'), 'C' - 'A');
        heap.insert(new Paciente("mario", "fractura", 'A'), 'A' - 'A');
        heap.insert(new Paciente("luisa", "mareo", 'B'), 'B' - 'A');
        assertThat(heap.remove().value.getNombre(), is("mario"));
        assertThat(heap.remove().value.getNombre(), is("luisa"));
        assertThat(heap.remove().value.getNombre(), is("ana"));
    }

    @Test
    public void testHeapVacio() {
        Heap<Paciente> heap = new Heap<>();
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void testHeapNoVacioDespuesDeInsertar() {
        Heap<Paciente> heap = new Heap<>();
        heap.insert(new Paciente("eva", "tos", 'D'), 'D' - 'A');
        assertThat(heap.isEmpty(), is(false));
    }
}
