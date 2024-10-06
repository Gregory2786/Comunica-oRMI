package comunicaçaoRMI;

import java.rmi.*;

public interface Hello extends Remote {
    public double calcularMedia(double num1, double num2, double num3) throws RemoteException;
}
