package es.uc3m.tiw.domains;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path="usuarios", rel="usuarios")
public interface UsuarioDAO extends CrudRepository<Usuario, String>{

//	List<Usuario> findByEmailAndPassword(String email, String password);
	public Usuario findByEmailAndPassword(String email, String password);
//	public List<Usuario> findByName(String name);
//	public Usuario findTop1ByName(String name);
//	public List<Usuario> findByNameAndSurname(String name, String surname);
//	public List<Usuario> findByAddressStreet(String streetname);
	public List<Usuario> findAll();
	public List<Usuario> findByRole(String role);
	public Usuario findByEmail(String email);
//	
}
