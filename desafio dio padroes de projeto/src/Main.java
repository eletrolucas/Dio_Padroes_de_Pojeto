import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("João Silva");

        Banco banco = new Banco("Banco Exemplo");
        banco.setContas(new ArrayList<>());

        ContaFactory contaCorrenteFactory = new ContaCorrenteFactory();
        ContaFactory contaPoupancaFactory = new ContaPoupancaFactory();

        Conta contaCorrente = banco.criarConta(cliente, contaCorrenteFactory);
        Conta contaPoupanca = banco.criarConta(cliente, contaPoupancaFactory);

        contaCorrente.depositar(1000);
        contaPoupanca.depositar(2000);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
    }
}