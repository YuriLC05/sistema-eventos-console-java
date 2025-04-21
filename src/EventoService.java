import java.util.List;

public class EventoService {
    private List<Evento> eventos;
    private ArquivoService arquivoService = new ArquivoService();

    public EventoService() {
        eventos = arquivoService.carregarEventos();
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
        arquivoService.salvarEventos(eventos);
    }

    public void listarEventos() {
        System.out.println("=== Lista de Eventos ===");
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.\n");
        } else {
            for (Evento e : eventos) {
                System.out.println("Nome: " + e.getNome() +
                                   " | Endereço: " + e.getEndereco() +
                                   " | Categoria: " + e.getCategoria() +
                                   " | Horário: " + e.getHorario() +
                                   " | Descrição: " + e.getDescricao());
            }
            System.out.println();
        }
    }

    public Evento buscarEventoPorNome(String nome) {
        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nome)) return e;
        }
        return null;
    }

    public List<Evento> getEventos() {
        return eventos;
    }
}