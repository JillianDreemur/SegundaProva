package prova.aula.poo.src.Main;
import prova.aula.poo.src.Model.Estoque;
import prova.aula.poo.src.Model.Produto;
import java.util.Scanner;

public class MenuLoja {
    public int menuLoja(){
        System.out.println("===========================================" +
                         "\n=-             MENU DA LOJA              -=" +
                         "\n===========================================" +
                         "\n=- 0 - Voltar ao Menu Principal          -=" +
                         "\n=- 1 - Cadastrar novo produto            -=" +
                         "\n=- 2 - Ver disponibilidade do produto    -=" +
                         "\n=- 3 - Pesquisar produto por nome        -=" +
                         "\n=- 4 - Pesquisar produto por ID          -=" +
                         "\n=- 5 - Atualizar produto                 -=" +
                         "\n=- 6 - Excluir produto                   -=" +
                         "\n=- 7 - Gerar relatório dos produtos      -=" +
                         "\n===========================================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite a opção desejada: ");
        int opcaoLoja = scanner.nextInt();

        while (opcaoLoja < 0 || opcaoLoja > 7) {
            System.out.println("\nPor favor, digite uma das opções do menu.");
            System.out.println("\nDigite a opção desejada: ");
            opcaoLoja = scanner.nextInt();
        }
        return opcaoLoja;
    }

    public void cadastrarProduto(Estoque estoque){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do produto: ");
        String ID = scanner.next();
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.next();
        System.out.println("Digite a descrição do produto: ");
        String descricao = scanner.next();
        System.out.println("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade do estoque do produto: ");
        int qnt = scanner.nextInt();
        Produto produto = new Produto(ID, nome, descricao, preco, qnt);
        int cadastro = estoque.cadastrarProduto(produto);
        if(cadastro == 1){
            System.out.println("Produto cadastrado com sucesso!");
        } else if (cadastro == 2) {
            System.out.println("O estoque está cheio, não podemos cadastrar um novo produto.");
        } else {
            System.out.println("Erro no cadastro do produto, por favor, tente novamente.");
        }
    }

    public void verificarDisponibilidade(Estoque estoque){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite o nome do produto que deseja buscar: ");
        String nome = scanner.next();
        Produto verificacao = estoque.verificarDisponibilidade(nome);
        if(verificacao == null){
            System.out.println("Desculpe, mas o produto não está cadastrado no estoque.");
        } else if (verificacao.qntEstoque <= 1){
            System.out.println("O produto só tem 1 unidade disponível.");
        } else {
            verificacao.exibirInfo();
        }
    }

    public void atualizarProduto(Estoque estoque){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite o nome do produto que deseja atualizar: ");
        String nome = scanner.next();
        if(estoque.buscarNome(nome) == null){
            System.out.println("Desculpe, mas esse produto não existe.");
        } else {
            System.out.println("Por favor digite o novo ID do produto: ");
            String IDNovo = scanner.next();
            System.out.println("Por favor digite o novo nome do produto: ");
            String nomeNovo = scanner.next();
            System.out.println("Por favor digite a nova descrição do produto: ");
            String descricaoNovo = scanner.next();
            System.out.println("Por favor digite o novo preco do produto: ");
            double precoNovo = scanner.nextDouble();
            System.out.println("Por favor digite a nova quantidade dsponível do produto: ");
            int qntNovo = scanner.nextInt();
            Produto produto = new Produto(IDNovo, nomeNovo, descricaoNovo, precoNovo, qntNovo);
            boolean atualizacao = estoque.atualizarProduto(nome, produto);
            if(!atualizacao) {
                System.out.println("Houve algum erro na atualização do produto," +
                        "por favor, tente novamente.");
            } else {
                System.out.println("Produto atualizado com sucesso.");
            }
        }
    }

    public void excluirProduto(Estoque estoque){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto que deseja excluir: ");
        String nome = scanner.next();
        Produto busca = estoque.buscarNome(nome);
        if(busca == null){
            System.out.println("Desculpe, mas esse produto não existe.");
        } else {
            boolean exclusao = estoque.excluirProduto(nome);
            if(!exclusao){
                System.out.println("Erro ao excluir o produto, por favor, tente novamente.");
            } else {
                System.out.println("Produto excluído com sucesso.");
            }
        }
    }

    public void gerarRelatorio(Estoque estoque){
        if(estoque.qntProdutos == 0){
            System.out.println("O estoque da loja está vazio.");
        } else {
            System.out.println("QUANTIDADE DE PRODUTOS CADASTRADOS: %i" + estoque.qntProdutos);
            System.out.println("===========================================");
            for(int i = 0; i < estoque.qntProdutos; i++) {
                System.out.println("PRODUTO %i" + i);
                System.out.println("===========================================");
                System.out.println("Nome do produto: %s" + estoque.listaDeProdutos[i].nome);
                System.out.println("ID do produto: %s" + estoque.listaDeProdutos[i].ID);
                System.out.println("Descrição do produto: %s" +
                        estoque.listaDeProdutos[i].descricao);
                System.out.println("Preço do produto: %d" + estoque.listaDeProdutos[i].preco);
                System.out.println("Quantidade do produto no estoque: %i" +
                        estoque.listaDeProdutos[i].qntEstoque);
                System.out.println("===========================================");
            }
        }
    }

    public void buscarProdutoPorNome(Estoque estoque){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite o nome do produto que deseja buscar: ");
        String nome = scanner.next();
        Produto produtoBuscado = estoque.buscarNome(nome);
        System.out.println("Nome: %s" + produtoBuscado.nome);
        System.out.println("ID: %s" + produtoBuscado.ID);
        System.out.println("Descricao: %s" + produtoBuscado.descricao);
        System.out.println("Preço: %d" + produtoBuscado.preco);
        System.out.println("Quantidade no estoque: %i" + produtoBuscado.qntEstoque);
    }

    public void buscarProdutoPorID(Estoque estoque){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite o nome do produto que deseja buscar: ");
        String ID = scanner.next();
        Produto produtoBuscado = estoque.buscarID(ID);
        System.out.println("Nome: %s" + produtoBuscado.nome);
        System.out.println("ID: %s" + produtoBuscado.ID);
        System.out.println("Descricao: %s" + produtoBuscado.descricao);
        System.out.println("Preço: %d" + produtoBuscado.preco);
        System.out.println("Quantidade no estoque: %i" + produtoBuscado.qntEstoque);
    }
}
