package test;

import tienda.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {

    private Inventario inventario;
    private Producto producto;

    @BeforeEach
    public void setUp() {
        inventario = new Inventario(); // Inicializa el objeto Inventario antes de cada prueba
        producto = new Producto("001", "Producto 1", 100.0, 10); // Inicializa el objeto Producto antes de cada prueba
    }

    // Prueba para añadir un producto
    @Test
    public void testAñadirProducto() {
        inventario.añadirProducto(producto);
        assertEquals(1, inventario.listarProductos().size());
    }

    // Prueba para buscar un producto por código
    @Test
    public void testBuscarProductoPorCodigo() {
        inventario.añadirProducto(producto);
        Producto resultado = inventario.buscarProductoPorCodigo("001");
        assertNotNull(resultado);
        assertEquals("001", resultado.getCodigo());
    }

    // Prueba para eliminar un producto
    @Test
    public void testEliminarProducto() {
        inventario.añadirProducto(producto);
        inventario.eliminarProducto("001");
        assertEquals(0, inventario.listarProductos().size());
    }

    // Prueba para actualizar el stock de un producto
    @Test
    public void testActualizarStock() {
        inventario.añadirProducto(producto);
        inventario.actualizarStock("001", 100);
        Producto resultado = inventario.buscarProductoPorCodigo("001");
        assertEquals(100, resultado.getStock());
    }
}
