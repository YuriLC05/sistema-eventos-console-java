import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios;
    private int proximoId = 1;
    private ArquivoService arquivoService = new ArquivoService();

    public UsuarioService() {
        usuarios = arquivoService.carregarUsuarios();
        if (!usuarios.isEmpty()) {
            proximoId = usuarios.stream().mapToInt(Usuario::getId).max().orElse(0) + 1;
        }
    }

    public int gerarNovoId() {
        return proximoId++;
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        arquivoService.salvarUsuarios(usuarios);
    }

    public void listarUsuarios() {
        System.out.println("=== Lista de Usuários ===");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.\n");
        } else {
            for (Usuario u : usuarios) {
                System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Email: " + u.getEmail() + " | Telefone: " + u.getTelefone());
            }
            System.out.println();
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}