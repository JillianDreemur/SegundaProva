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
            if(listaDeFornecedores[qntFornecedores - 1] != null){
                return true;
            } else {
                qntFornecedores -= 1;
                return false;
            }
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

    public void buscarProdutoPorNome(String nome){
        for(int i = 0; i < qntFornecedores; i++){
            for(int j = 0; j < this.listaDeFornecedores[i].
                    qntProdutosFornecedor; j++){
                if(this.listaDeFornecedores[i].produtosDoFornecedor[j].nome.equalsIgnoreCase(nome)){
                    System.out.println("Fornecedor $s" + this.listaDeFornecedores[i]);
                    this.listaDeFornecedores[i].produtosDoFornecedor[j].exibirInfo();
                }
            }
        }
    }
}