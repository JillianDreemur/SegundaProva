package br.estoque.src.Main;
import br.estoque.src.Model.Fornecedor;
import br.estoque.src.Model.Produto;
import br.estoque.src.Model.GestorFornecedor;
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

    public void cadastrarFornecedor(GestorFornecedor gestorFornecedor){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do fornecedor: ");
        String nome = scanner.next();
        System.out.println("Digite o CNPJ do fornecedor: ");
        int cnpj = scanner.nextInt();
        System.out.println("Digite a senha do fornecedor: ");
        String senha = scanner.next();
        System.out.println("Digite o limite de produtos do fornecedor: ");
        int limiteProdutos = scanner.nextInt();
        Fornecedor novoFornecedor = new Fornecedor(nome, cnpj, senha, limiteProdutos);
        boolean cadastro = gestorFornecedor.cadastrarFornecedor(novoFornecedor);
        if(cadastro){
            System.out.println("Fornecedor " + nome + " cadastrado com " +
                    "sucesso!");
        } else {
            System.out.println("Erro no cadastro, por favor, " +
                    "tente novamente");
        }
    }

    public void buscarProdutoPorNome(GestorFornecedor gestorFornecedor){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite o nome do produto que deseja buscar: ");
        String nome = scanner.next();
        gestorFornecedor.buscarProdutoPorNome(nome);
    }

    public void exibirInfoFornecedor(GestorFornecedor gestorFornecedor){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CNPJ do fornecedor que deseja buscar: ");
        int cnpj = scanner.nextInt();
        Fornecedor busca = gestorFornecedor.exibirInfoFornecedor(cnpj);
        if(busca == null){
            System.out.println("Desculpe, mas esse fornecedor não existe.");
        } else {
            busca.exibirInfo();
        }
    }

    public void relatorioFornecedores(GestorFornecedor gestorFornecedor){
        for(int i = 0; i < gestorFornecedor.qntFornecedores; i++){
            System.out.println("Fornecedor %i" + i);
            System.out.println("\nNome: %s" + gestorFornecedor.listaDeFornecedores[i].nome);
            System.out.println("\nCNPJ: %i" + gestorFornecedor.listaDeFornecedores[i].cnpj);
            System.out.println("\nQuantidade de produtos: %i\n" +
                    gestorFornecedor.listaDeFornecedores[i].qntProdutosFornecedor);
        }
    }
}
