package br.estoque.src.Model;
import java.util.Scanner;

public class Cliente {
    public Carrinho[] carrinho;
    public double limiteDeGasto;
    public int conta = 0;

    public Cliente(double limiteDeGasto, int limiteCarrinho){
        this.limiteDeGasto = limiteDeGasto;
        this.carrinho = new Carrinho[limiteCarrinho];
    }

    public void verificarConta(){
        for(int i = 0; i < this.carrinho[0].produtosNoCarrinho.length; i++){
            conta += carrinho[0].produtosNoCarrinho[i].qntEstoque;
        }
        System.out.println("Gostaria de finalizar a compra " +
                "agora e fechar a conta? (1 - Sim / 2 - Não)");
        Scanner scanner = new Scanner(System.in);
        while (true){
            int escolha = scanner.nextInt();
            if(conta == 1){
                System.out.println("Obrigada pela preferência e volte " +
                        "sempre!");
                conta = 0;
                for(int i = 0; i < carrinho[0].
                        produtosNoCarrinho.length; i++){
                    carrinho[0].produtosNoCarrinho[i] = null;
                }
                break;
            } else if (conta == 2){
                System.out.println("Boas compras!");
                break;
            } else {
                System.out.println("Escolha uma opção válida.");
            }
        }
    }
}
