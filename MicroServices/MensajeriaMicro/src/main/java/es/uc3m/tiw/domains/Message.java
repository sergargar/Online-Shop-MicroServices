package es.uc3m.tiw.domains;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@Table(name="message")
//@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmessage;


////	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="sender")
//	@Column(name="sender")
	private Usuario sender;

//	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="receiver")
//	@Column(name="receiver")
	private Usuario receiver;
	
	@Column(name="texto")
	private String texto;
	
	public Message() {
	}

	public int getIdmessage() {
		return this.idmessage;
	}

	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getSender() {
		return sender;
	}

	public void setSender(Usuario sender) {
		this.sender = sender;
	}

	public Usuario getReceiver() {
		return receiver;
	}

	public void setReceiver(Usuario receiver) {
		this.receiver = receiver;
	}


}