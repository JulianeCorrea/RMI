import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankServer {
    public static void main(String[] args) {
        try {
            // Criar o objeto remoto
            BankAccountImpl bankAccount = new BankAccountImpl(1000.0); // Saldo inicial R$ 1000
            
            // Iniciar o registro RMI na porta 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Registrar o objeto remoto
            registry.rebind("BankAccount", bankAccount);
            
            System.out.println("Servidor RMI da conta bancária está rodando...");
            System.out.println("Objeto registrado como 'BankAccount'");
            System.out.println("Pressione Ctrl+C para encerrar o servidor");
            
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}