package trabalhopoo.nullapp;

public class Produto {

    private int codigo;
    private String nome;
    private int quantidade;
    private int preco_unitario;
    private String Cpf;
    private byte[] foto;


    public Produto() {
    }

    public Produto(String nome, int quantidade, int preco_unitario, String cpf, byte[] foto) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
        Cpf = cpf;
        this.foto = foto;
    }

    public Produto(String nome, int quantidade, int preco_unitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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


}
