package br.com.albus.comum.produto;

import br.com.albus.comum.categoria.Categoria;
import br.com.albus.comum.endereco.EnumTipoEndereco;
import br.com.albus.comum.municipio.Municipio;
import br.com.albus.comum.pessoa.Pessoa;
import br.com.albus.generic.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @Column(name = "PRO_NOME")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRO_CATEGORIA")
    private Categoria categoria;

    @Column(name = "PRO_QUANTIDADE")
    private Long quantidade;

    @Column(name = "PRO_DESCRICAO")
    private String descricao;

    @Column(name = "PRO_CUSTO")
    private Double custo;

    @Column(name = "PRO_VALOR_DE_VENDA")
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
