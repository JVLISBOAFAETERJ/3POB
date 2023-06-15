package loja;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoProdutos {
    private List<Produto> listaProdutos;
    private Scanner scanner;

    public AplicacaoProdutos() {
        listaProdutos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        AplicacaoProdutos aplicacao = new AplicacaoProdutos();
        aplicacao.executar();
    }

    public void executar() {
        int opcao = 0;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    incluirProduto();
                    break;
                case 2:
                    alterarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 4:
                    listarTodosProdutos();
                    break;
                case 5:
                    listarProduto();
                    break;
                case 6:
                    salvarProdutosEmArquivo();
                    System.out.println("Encerrando aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
            }

            System.out.println();
        } while (opcao != 6);
    }

    private void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Incluir produto");
        System.out.println("2. Alterar produto");
        System.out.println("3. Excluir produto");
        System.out.println("4. Listar todos produtos");
        System.out.println("5. Listar um produto");
        System.out.println("6. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    private void incluirProduto() {
        System.out.println("===== INCLUIR PRODUTO =====");
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o código de barras: ");
        String codigoBarras = scanner.nextLine();

        System.out.print("Digite o SKU: ");
        String sku = scanner.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Digite o peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Digite o fabricante: ");
        String fabricante = scanner.nextLine();

        Produto produto = new Produto(id, codigoBarras, sku, nome, descricao, categoria, preco, peso, fabricante);
        listaProdutos.add(produto);

        System.out.println("Produto adicionado com sucesso!");
    }

    private void alterarProduto() {
        System.out.println("===== ALTERAR PRODUTO =====");
        System.out.print("Digite o ID do produto que deseja alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Produto produtoEncontrado = null;

        for (Produto produto : listaProdutos) {
            if (produto.getId() == id) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null) {
            System.out.print("Digite o novo nome: ");
            String nome = scanner.nextLine();
            produtoEncontrado.setNome(nome);

            System.out.print("Digite a nova descrição: ");
            String descricao = scanner.nextLine();
            produtoEncontrado.setDescricao(descricao);

            System.out.print("Digite a nova categoria: ");
            String categoria = scanner.nextLine();
            produtoEncontrado.setCategoria(categoria);

            System.out.print("Digite o novo preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); 
            produtoEncontrado.setPreco(preco);

            System.out.print("Digite o novo peso: ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); 
            produtoEncontrado.setPeso(peso);

            System.out.print("Digite o novo fabricante: ");
            String fabricante = scanner.nextLine();
            produtoEncontrado.setFabricante(fabricante);

            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void excluirProduto() {
        System.out.println("===== EXCLUIR PRODUTO =====");
        System.out.print("Digite o ID do produto que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Produto produtoEncontrado = null;

        for (Produto produto : listaProdutos) {
            if (produto.getId() == id) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null) {
            listaProdutos.remove(produtoEncontrado);
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void listarTodosProdutos() {
        System.out.println("===== LISTAR TODOS PRODUTOS =====");

        try (Scanner fileScanner = new Scanner(new File("produtos.txt"))) {
            while (fileScanner.hasNextLine()) {
                String idStr = fileScanner.nextLine();
                String codigoBarras = fileScanner.nextLine();
                String sku = fileScanner.nextLine();
                String nome = fileScanner.nextLine();
                String descricao = fileScanner.nextLine();
                String categoria = fileScanner.nextLine();
                double preco = Double.parseDouble(fileScanner.nextLine());
                double peso = Double.parseDouble(fileScanner.nextLine());
                String fabricante = fileScanner.nextLine();
                fileScanner.nextLine();
                Produto produto = new Produto(Integer.parseInt(idStr), codigoBarras, sku, nome, descricao, categoria, preco, peso, fabricante);
                System.out.println(produto);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo 'produtos.txt' não encontrado.");
        }
    }

    private void listarProduto() {
        System.out.println("===== LISTAR PRODUTO =====");
        System.out.print("Digite o ID do produto que deseja listar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File("produtos.txt"))) {
            boolean produtoEncontrado = false;

            while (fileScanner.hasNextLine()) {
                String idStr = fileScanner.nextLine();
                String codigoBarras = fileScanner.nextLine();
                String sku = fileScanner.nextLine();
                String nome = fileScanner.nextLine();
                String descricao = fileScanner.nextLine();
                String categoria = fileScanner.nextLine();
                double preco = Double.parseDouble(fileScanner.nextLine());
                double peso = Double.parseDouble(fileScanner.nextLine());
                String fabricante = fileScanner.nextLine();
                fileScanner.nextLine();

                if (Integer.parseInt(idStr) == id) {
                    Produto produto = new Produto(Integer.parseInt(idStr), codigoBarras, sku, nome, descricao, categoria, preco, peso, fabricante);
                    System.out.println(produto);
                    produtoEncontrado = true;
                    break;
                }
            }

            if (!produtoEncontrado) {
                System.out.println("Produto não encontrado.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo 'produtos.txt' não encontrado.");
        }
    }

    private void salvarProdutosEmArquivo() {
        try (FileWriter fileWriter = new FileWriter("produtos.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            for (Produto produto : listaProdutos) {
                printWriter.println(produto.getId());
                printWriter.println(produto.getCodigoBarras());
                printWriter.println(produto.getSku());
                printWriter.println(produto.getNome());
                printWriter.println(produto.getDescricao());
                printWriter.println(produto.getCategoria());
                printWriter.println(produto.getPreco());
                printWriter.println(produto.getPeso());
                printWriter.println(produto.getFabricante());
                printWriter.println();
            }

            System.out.println("Produtos salvos no arquivo 'produtos.txt'.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os produtos no arquivo.");
        }
    }
}
