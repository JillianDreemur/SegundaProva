package br.estoque.src.Model;

public class Cliente {
    public Carrinho[] carrinho;
    public double limiteGasto;

    public Cliente(double limiteDeGasto){
        this.carrinho = new Carrinho[25];
        this.limiteGasto = limiteDeGasto;
    }
}
