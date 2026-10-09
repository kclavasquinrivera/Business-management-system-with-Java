import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Inventario {

    private static HashMap<String, ArrayList<Producto>> categorias = new HashMap<>();

    private static ArrayList<Proveedor> proveedores = new ArrayList<>();

    private static double presupuesto = 5000.0;

    private static Scanner sc = new Scanner(System.in);

    static {

        categorias.put("Camisas", new ArrayList<>());
        categorias.put("Pantalones", new ArrayList<>());
        categorias.put("Zapatos", new ArrayList<>());
        categorias.put("Chaquetas", new ArrayList<>());

        categorias.get("Camisas").add(new Producto("Camisa Roja", 20, "Camisas"));
        categorias.get("Camisas").add(new Producto("Camisa Azul", 25, "Camisas"));

        categorias.get("Pantalones").add(new Producto("Pantalón Negro", 30, "Pantalones"));
        categorias.get("Pantalones").add(new Producto("Pantalón Azul", 28, "Pantalones"));

        categorias.get("Zapatos").add(new Producto("Tenis Nike", 60, "Zapatos"));
        categorias.get("Zapatos").add(new Producto("Botas Timberland", 120, "Zapatos"));

        categorias.get("Chaquetas").add(new Producto("Chaqueta Negra", 50, "Chaquetas"));
        categorias.get("Chaquetas").add(new Producto("Chaqueta Azul", 55, "Chaquetas"));

        proveedores.add(new Proveedor("Proveedor A", "Camisas", "Camisa Roja", 15.0));
        proveedores.add(new Proveedor("Proveedor B", "Pantalones", "Pantalón Negro", 20.0));
        proveedores.add(new Proveedor("Proveedor C", "Zapatos", "Tenis Nike", 50.0));
        proveedores.add(new Proveedor("Proveedor D", "Chaquetas", "Chaqueta Negra", 40.0));
      
    }


    public static void menuInventario() {
      
        while (true) {
          
            System.out.println("\n===== INVENTORY DEPARTMENT =====");
            System.out.println("1. View inventory");
            System.out.println("2. Add new product");
            System.out.println("3. Suppliers");
            System.out.println("4. Expenses");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
          
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                
                case 1:
                    verInventario();
                    break;
                
                case 2:  
                    agregarProducto();
                    break;
                
                case 3:
                
                    menuProveedores();
                    break;
                case 4:
                
                    menuGastos();
                    break;
                
                case 5:
                    return;
                
                default:
                
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void verInventario() {
      
        System.out.println("\n===== INVENTORY =====");
      
        for (String cat : categorias.keySet()) {
          
            System.out.println("Category: " + cat);
            for (Producto p : categorias.get(cat)) {
              
                System.out.println(" - " + p.getNombre() + " | Price: $" + p.getPrecio());
              
            }
        }
    }

    private static void agregarProducto() {
      
        System.out.print("Enter the category: ");
        String cat = sc.nextLine();

        System.out.print("Enter the product name: ");
        String nombre = sc.nextLine();

        System.out.print("Enter the product price: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        Producto p = new Producto(nombre, precio, cat);
        categorias.putIfAbsent(cat, new ArrayList<>());
        categorias.get(cat).add(p);

        System.out.println("Product added successfully.");
      
    }

    private static void menuProveedores() {
      
        System.out.println("\n1. View suppliers");
        System.out.println("2. Add supplier");
        System.out.println("3. Remove supplier");
        System.out.print("Select an option: ");
      
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            
            case 1:
                verProveedores();
                break;
            
            case 2:
                agregarProveedor();
                break;
            
            case 3:
                eliminarProveedor();
                break;
            
            default:
                System.out.println("Invalid option.");
            
        }
    }

    private static void verProveedores() {
      
        System.out.println("\n===== SUPPLIERS =====");
        System.out.printf("%-15s %-15s %-20s %-10s\n", "Name", "Category", "Product", "Price");
      
        for (Proveedor prov : proveedores) {
          
            System.out.printf("%-15s %-15s %-20s $%-10.2f\n",
                    prov.getNombre(), prov.getCategoria(), prov.getProducto(), prov.getPrecioCompra());
        }
    }

    private static void agregarProveedor() {
      
        System.out.print("Enter supplier name: ");
        String nombre = sc.nextLine();

        System.out.print("Enter product category: ");
        String categoria = sc.nextLine();

        System.out.print("Enter product name: ");
        String producto = sc.nextLine();

        System.out.print("Enter purchase price: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        proveedores.add(new Proveedor(nombre, categoria, producto, precio));
        System.out.println("Supplier added successfully.");
      
    }

    private static void eliminarProveedor() {
      
        System.out.print("Enter supplier name to remove: ");
        String nombre = sc.nextLine();

        proveedores.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        System.out.println("Supplier removed successfully.");
      
    }

    private static void menuGastos() {
      
        System.out.println("\n1. View expenses");
        System.out.println("2. Reduce costs");
        System.out.println("3. Request more budget");
        System.out.print("Select an option: ");
      
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            
            case 1:
                verGastos();
                break;
            
            case 2:
                reducirCostos();
                break;
            
            case 3:
                solicitarPresupuesto();
                break;
            
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void verGastos() {
      
        double total = 0;
        for (Proveedor prov : proveedores) {
          
            total += prov.getPrecioCompra();
        }
      
        System.out.println("Total purchase expenses: $" + total);
        System.out.println("Available budget: $" + presupuesto);
      
    }

    private static void reducirCostos() {
      
        System.out.print("Enter supplier name to reduce purchases: ");
        String nombre = sc.nextLine();
        System.out.print("Enter new purchase price: ");
      
        double nuevo = sc.nextDouble();
        sc.nextLine();

        for (Proveedor prov : proveedores) {
          
            if (prov.getNombre().equalsIgnoreCase(nombre)) {
              
                prov.setPrecioCompra(nuevo);
                System.out.println("Cost updated successfully.");
                return;
            }
        }
      
        System.out.println("Supplier not found.");
    }

    private static void solicitarPresupuesto() {
      
        System.out.print("Enter additional budget amount: ");
      
        double extra = sc.nextDouble();
        sc.nextLine();

        presupuesto += extra;
        System.out.println("New available budget: $" + presupuesto);
      
    }
}
