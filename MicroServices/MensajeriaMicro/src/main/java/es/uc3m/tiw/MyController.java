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
	
	@Autowired
	MessageDAO mess;
	
	
	@RequestMapping(method = RequestMethod.POST, value="/messages")
	public @ResponseBody Message saveMessageSeller(@RequestBody @Validated Message pmsg) {

		return mess.save(pmsg);
	}
	
	@RequestMapping(value= "/messages/{receiver}", method = RequestMethod.GET)
	public @ResponseBody List<Message> getMessagesByReceiver (@PathVariable @Validated String receiver){
		Usuario aux = usuar.findByEmail(receiver);
		return mess.findByReceiver(aux);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/messagesrec/{receiver}")
	public @ResponseBody Message saveMessageClient(@PathVariable String receiver, @RequestBody @Validated Message pmessage) {

		Usuario us = usuar.findByEmail(receiver);
		pmessage.setReceiver(us);
		return mess.save(pmessage);
	}
	
	@RequestMapping(value= "/users",method = RequestMethod.GET)
	public @ResponseBody List<Usuario> getUsers(){
		return usuar.findAll();
	}
	

	
	
	
	public MyController() {
	}

}
