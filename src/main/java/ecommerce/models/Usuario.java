package ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario") // Nome da tabela no banco de dados
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do usuário

    @Column(name = "nome", nullable = false) // Coluna 'nome', não aceita valores nulos
    private String nome; // Nome do usuário

    // Construtor padrão
    public Usuario() {}

    // Construtor com parâmetros
    public Usuario(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método toString para facilitar o debug
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
