
import java.util.Scanner;

/**
 *
 * @author noteb
 */
public class ContaTerminal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        
        System.out.println("Por favor, digite o número da Agência:");
        int numero = leitura.nextInt();
        
        leitura.nextLine();
        
        System.out.println("Digite a Agência: ");
        String agencia = leitura.nextLine();
        
        System.out.println("Digite o Nome do Cliente: ");
        String nome = leitura.nextLine();
        
        System.out.println("Digite o Saldo: ");
        double saldo = leitura.nextDouble();
        
        System.out.println("Olá " +nome+
                ", obrigado por criar uma conta em nosso banco, sua agência é " 
                        +agencia+ ", conta " +numero+ " e seu saldo "+saldo+" já está disponível para saque\".");
       
    }
}
