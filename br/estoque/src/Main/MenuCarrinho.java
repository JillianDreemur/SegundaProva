package br.estoque.src.Main;
import br.estoque.src.Model.Carrinho;
import br.estoque.src.Model.Cliente;

public class MenuCarrinho {
    public int menuCarrinho(){
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
}
