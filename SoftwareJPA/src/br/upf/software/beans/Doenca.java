package br.upf.software.beans;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Doenca
 *
 */
@Entity
public class Doenca implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "genIdDoenca")
	@SequenceGenerator(name = "genIdDoenca", sequenceName = "genIdDoenca", initialValue = 1)
	private Integer id;
	@Column(length = 150)
	private String descricao;
	private static final long serialVersionUID = 1L;

	public Doenca() {
		super();
	}   
	
	public Doenca(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Doenca(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
   
}
