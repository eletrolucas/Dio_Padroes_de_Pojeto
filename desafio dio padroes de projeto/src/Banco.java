import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Conta criarConta(Cliente cliente, ContaFactory contaFactory) {
        Conta conta = contaFactory.criarConta(cliente);
        contas.add(conta);
        return conta;
    }
}
