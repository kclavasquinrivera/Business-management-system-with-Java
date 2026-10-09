import java.util.ArrayList;
import java.util.Scanner;

public class Marketing {

    private static Scanner sc = new Scanner(System.in);

    private static double presupuesto = 5000.0;
    private static ArrayList<String> contratosPublicidad = new ArrayList<>();
    private static ArrayList<Double> gastosPublicidad = new ArrayList<>();
    private static ArrayList<String> gastosRedes = new ArrayList<>();
    private static ArrayList<Double> gastosRedesMontos = new ArrayList<>();
    private static ArrayList<String> contratosPatrocinadores = new ArrayList<>();
    private static ArrayList<Double> gastosPatrocinadores = new ArrayList<>();


    private static ArrayList<Evento> eventos = new ArrayList<>();


    private static ArrayList<String> patrocinadores = new ArrayList<>();

    static {
      
        contratosPublicidad.add("TV Ad - Agency XYZ");
        gastosPublicidad.add(1200.0);
        contratosPublicidad.add("Local Radio - Agency ABC");
        gastosPublicidad.add(700.0);

        gastosRedes.add("Instagram Ads");
        gastosRedesMontos.add(250.0);
        gastosRedes.add("Facebook Ads");
        gastosRedesMontos.add(180.0);

        contratosPatrocinadores.add("CocaCola - Launch Event");
        gastosPatrocinadores.add(400.0);
        contratosPatrocinadores.add("Nike - Promotion Event");
        gastosPatrocinadores.add(350.0);

        eventos.add(new Evento("2025-01-15", "Central Plaza", "Collection Launch", "CocaCola", 500));
        eventos.add(new Evento("2025-02-10", "Shopping Mall", "Valentine Promotion", "Nike", 300));

        patrocinadores.add("CocaCola");
        patrocinadores.add("Nike");
        patrocinadores.add("Adidas");
        patrocinadores.add("Pepsi");
      
    }

    public static void menuMarketing() {
      
        while (true) {
          
            System.out.println("\n===== MARKETING DEPARTMENT =====");
            System.out.println("1. Advertising expenses");
            System.out.println("2. Important events");
            System.out.println("3. Sponsors list");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
          
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                
                case 1: menuGastos(); break;
                case 2: menuEventos(); break;
                case 3: menuPatrocinadores(); break;
                
                case 4: return;
                
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void menuGastos() {
      
        while (true) {
          
            System.out.println("\n===== ADVERTISING EXPENSES =====");
            System.out.println("1. View budget and expenses");
            System.out.println("2. Advertising contracts");
            System.out.println("3. Social media expenses");
            System.out.println("4. Sponsor contracts");
            System.out.println("5. Add expense");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
          
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                
                case 1: verPresupuestoGastos(); break;
                case 2: verContratosPublicidad(); break;
                case 3: verGastosRedes(); break;
                case 4: verContratosPatrocinadores(); break;
                case 5: agregarGasto(); break;
                
                case 6: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void verPresupuestoGastos() {
      
        double totalGastos = 0;
        for (double g : gastosPublicidad) totalGastos += g;
        for (double g : gastosRedesMontos) totalGastos += g;
        for (double g : gastosPatrocinadores) totalGastos += g;

        System.out.println("\nInitial budget: $" + presupuesto);
        System.out.println("Total expenses: $" + totalGastos);
        System.out.println("Remaining budget: $" + (presupuesto - totalGastos));
    }

    private static void verContratosPublicidad() {
      
        System.out.println("\n===== ADVERTISING CONTRACTS =====");
        for (int i = 0; i < contratosPublicidad.size(); i++) {
          
            System.out.println("- " + contratosPublicidad.get(i) + " | Amount: $" + gastosPublicidad.get(i));
        }
    }

    private static void verGastosRedes() {
        System.out.println("\n===== SOCIAL MEDIA EXPENSES =====");
        for (int i = 0; i < gastosRedes.size(); i++) {
          
            System.out.println("- " + gastosRedes.get(i) + " | Amount: $" + gastosRedesMontos.get(i));
        }
    }

    private static void verContratosPatrocinadores() {
      
        System.out.println("\n===== SPONSOR CONTRACTS =====");
        for (int i = 0; i < contratosPatrocinadores.size(); i++) {
          
            System.out.println("- " + contratosPatrocinadores.get(i) + " | Amount: $" + gastosPatrocinadores.get(i));
          
        }
    }

    private static void agregarGasto() {
      
        System.out.println("\nSelect expense type:");
        System.out.println("1. Advertising contract");
        System.out.println("2. Social media expense");
        System.out.println("3. Sponsor contract");
        System.out.print("Option: ");
      
        int op = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter expense description: ");
        String desc = sc.nextLine();
        System.out.print("Enter expense amount: ");
        double monto = sc.nextDouble();
      
        sc.nextLine();

        switch (op) {
            
            case 1: contratosPublicidad.add(desc); gastosPublicidad.add(monto); break;
            case 2: gastosRedes.add(desc); gastosRedesMontos.add(monto); break;
            case 3: contratosPatrocinadores.add(desc); gastosPatrocinadores.add(monto); break;
            default: System.out.println("Invalid option."); return;
        }
      
        System.out.println("Expense added successfully.");
    }

    private static void menuEventos() {
      
        while (true) {
          
            System.out.println("\n===== EVENTS =====");
            System.out.println("1. Add event");
            System.out.println("2. View events");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
          
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                
                case 1: agregarEvento(); break;
                case 2: verEventos(); break;
                case 3: return;
                
                default: System.out.println("Invalid option.");
                
            }
        }
    }

    private static void agregarEvento() {
      
        System.out.print("Enter event date: ");
        String fecha = sc.nextLine();
        System.out.print("Enter event location: ");
        String lugar = sc.nextLine();
        System.out.print("Enter event purpose: ");
        String motivo = sc.nextLine();
        System.out.print("Enter sponsor/collaborator: ");
        String colaborador = sc.nextLine();
        System.out.print("Enter estimated event cost: ");
        double gasto = sc.nextDouble();
      
        sc.nextLine();

        eventos.add(new Evento(fecha, lugar, motivo, colaborador, gasto));
        System.out.println("Event added successfully.");
      
    }

    private static void verEventos() {
      
        System.out.println("\n===== EVENTS =====");
        if (eventos.isEmpty()) System.out.println("No events registered.");
          
        else eventos.forEach(e -> System.out.println(e));
      
    }

    private static void menuPatrocinadores() {
      
        while (true) {
          
            System.out.println("\n===== SPONSORS =====");
            System.out.println("1. View sponsors");
            System.out.println("2. Add sponsor");
            System.out.println("3. Cancel contract");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
          
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                
                case 1: verPatrocinadores(); break;
                case 2: agregarPatrocinador(); break;
                case 3: cancelarPatrocinio(); break;
                case 4: return;
                
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void verPatrocinadores() {
      
        if (patrocinadores.isEmpty()) System.out.println("No sponsors registered.");
          
        else patrocinadores.forEach(p -> System.out.println("- " + p));
    }

    private static void agregarPatrocinador() {
      
        System.out.print("Enter sponsor name: ");
      
        patrocinadores.add(sc.nextLine());
      
        System.out.println("Sponsor added successfully.");
      
    }

    private static void cancelarPatrocinio() {
      
        System.out.print("Enter sponsor name to cancel: ");
      
        String nombre = sc.nextLine();
      
        if (patrocinadores.remove(nombre)) System.out.println("Contract canceled successfully.");
          
        else System.out.println("Sponsor not found.");
    }
}
