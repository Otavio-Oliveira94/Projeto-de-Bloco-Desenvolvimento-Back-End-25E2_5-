import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CRUD {
    private static final String HEADER = "id,nome,cpf,email,telefone,password";
    private final Path csvPath;

    public CRUD(Path csvPath) {
        this.csvPath = csvPath;
    }

    public void cadastrarUsuario(Usuario usuario) throws IOException {
        gerarArquivo();

        if (!dadosValidos(usuario)){
            System.out.println("Dados inválidos para cadastro.");
            return;
        }
        if (usuarioExiste(usuario.getCpf(), usuario.getEmail())){
            System.out.println("Cliente já castrado.");
            return;
        }

        String linha = String.format(
                "%s, %s, %s, %s, %s, %s",
                usuario.getId(),
                escape(usuario.getNome()),
                escape(usuario.getCpf()),
                escape(usuario.getEmail()),
                escape(telefonesToCsv(usuario.getTelefone())),
                escape(usuario.getPassword())
        );

        try (BufferedWriter escreverArquivo = Files.newBufferedWriter(csvPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            escreverArquivo.write(linha);
            escreverArquivo.newLine();
        }
        System.out.println("Usuário cadastrado com sucesso.");
    }

    private void gerarArquivo() throws IOException {
        if (Files.notExists(csvPath)) {
            Files.createFile(csvPath);
            try (BufferedWriter escreverArquivo = Files.newBufferedWriter(csvPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                escreverArquivo.write(HEADER);
                escreverArquivo.newLine();
            }
        }
    }

    private boolean usuarioExiste(String cpf, String email) throws IOException {
        if (Files.notExists(csvPath)) {
            return false;
        }
        try (BufferedReader lerArquivo = Files.newBufferedReader(csvPath, StandardCharsets.UTF_8)) {
            String linha = lerArquivo.readLine();
            //lerArquivo.readLine();
            //String linha;
            while ((linha = lerArquivo.readLine()) != null) {
                String [] linhaFormatada = linha.split(",", -1);
                if(linhaFormatada.length < 4){
                    continue;
                }
                String cpfCsv = linhaFormatada[2].trim();
                String emailCsv = linhaFormatada[3].trim();

                if (cpfCsv.equals(cpf) || emailCsv.equalsIgnoreCase(email)) {
                    return true;
                }

                /*for (int i = 0; i < linhaFormatada.length; i++) {
                    linhaFormatada[i] = linhaFormatada[i].trim();
                    if (linhaFormatada[i].startsWith("\"") && linhaFormatada[i].endsWith("\"") && linhaFormatada[i].length() >= 2) {
                        linhaFormatada[i] = linhaFormatada[i].substring(1, linhaFormatada[i].length() - 1).replace("\"\"", "\"");
                    }
                }*/

                /*if (linhaFormatada.length >= 4) {
                    if(linhaFormatada[2].equals(cpf) || linhaFormatada[2].equals(email)) {
                        return true;
                    }
                }*/
            }
        }
        return false;
    }

    private boolean dadosValidos(Usuario usuario) {
        return usuario.getId() != null &&
                usuario.getNome() != null && !usuario.getNome().isBlank() &&
                usuario.getCpf() != null && !usuario.getCpf().isBlank() &&
                usuario.getEmail() != null && !usuario.getEmail().isBlank() &&
                usuario.getPassword() != null && !usuario.getPassword().isBlank();
    }

    private String telefonesToCsv(List<String> telefones) {
        return (telefones == null || telefones.isEmpty()) ? "" : String.join(";", telefones);
    }

    private String escape(String escape) {
        if (escape == null) {
            return "";
        }
        String limpar = escape.replace("\r", " ").replace("\n", " ");
        if (limpar.contains(",") || limpar.contains("\"")) {
            limpar = "\"" + limpar.replace("\"", "\"\"") + "\"";
        }
        return limpar;
    }
}