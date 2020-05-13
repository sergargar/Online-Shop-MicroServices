package es.uc3m.tiw.domains;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path="shopping_cart", rel="shopping_cart")
public interface CartDAO extends CrudRepository<ShoppingCart, Integer>{

	public List<ShoppingCart> findByPersonAndProduct(String person, String product);
	//public  findByEmailAndPassword(String email, String password);
	public List<ShoppingCart> findByPerson(String person);
//	public ShoppingCart findTop1ByName(String name);
//	public List<ShoppingCart> findByNameAndSurname(String name, String surname);
//	public List<ShoppingCart> findByAddressStreet(String streetname);

	public List<ShoppingCart> findAll();
//
}
