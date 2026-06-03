====================================================================
APLICAÇÃO RMI - CONTA BANCÁRIA
====================================================================

DESCRIÇÃO:
----------
Aplicação distribuída utilizando Java RMI (Remote Method Invocation)
que implementa uma conta bancária compartilhada entre múltiplos clientes.
O objeto remoto permite operações de depósito, saque e consulta de saldo
de forma concorrente e segura.

FUNCIONALIDADES:
---------------
- Depositar valores na conta
- Sacar valores (com validação de saldo)
- Consultar saldo atual
- Acesso simultâneo de múltiplos clientes
- Sincronização de dados para evitar condições de corrida

ESTRUTURA DOS ARQUIVOS:
-----------------------
BankAccount.java      - Interface remota
BankAccountImpl.java  - Implementação do objeto remoto
BankServer.java       - Servidor RMI
BankClient.java       - Cliente RMI
readme.txt           - Este arquivo

PRÉ-REQUISITOS:
--------------
- JDK (Java Development Kit) versão 8 ou superior instalado
- Conexão de rede local (para testes, pode ser localhost)

COMPILAÇÃO:
-----------
Para compilar todos os arquivos, execute no terminal:

javac *.java

EXECUÇÃO:
---------
1. Inicie o servidor (em um terminal):

java BankServer

   O servidor irá:
   - Criar uma conta com saldo inicial de R$ 1.000,00
   - Iniciar o registro RMI na porta 1099
   - Aguardar conexões dos clientes

2. Inicie o(s) cliente(s) (em outro(s) terminal(es)):

java BankClient

OPERAÇÕES DISPONÍVEIS NO CLIENTE:
---------------------------------
Opção 1 - Depositar:   Adiciona um valor positivo à conta
Opção 2 - Sacar:       Remove um valor da conta (se houver saldo)
Opção 3 - Consultar:   Exibe o saldo atual
Opção 0 - Sair:        Encerra o cliente

TESTANDO A APLICAÇÃO:
---------------------
Exemplo de uso com um cliente:

1. Consultar saldo    → R$ 1.000,00
2. Depositar R$ 500   → Saldo: R$ 1.500,00
3. Sacar R$ 200       → Saldo: R$ 1.300,00
4. Consultar saldo    → R$ 1.300,00

Teste com múltiplos clientes:

- Cliente 1 deposita R$ 100
- Cliente 2 consulta saldo (vê o novo saldo)
- Cliente 2 saca R$ 50
- Cliente 1 consulta saldo (vê o saldo atualizado)

CARACTERÍSTICAS TÉCNICAS:
-------------------------
- Interface remota estende java.rmi.Remote
- Implementação estende UnicastRemoteObject
- Métodos sincronizados (synchronized) para concorrência
- Registro RMI na porta padrão 1099
- Validação de valores positivos e saldo suficiente

ENCERRANDO A APLICAÇÃO:
-----------------------
1. Nos clientes: digite 0 ou pressione Ctrl+C
2. No servidor: pressione Ctrl+C

OBSERVAÇÕES:
------------
- O servidor deve ser iniciado ANTES de qualquer cliente
- Todos os clientes compartilham a MESMA conta bancária
- As operações são atômicas e thread-safe devido ao synchronized
- Para executar em rede, substitua "localhost" pelo IP do servidor

EXEMPLO DE SAÍDA DO SERVIDOR:
-----------------------------
Servidor RMI da conta bancária está rodando...
Objeto registrado como 'BankAccount'
Pressione Ctrl+C para encerrar o servidor
Depósito de R$ 500.0 realizado. Saldo atual: R$ 1500.0
Saque de R$ 200.0 realizado. Saldo atual: R$ 1300.0
Consulta de saldo: R$ 1300.0

EXEMPLO DE SAÍDA DO CLIENTE:
----------------------------
Cliente conectado à conta bancária RMI
=====================================

Operações disponíveis:
1 - Depositar
2 - Sacar
3 - Consultar Saldo
0 - Sair
Escolha uma opção: 3
Saldo atual: R$ 1000.0

====================================================================
