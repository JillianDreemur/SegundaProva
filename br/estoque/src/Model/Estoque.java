package prova.aula.poo.src.Model;
import prova.aula.poo.src.Model.Produto;
import java.util.Scanner;

public class Estoque {
    public Produto[] listaDeProdutos = new Produto[20];
    public int qntProdutos = 0;

    public Produto verificarDisponibilidade(String nome) {
        for (int i = 0; i < qntProdutos; i++) {
            if (this.listaDeProdutos[i].nome.equalsIgnoreCase(nome)) {
                return this.listaDeProdutos[i];
            }
        }
        return null;
    }

    public int cadastrarProduto(Produto produto) {
        if (buscarNome(produto.nome) == null) {
            if (qntProdutos < listaDeProdutos.length) {
                this.listaDeProdutos[this.qntProdutos] = produto;
                this.qntProdutos++;
                return 1;
            } else {
                return 2;
            }
        } else {
            return 3;
        }
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
                listaDeProdutos[i].ID = produto.ID;
                listaDeProdutos[i].nome = produto.nome;
                listaDeProdutos[i].descricao = produto.descricao;
                listaDeProdutos[i].preco = produto.preco;
                listaDeProdutos[i].qntEstoque = produto.qntEstoque;
            }
        }
        return (buscarNome(nomeProduto) == null) && (buscarNome(produto.nome) != null);
    }
}
