package es.uc3m.tiw.domains;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PURCHASE database table.
 *
 */
@Entity
@Table(name="purchase")
@NamedQuery(name="Purchase.findAll", query="SELECT pu FROM Purchase pu")
public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpurchase;

	private String date;

	private int id;

	private String payment;

	private String person;

	private String product;

	private int total;

	public Purchase() {
	}

	public int getIdpurchase() {
		return this.idpurchase;
	}

	public void setIdpurchase(int idpurchase) {
		this.idpurchase = idpurchase;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}


	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
