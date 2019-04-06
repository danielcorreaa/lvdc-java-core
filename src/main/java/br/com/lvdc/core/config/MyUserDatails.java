package br.com.lvdc.core.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.lvdc.core.modelo.Usuario;


@SuppressWarnings("serial")
public class MyUserDatails extends Usuario implements UserDetails{
	
	public MyUserDatails(Usuario usuario) {
		super(usuario);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		return  this.getPerfis();
	}

	@Override
	public String getPassword() {
		PasswordEncoder encode = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encode.encode(this.getSenha());
	}

	@Override
	public String getUsername() {
		return this.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {	
		return true;
	}

}
