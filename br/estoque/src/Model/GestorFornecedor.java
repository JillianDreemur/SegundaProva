package br.estoque.src.Model;

public class GestorFornecedor {
    public Fornecedor[] listaDeFornecedores;
    public int qntFornecedores = 0;

    public GestorFornecedor(int limiteFornecedores){
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

    public Fornecedor exibirInfoFornecedor(int cnpj) {
        for(int i = 0; i < qntFornecedores; i++) {
            if(listaDeFornecedores[i].cnpj == cnpj){
                return listaDeFornecedores[i];
            }
        }
        return null;
    }

    public void relatorioFornecedor(Fornecedor fornecedorLogado){
        System.out.println("\nNome: %s" + fornecedorLogado.nome);
        System.out.println("\nCNPJ: %i" + fornecedorLogado.cnpj);
        System.out.println("\nSenha: %i" + fornecedorLogado.senha);
        System.out.println("\nQuantidade de produtos: %i\n" +
                    fornecedorLogado.qntProdutosFornecedor);
    }

    public boolean buscarProdutoPorNome(String nome){
        for(int i = 0; i < qntFornecedores; i++){
            for(int j = 0; j < this.listaDeFornecedores[i].qntProdutosFornecedor; j++){
                if(this.listaDeFornecedores[i].produtosDoFornecedor[j].nome.equalsIgnoreCase(nome)){
                    this.listaDeFornecedores[i].produtosDoFornecedor[j].exibirInfo();
                    return true;
                }
            }
        }
        return false;
    }
}