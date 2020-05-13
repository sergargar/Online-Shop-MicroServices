package es.uc3m.tiw.domains;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WISHLIST database table.
 *
 */
@Entity
@Table(name="wishlist")
@NamedQuery(name="Wishlist.findAll", query="SELECT w FROM Wishlist w")
public class Wishlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String person;

	private String product;

	public Wishlist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

}
