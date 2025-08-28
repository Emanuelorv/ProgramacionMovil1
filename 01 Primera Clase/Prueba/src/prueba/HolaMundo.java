package prueba;

public class HolaMundo {
    String nombre = "John Doe"; //Por default
    
    public HolaMundo (){
        //saludar();
    }
//métodos
    public void saludar (String nombre){ //argumento -> dinero
        //this se refiere a esta clase, donde se esta trabajando
        this.nombre = nombre;
        //Metodo ocupa ese argumento, denero para pasear
        System.out.println("hola mundo" + nombre);
    }
    
    public static void despedirse(){
        System.out.println("adios");
        //EXIT_ON_CLOSE();
    }
}