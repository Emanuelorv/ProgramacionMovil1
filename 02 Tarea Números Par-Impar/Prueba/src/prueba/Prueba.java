package prueba;
import java.util.Scanner;
/**
 *
 * @author Ortega Ventura Emanuel
 */
public class Prueba {
    public static void main(String[] args) {
        NumerosParImpar npi = new NumerosParImpar();
        //npi.valida(19);
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un numero");
        int num = sc.nextInt();
        npi.validar(num);
    }
    
}
