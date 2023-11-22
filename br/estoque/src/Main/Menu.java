package prova.aula.poo.src.Main;
import prova.aula.poo.src.Model.Estoque;
import prova.aula.poo.src.Model.GestorProdutos;
import java.util.Scanner;

public class Menu {
    public int menuPrincipal(){
        System.out.println("==============================" +
                         "\n=-      MENU PRINCIPAL      -=" +
                         "\n==============================" +
                         "\n=- 0 - Sair                 -=" +
                         "\n=- 1 - Menu de Gestão       -=" +
                         "\n=- 2 - Menu da Loja         -=" +
                         "\n=- 3 - Login Fornecedor     -=" +
                         "\n==============================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite a opção desejada: ");
        int opcaoPrincipal = scanner.nextInt();

        while (opcaoPrincipal < 0 || opcaoPrincipal > 3) {
            System.out.println("\nPor favor, digite uma das opções do menu.");
            System.out.println("\nDigite a opção desejada: ");
            opcaoPrincipal = scanner.nextInt();
        }
        return opcaoPrincipal;
    }

    public void Perfumaria(MenuLoja menuLoja, MenuGestorLoja menuGestorLoja, Estoque estoque,
            GestorProdutos gestorProdutos, MenuGestorFornecedor menuGestorFornecedor){
        while (true){
            int opcao;
            opcao = menuPrincipal();
            switch (opcao){
                case 0: //SAIDA DO MENU PRINCIPAL
                    break;
                case 1: // ENTRADA MENU DA LOJA
                    while (true){
                        int opcaoLoja;
                        opcaoLoja = menuLoja.menuLoja();
                        switch (opcaoLoja){
                            case 0: // VOLTAR AO MENU PRINCIPAL
                                break;
                            case 1: // CADASTRAR PRODUTO
                                menuLoja.cadastrarProduto(estoque);
                            case 2: // DISPONIBILIDADE DO PRODUTO
                                menuLoja.verificarDisponibilidade(estoque);
                            case 3: // PESQUISAR PRODUTO POR NOME
                                menuLoja.buscarProdutoPorNome(estoque);
                            case 4: // PESQUISAR PRODUTO POR ID
                                menuLoja.buscarProdutoPorID(estoque);
                            case 5: // ATUALIZAR PRODUTO
                                menuLoja.atualizarProduto(estoque);
                            case 6: // EXCLUIR PRODUTO
                                menuLoja.excluirProduto(estoque);
                            case 7: // GERAR RELATORIO
                                menuLoja.gerarRelatorio(estoque);
                        }
                    }
                case 2: // ENTRADA MENU DO GESTOR
                    while (true){
                        int opcaoGestor;
                        opcaoGestor = menuGestorLoja.menuGestao();
                        switch (opcaoGestor){
                            case 0: // VOLTAR AO MENU PRINCIPAL
                                break;
                            case 1: // CADASTRAR FORNECEDOR
                                menuGestorLoja.cadastrarFornecedor(gestorProdutos);
                            case 2: // BUSCAR PRODUTO POR NOME
                                menuGestorLoja.buscarProdutoPorNome(gestorProdutos);
                            case 3: // BUSCAR PRODUTO POR NOME
                                menuGestorLoja.buscarProdutoPorID(gestorProdutos);
                            case 4: // EXIBIR INFORMAÇÕES DO FORNECEDOR
                                menuGestorLoja.exibirInfoFornecedor(gestorProdutos);
                            case 5: // EXIBIR INFORMAÇÕES DO PRODUTO
                                menuGestorLoja.exibirInfoProduto(gestorProdutos);
                            case 6: // EXIBIR RELATÓRIO DOS FORNECEDORES
                                menuGestorLoja.relatorioFornecedores(gestorProdutos);
                        }
                    }
                case 3: // ENTRADA GESTÃO DO FORNECEDOR
                    boolean login = menuGestorFornecedor.login(gestorProdutos);
                    while (!login){
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Um dos dados está incorreto. " +
                                "\nGostaria de tentar novamente?" +
                                "\nPara Sim digite 1; Para não, digite qualquer outro número.");
                        int confirmacao = scanner.nextInt();
                        if(confirmacao == 1){
                            login = menuGestorFornecedor.login(gestorProdutos);
                        } else {
                            break;
                        }
                    }
                    while (true){ // FORNECEDOR LOGADO
                        int opcaoFornecedor;
                        opcaoFornecedor = menuGestorFornecedor.menuGestorFornecedor();
                        switch (opcaoFornecedor){
                            case 0: // VOLTA AO MENU PRINCIPAL
                                break;
                            case 1: // CADASTRAR NOVO PRODUTO
                                menuGestorFornecedor.cadastrarProduto();
                            case 2: // BUSCAR PRODUTO POR NOME
                                menuGestorFornecedor.buscarProdutoPorNome();
                            case 3: // BUSCAR PRODUTO POR ID
                                menuGestorFornecedor.buscarProdutoPorID();
                            case 4: // EXIBIR RELATÓRIO DOS PRODUTOS
                                menuGestorFornecedor.relatorioProduto();
                        }
                    }
            }
        }

    }
}