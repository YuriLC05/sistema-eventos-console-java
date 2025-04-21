import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persistivel {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private List<String> eventosInscritos = new ArrayList<>(); // Armazena nomes dos eventos

    public Usuario(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void inscrever(String nomeEvento) {
        if (!eventosInscritos.contains(nomeEvento)) {
            eventosInscritos.add(nomeEvento);
        }
    }

    public void cancelarInscricao(String nomeEvento) {
        eventosInscritos.remove(nomeEvento);
    }

    public List<String> getEventosInscritos() {
        return eventosInscritos;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
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