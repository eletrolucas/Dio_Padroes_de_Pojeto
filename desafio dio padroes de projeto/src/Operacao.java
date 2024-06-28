import java.text.SimpleDateFormat;
import java.util.Date;

public class Operacao {
    private Date data;
    private double valor;
    private String tipo;

    public Operacao(Date data, double valor, String tipo) {
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "data=" + getFormattedDate() +
                ", valor=" + valor +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}