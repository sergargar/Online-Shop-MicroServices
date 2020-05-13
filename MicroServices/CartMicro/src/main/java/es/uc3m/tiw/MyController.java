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
	CartDAO ca;


	@RequestMapping(method = RequestMethod.POST, value="/shoppingcart")
	public @ResponseBody ShoppingCart saveShoppingCart(@RequestBody @Validated ShoppingCart puser) {
		return ca.save(puser);
	}




	@RequestMapping(value="/shoppingcart/{email}",method = RequestMethod.GET)
	public @ResponseBody  List<ShoppingCart> getShoppingCartByEmail(@PathVariable String email){
		//find where email
		return ca.findByPerson(email);
	}

	@RequestMapping(value="/shoppingcart/{person}/{product}",method = RequestMethod.GET)
	public @ResponseBody  List<ShoppingCart> getShoppingCartByPersonandProduct(@PathVariable @Validated String person, @PathVariable @Validated String product){
		//find where email
		return ca.findByPersonAndProduct(person,product);
	}


	@RequestMapping(method = RequestMethod.PUT, value="/shoppingcart/{user}/{product}")
	public @ResponseBody ShoppingCart updateShoppingCart(@PathVariable @Validated String user, @PathVariable @Validated String product, @RequestBody ShoppingCart pShoppingCart) {

		List<ShoppingCart> us1 = ca.findByPersonAndProduct(user,product);
		ShoppingCart us=us1.get(0);
		us.setAmount(pShoppingCart.getAmount());
		us.setPerson(pShoppingCart.getPerson());
		us.setProduct(pShoppingCart.getProduct());

		return ca.save(us);
	}


	@RequestMapping(method = RequestMethod.DELETE, value="/shoppingcart/{user}/{product}")
	public @ResponseBody void deleteShoppingCart(@PathVariable @Validated String user, @PathVariable @Validated String product) {
		List<ShoppingCart> us1 = ca.findByPersonAndProduct(user,product);
		ShoppingCart us=us1.get(0);
			ca.delete(us);
	}



//	@RequestMapping(value="/shoppingcart",method = RequestMethod.GET)
//	public @ResponseBody ResponseEntity<List<ShoppingCart>> getQueryParameter(@RequestParam(value="name", required=false) String pName){
//		List<ShoppingCart> listShoppingCart;
//		if (pName != null){
//			listShoppingCart = ca.findByName(pName);
//		}
//		else {
//			listShoppingCart = ca.findAll();
//		}
//		return new ResponseEntity<>(listShoppingCart, HttpStatus.OK);
//	}

//	@RequestMapping(value="/shoppingcart",method = RequestMethod.GET)





	public MyController() {
	}

}
