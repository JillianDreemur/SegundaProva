package br.estoque.src.Main;
import br.estoque.src.Model.Estoque;
import br.estoque.src.Model.GestorFornecedor;
import br.estoque.src.Model.Produto;
import br.estoque.src.Model.Fornecedor;

public class Main {
    public static void main(String[] args) {
        MenuLoja menuLoja = new MenuLoja();
        MenuGestorLoja menuGestorLoja = new MenuGestorLoja();
        MenuGestorFornecedor menuGestorFornecedor = new MenuGestorFornecedor();
        Estoque estoque = new Estoque(10);
        GestorFornecedor gestorFornecedor = new GestorFornecedor(10);

        Menu menu = new Menu();
        menu.menu(menuLoja, menuGestorLoja, estoque, gestorFornecedor, menuGestorFornecedor);
    }
}