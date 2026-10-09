public class BaseDatos {


      private static Usuario[] usuarios = {
        
          new Usuario("Jose", "123", "MARKETING"),
          new Usuario("Clara", "abc", "MARKETING"),
          new Usuario("Maria", "abc", "CAJA"),
          new Usuario("Luis", "999", "CAJA"),
          new Usuario("Pablo", "pass", "INVENTARIO"),
          new Usuario("Elena", "321", "INVENTARIO"),
          new Usuario("Ana", "000", "FINANZAS"),
          new Usuario("Mario", "111", "FINANZAS"),
          new Usuario("Sofia", "222", "RECURSOS_HUMANOS"),
          new Usuario("David", "333", "RECURSOS_HUMANOS")
        
      };
  
    public static Usuario login(String nombre, String pass) {
      
      for (Usuario u : usuarios) {
        
        if (u.getNombre().equals(nombre) && u.getPassword().equals(pass)) {
          
          return u;
          
        }
      }
      
      return null;
    }
}

