package br.upf.software.beans;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Paciente
 *
 */
@Entity

public class Paciente implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "genPacienteId")
	@SequenceGenerator(name = "genPacienteId", sequenceName = "genPacienteId", initialValue = 1)
	private Integer id;
	@Column(insertable = false, length = 50)
	private String nome;
	@Column(length = 100)
	private String email;
	@ManyToOne(optional = false)
	private Doenca doenca;
	private static final long serialVersionUID = 1L;

	public Paciente() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public Doenca getDoenca() {
		return this.doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}
	public Paciente(Integer id, String nome, String email, Doenca doenca) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.doenca = doenca;
	}
   
}
