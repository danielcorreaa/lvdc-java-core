package br.com.lvdc.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lvdc.core.config.MyUserDatails;
import br.com.lvdc.core.exception.LocadoraBusinessException;
import br.com.lvdc.core.modelo.Usuario;
import br.com.lvdc.core.repository.UsuarioRepository;

@Service
public class UserDatailService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.buscarPorLogin(username);
		if(usuario ==  null){
			throw new LocadoraBusinessException("Usuário inválido");
		}
		return new MyUserDatails(usuario);
	}

}
