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
                produtosNoCarrinho[i].qntEstoque += novoProduto.qntEstoque;
                return true;
            }
        }
        if(produtosNoCarrinho[qntProdutosNoCarrinho] == null){
            produtosNoCarrinho[qntProdutosNoCarrinho] = novoProduto;
            qntProdutosNoCarrinho++;
            if(produtosNoCarrinho[qntProdutosNoCarrinho - 1] != null){
                return true;
            }
        }
        return false;
    }
}
