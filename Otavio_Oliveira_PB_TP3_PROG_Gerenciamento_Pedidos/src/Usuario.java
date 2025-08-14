import java.util.List;
import java.util.UUID;

public class Usuario {
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private List<String> telefone;
    private String password;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<String> telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
