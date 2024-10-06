package comunicaçaoRMI;

import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
    public static void main(String[] args) {
        try {
            // Procura o registro do RMI no Servidor
            Hello stub = (Hello) LocateRegistry.getRegistry("localhost").lookup("Servidor");
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Informe o primeiro número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Informe o segundo número: ");
            double num2 = scanner.nextDouble();
            System.out.print("Informe o terceiro número: ");
            double num3 = scanner.nextDouble();
            
            // Chama o método do servidor e imprime a mensagem
            System.out.println("Invocando método do servidor para calcular a média.");
            double media = stub.calcularMedia(num1, num2, num3);
            System.out.println("A média aritmética é: " + media);
            
            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

