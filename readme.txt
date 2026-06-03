INSTRUÇÕES PARA COMPILAR E EXECUTAR A APLICAÇÃO RMI DE CONTA BANCÁRIA
=====================================================================

PRÉ-REQUISITOS:
- JDK (Java Development Kit) instalado (versão 8 ou superior)
- Terminal/Console para executar os comandos

ARQUIVOS DA APLICAÇÃO:
- BankAccount.java (interface remota)
- BankAccountImpl.java (implementação)
- BankServer.java (servidor)
- BankClient.java (cliente)

PASSO 1: COMPILAÇÃO
-------------------
Compile todos os arquivos .java com o seguinte comando:

javac *.java

Este comando gerará os arquivos .class correspondentes.

PASSO 2: INICIAR O SERVIDOR RMI
-------------------------------
Em um terminal, execute o servidor:

java BankServer

O servidor irá:
- Criar o objeto remoto da conta bancária (saldo inicial: R$ 1000)
- Iniciar o registro RMI na porta 1099
- Registrar o objeto com o nome "BankAccount"

PASSO 3: EXECUTAR OS CLIENTES
-----------------------------
Em outro(s) terminal(ais), execute os clientes:

java BankClient

Você pode executar quantos clientes quiser simultaneamente
para demonstrar o acesso concorrente à conta.

PASSO 4: TESTANDO A APLICAÇÃO
-----------------------------
Em cada cliente, você poderá:
- Depositar valores na conta
- Sacar valores (com verificação de saldo)
- Consultar o saldo atual

O servidor mostrará logs de todas as operações realizadas.

EXEMPLO DE USO:
---------------
Cliente 1: Depositar R$ 500
Cliente 2: Sacar R$ 200
Cliente 3: Consultar saldo (deve mostrar R$ 1300, se saldo inicial era R$ 1000)

CARACTERÍSTICAS DA IMPLEMENTAÇÃO:
---------------------------------
- Métodos sincronizados (synchronized) garantem acesso concorrente seguro
- Validação de valores positivos para depósitos e saques
- Verificação de saldo suficiente para saques
- Logs no servidor para acompanhamento das operações

PARA ENCERRAR A APLICAÇÃO:
-------------------------
1. Feche todos os clientes (opção 0 ou Ctrl+C)
2. Encerre o servidor com Ctrl+C

POSSÍVEIS PROBLEMAS E SOLUÇÕES:
-------------------------------
- Erro "Connection refused": Certifique-se que o servidor está rodando
- Erro "ClassNotFoundException": Verifique se todos os arquivos .class existem
- Porta 1099 em uso: Altere a porta no código do servidor e cliente

OBSERVAÇÕES:
-----------
- Todos os clientes compartilham a mesma conta bancária
- As operações são atômicas devido ao uso de 'synchronized'
- O servidor deve estar rodando antes de qualquer cliente