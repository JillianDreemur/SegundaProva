package br.estoque.src.Model;
import br.estoque.src.Model.Produto;

public class Fornecedor {
    public String nome;
    public String senha;
    public int cnpj;
    public Produto[] produtosDoFornecedor;
    public int qntProdutosFornecedor = 0;

    public Fornecedor(String nome, int cnpj, String senha, int limiteProdutos) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.senha = senha;
        this.produtosDoFornecedor = new Produto[limiteProdutos];
    }

    public boolean cadastrarProdutoFornecedor(Produto produto) {
        if (buscarNome(produto.nome) == null) {
            if (qntProdutosFornecedor < produtosDoFornecedor.length) {
                this.produtosDoFornecedor[this.qntProdutosFornecedor] = produto;
                this.qntProdutosFornecedor++;
                return true;
            }
        }
        return false;
    }

    public Produto buscarNome(String nome) {
        for (int i = 0; i < qntProdutosFornecedor; i++) {
            if (this.produtosDoFornecedor[i].nome.equalsIgnoreCase(nome)) {
                return this.produtosDoFornecedor[i];
            }
        }
        return null;
    }

    public Produto buscarID(String ID) {
        for (int i = 0; i < qntProdutosFornecedor; i++) {
            if (this.produtosDoFornecedor[i].ID.equalsIgnoreCase(ID)) {
                return this.produtosDoFornecedor[i];
            }
        }
        return null;
    }

    public void exibirInfo(){
        System.out.printf("\nNome: %s",this.nome);
        System.out.printf("\nCNPJ: %d\n",this.cnpj);
        for (int i = 0; i < produtosDoFornecedor.length; i++) {
            System.out.println("Produto: " + produtosDoFornecedor[i]);
        }
    }
}
