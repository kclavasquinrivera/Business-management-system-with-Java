import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();
      
        usuarios.add(new Usuario("Jose", "123", "MARKETING"));
        usuarios.add(new Usuario("Clara", "abc", "MARKETING"));
        usuarios.add(new Usuario("Maria", "abc", "CAJA"));
        usuarios.add(new Usuario("Luis", "999", "CAJA"));
        usuarios.add(new Usuario("Pablo", "pass", "INVENTARIO"));
        usuarios.add(new Usuario("Elena", "321", "INVENTARIO"));
        usuarios.add(new Usuario("Ana", "000", "FINANZAS"));
        usuarios.add(new Usuario("Mario", "111", "FINANZAS"));
        usuarios.add(new Usuario("Sofia", "222", "RECURSOS_HUMANOS"));
        usuarios.add(new Usuario("David", "333", "RECURSOS_HUMANOS"));


        System.out.println("===== AVAILABLE USERS =====");
        System.out.printf("%-10s %-10s %-20s\n", "Username", "Password", "Department");
      
        for (Usuario u : usuarios) {
          
            System.out.printf("%-10s %-10s %-20s\n", u.getNombre(), u.getPassword(), u.getDepartamento());
        }
      
        System.out.println();


        System.out.println("===== LOGIN =====");
        System.out.print("Username: ");
        String nombre = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        Usuario loggedUser = null;
      
        for (Usuario u : usuarios) {
          
            if (u.getNombre().equals(nombre) && u.getPassword().equals(pass)) {
              
                loggedUser = u;
                break;
            }
        }

        if (loggedUser == null) {
          
            System.out.println("Incorrect username or password.");
            return;
        }

        System.out.println("\nWelcome " + loggedUser.getNombre() +
                           " | Department: " + loggedUser.getDepartamento());


        switch (loggedUser.getDepartamento()) {
            
            case "CAJA":
                Caja.menuCaja(loggedUser);
                break;
            
            case "MARKETING":
                Marketing.menuMarketing();
                break;
            
            case "INVENTARIO":
                Inventario.menuInventario();
                break;
            
            case "FINANZAS":
                Finanzas.menuFinanzas();
                break;
            
            case "RECURSOS_HUMANOS":
                RecursosHumanos.menuRRHH();
                break;
            
            default:
                System.out.println("Department not available yet.");
        }
    }
}
