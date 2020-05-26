package br.com.albus.comum.produto;

import br.com.albus.comum.categoria.Categoria;
import br.com.albus.comum.endereco.EnumTipoEndereco;
import br.com.albus.comum.municipio.Municipio;
import br.com.albus.comum.pessoa.Pessoa;
import br.com.albus.generic.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PRODUTO", schema = "public")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "PRO_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "PRO_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "PRO_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "PRO_USUARIO_ALTERACAO"))
@Getter
@Setter
@NoArgsConstructor
public class Produto extends GenericEntity<Long> {

    @Id
    @Column(name = "PRO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRO_NOME", length = 255, nullable = false)
    @Size(min = 5, max = 255, message = "O nome deve ser maior que 5 e menor que 255 digitos.")
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "Categoria não pode ser null.")
    @JoinColumn(name = "PRO_CATEGORIA", nullable = false, foreignKey = @ForeignKey(name = "FK_CATEGORIA_IN_PRODUTO"))
    private Categoria categoria;

    @Column(name = "PRO_QUANTIDADE", nullable = false)
    @NotNull(message = "Quantidade não pode ser null.")
    @PositiveOrZero(message = "Quantidade não pode ser negativa.")
    private Long quantidade;

    @Column(name = "PRO_DESCRICAO", length = 1000)
    @Size(max = 1000, message = "A descricao deve ser menor que 1000 digitos.")
    private String descricao;

    @Column(name = "PRO_CUSTO", nullable = false)
    @NotNull(message = "Custo não pode ser null.")
    @PositiveOrZero(message = "Custo não pode ser negativa.")
    private Double custo;

    @Column(name = "PRO_VALOR_DE_VENDA", nullable = false)
    @NotNull(message = "Valor de venda não pode ser null.")
    @PositiveOrZero(message = "Valor de venda não pode ser negativa.")
    private Double valorDeVenda;

    @Column(name = "PRO_URL_IMG")
    private String urlImg;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
