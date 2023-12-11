package br.estoque.src.Main;
import br.estoque.src.Model.Fornecedor;
import br.estoque.src.Model.Produto;
import br.estoque.src.Model.GestorFornecedor;
import java.util.Scanner;

public class MenuGestorFornecedor {
    public Fornecedor FornecedorLogado;

    public boolean login(GestorFornecedor gestorFornecedor){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Fornecedor, digite seu CNPJ para logar: ");
        int cnpj = scanner.nextInt();
        System.out.println("Fornecedor, digite sua SENHA para logar: ");
        String senha = scanner.next();
        for(int i = 0; i < gestorFornecedor.qntFornecedores; i++){
            if(gestorFornecedor.listaDeFornecedores[i].cnpj == cnpj &&
                    gestorFornecedor.listaDeFornecedores[i].senha.equalsIgnoreCase(senha)){
                this.FornecedorLogado = gestorFornecedor.listaDeFornecedores[i];
                System.out.println("Bem vindo, %s" + FornecedorLogado.nome);
                return true;
            }
        }
        return false;
    }

    public int menuGestorFornecedor(){
        System.out.println("===========================================" +
                         "\n=-           ÁREA DO FORNECEDOR          -=" +
                         "\n===========================================" +
                         "\n=- 0 - Voltar ao Menu Principal          -=" +
                         "\n=- 1 - Cadastrar novo produto            -=" +
                         "\n=- 2 - Buscar produto por nome           -=" +
                         "\n=- 3 - Buscar produto por ID             -=" +
                         "\n=- 4 - Exibir relatório dos produtos     -=" +
                         "\n===========================================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite a opção desejada: ");
        int opcaoGestaoFornec = scanner.nextInt();

        while (opcaoGestaoFornec < 0 || opcaoGestaoFornec > 4) {
            System.out.println("\nPor favor, digite uma das opções do menu.");
            System.out.println("\nDigite a opção desejada: ");
            opcaoGestaoFornec = scanner.nextInt();
        }
        return opcaoGestaoFornec;
    }

    public void cadastrarProduto(){
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
        boolean cadastro = FornecedorLogado.cadastrarProdutoFornecedor(produto);
        if(cadastro){
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Erro no cadastro do produto, " +
                    "por favor, tente novamente.");
        }
    }

    public void buscarProdutoPorNome(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPor favor digite o nome do produto que deseja buscar: ");
        String nome = scanner.next();
        Produto produtoBuscado = FornecedorLogado.buscarNome(nome);
        System.out.println("Nome: %s" + produtoBuscado.nome);
        System.out.println("ID: %s" + produtoBuscado.ID);
        System.out.println("Descricao: %s" + produtoBuscado.descricao);
        System.out.println("Preço: %d" + produtoBuscado.preco);
        System.out.println("Quantidade no estoque: %i" + produtoBuscado.qntEstoque);
    }

    public void buscarProdutoPorID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPor favor digite o nome do produto que deseja buscar: ");
        String nome = scanner.next();
        Produto produtoBuscado = FornecedorLogado.buscarID(nome);
        System.out.println("Nome: %s" + produtoBuscado.nome);
        System.out.println("ID: %s" + produtoBuscado.ID);
        System.out.println("Descricao: %s" + produtoBuscado.descricao);
        System.out.println("Preço: %d" + produtoBuscado.preco);
        System.out.println("Quantidade no estoque: %i" + produtoBuscado.qntEstoque);
    }

    public void relatorioProduto(){
        for(int i = 0; i < FornecedorLogado.qntProdutosFornecedor; i++){
            System.out.println("PRODUTO %i" + i);
            System.out.println("\n===========================================");
            System.out.println("\nID: %s" + FornecedorLogado.produtosDoFornecedor[i].ID);
            System.out.println("\nNome: %s" + FornecedorLogado.produtosDoFornecedor[i].nome);
            System.out.println("\nDescrição: %s" +
                    FornecedorLogado.produtosDoFornecedor[i].descricao);
            System.out.println("\nPreço: %d" + FornecedorLogado.produtosDoFornecedor[i].preco);
            System.out.println("\nQuantidade no estoque: %i" +
                    FornecedorLogado.produtosDoFornecedor[i].qntEstoque);
            System.out.println("\n===========================================\n");
        }
    }
}
