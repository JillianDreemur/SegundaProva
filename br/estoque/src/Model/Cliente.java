package br.estoque.src.Model;

public class Cliente {
    public Carrinho[] carrinho = new Carrinho[1];
    public double limiteGasto;
    public int conta = 0;

    public Cliente(double limiteDeGasto){
        this.limiteGasto = limiteDeGasto;
    }
}
