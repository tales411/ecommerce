package models;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Long id; // Identificador único do pedido
    private Long usuarioId; // Referência ao usuário que fez o pedido
    private List<Produto> produtos = new ArrayList<>(); // Produtos adicionados ao pedido

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // Adicionar um produto ao pedido
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    // Remover um produto do pedido
    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    // Calcular o valor total do pedido
    public Double calcularValor() {
        return produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }
}
