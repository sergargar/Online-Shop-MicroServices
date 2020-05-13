package es.uc3m.tiw.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	private String name;
	
	@Column(name="brand")
	private String brand;

	@Column(name="longdesc")
	private String longdesc;
	
	@Column(name="os")
	private String os;
	
	@Column(name="price")
	private Float price;

	@Column(name="shortdesc")
	private String shortdesc;
	
	@Column(name="size")
	private Float size;
	
	@Column(name="storage")
	private Integer storage;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idseller")
//	@Column(name="idseller")
	private Usuario idseller;

//	//bi-directional many-to-one association to ShoppingCart
//	@OneToMany(mappedBy="productBean")
//	private List<ShoppingCart> shoppingCarts;
//
//	//bi-directional many-to-many association to Usuario
//	@ManyToMany(mappedBy="products2")
//	private List<Usuario> usuarios;

	public Product() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLongdesc() {
		return this.longdesc;
	}

	public void setLongdesc(String longdesc) {
		this.longdesc = longdesc;
	}

	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getShortdesc() {
		return this.shortdesc;
	}

	public void setShortdesc(String shortdesc) {
		this.shortdesc = shortdesc;
	}

	public float getSize() {
		return this.size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public int getStorage() {
		return this.storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

//	public String getIdsellerName() {
//		return this.idseller.getEmail();
//	}
	
	public Usuario getIdseller() {
		return this.idseller;
	}

	public void setIdseller(Usuario idseller) {
		this.idseller = idseller;
	}

//	public List<ShoppingCart> getShoppingCarts() {
//		return this.shoppingCarts;
//	}
//
//	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
//		this.shoppingCarts = shoppingCarts;
//	}
//
//	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
//		getShoppingCarts().add(shoppingCart);
//		shoppingCart.setProductBean(this);
//
//		return shoppingCart;
//	}
//
//	public ShoppingCart removeShoppingCart(ShoppingCart shoppingCart) {
//		getShoppingCarts().remove(shoppingCart);
//		shoppingCart.setProductBean(null);
//
//		return shoppingCart;
//	}
//
//	public List<Usuario> getUsuarios() {
//		return this.usuarios;
//	}
//
//	public void setUsuarios(List<Usuario> usuarios) {
//		this.usuarios = usuarios;
//	}

}