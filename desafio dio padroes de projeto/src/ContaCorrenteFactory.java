public class ContaCorrenteFactory implements ContaFactory {
    @Override
    public Conta criarConta(Cliente cliente) {
        return new ContaCorrente(cliente);
    }
}
