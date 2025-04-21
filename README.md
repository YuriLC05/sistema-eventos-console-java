# Sistema de Cadastro e Notificação de Eventos (Console Java)

Este é um sistema de eventos em console, desenvolvido em Java, seguindo o paradigma de Programação Orientada a Objetos (POO) e arquitetura MVC. O sistema permite o cadastro, listagem, inscrição e cancelamento de usuários em eventos, além de persistência dos dados em arquivos texto.

## Funcionalidades
- Cadastro de usuários
- Cadastro de eventos
- Listagem de usuários e eventos
- Inscrição de usuários em eventos
- Cancelamento de inscrições
- Listagem das inscrições de cada usuário
- Persistência de dados em arquivos `.data`
- Menus interativos em console

## Estrutura do Projeto
```
sistema-eventos-console-java/
├── src/
│   ├── ArquivoService.java
│   ├── CategoriaEvento.java
│   ├── ConsoleView.java
│   ├── Evento.java
│   ├── EventoService.java
│   ├── MainController.java
│   ├── Persistivel.java
│   ├── Usuario.java
│   ├── UsuarioService.java
├── usuarios.data
├── eventos.data
└── README.md
```

## Como Executar
1. **Pré-requisitos:**
   - Java 11 ou superior instalado
   - (Opcional) VS Code com extensão Java ou outro IDE

2. **Compilação:**
   - No terminal, navegue até a pasta do projeto e execute:
     ```sh
     javac -d bin src/*.java
     ```

3. **Execução:**
   - No terminal:
     ```sh
     java -cp bin MainController
     ```
   - Ou utilize o botão "Run and Debug" do VS Code com o arquivo `MainController.java` aberto.

## Instruções de Uso
- O sistema apresenta um menu principal com as seguintes opções:
  1. Cadastrar usuário
  2. Listar usuários
  3. Cadastrar evento
  4. Listar eventos
  5. Inscrever usuário em evento
  6. Cancelar inscrição de usuário
  7. Listar inscrições de usuário
  0. Sair

- **Cadastro:** Siga as instruções do console para inserir os dados.
- **Inscrição:** Informe o ID do usuário e o nome do evento para inscrever.
- **Persistência:** Os dados são salvos automaticamente em `usuarios.data` e `eventos.data`.
- **Os dados permanecem salvos mesmo após fechar o programa.**

## Observações
- O sistema utiliza apenas bibliotecas padrão do Java.
- O código segue boas práticas de POO e MVC.
- Comentários e organização foram priorizados para facilitar a manutenção e avaliação.

---

Desenvolvido para fins acadêmicos. Dúvidas ou sugestões, entre em contato!