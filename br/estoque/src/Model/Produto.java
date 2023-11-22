package br.estoque.src.Model;

public class Produto {
    public String ID;
    public String nome;
    public String descricao;
    public double preco;
    public int qntEstoque;

    public Produto(String ID, String nome, String descricao, double preco, int qntEstoque) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
    }

    public void exibirInfo() {
        System.out.printf("\nNome: %s", this.nome);
        System.out.printf("\nDescrição: %s", this.descricao);
        System.out.printf("\nPreço: %s", this.preco);
        System.out.printf("\nQuantidade Disponivel: %d", this.qntEstoque);
    }

}




