package es.uc3m.tiw.domains;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path="payment", rel="payment")
public interface PaymentDAO extends CrudRepository<Payment, String>{

//	List<Payment> findByEmailAndPassword(String email, String password);
	//public  findByEmailAndPassword(String email, String password);
//	public List<Payment> findByName(String name);
//	public Payment findTop1ByName(String name);
//	public List<Payment> findByNameAndSurname(String name, String surname);
//	public List<Payment> findByAddressStreet(String streetname);

	public List<Payment> findAll();
//
}
