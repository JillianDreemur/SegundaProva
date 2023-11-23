package br.estoque.src.Model;

public class GestorProdutos {
    public Fornecedor[] listaDeFornecedores;
    public int qntFornecedores = 0;

    public GestorProdutos(int limiteFornecedores){
        this.listaDeFornecedores = new Fornecedor[limiteFornecedores];
    }

    public boolean cadastrarFornecedor(Fornecedor novoFornecedor) {
        if (qntFornecedores < listaDeFornecedores.length) {
            this.listaDeFornecedores[this.qntFornecedores] = novoFornecedor;
            this.qntFornecedores++;
            return true;
        }
        return false;
    }

    public Fornecedor[] buscarProdutoPorNome(String nome) {
        Fornecedor[] fornecedoresTemp = new Fornecedor[qntFornecedores];
        for(int i = 0; i < qntFornecedores; i++) {
            if(this.listaDeFornecedores[i].buscarNome(nome) != null) {
                fornecedoresTemp[i] = this.listaDeFornecedores[i];
            }
        }
        return fornecedoresTemp;
    }

    public Fornecedor[] buscarProdutoPorID(String ID) {
        Fornecedor[] fornecedoresTemp = new Fornecedor[qntFornecedores];
        for(int i = 0; i < qntFornecedores; i++) {
            if(this.listaDeFornecedores[i].buscarID(ID) != null) {
                fornecedoresTemp[i] = this.listaDeFornecedores[i];
            }
        }
        return fornecedoresTemp;
    }

    public Fornecedor exibirInfoFornecedor(int cnpj) {
        for(int i = 0; i < qntFornecedores; i++) {
            if(listaDeFornecedores[i].cnpj == cnpj){
                return listaDeFornecedores[i];
            }
        }
        return null;
    }

    public Produto[] exibirInfoProduto(String nome) {
        Produto[] produtoTemp = new Produto[qntFornecedores];
        for(int i = 0; i < qntFornecedores; i++) {
            for(int j = 0; j < listaDeFornecedores[i].qntProdutosFornecedor; j++){
                if(this.listaDeFornecedores[i].produtosDoFornecedor[j].nome.equalsIgnoreCase(nome)) {
                    produtoTemp[i] = this.listaDeFornecedores[i].produtosDoFornecedor[j];
                }
            }
        }
        return produtoTemp;
    }

    public void relatorioFornecedores(){
        for(int i = 0; i < qntFornecedores; i++){
            System.out.println("Fornecedor %i" + i);
            System.out.println("\nNome: %s" + listaDeFornecedores[i].nome);
            System.out.println("\nCNPJ: %i" + listaDeFornecedores[i].cnpj);
            System.out.println("\nQuantidade de produtos: %i\n" +
                    listaDeFornecedores[i].qntProdutosFornecedor);
        }
    }
}