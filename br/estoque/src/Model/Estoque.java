package br.estoque.src.Model;
import br.estoque.src.Model.Produto;

public class Estoque {
    public Produto[] listaDeProdutos;
    public int qntProdutos = 0;

    public Estoque(int limiteProdutos){
        this.listaDeProdutos = new Produto[limiteProdutos];
    }

    public Produto verificarDisponibilidade(String nome) {
        for (int i = 0; i < qntProdutos; i++) {
            if (this.listaDeProdutos[i].nome.equalsIgnoreCase(nome)) {
                return this.listaDeProdutos[i];
            }
        }
        return null;
    }

    public boolean cadastrarProduto(Produto produto) {
        if (buscarNome(produto.nome) == null) {
            if (qntProdutos < listaDeProdutos.length) {
                this.listaDeProdutos[this.qntProdutos] = produto;
                this.qntProdutos++;
            }
            if(buscarNome(produto.nome) != null){
                return true;
            }
        }
        return false;
    }

    public Produto buscarNome(String nome) {
        for (int i = 0; i < qntProdutos; i++) {
            if (this.listaDeProdutos[i].nome.equalsIgnoreCase(nome)) {
                return this.listaDeProdutos[i];
            }
        }
        return null;
    }

    public Produto buscarID(String ID) {
        for (int i = 0; i < qntProdutos; i++) {
            if (this.listaDeProdutos[i].ID.equalsIgnoreCase(ID)) {
                return this.listaDeProdutos[i];
            }
        }
        return null;
    }

    public boolean excluirProduto(String nome){
        int variavel = 0;
        for(int i = 0; i < qntProdutos; i++){
            if(this.listaDeProdutos[i].nome.equalsIgnoreCase(nome)){
                this.listaDeProdutos[i] = null;
                variavel = i;
                break;
            }
        }
        return this.listaDeProdutos[variavel] == null;
    }

    public boolean atualizarProduto(String nomeProduto, Produto produto) {
        for (int i = 0; i < qntProdutos; i++) {
            if(this.listaDeProdutos[i].nome.equalsIgnoreCase(nomeProduto)) {
                this.listaDeProdutos[i].ID = produto.ID;
                this.listaDeProdutos[i].nome = produto.nome;
                this.listaDeProdutos[i].descricao = produto.descricao;
                this.listaDeProdutos[i].preco = produto.preco;
                this.listaDeProdutos[i].qntEstoque = produto.qntEstoque;
            }
        }
        return (buscarNome(nomeProduto) == null) &&
                (buscarNome(produto.nome) != null);
    }
}
