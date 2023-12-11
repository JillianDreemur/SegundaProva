package br.estoque.src.Model;
import java.util.Scanner;

public class Carrinho {
    public Produto[] produtosNoCarrinho;
    public int qntProdutosNoCarrinho = 0;

    public Carrinho(int limiteProdutos){
        this.produtosNoCarrinho = new Produto[limiteProdutos];
    }

    public boolean adicionarProduto(Produto novoProduto){
        for(int i = 0; i < produtosNoCarrinho.length; i++){
            if(produtosNoCarrinho[i].equals(novoProduto)){
                System.out.println("O produto selecionado já " +
             "está no carrinho; Por esse motivo, apenas aumentaremos a " +
                        "quantidade do produto.");
                produtosNoCarrinho[i].qntEstoque += novoProduto.qntEstoque;
                return true;
            }
        }
        if(produtosNoCarrinho[qntProdutosNoCarrinho] == null){
            produtosNoCarrinho[qntProdutosNoCarrinho] = novoProduto;
            qntProdutosNoCarrinho++;
            if(produtosNoCarrinho[qntProdutosNoCarrinho - 1] != null){
                return true;
            } else {
                qntProdutosNoCarrinho -= 1;
                return false;
            }
        }
        return false;
    }

    public boolean buscarProduto(String nome){
        for (int i = 0; i < produtosNoCarrinho.length; i++){
            if(produtosNoCarrinho[i].nome.equalsIgnoreCase(nome)){
                produtosNoCarrinho[i].exibirInfo();
                return true;
            }
        }
        return false;
    }

    public boolean excluirProduto(String nome){
        for (int i = 0; i < produtosNoCarrinho.length; i++){
            if(produtosNoCarrinho[i].nome.equalsIgnoreCase(nome)){
                produtosNoCarrinho[i] = null;
                if(produtosNoCarrinho[i] == null){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean editarProduto(String nome, int novaQnt){
        for (int i = 0; i < this.produtosNoCarrinho.length; i++){
            if(this.produtosNoCarrinho[i].nome.equalsIgnoreCase(nome)){
                while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Para aumentar a quantidade digite 1");
                System.out.println("Para diminuir a quantidade digite 2");
                int conta = scanner.nextInt();
                if(conta == 1){
                    this.produtosNoCarrinho[i].qntEstoque += novaQnt;
                    return true;
                } else if (conta == 2){
                    this.produtosNoCarrinho[i].qntEstoque -= novaQnt;
                    return true;
                } else {
                    System.out.println("Escolha uma opção válida.");
                    }
                }
            }
        }
        return false;
    }

    public void mostrarCarrinho(){
        for(int i = 0; i < this.produtosNoCarrinho.length; i++){
            System.out.println("------------------------------------------");
            System.out.println();
            System.out.println("Nome do Produto: %s" +
                    this.produtosNoCarrinho[i].nome);
            System.out.println("Quantidade a ser comprada: %i" +
                    this.produtosNoCarrinho[i].qntEstoque);
        }
    }
}
