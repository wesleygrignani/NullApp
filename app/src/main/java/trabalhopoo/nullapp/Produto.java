package trabalhopoo.nullapp;

public class Produto {

    String nome;
    int quantidade;
    int preco_unitario;
    String descricao;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(int preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
