package br.com.albus.comum.receita;

import br.com.albus.comum.pessoa.fisica.PessoaFisica;
import br.com.albus.generic.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_RECEITAS", schema = "public")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "REC_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "REC_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "REC_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "REC_USUARIO_ALTERACAO"))
@Getter
@Setter
@NoArgsConstructor
public class Receita extends GenericEntity<Long> {

    @Id
    @Column(name = "REC_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "Autor não deve ser vazio.")
    @JoinColumn(name = "PS_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PESSOA_FISICA_IN_RECEITA"))
    private PessoaFisica autor;

    @Column(name = "REC_NOME", length = 255, nullable = false)
    @Size(min = 3, max = 255, message = "O nome deve ser maior que 3 e menor que 255 digitos.")
    private String nome;

    @Column(name = "REC_DESCRICAO", length = 1000)
    @Size(max = 1000, message = "A descricao deve ser menor que 1000 digitos.")
    private String descricao;

    @Column(name = "REC_RECEITA", length = 1000)
    @Size(max = 5000, message = "A descricao deve ser menor que 5000 digitos.")
    private String receita;

    @Column(name = "REC_CUSTO", nullable = false)
    @NotNull(message = "Custo não pode ser null.")
    @PositiveOrZero(message = "Custo não pode ser negativa.")
    private Double custo;

    @Column(name = "REC_URL_IMG")
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
