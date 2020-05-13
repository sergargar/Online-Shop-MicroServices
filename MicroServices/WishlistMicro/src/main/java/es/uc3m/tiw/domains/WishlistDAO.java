package es.uc3m.tiw.domains;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path="wishlist", rel="wishlist")
public interface WishlistDAO extends CrudRepository<Wishlist, Integer>{

	public List<Wishlist> findByPersonAndProduct(String person, String product);
	//public  findByEmailAndPassword(String email, String password);
	public List<Wishlist> findByPerson(String person);
//	public Wishlist findTop1ByName(String name);
//	public List<Wishlist> findByNameAndSurname(String name, String surname);
//	public List<Wishlist> findByAddressStreet(String streetname);

	public List<Wishlist> findAll();
//
}
