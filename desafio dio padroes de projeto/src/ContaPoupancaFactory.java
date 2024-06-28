public class ContaPoupancaFactory implements ContaFactory {
    @Override
    public Conta criarConta(Cliente cliente) {
        return new ContaPoupanca(cliente);
    }
}