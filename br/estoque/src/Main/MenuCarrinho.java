package br.estoque.src.Main;
import br.estoque.src.Model.Carrinho;
import br.estoque.src.Model.Cliente;
import java.util.Scanner;

public class MenuCarrinho {
    public int menuCarrinho(){
        System.out.println("==============================" +
                         "\n=-       MENU CLIENTE       -=" +
                         "\n==============================" +
                         "\n=- 0 - Sair                 -=" +
                         "\n=- 1 - Adicionar produto    -=" +
                         "\n=- 2 - Buscar produto       -=" +
                         "\n=- 3 - Excluir produto      -=" +
                         "\n=- 4 - Editar produto       -=" +
                         "\n=- 5 - Mostrar carrinho     -=" +
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
