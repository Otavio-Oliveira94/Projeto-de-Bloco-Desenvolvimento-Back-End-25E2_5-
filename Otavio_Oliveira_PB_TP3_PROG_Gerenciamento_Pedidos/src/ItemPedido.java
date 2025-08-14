import java.util.UUID;

public class ItemPedido {
    private UUID idItemPedido;
    private int quantidade;
    private double preco;

    public UUID getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(UUID idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
