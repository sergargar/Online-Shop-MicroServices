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
	WishlistDAO ca;


	@RequestMapping(method = RequestMethod.POST, value="/wishlist")
	public @ResponseBody Wishlist saveWishlist(@RequestBody @Validated Wishlist puser) {
		return ca.save(puser);
	}




	@RequestMapping(value="/wishlist/{email}",method = RequestMethod.GET)
	public @ResponseBody  List<Wishlist> getWishlistByEmail(@PathVariable String email){
		//find where email
		return ca.findByPerson(email);
	}


	@RequestMapping(method = RequestMethod.DELETE, value="/wishlist/{user}/{product}")
	public @ResponseBody void deleteWishlist(@PathVariable @Validated String user, @PathVariable @Validated String product) {
		List<Wishlist> us1 = ca.findByPersonAndProduct(user,product);
		Wishlist us=us1.get(0);
			ca.delete(us);
	}





	public MyController() {
	}

}
