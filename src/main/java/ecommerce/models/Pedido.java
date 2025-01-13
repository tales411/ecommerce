package ecommerce.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do pedido

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario; // Referência ao usuário que fez o pedido

    @ManyToMany
    @JoinTable(
        name = "pedido_produto", // Nome da tabela intermediária
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos = new ArrayList<>(); // Produtos adicionados ao pedido

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
