package br.com.code.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=50)
	@NotBlank
	@Size(min=3,max=50)
	private String nome;
	
	@Column(nullable=false, length=50)
	@NotBlank
	@Size(min=3,max=50, message="Campo requerido entre {min} e {max}")
	private String sobrenome;
	
	@Column(name="tipo_sexo",nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoSexo sexo;
	
	@Column(name="data_nascimento",nullable=false)
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
