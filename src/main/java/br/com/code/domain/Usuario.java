package br.com.code.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Usuario {

	private Long id;
	
	@NotBlank
	@Size(min=3,max=50)
	private String nome;
	
	@NotBlank
	@Size(min=3,max=50, message="Campo requerido entre {min} e {max}")
	private String sobrenome;
	
	private TipoSexo sexo;
	
	@NotNull(message="O campo de data é requerido")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data;
	
	public Usuario() {
		super();
	}	

	public Usuario(Long id, String nome, String sobrenome, TipoSexo sexo, LocalDate data) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.data = data;
	}

	public Usuario(Long id, String nome, String sobrenome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public Usuario(Long id, String nome, String sobrenome, LocalDate data) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.data = data;
	}

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public TipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}
	
	
}
