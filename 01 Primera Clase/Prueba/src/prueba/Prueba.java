package prueba;
//Autor: Ortega Ventura Emanuel
public class Prueba {
    public static void main(String[] args) {
        
        HolaMundo.despedirse();//No necesita un objeto lo hace desde la clase, no necesita argumentos
        
        HolaMundo hm = new HolaMundo(); //Exa: como se crea un objeto nuevo -> con new
        //hm tipo de clase
        hm.nombre ="Omar";
        // hm.saludar(); //llama al método saludar
        hm.saludar("Ana"); //Este si da un argumento para colocarlo en el método
        
    }
}

