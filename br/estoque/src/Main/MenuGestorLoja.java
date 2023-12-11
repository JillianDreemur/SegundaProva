package br.estoque.src.Main;
import br.estoque.src.Model.Fornecedor;
import br.estoque.src.Model.Produto;
import br.estoque.src.Model.GestorProdutos;
import java.util.Scanner;

public class MenuGestorLoja {
    public int menuGestao(){
        System.out.println("===========================================" +
                         "\n=-             GESTOR DA LOJA            -=" +
                         "\n===========================================" +
                         "\n=- 0 - Voltar ao Menu Principal          -=" +
                         "\n=- 1 - Cadastrar novo Fornecedor         -=" +
                         "\n=- 2 - Buscar produto por nome           -=" +
                         "\n=- 3 - Buscar produto por ID             -=" +
                         "\n=- 4 - Exibir informações do fornecedor  -=" +
                         "\n=- 5 - Exibir informações do produto     -=" +
                         "\n=- 6 - Exibir relatório dos fornecedores -=" +
                         "\n===========================================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite a opção desejada: ");
        int opcaoGestao = scanner.nextInt();

        while (opcaoGestao < 0 || opcaoGestao > 6) {
            System.out.println("\nPor favor, digite uma das opções do menu.");
            System.out.println("\nDigite a opção desejada: ");
            opcaoGestao = scanner.nextInt();
        }
        return opcaoGestao;
    }

    public void cadastrarFornecedor(GestorProdutos gestorProdutos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do fornecedor: ");
        String nome = scanner.next();
        System.out.println("Digite o CNPJ do fornecedor: ");
        int cnpj = scanner.nextInt();
        System.out.println("Digite a senha do fornecedor: ");
        String senha = scanner.next();
        int cadastro = gestorProdutos.cadastrarFornecedor
                (nome, cnpj, senha);
        if(cadastro == 1){
            System.out.println("Fornecedor " + nome + " cadastrado com " +
                    "sucesso!");
        } else if (cadastro == 2){
            System.out.println("Erro no cadastro, por favor, " +
                    "tente novamente");
        } else {
            System.out.println("Sinto muito, mas a lista de fornecedores " +
     "está cheia; Para cadastrar um novo fornecedor, " +
                    "libere espaço na lista.");
        }
    }

    public void buscarProdutoPorNome(GestorProdutos gestorProdutos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite o nome do produto que deseja buscar: ");
        String nome = scanner.next();
        Fornecedor[] fornecedoresProduto = gestorProdutos.buscarProdutoPorNome(nome);
        if(fornecedoresProduto.length == 0){
            System.out.println("Desculpe, mas não existe nenhum fornecedor que tenha esse produto.");
        } else {
            System.out.println("Fornecedores do produto %s" + nome);
            for(int i = 0; i < fornecedoresProduto.length; i++){
                System.out.println((i+1) + " ." + fornecedoresProduto[i]);
            }
        }
    }

    public void buscarProdutoPorID(GestorProdutos gestorProdutos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite o ID do produto que deseja buscar: ");
        String ID = scanner.next();
        Fornecedor[] fornecedoresProduto = gestorProdutos.buscarProdutoPorID(ID);
        if(fornecedoresProduto.length == 0){
            System.out.println("Desculpe, mas não existe nenhum fornecedor que tenha esse produto.");
        } else {
            System.out.println("Fornecedores do produto %s" + ID);
            for(int i = 0; i < fornecedoresProduto.length; i++){
                System.out.println((i+1) + " ." + fornecedoresProduto[i]);
            }
        }
    }

    public void exibirInfoFornecedor(GestorProdutos gestorProdutos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CNPJ do fornecedor que deseja buscar: ");
        int cnpj = scanner.nextInt();
        Fornecedor busca = gestorProdutos.exibirInfoFornecedor(cnpj);
        if(busca == null){
            System.out.println("Desculpe, mas esse fornecedor não existe.");
        } else {
            busca.exibirInfo();
        }
    }

    public void exibirInfoProduto(GestorProdutos gestorProdutos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto pelo qual deseja buscar: ");
        String nome = scanner.next();
        Produto[] produto = gestorProdutos.exibirInfoProduto(nome);
        for(int i = 0; i < produto.length; i++){
            if(produto.length == 0){
                System.out.println("Desculpe, mas nenhum fornecedor tem esse produto cadastrado.");
            } else {
                produto[i].exibirInfo();
            }
        }
    }

    public void relatorioFornecedores(GestorProdutos gestorProdutos){
        for(int i = 0; i < gestorProdutos.qntFornecedores; i++){
            System.out.println("Fornecedor %i" + i);
            System.out.println("\nNome: %s" + gestorProdutos.listaDeFornecedores[i].nome);
            System.out.println("\nCNPJ: %i" + gestorProdutos.listaDeFornecedores[i].cnpj);
            System.out.println("\nQuantidade de produtos: %i\n" +
                    gestorProdutos.listaDeFornecedores[i].qntProdutosFornecedor);
        }
    }
}
