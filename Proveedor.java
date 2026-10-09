public class Proveedor {
    private String nombre;
    private String categoria;
    private String producto;
    private double precioCompra;

    public Proveedor(String nombre, String categoria, String producto, double precioCompra) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.producto = producto;
        this.precioCompra = precioCompra;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getProducto() { return producto; }
    public double getPrecioCompra() { return precioCompra; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setProducto(String producto) { this.producto = producto; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }

    @Override
    public String toString() {
        return nombre + " | " + categoria + " | " + producto + " | $" + precioCompra;
    }
}
