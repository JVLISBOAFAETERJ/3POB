package albergue;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcaoPrincipal = 0;

        do {
            exibirMenuPrincipal();
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcaoPrincipal) {
                case 1:
                    manipularCamas(scanner);
                    break;
                case 2:
                    manipularClientes(scanner);
                    break;
                case 3:
                    manipularQuartos(scanner);
                    break;
                case 4:
                    manipularReservas(scanner);
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoPrincipal != 5);

        scanner.close();
    }

    public static void exibirMenuPrincipal() {
        System.out.println("===== Menu Principal =====");
        System.out.println("1. Camas");
        System.out.println("2. Clientes");
        System.out.println("3. Quartos");
        System.out.println("4. Reservas");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirMenuCamas() {
        System.out.println("===== Menu Camas =====");
        System.out.println("1. Incluir Cama");
        System.out.println("2. Alterar Cama");
        System.out.println("3. Excluir Cama");
        System.out.println("4. Listar Camas");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirMenuClientes() {
        System.out.println("===== Menu Clientes =====");
        System.out.println("1. Incluir Cliente");
        System.out.println("2. Alterar Cliente");
        System.out.println("3. Excluir Cliente");
        System.out.println("4. Listar Clientes");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirMenuQuartos() {
        System.out.println("===== Menu Quartos =====");
        System.out.println("1. Incluir Quarto");
        System.out.println("2. Alterar Quarto");
        System.out.println("3. Excluir Quarto");
        System.out.println("4. Listar Quartos");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirMenuReservas() {
        System.out.println("===== Menu Reservas =====");
        System.out.println("1. Incluir Reserva");
        System.out.println("2. Alterar Reserva");
        System.out.println("3. Excluir Reserva");
        System.out.println("4. Listar Reservas");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void manipularCamas(Scanner scanner) {
        int opcaoCamas = 0;

        do {
            exibirMenuCamas();
            opcaoCamas = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoCamas){
                case 1:

                    System.out.println("===== Incluir Cama =====");
                    System.out.print("Digite o ID da cama: ");
                    int idCama = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o código da cama: ");
                    String codigoCama = scanner.nextLine();

                    System.out.print("A cama é beliche? (true/false): ");
                    boolean ehBeliche = scanner.nextBoolean();
                    scanner.nextLine(); 

                    System.out.print("Digite a posição da cama: ");
                    String posicao = scanner.nextLine();

                    System.out.print("Digite a descrição da cama: ");
                    String descricaoCama = scanner.nextLine();

                    cama novaCama = new cama(idCama, codigoCama, ehBeliche, posicao, descricaoCama);
                    cama.incluirCama(novaCama);
                    break;
                case 2:
                   
                    System.out.println("===== Alterar Cama =====");
                    System.out.print("Digite o ID da cama que deseja alterar: ");
                    int idCamaAlterar = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite o novo código da cama: ");
                    String novoCodigoCama = scanner.nextLine();

                    System.out.print("A cama é beliche? (true/false): ");
                    boolean novoEhBeliche = scanner.nextBoolean();
                    scanner.nextLine(); 

                    System.out.print("Digite a nova posição da cama: ");
                    String novaPosicao = scanner.nextLine();

                    System.out.print("Digite a nova descrição da cama: ");
                    String novaDescricaoCama = scanner.nextLine();

                    cama camaAlterada = new cama(idCamaAlterar, novoCodigoCama, novoEhBeliche, novaPosicao, novaDescricaoCama);
                    cama.alterarCama(idCamaAlterar, camaAlterada);
                    break;
                case 3:

                    System.out.println("===== Excluir Cama =====");
                    System.out.print("Digite o ID da cama que deseja excluir: ");
                    int idCamaExcluir = scanner.nextInt();
                    scanner.nextLine();

                    cama.excluirCama(idCamaExcluir);
                    break;
                case 4:
                   
                    System.out.println("===== Listar Camas =====");
                    cama.listarCamas();
                    break;
                case 5:
                    System.out.println("Voltando para o menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoCamas != 5);
    }

    public static void manipularClientes(Scanner scanner) {
        int opcaoClientes = 0;

        do {
            exibirMenuClientes();
            opcaoClientes = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcaoClientes) {
                case 1:
                  
                    System.out.println("===== Incluir Cliente =====");
                    System.out.print("Digite o ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("Digite o endereço do cliente: ");
                   String enderecoCliente = scanner.nextLine();

                    System.out.print("Digite o código postal do cliente: ");
                    String postalCode = scanner.nextLine();

                    System.out.print("Digite o país do cliente: ");
                    String pais = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Digite o Passaporte do cliente: ");
                    String passaporte = scanner.nextLine();

                    System.out.print("Digite o email do cliente: ");
                    String email = scanner.nextLine();

                    System.out.print("Digite a data de nascimento do cliente: ");
                    String dataNascimento = scanner.nextLine();

                    cliente novoCliente = new cliente(idCliente, nomeCliente, enderecoCliente, postalCode, pais, cpf, passaporte, email, dataNascimento);
                    cliente.incluirCliente(novoCliente);
                    break;
                case 2:
                  
                    System.out.println("===== Alterar Cliente =====");
                    System.out.print("Digite o ID do cliente que deseja alterar: ");
                    int idClienteAlterar = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite o novo nome do cliente: ");
                    String novoNomeCliente = scanner.nextLine();

                    System.out.print("Digite o novo endereço do cliente: ");
                    String novoEnderecoCliente = scanner.nextLine();

                    System.out.print("Digite o novo código postal do cliente: ");
                    String novoPostalCode = scanner.nextLine();

                    System.out.print("Digite o novo país do cliente: ");
                    String novoPais = scanner.nextLine();

                    System.out.print("Digite o novo CPF do cliente: ");
                    String novoCpf = scanner.nextLine();

                    System.out.print("Digite o novo Passaporte do cliente: ");
                    String novoPassaporte = scanner.nextLine();

                    System.out.print("Digite o novo email do cliente: ");
                    String novoEmail = scanner.nextLine();

                    System.out.print("Digite a nova data de nascimento do cliente: ");
                    String novaDataNascimento = scanner.nextLine();

                    cliente clienteAlterado = new cliente(idClienteAlterar, novoNomeCliente, novoEnderecoCliente, novoPostalCode, novoPais, novoCpf, novoPassaporte, novoEmail, novaDataNascimento);
                    cliente.alterarCliente(idClienteAlterar, clienteAlterado);
                    break;
                case 3:
                    
                    System.out.println("===== Excluir Cliente =====");
                    System.out.print("Digite o ID do cliente que deseja excluir: ");
                    int idClienteExcluir = scanner.nextInt();
                    scanner.nextLine(); 

                    cliente.excluirCliente(idClienteExcluir);
                    break;
                case 4:
                    
                    System.out.println("===== Listar Clientes =====");
                    cliente.listarClientes();
                    break;
                case 5:
                    System.out.println("Voltando para o menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoClientes != 5);
    }

    public static void manipularQuartos(Scanner scanner) {
        int opcaoQuartos = 0;

        do {
            exibirMenuQuartos();
            opcaoQuartos = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcaoQuartos) {
                case 1:
                    
                    System.out.println("===== Incluir Quarto =====");
                    System.out.print("Digite o ID do quarto: ");
                    int idQuarto = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do quarto: ");
                    String nomeQuarto = scanner.nextLine();

                    System.out.print("Digite a quantidade de camas do quarto: ");
                    int qtdeCamas = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("O quarto possui banheiro? (true/false): ");
                    boolean temBanheiro = scanner.nextBoolean();
                    scanner.nextLine(); 

                    System.out.print("Digite a descrição do quarto: ");
                    String descricaoQuarto = scanner.nextLine();

                    quarto novoQuarto = new quarto(idQuarto, nomeQuarto, qtdeCamas, temBanheiro, descricaoQuarto);
                    quarto.incluirQuarto(novoQuarto);
                    break;
                case 2:
                    
                    System.out.println("===== Alterar Quarto =====");
                    System.out.print("Digite o ID do quarto que deseja alterar: ");
                    int idQuartoAlterar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo nome do quarto: ");
                    String novoNomeQuarto = scanner.nextLine();

                    System.out.print("Digite a nova quantidade de camas do quarto: ");
                    int novaQtdeCamas = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("O quarto possui banheiro? (true/false): ");
                    boolean novoTemBanheiro = scanner.nextBoolean();
                    scanner.nextLine(); 

                    System.out.print("Digite a nova descrição do quarto: ");
                    String novaDescricaoQuarto = scanner.nextLine();

                    quarto quartoAlterado = new quarto(idQuartoAlterar, novoNomeQuarto, novaQtdeCamas, novoTemBanheiro, novaDescricaoQuarto);
                    quarto.alterarQuarto(idQuartoAlterar, quartoAlterado);
                    break;
                case 3:
                    
                    System.out.println("===== Excluir Quarto =====");
                    System.out.print("Digite o ID do quarto que deseja excluir: ");
                    int idQuartoExcluir = scanner.nextInt();
                    scanner.nextLine(); 

                    quarto.excluirQuarto(idQuartoExcluir);
                    break;
                case 4:
                   
                    System.out.println("===== Listar Quartos =====");
                    quarto.listarQuartos();
                    break;
                case 5:
                    System.out.println("Voltando para o menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoQuartos != 5);
    }

    public static void manipularReservas(Scanner scanner) {
        int opcaoReservas = 0;

        do {
            exibirMenuReservas();
            opcaoReservas = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcaoReservas) {
                case 1:
                    
                    System.out.println("===== Incluir Reserva =====");
                    System.out.print("Digite o ID da reserva: ");
                    int idReserva = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite o ID do quarto: ");
                    int idQuarto = scanner.nextInt();
                    scanner.nextLine(); 

                   System.out.print("Digite o ID da cama: ");
                    int idCama = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite o ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite a data de entrada da reserva: ");
                    String dataEntrada = scanner.nextLine();

                    System.out.print("Digite a data de saída da reserva: ");
                    String dataSaida = scanner.nextLine();

                    reserva novaReserva = new reserva(idReserva, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
                    reserva.incluirReserva(novaReserva);
                    break;
                case 2:
                   
                    System.out.println("===== Alterar Reserva =====");
                    System.out.print("Digite o ID da reserva que deseja alterar: ");
                    int idReservaAlterar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo ID do quarto: ");
                    int novoIdQuarto = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo ID da cama: ");
                    int novoIdCama = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo ID do cliente: ");
                    int novoIdCliente = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Digite a nova data de entrada da reserva: ");
                    String novaDataEntrada = scanner.nextLine();

                    System.out.print("Digite a nova data de saída da reserva: ");
                    String novaDataSaida = scanner.nextLine();

                    reserva reservaAlterada = new reserva(idReservaAlterar, novoIdQuarto, novoIdCama, novoIdCliente, novaDataEntrada, novaDataSaida);
                    reserva.alterarReserva(idReservaAlterar, reservaAlterada);
                    break;
                case 3:
                    
                    System.out.println("===== Excluir Reserva =====");
                    System.out.print("Digite o ID da reserva que deseja excluir: ");
                    int idReservaExcluir = scanner.nextInt();
                    scanner.nextLine(); 

                    reserva.excluirReserva(idReservaExcluir);
                    break;
                case 4:
                    
                    System.out.println("===== Listar Reservas =====");
                    reserva.listarReservas();
                    break;
                case 5:
                    System.out.println("Voltando para o menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoReservas != 5);
    }
}
