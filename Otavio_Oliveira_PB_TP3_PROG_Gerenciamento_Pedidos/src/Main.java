import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setId(UUID.randomUUID());
        usuario.setNome("Otavio Oliveira");
        usuario.setCpf("12345678912");
        usuario.setEmail("otavio.otavio@gmail.com");
        usuario.setTelefone(Arrays.asList("11123451234", "13123451234"));
        usuario.setPassword("senha123456");

        //Usuario usuario = EntradaDados.entrarDadosUsuario();

        CRUD primeiroTeste = new CRUD(Path.of("usuarios.csv"));

        try {
            primeiroTeste.cadastrarUsuario(usuario);
        } catch (IOException e){
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}