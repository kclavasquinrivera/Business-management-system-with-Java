public class Usuario {
  
    private String nombre;
    private String password;  
    private String departamento;

    public Usuario(String nombre, String password, String departamento) {
      
        this.nombre = nombre;
        this.password = password;
        this.departamento = departamento;
      
    }

    public String getNombre() {
      
        return nombre;
      
    }

    public String getPassword() {   
      
        return password;
    }

    public String getDepartamento() {
        return departamento;
      
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
      
    }

    public void setPassword(String password) {
        this.password = password;
      
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
      
    }
}
