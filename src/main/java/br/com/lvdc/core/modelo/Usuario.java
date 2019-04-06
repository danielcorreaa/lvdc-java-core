package br.com.lvdc.core.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String login;
	private String senha;
	
	@OneToMany(mappedBy="usuario", cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Perfil> perfis;
	
	
	public Usuario(Usuario usuario) {
		this.login = usuario.login;
		this.senha = usuario.senha;
		this.perfis = usuario.perfis;
	}
	
}
