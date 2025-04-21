import java.util.Scanner;
import java.time.LocalDateTime;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioService usuarioService = new UsuarioService();
        EventoService eventoService = new EventoService();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("=== Sistema de Eventos ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Cadastrar evento");
            System.out.println("4 - Listar eventos");
            System.out.println("5 - Inscrever usuário em evento");
            System.out.println("6 - Cancelar inscrição de usuário");
            System.out.println("7 - Listar inscrições de usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    Usuario usuario = new Usuario(usuarioService.gerarNovoId(), nome, email, telefone);
                    usuarioService.cadastrarUsuario(usuario);
                    System.out.println("Usuário cadastrado com sucesso!\n");
                    break;
                case 2:
                    usuarioService.listarUsuarios();
                    break;
                case 3:
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Categoria (SHOW, CONFERENCIA, ESPORTES, CURSO): ");
                    String categoriaStr = scanner.nextLine();
                    CategoriaEvento categoria;
                    try {
                        categoria = CategoriaEvento.valueOf(categoriaStr.toUpperCase());
                    } catch (Exception e) {
                        System.out.println("Categoria inválida! Evento não cadastrado.\n");
                        break;
                    }
                    System.out.print("Horário (AAAA-MM-DDTHH:MM, exemplo 2025-05-01T19:00): ");
                    String horarioStr = scanner.nextLine();
                    LocalDateTime horario;
                    try {
                        horario = LocalDateTime.parse(horarioStr);
                    } catch (Exception e) {
                        System.out.println("Horário inválido! Evento não cadastrado.\n");
                        break;
                    }
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    Evento evento = new Evento(nomeEvento, endereco, categoria, horario, descricao);
                    eventoService.cadastrarEvento(evento);
                    System.out.println("Evento cadastrado com sucesso!\n");
                    break;
                case 4:
                    eventoService.listarEventos();
                    break;
                case 5:
                    System.out.print("ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    Usuario u = usuarioService.buscarUsuarioPorId(idUsuario);
                    if (u == null) {
                        System.out.println("Usuário não encontrado!\n");
                        break;
                    }
                    System.out.print("Nome do evento para inscrição: ");
                    String nomeEventoInscricao = scanner.nextLine();
                    Evento ev = eventoService.buscarEventoPorNome(nomeEventoInscricao);
                    if (ev == null) {
                        System.out.println("Evento não encontrado!\n");
                        break;
                    }
                    u.inscrever(nomeEventoInscricao);
                    usuarioService.cadastrarUsuario(u); // Atualiza persistência
                    System.out.println("Inscrição realizada com sucesso!\n");
                    break;
                case 6:
                    System.out.print("ID do usuário: ");
                    int idUsuarioCanc = scanner.nextInt();
                    scanner.nextLine();
                    Usuario uc = usuarioService.buscarUsuarioPorId(idUsuarioCanc);
                    if (uc == null) {
                        System.out.println("Usuário não encontrado!\n");
                        break;
                    }
                    System.out.print("Nome do evento para cancelar inscrição: ");
                    String nomeEventoCanc = scanner.nextLine();
                    uc.cancelarInscricao(nomeEventoCanc);
                    usuarioService.cadastrarUsuario(uc); // Atualiza persistência
                    System.out.println("Inscrição cancelada!\n");
                    break;
                case 7:
                    System.out.print("ID do usuário: ");
                    int idUsuarioList = scanner.nextInt();
                    scanner.nextLine();
                    Usuario ul = usuarioService.buscarUsuarioPorId(idUsuarioList);
                    if (ul == null) {
                        System.out.println("Usuário não encontrado!\n");
                        break;
                    }
                    System.out.println("Eventos inscritos:");
                    for (String nomeEv : ul.getEventosInscritos()) {
                        System.out.println("- " + nomeEv);
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
            }
        }
        scanner.close();
    }
}