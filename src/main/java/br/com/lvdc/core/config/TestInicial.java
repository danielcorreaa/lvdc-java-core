package br.com.lvdc.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.lvdc.core.repository.PerfilRepository;
import br.com.lvdc.core.repository.UsuarioRepository;

@Component
public class TestInicial implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private  UsuarioRepository repository;
	@Autowired
	private  PerfilRepository repositoryPerfil;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		String api ="grant_type=password&username=admin&password=123";

		
	}

}
