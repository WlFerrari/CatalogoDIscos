import java.util.ArrayList;
import java.util.Scanner;

public class Catalogo {
    private static ArrayList<Disco> discos = new ArrayList<>();
    private static ArrayList<Artista> artistas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n💽Catálogo de Discos💽");
            System.out.println("1. Cadastrar novo disco");
            System.out.println("2. Cadastrar novo artista");
            System.out.println("3. Listar discos");
            System.out.println("4. Editar disco");
            System.out.println("5. Editar artista");
            System.out.println("6. Remover disco");
            System.out.println("7. Remover artista");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDisco();
                    break;
                case 2:
                    cadastrarArtista();
                    break;
                case 3:
                    listarDiscos();
                    break;
                case 4:
                    editarDisco();
                    break;
                case 5:
                    editarArtista();
                    break;
                case 6:
                    removerDisco();
                    break;
                case 7:
                    removerArtista();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 8);
    }

    private static void cadastrarDisco() {
        System.out.print("Título do disco: ");
        String titulo = scanner.nextLine();
        System.out.print("Ano de lançamento: ");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Escolha um artista: ");
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + ". " + artistas.get(i));
        }
        System.out.print("Número do artista: ");
        int artistaIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (artistaIndex >= 0 && artistaIndex < artistas.size()) { // Index é a posição dos artistas na lista (bgl amaldiçoado)
            Artista artista = artistas.get(artistaIndex);
            Disco disco = new Disco(titulo, anoLancamento, artista);

            System.out.print("Quantas faixas o disco possui? ");
            int numFaixas = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numFaixas; i++) {
                System.out.print("Digite o nome da faixa " + (i + 1) + ": ");
                String faixa = scanner.nextLine();
                disco.addFaixa(faixa);
            }

            discos.add(disco); // sdds do append no python
            System.out.println("Disco cadastrado com sucesso!");
        } else {
            System.out.println("Artista inválido!");
        }
    }

    private static void cadastrarArtista() {
        System.out.print("Nome do artista: ");
        String nome = scanner.nextLine();
        System.out.print("Gênero musical: ");
        String genero = scanner.nextLine();
        Artista artista = new Artista(nome, genero);
        artistas.add(artista);
        System.out.println("Artista cadastrado com sucesso!");
    }

    private static void listarDiscos() {
        if (discos.isEmpty()) { // Deus abençoe a w3schools
            System.out.println("Nenhum disco cadastrado.");
        } else {
            for (Disco disco : discos) {
                System.out.println(disco);
                System.out.println("===========================");
            }
        }
    }

    private static void editarDisco() { // Arrependimento: Era melhor ter feito alterando na propria instancia (agr ja foi)
        listarDiscos();
        System.out.print("Escolha o número do disco para editar: ");
        int index = scanner.nextInt() - 1; // 1 se transforma em 0 e etc
        scanner.nextLine();

        if (index >= 0 && index < discos.size()) {
            Disco disco = discos.get(index);

            System.out.print("Novo título (atual: " + disco.getTitulo() + "): ");
            String novoTitulo = scanner.nextLine();
            System.out.print("Novo ano de lançamento (atual: " + disco.getAnoLancamento() + "): ");
            int novoAno = scanner.nextInt();
            scanner.nextLine();

            disco.setTitulo(novoTitulo);
            disco.setAnoLancamento(novoAno);
            System.out.println("Disco editado com sucesso!");
        } else {
            System.out.println("Disco inválido!");
        }
    }

    private static void editarArtista() {
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + ". " + artistas.get(i));
        }
        System.out.print("Escolha o número do artista para editar: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < artistas.size()) {
            Artista artista = artistas.get(index);

            System.out.print("Novo nome (atual: " + artista.getNome() + "): ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo gênero musical (atual: " + artista.getGenero() + "): ");
            String novoGenero = scanner.nextLine();

            artista.setNome(novoNome);
            artista.setGenero(novoGenero);
            System.out.println("Artista editado com sucesso!");
        } else {
            System.out.println("Artista inválido!");
        }
    }

    private static void removerDisco() {
        listarDiscos();
        System.out.print("Escolha o número do disco para remover: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < discos.size()) {
            discos.remove(index);
            System.out.println("Disco removido com sucesso!");
        } else {
            System.out.println("Disco inválido!");
        }
    }

    private static void removerArtista() {
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + ". " + artistas.get(i));
        }
        System.out.print("Escolha o número do artista para remover: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < artistas.size()) {
            Artista artista = artistas.get(index);
            discos.removeIf(disco -> disco.getArtista().equals(artista));
            artistas.remove(index);
            System.out.println("Artista e seus discos removidos com sucesso!");
        } else {
            System.out.println("Artista inválido!");
        }
    }
}
