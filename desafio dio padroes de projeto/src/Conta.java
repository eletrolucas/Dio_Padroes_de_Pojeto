import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    private List<Operacao> operacoes;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.operacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        registrarOperacao(valor, "saque");
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        registrarOperacao(valor, "deposito");
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        registrarOperacao(valor, "transferencia");
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    private void registrarOperacao(double valor, String tipo) {
        Operacao operacao = new Operacao(new Date(), valor, tipo);
        operacoes.add(operacao);
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato ===");
        for (Operacao operacao : operacoes) {
            System.out.println(operacao);
        }
        imprimirInfosComuns();
    }
}