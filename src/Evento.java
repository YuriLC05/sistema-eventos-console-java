import java.time.LocalDateTime;

public class Evento extends Persistivel {
    private String nome;
    private String endereco;
    private CategoriaEvento categoria;
    private LocalDateTime horario;
    private String descricao;

    public Evento(String nome, String endereco, CategoriaEvento categoria, LocalDateTime horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public CategoriaEvento getCategoria() {
        return categoria;
    }
    public LocalDateTime getHorario() {
        return horario;
    }
    public String getDescricao() {
        return descricao;
    }

    public boolean isEmAndamento() {
        LocalDateTime agora = LocalDateTime.now();
        return !agora.isBefore(horario) && agora.isBefore(horario.plusHours(2));
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