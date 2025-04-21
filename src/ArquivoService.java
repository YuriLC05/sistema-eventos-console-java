import java.io.*;
import java.util.*;

public class ArquivoService {
    private static final String USUARIOS_FILE = "usuarios.data";
    private static final String EVENTOS_FILE = "eventos.data";

    // Salva lista de usuários em arquivo texto
    public void salvarUsuarios(List<Usuario> usuarios) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USUARIOS_FILE))) {
            for (Usuario u : usuarios) {
                writer.println(u.getId() + ";" + u.getNome() + ";" + u.getEmail() + ";" + u.getTelefone());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    // Carrega lista de usuários do arquivo texto
    public List<Usuario> carregarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    usuarios.add(new Usuario(id, partes[1], partes[2], partes[3]));
                }
            }
        } catch (IOException e) {
            // Arquivo pode não existir na primeira execução
        }
        return usuarios;
    }

    // Salva lista de eventos em arquivo texto
    public void salvarEventos(List<Evento> eventos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(EVENTOS_FILE))) {
            for (Evento e : eventos) {
                writer.println(e.getNome() + ";" + e.getEndereco() + ";" + e.getCategoria() + ";" + e.getHorario() + ";" + e.getDescricao());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos: " + e.getMessage());
        }
    }

    // Carrega lista de eventos do arquivo texto
    public List<Evento> carregarEventos() {
        List<Evento> eventos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(EVENTOS_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 5) {
                    try {
                        eventos.add(new Evento(
                            partes[0],
                            partes[1],
                            CategoriaEvento.valueOf(partes[2]),
                            java.time.LocalDateTime.parse(partes[3]),
                            partes[4]
                        ));
                    } catch (Exception ex) {
                        // Ignora linhas mal formatadas
                    }
                }
            }
        } catch (IOException e) {
            // Arquivo pode não existir na primeira execução
        }
        return eventos;
    }
}