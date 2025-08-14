import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class EntradaDados {

    public static Usuario entrarDadosUsuario() {
        try (Scanner entrada = new Scanner(System.in, StandardCharsets.UTF_8)){
                Usuario usuario = new Usuario();
                usuario.setId(UUID.randomUUID());

                System.out.println("--------- Cadastro de Usuário ---------");

                System.out.print("Nome: ");
                usuario.setNome(entrada.nextLine().trim());

                System.out.print("CPF: ");
                usuario.setCpf(entrada.nextLine().trim());

                System.out.print("E-mail: ");
                usuario.setEmail(entrada.nextLine().trim());

                System.out.print("Telefone(s) (separe por ';'): ");
                String tels = entrada.nextLine().trim();
                List<String> telefones = new ArrayList<>();
                if (!tels.isEmpty()) {
                    for (String t : tels.split(";")) {
                        String tt = t.trim();
                        if (!tt.isEmpty()) telefones.add(tt);
                    }
                }
                usuario.setTelefone(telefones);

                System.out.print("Senha: ");
                usuario.setPassword(entrada.nextLine().trim());

                return usuario;
        }
    }
}