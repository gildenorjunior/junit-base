package integracao.bancodedados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class ContatoModel {
	
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="O DDD deve ser preenchido")
	private String ddd;
	
	@NotEmpty(message="O Telefone deve ser preenchido")
	private String telefone;
	
	@NotEmpty(message="O nome deve ser preenchido")
	private String nome;
	
	// CONSTRUCTOR
	public ContatoModel() {
	}
	
	public ContatoModel(String nome, String ddd, String telefone) {
		this.ddd = ddd;
		this.telefone = telefone;
		this.nome = nome;
	}
	
	//MÉTODOS GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
