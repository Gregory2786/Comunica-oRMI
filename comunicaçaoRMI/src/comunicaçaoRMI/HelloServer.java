package comunicaçaoRMI;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloServer implements Hello {
    public HelloServer() {}

    public static void main(String[] args) {
        try {
            HelloServer server = new HelloServer();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1099); // Criar registro na porta 1099
            registry.bind("Servidor", stub);
            System.out.println("Servidor inicializado com sucesso.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public double calcularMedia(double num1, double num2, double num3) throws RemoteException {
        System.out.println("Calculando média dos números: " + num1 + ", " + num2 + ", " + num3);
        return (num1 + num2 + num3) / 3;
    }
}
