package es.uc3m.tiw.domains;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path="purchase", rel="purchase")
public interface PurchaseDAO extends CrudRepository<Purchase, Integer>{

//	List<Purchase> findByEmailAndPassword(String email, String password);
	//public  findByEmailAndPassword(String email, String password);
	public List<Purchase> findByPerson(String name);
//	public Purchase findTop1ByName(String name);
//	public List<Purchase> findByNameAndSurname(String name, String surname);
//	public List<Purchase> findByAddressStreet(String streetname);

	public List<Purchase> findAll();
//
}
