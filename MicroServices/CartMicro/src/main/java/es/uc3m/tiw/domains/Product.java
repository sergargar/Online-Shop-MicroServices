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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String name;
	
	@Column(name="brand")
	private String brand;

	@Column(name="long_desc")
	private String longDesc;
	
	@Column(name="os")
	private String os;
	
	@Column(name="price")
	private float price;

	@Column(name="short_desc")
	private String shortDesc;
	
	@Column(name="size")
	private float size;
	
	@Column(name="storage")
	private int storage;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_seller")
	private Usuario usuario;

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

	public String getLongDesc() {
		return this.longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
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

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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