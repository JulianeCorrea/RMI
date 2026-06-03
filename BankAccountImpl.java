import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankAccountImpl extends UnicastRemoteObject implements BankAccount {
    private double balance;
    
    public BankAccountImpl() throws RemoteException {
        super();
        this.balance = 0.0;
    }
    
    public BankAccountImpl(double initialBalance) throws RemoteException {
        super();
        this.balance = initialBalance;
    }
    
    @Override
    public synchronized void deposita(double valor) throws RemoteException {
        if (valor > 0) {
            balance += valor;
            System.out.println("Depósito de R$ " + valor + " realizado. Saldo atual: R$ " + balance);
        } else {
            System.out.println("Valor de depósito inválido: R$ " + valor);
        }
    }
    
    @Override
    public synchronized void retira(double valor) throws RemoteException {
        if (valor > 0 && valor <= balance) {
            balance -= valor;
            System.out.println("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + balance);
        } else if (valor > balance) {
            System.out.println("Saldo insuficiente para saque de R$ " + valor + ". Saldo atual: R$ " + balance);
        } else {
            System.out.println("Valor de saque inválido: R$ " + valor);
        }
    }
    
    @Override
    public double saldo() throws RemoteException {
        System.out.println("Consulta de saldo: R$ " + balance);
        return balance;
    }
}
