package es.uc3m.tiw;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.uc3m.tiw.domains.*;



@Controller
@CrossOrigin
public class MyController {

	@Autowired
	PaymentDAO paym;
	@Autowired
	PurchaseDAO purch;

	@RequestMapping(method = RequestMethod.POST, value="/payments")
	public @ResponseBody Payment savePayment(@RequestBody @Validated Payment pay) {
		return paym.save(pay);
	}

	@RequestMapping(method = RequestMethod.POST, value="/purchases")
	public @ResponseBody Purchase savePurchase(@RequestBody @Validated Purchase purc) {

		return purch.save(purc);
	}

	@RequestMapping(value= "/payments",method = RequestMethod.GET)
	public @ResponseBody List<Payment> getPayments(){
		return paym.findAll();
	}

	@RequestMapping(value= "/purchases",method = RequestMethod.GET)
	public @ResponseBody List<Purchase> getPurchases(){
		return purch.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value="/payments/{id}")
	public @ResponseBody Payment findByCard(@PathVariable @Validated String id) {
		Payment us = paym.findById(id).orElse(null);
			return us;
	}

	@RequestMapping(method = RequestMethod.GET, value="/purchases/{email}")
	public @ResponseBody List<Purchase> findByEmail(@PathVariable @Validated String email) {
			return purch.findByPerson(email);
	}

	@RequestMapping(method = RequestMethod.POST, value="/CardValidation")
	public @ResponseBody ResponseEntity<Integer> CardValidation(@RequestBody @Validated Payment pa) {

				String card = pa.getCard();
				String cv2 = pa.getCv2();
				String date = pa.getDate();


				int divides = (int)Long.parseLong(card) % 4;
				Date now = new Date();
			 	SimpleDateFormat simpleDateformatm = new SimpleDateFormat("MM");
				int month = Integer.parseInt(simpleDateformatm.format(now));
				SimpleDateFormat simpleDateformaty = new SimpleDateFormat("YY");
				int year = Integer.parseInt(simpleDateformaty.format(now));
				int expMonth = Integer.parseInt(date.substring(0,2));
				int expYear = Integer.parseInt(date.substring(3,5));
				int okDate = 0;

				if(expYear >= year){
					if(expYear == year){
						if(expMonth >= month){
							okDate = 1;
						}
					}
					else{
						okDate = 1;
					}
				}

				boolean valid = false;
				if(card.matches("\\d{16}") && cv2.matches("\\d{3}") && (divides==0) && (okDate == 1)){
					valid = true;
				}
				if(valid){
					Random random = new Random();
					int paymentid =random.nextInt(1000000001);//generate random payment id
					Integer intobject= new Integer(paymentid);
					return new ResponseEntity<>(intobject, HttpStatus.OK);//ok error code
				}
				else{
					return new ResponseEntity<>(HttpStatus.PAYMENT_REQUIRED);//402 error code
				}
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/payments/{id}")
	public @ResponseBody void deletePayment(@PathVariable @Validated String id) {
		Payment us = paym.findById(id).orElse(null);
		if (us != null) {
			paym.delete(us);
		}
	}





	public MyController() {
	}

}
