import java.util.Scanner;

/**
 * Classe utilizada para a controle do sistema.
 *
 * @author Iorran Santos de Lira
 */
public class MrBetMain {
    public static void main(String[] args) {
        MrBetSistema sistema = new MrBetSistema();
        Scanner scanner = new Scanner(System.in);
        String escolha = "";

        while (true) {
            escolha = menu(scanner);
            comando(escolha, sistema, scanner);
        }
    }

    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(M)Minha inclusão de times\n" +
                        "(R)Recuperar time\n" +
                        "(.)Adicionar campeonato\n" +
                        "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
                        "(E)Exibir campeonatos que o time participa\n" +
                        "(T)Tentar a sorte e status\n" +
                        "(!)Já pode fechar o programa!\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    private static String subMenu(Scanner scanner) {
        System.out.println("(I) Incluir time em campeonato ou" +
                " (V) Verificar se time está em campeonato?");
        return scanner.next().toUpperCase();
    }

    private static String subMenu2(Scanner scanner) {
        System.out.println("(A)Apostar ou (S)Status das Apostas?");
        return scanner.next().toUpperCase();
    }

    private static void subComando2(String opcao, MrBetSistema sistema, Scanner scanner) {
        switch (opcao) {
            case "A":
                tentaSorte(sistema, scanner);
                break;
            case "S":
                statusAposta(sistema);
                break;
        }
    }

    private static void subComando(String opcao, MrBetSistema sistema, Scanner scanner) {
        switch (opcao) {
            case "I":
                incluirTimeEmCampeonato(sistema, scanner);
                break;
            case "V":
                verificarTimeEmCampeonato(sistema, scanner);
                break;
        }
    }

        private static void comando(String opcao, MrBetSistema sistema, Scanner scanner) {
            switch (opcao) {
                case "M":
                    adicionaTimes(sistema, scanner);
                    break;
                case "R":
                    consultaTimes(sistema, scanner);
                    break;
                case ".":
                    adicionaCampeonato(sistema, scanner);
                    break;
                case "B":
                    String subescolha = subMenu(scanner);
                    subComando(subescolha, sistema, scanner);
                    break;
                case "E":
                    exibeCampeonato(sistema, scanner);
                    break;
                case "T":
                    String subescolha2 = subMenu2(scanner);
                    subComando2(subescolha2, sistema, scanner);
                    break;
                case "!":
                    sai();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }



        public static void adicionaTimes(MrBetSistema sistema, Scanner scanner) {
            System.out.print("Código: ");
            String id = scanner.next();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Mascote: ");
            String mascote = scanner.nextLine();
            String saida = sistema.adicionaTimes(id, nome, mascote);
            System.out.print(saida);
        }

        public static void consultaTimes(MrBetSistema sistema, Scanner scanner) {
        System.out.print("Código: ");
        String id = scanner.next();
        String saida = sistema.consultaTimes(id);
        System.out.print(saida);
        }

    private static void adicionaCampeonato(MrBetSistema sistema, Scanner scanner) {
        System.out.print("Campeonato: ");
        String nomeCampeonato = scanner.next();
        System.out.print("Participantes: ");
        int qtdParticipantes = scanner.nextInt();
        String saida = sistema.adicionaCampeonato(nomeCampeonato, qtdParticipantes);
        System.out.print(saida);


    }

    private static void incluirTimeEmCampeonato(MrBetSistema sistema, Scanner scanner){
        System.out.print("Código: ");
        String id = scanner.next();
        System.out.print("Campeonato: ");
        String nomeCampeonato = scanner.next();
        String saida = sistema.incluirTimeEmCampeonato(id, nomeCampeonato);
        System.out.print(saida);
    }

    private static void verificarTimeEmCampeonato(MrBetSistema sistema, Scanner scanner){
        System.out.print("Código: ");
        String id = scanner.next();
        System.out.print("Campeonato: ");
        String nomeCampeonato = scanner.next();
        String saida = sistema.verificarTimeEmCampeonato(id, nomeCampeonato);
        System.out.print(saida);
    }

    private static void exibeCampeonato(MrBetSistema sistema, Scanner scanner) {
        System.out.print("Time: ");
        String id = scanner.next();
        String saida = sistema.exibeCampeonato(id);
        System.out.print(saida);

    }

    private static void tentaSorte(MrBetSistema sistema, Scanner scanner) {
        System.out.print("Código: ");
        String id = scanner.next();
        System.out.print("Campeonato: ");
        String nomeCampeonato = scanner.next();
        scanner.nextLine();
        System.out.print("Colocação: ");
        int colocacao = scanner.nextInt();
        System.out.print("Valor da Aposta: R$");
        double valorAposta = scanner.nextDouble();
        String saida = sistema.tentaSorte(id, nomeCampeonato,colocacao,valorAposta);
        System.out.print(saida);
    }

    private static void statusAposta(MrBetSistema sistema) {
        String saida = sistema.statusAposta();
        System.out.print(saida);
    }
        private static void sai() {
            System.out.println("Por hoje é só pessoal!");
            System.exit(0);
        }
    }