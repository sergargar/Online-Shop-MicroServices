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
	UsuarioDAO usuar;
	

	
	@RequestMapping(value= "/user/{email}", method = RequestMethod.GET)
	public @ResponseBody Usuario getUsersByEmail (@PathVariable @Validated String email){
		return usuar.findByEmail(email);
	}
	
	
	@RequestMapping(value= "/users",method = RequestMethod.GET)
	public @ResponseBody List<Usuario> getUsers(){
		return usuar.findAll();
	}
	
	@RequestMapping(value= "/users/{role}", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> getUsersByRole (@PathVariable @Validated String role){
		return usuar.findByRole(role);
	}
	


	@RequestMapping(method = RequestMethod.POST, value="/users")
	public @ResponseBody Usuario saveUser(@RequestBody @Validated Usuario puser) {
		return usuar.save(puser);
	}



	@RequestMapping("/users/{email}/{password}")
	public @ResponseBody Usuario getUserByEmailAndSurname(@PathVariable String email,
											  @PathVariable String password){
		return usuar.findByEmailAndPassword(email, password);
	}


	@RequestMapping(method = RequestMethod.PUT, value="/users/{id}")
	public @ResponseBody Usuario updateUser(@PathVariable @Validated String id, @RequestBody Usuario pUser) {

		Usuario us = usuar.findById(id).orElse(null);
		us.setName(pUser.getName());
		us.setSurname(pUser.getSurname());
		us.setAddress(pUser.getAddress());
		us.setEmail(pUser.getEmail());
		us.setPassword(pUser.getPassword());
		return usuar.save(us);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/users/{id}")
	public @ResponseBody void deleteUser(@PathVariable @Validated String id) {
		Usuario us = usuar.findById(id).orElse(null);
		if (us != null) {
			usuar.delete(us);
		}
	}








	public MyController() {
	}

}
