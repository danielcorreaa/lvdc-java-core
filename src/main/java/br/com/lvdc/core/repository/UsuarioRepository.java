package br.com.lvdc.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.lvdc.core.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("Select u From Usuario u join  Perfil per on u.id = per.usuario.id where u.login = :username")
	Usuario buscarPorLogin(String username);

}
