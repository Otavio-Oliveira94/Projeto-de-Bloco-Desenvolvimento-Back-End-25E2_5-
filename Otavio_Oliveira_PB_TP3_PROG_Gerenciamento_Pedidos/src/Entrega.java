import java.util.UUID;

public class Entrega {
    private UUID idEntrega;
    private String nome;
    private int ordem;

    public UUID getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(UUID idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
}
