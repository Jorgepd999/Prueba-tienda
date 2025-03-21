/**
 * @author AENUTEC
 */
package tienda;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void añadirProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto; // Retorna el producto si el código coincide
            }
        }
        return null;
    }

    public void eliminarProducto(String codigo) {
        productos.removeIf(p -> p.getCodigo().equals(codigo));
    }

    public void actualizarStock(String codigo, int nuevoStock) {
        Producto producto = buscarProductoPorCodigo(codigo);
        if (producto != null) {
            producto.setStock(nuevoStock);
        }
    }

    public List<Producto> listarProductos() {
        return productos;
    }
}