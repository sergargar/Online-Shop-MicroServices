package es.uc3m.tiw.domains;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MessageDAO extends CrudRepository<Message, Integer>{
//	List<Usuario> findByEmailAndPassword(String email, String password);
//	public Usuario findByEmailAndPassword(String email, String password);
//	public List<Usuario> findByName(String name);
//	public Usuario findTop1ByName(String name);
//	public List<Usuario> findByNameAndSurname(String name, String surname);
//	public List<Usuario> findByAddressStreet(String streetname);
	public List<Message> findAll();
	public List<Message> findByReceiver(Usuario receiver);
	
	
}
