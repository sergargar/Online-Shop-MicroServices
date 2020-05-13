package es.uc3m.tiw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import es.uc3m.tiw.domains.*;



@Controller
@CrossOrigin
public class MyController {

	@Autowired
	ProductDAO prod;

	@RequestMapping(method = RequestMethod.POST, value="/products")
	public @ResponseBody Product saveProduct(@RequestBody @Validated Product pprod) {
		return prod.save(pprod);
	}




	@RequestMapping(method = RequestMethod.DELETE, value="/products/{name}")
	public @ResponseBody void deleteProduct(@PathVariable @Validated String name) {
		Product p = prod.findById(name).orElse(null);
		if (p != null) {
			prod.delete(p);
		}
	}


//	@RequestMapping("/users/{name}/{password}")
//	public @ResponseBody List<Product> getUserByEmailAndSurname(@PathVariable String email,
//											  @PathVariable String password){
//		return prod.findByEmailAndPassword(email, password);
//	}


	@RequestMapping(value= "/products",method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts(){
		return prod.findAll();
	}

	@RequestMapping(value= "/products/{name}",method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable @Validated String name){
		return prod.findById(name).orElse(null);
	}



/*	@RequestMapping("/users/{email}/{password}")
	public @ResponseBody Product getUserByEmailAndSurname(@PathVariable String email,
											  @PathVariable String password){
		return prod.findByEmailAndPassword(email, password);
	}*/


	@RequestMapping(method = RequestMethod.PUT, value="/products/{name}")
	public @ResponseBody Product updateUser(@PathVariable @Validated String name, @RequestBody Product pProduct) {
		//Optional<User> us = daous.findById(id);
		Product aux = prod.findById(name).orElse(null);

		aux.setBrand(pProduct.getBrand());
		aux.setSize(pProduct.getSize());
		aux.setOs(pProduct.getOs());
		aux.setShortdesc(pProduct.getShortdesc());
		aux.setLongdesc(pProduct.getLongdesc());
		aux.setPrice(pProduct.getPrice());
		aux.setStorage(pProduct.getStorage());

		return prod.save(aux);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/users/{id}")
	public @ResponseBody void deleteUser(@PathVariable @Validated String id) {
		Product us = prod.findById(id).orElse(null);
		if (us != null) {
			prod.delete(us);
		}
	}



//	@RequestMapping(value="/users",method = RequestMethod.GET)
//	public @ResponseBody ResponseEntity<List<Product>> getQueryParameter(@RequestParam(value="name", required=false) String pName){
//		List<Product> listUser;
//		if (pName != null){
//			listUser = prod.findByName(pName);
//		}
//		else {
//			listUser = prod.findAll();
//		}
//		return new ResponseEntity<>(listUser, HttpStatus.OK);
//	}

//	@RequestMapping(value="/users",method = RequestMethod.GET)





	public MyController() {
	}

}
