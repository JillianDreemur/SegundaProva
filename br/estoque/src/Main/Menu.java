package br.estoque.src.Main;
import br.estoque.src.Model.Estoque;
import br.estoque.src.Model.GestorFornecedor;
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

    public void menu(MenuLoja menuLoja, MenuGestorLoja menuGestorLoja, Estoque estoque,
      GestorFornecedor gestorFornecedor, MenuGestorFornecedor menuGestorFornecedor){
        while (true){
            int opcao;
            opcao = menuPrincipal();
            if(opcao == 0){ //SAIR DO CODIGO
                break;
            } else if (opcao == 1){ // MENU DA LOJA
                while (true) {
                    int opcaoLoja;
                    opcaoLoja = menuLoja.menuLoja();
                    if (opcaoLoja == 0) {
                        break;
                    } else if (opcaoLoja == 1) {
                        menuLoja.cadastrarProduto(estoque);
                    } else if (opcaoLoja == 2) {
                        menuLoja.verificarDisponibilidade(estoque);
                    } else if (opcaoLoja == 3) {
                        menuLoja.buscarProdutoPorNome(estoque);
                    } else if (opcaoLoja == 4) {
                        menuLoja.buscarProdutoPorID(estoque);
                    } else if (opcaoLoja == 5) {
                        menuLoja.atualizarProduto(estoque);
                    } else if (opcaoLoja == 6) {
                        menuLoja.excluirProduto(estoque);
                    } else if (opcaoLoja == 7) {
                        menuLoja.gerarRelatorio(estoque);
                    }
                }
            } else if (opcao == 2){ // MENU GESTOR LOJA
                while (true){
                    int opcaoGestor;
                    opcaoGestor = menuGestorLoja.menuGestao();
                    if(opcaoGestor == 0){
                        break;
                    } else if (opcaoGestor == 1){
                        menuGestorLoja.cadastrarFornecedor(gestorFornecedor);
                    } else if (opcaoGestor == 2){
                        menuGestorLoja.buscarProdutoPorNome(gestorFornecedor);
                    } else if (opcaoGestor == 3){
                        menuGestorLoja.exibirInfoFornecedor(gestorFornecedor);
                    } else if (opcaoGestor == 4){
                        menuGestorLoja.relatorioFornecedores(gestorFornecedor);
                    }
                }
            } else if (opcao == 3){ //MENU FORNECEDOR
                boolean login = menuGestorFornecedor.login(gestorFornecedor);
                while (!login){
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Um dos dados está incorreto. " +
                                "\nGostaria de tentar novamente?" +
                                "\nPara Sim digite 1; Para não, digite qualquer outro número.");
                        int confirmacao = scanner.nextInt();
                        if(confirmacao == 1){
                            login = menuGestorFornecedor.login(gestorFornecedor);
                        } else {
                            break;
                        }
                    } // AREA LOGIN DO FORNECEDOR
                while (true){ // FORNECEDOR LOGADO
                    int opcaoFornecedor;
                    opcaoFornecedor = menuGestorFornecedor.menuGestorFornecedor();
                    if(opcaoFornecedor == 0){
                        break;
                    } else if (opcaoFornecedor == 1){
                        menuGestorFornecedor.cadastrarProduto();
                    } else if (opcaoFornecedor == 2){
                        menuGestorFornecedor.buscarProdutoPorNome();
                    } else if (opcaoFornecedor == 3){
                        menuGestorFornecedor.buscarProdutoPorID();
                    } else if (opcaoFornecedor == 4){
                        menuGestorFornecedor.relatorioProduto();
                    }
                }
            }
        }
    }
}