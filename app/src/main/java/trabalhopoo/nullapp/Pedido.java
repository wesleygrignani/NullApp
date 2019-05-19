package trabalhopoo.nullapp;

public class Pedido {

    private CadastraCartao cartao;
    private Produto produto;
    private ClienteLogado cliente;


    public CadastraCartao getCartao() {
        return cartao;
    }

    public void setCartao(CadastraCartao cartao) {
        this.cartao = cartao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ClienteLogado getCliente() {
        return cliente;
    }

    public void setCliente(ClienteLogado cliente) {
        this.cliente = cliente;
    }
}
