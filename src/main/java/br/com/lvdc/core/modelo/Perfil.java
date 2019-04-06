package br.com.lvdc.core.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class Perfil implements GrantedAuthority{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String nome;
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	
	@Override
	public String getAuthority() {
		return nome;
	}

}
