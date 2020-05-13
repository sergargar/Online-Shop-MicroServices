package es.uc3m.tiw.domains;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="payment")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	String card;
	String cv2;
	String date;
	int price;

	public Payment() {

	}

	public Payment(String card, String cv2, String date, int price) {
		this.card = card;
		this.cv2 = cv2;
		this.date = date;
		this.price = price;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCv2() {
		return cv2;
	}

	public void setCv2(String cv2) {
		this.cv2 = cv2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
