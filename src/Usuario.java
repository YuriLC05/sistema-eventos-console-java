import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persistivel {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private List<Evento> eventosInscritos = new ArrayList<>();

    public Usuario(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void inscrever(Evento evento) {
        eventosInscritos.add(evento);
    }

    public void cancelarInscricao(Evento evento) {
        eventosInscritos.remove(evento);
    }

    @Override
    public void salvar() {
        // Implementação de persistência
    }

    @Override
    public void carregar() {
        // Implementação de carregamento
    }
}