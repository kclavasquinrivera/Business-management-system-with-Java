import java.util.Scanner;

public class Caja {
  
    private static double totalTarjeta = 0;
    private static double totalEfectivo = 0;
  
    public static void menuCaja(Usuario user) {
      Scanner sc = new Scanner(System.in);
  
        while (true) {
          
          System.out.println("\n===== CASH REGISTER =====");
          System.out.println("1. Checkout");
          System.out.println("2. Store Closing");
          System.out.println("3. User Info");
          System.out.println("4. Exit");
          System.out.print("Select an option: ");
          
          int op = sc.nextInt();
          sc.nextLine();
    
          switch (op) {
              
            case 1:
              facturar();
              break;
              
            case 2:
              cierre();
              break;
              
            case 3:
              
              System.out.println("User: " + user.getNombre());
              System.out.println("Department: " + user.getDepartamento());
              break;
              
            case 4:
              return;
          }
        }
      }
  
      private static void facturar() {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter product name: ");
        String p = sc.nextLine();
    
        System.out.print("Product cost: ");
        double costo = sc.nextDouble();
    
        double impuesto = costo * 0.07;
        double total = costo + impuesto;
    
        System.out.println("Final price with tax: $" + total);
    
        System.out.print("Pay with (1) Card or (2) Cash: ");
        int metodo = sc.nextInt();
    
        if (metodo == 1) {
          
          sc.nextLine();
          System.out.print("Enter card number: ");
          String tarjeta = sc.nextLine();
          totalTarjeta += total;
          System.out.println("Payment approved.");
          
        } else {
          
          System.out.print("Amount received in cash: ");
          double recibido = sc.nextDouble();
    
          if (recibido > total) {
            
            double vuelto = recibido - total;
            System.out.println("Change to give: $" + vuelto);
            
          } else if (recibido == total) {
            
            System.out.println("Exact payment.");
          } else {
            
            System.out.println("ERROR: insufficient funds.");
            return;
          }
    
          totalEfectivo += total;
        }
    
        System.out.println("Invoice processed.");
        
      }
  
      private static void cierre() {
        
        Scanner sc = new Scanner(System.in);
    
          System.out.println("\n===== STORE CLOSING =====");
          System.out.println("Total sales by card: $" + totalTarjeta);
          System.out.println("Total cash sales: $" + totalEfectivo);
      
          System.out.println("\nTotal cash you should have: $" + totalEfectivo);
      
          System.out.print("Enter actual cash on hand: ");
          double efectivoReal = sc.nextDouble();
      
          if (efectivoReal == totalEfectivo) {
            
            System.out.println("Closing correct. Cash register balanced.");
            
          } else {
            
            System.out.println("Closing incorrect. Cash discrepancy detected.");
          }
      }
}
