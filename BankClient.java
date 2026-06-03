import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class BankClient {
    public static void main(String[] args) {
        try {
            // Conectar ao registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Obter o stub do objeto remoto
            BankAccount account = (BankAccount) registry.lookup("BankAccount");
            
            System.out.println("Cliente conectado à conta bancária RMI");
            System.out.println("=====================================");
            
            Scanner scanner = new Scanner(System.in);
            int option;
            
            do {
                System.out.println("\nOperações disponíveis:");
                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Consultar Saldo");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                
                option = scanner.nextInt();
                
                switch (option) {
                    case 1:
                        System.out.print("Digite o valor para depósito: R$ ");
                        double depositValue = scanner.nextDouble();
                        account.deposita(depositValue);
                        break;
                        
                    case 2:
                        System.out.print("Digite o valor para saque: R$ ");
                        double withdrawValue = scanner.nextDouble();
                        account.retira(withdrawValue);
                        break;
                        
                    case 3:
                        double currentBalance = account.saldo();
                        System.out.println("Saldo atual: R$ " + currentBalance);
                        break;
                        
                    case 0:
                        System.out.println("Encerrando cliente...");
                        break;
                        
                    default:
                        System.out.println("Opção inválida!");
                }
                
            } while (option != 0);
            
            scanner.close();
            
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}