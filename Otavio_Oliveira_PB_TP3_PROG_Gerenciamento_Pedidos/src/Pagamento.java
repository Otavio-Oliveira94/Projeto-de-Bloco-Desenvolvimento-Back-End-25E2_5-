import java.time.LocalDateTime;
import java.util.UUID;

public class Pagamento {
    private UUID idPagamento;
    private LocalDateTime dataPagamento;
    private double valor;
    private String statusTransacao;

    public UUID getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(UUID idPagamento) {
        this.idPagamento = idPagamento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatusTransacao() {
        return statusTransacao;
    }

    public void setStatusTransacao(String statusTransacao) {
        this.statusTransacao = statusTransacao;
    }
}
