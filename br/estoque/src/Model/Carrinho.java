package br.estoque.src.Model;
import br.estoque.src.Model.Produto;

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

    public boolean editarProduto(String nome){

    }
}
