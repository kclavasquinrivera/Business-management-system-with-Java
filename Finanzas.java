import java.util.HashMap;
import java.util.Scanner;

public class Finanzas {

    private static HashMap<String, Double> presupuesto = new HashMap<>();
    private static HashMap<String, Double> ventasMes = new HashMap<>();
    private static HashMap<String, Double> ventasAnio = new HashMap<>();
    private static final double IMPUESTO = 0.07;
    private static Scanner sc = new Scanner(System.in);

    static {

        presupuesto.put("CAJA", 5000.0);
        presupuesto.put("MARKETING", 3000.0);
        presupuesto.put("INVENTARIO", 4000.0);
        presupuesto.put("FINANZAS", 2000.0);
        presupuesto.put("RECURSOS_HUMANOS", 3500.0);

        ventasMes.put("enero", 12000.0);
        ventasMes.put("febrero", 15000.0);
        ventasMes.put("marzo", 18000.0);

        ventasAnio.put("2025", 200000.0);
        ventasAnio.put("2024", 180000.0);
    }

    public static void menuFinanzas() {
      
        while (true) {
          
            System.out.println("\n===== FINANCE DEPARTMENT =====");
            System.out.println("1. Sales");
            System.out.println("2. Taxes");
            System.out.println("3. Budget");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
          
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                
                case 1:
                    menuVentas();
                    break;
                
                case 2:
                    calcularImpuestos();
                    break;
                
                case 3:
                    menuPresupuesto();
                    break;
                
                case 4:
                    return;
                default:
                
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void menuVentas() {
      
        System.out.println("\n1. View monthly sales");
        System.out.println("2. View yearly sales");
        System.out.println("3. Register new sale");
        System.out.print("Select an option: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            
            case 1:
                System.out.println("Monthly sales:");
                for (String mes : ventasMes.keySet()) {
                    System.out.println(mes + ": $" + ventasMes.get(mes));
                }
                break;
            
            case 2:
                System.out.println("Yearly sales:");
                for (String anio : ventasAnio.keySet()) {
                    System.out.println(anio + ": $" + ventasAnio.get(anio));
                }
                break;
            
            case 3:
                registrarVenta();
                break;
            
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void registrarVenta() {
      
        System.out.print("Enter the month of the sale: ");
        String mes = sc.nextLine().toLowerCase();

        System.out.print("Enter the year of the sale: ");
        String anio = sc.nextLine();

        System.out.print("Enter the amount of the sale: ");
        double monto = sc.nextDouble();
        sc.nextLine();


        ventasMes.put(mes, ventasMes.getOrDefault(mes, 0.0) + monto);


        ventasAnio.put(anio, ventasAnio.getOrDefault(anio, 0.0) + monto);

        System.out.println("Sale registered successfully.");
    }

    private static void calcularImpuestos() {
      
        double totalVentas = 0;
        for (double v : ventasMes.values()) totalVentas += v;

        double impuestos = totalVentas * IMPUESTO;
        System.out.println("\n=== TAX CALCULATION ===");
        System.out.println("Total sales: $" + totalVentas);
        System.out.println("Taxes to pay (7%): $" + impuestos);

        // Opción de pagar impuestos (simulado)
        System.out.print("Do you want to register tax payment? (y/n): ");
        String opcion = sc.nextLine();
      
        if (opcion.equalsIgnoreCase("y")) {
          
            System.out.println("Tax payment registered successfully.");
        }
    }

    // ===== BUDGET =====
    private static void menuPresupuesto() {
      
        System.out.println("\n1. View budget by department");
        System.out.println("2. Modify department budget");
        System.out.print("Select an option: ");
      
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            
            case 1:
                mostrarPresupuesto();
                break;
            
            case 2:
                modificarPresupuesto();
                break;
            
            default:
                System.out.println("Invalid option.");
            
        }
    }

    private static void mostrarPresupuesto() {
      
        System.out.println("\n===== BUDGET BY DEPARTMENT =====");
      
        for (String dep : presupuesto.keySet()) {
            System.out.println(dep + ": $" + presupuesto.get(dep));
          
        }

        double totalNecesario = 0;
        for (double p : presupuesto.values()) totalNecesario += p;

        System.out.println("Total required to cover all departments: $" + totalNecesario);
      
    }

    private static void modificarPresupuesto() {
      
        System.out.print("Enter the department name to modify: ");
        String dep = sc.nextLine().toUpperCase();

        if (!presupuesto.containsKey(dep)) {
          
            System.out.println("Department does not exist.");
            return;
          
        }

        System.out.print("Enter the new budget: ");
        double nuevo = sc.nextDouble();
        sc.nextLine();

        presupuesto.put(dep, nuevo);
        System.out.println("Budget updated successfully.");
    }
}
