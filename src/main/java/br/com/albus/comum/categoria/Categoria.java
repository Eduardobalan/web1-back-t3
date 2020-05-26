package br.com.albus.comum.categoria;

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
@Table(name = "TB_CATEGORIA", schema = "public")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "CAT_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "CAT_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "CAT_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "CAT_USUARIO_ALTERACAO"))
@Getter
@Setter
@NoArgsConstructor
public class Categoria extends GenericEntity<Long> {

    @Id
    @Column(name = "CAT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CAT_TIPO_CATEGORIA")
    private EnumTipoCategoria tipoCategoria;

    @Column(name = "CAT_NOME")
    private String nome;

    @Column(name = "CAT_DESCRICAO")
    private String descricao;

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
