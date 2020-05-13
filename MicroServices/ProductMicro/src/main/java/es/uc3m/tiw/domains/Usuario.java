package es.uc3m.tiw.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;
	
	@Id
	private String email;

	private String name;

	private String password;

	private String role;

	private String surname;


//
	//bi-directional many-to-one association to Product
//	@OneToMany(mappedBy="usuarios")
//	private List<Product> products1;
//
//	//bi-directional many-to-one association to Purchase
//	@OneToMany(mappedBy="usuario")
//	private List<Purchase> purchases;
//
//	//bi-directional many-to-one association to ShoppingCart
//	@OneToMany(mappedBy="usuario")
//	private List<ShoppingCart> shoppingCarts;

//	//bi-directional many-to-many association to Product
//	@ManyToMany
//	@JoinTable(
//		name="wishlist"
//		, joinColumns={
//			@JoinColumn(name="person")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="product")
//			}
//		)
//	private List<Product> products2;
//
//	//bi-directional many-to-one association to Wishlist
//	@OneToMany
//	@JoinColumn(name="wishlist")
//	private List<Wishlist> wishlists;

	public Usuario() {
	}

//	public int getIdusers() {
//		return this.idusers;
//	}
//
//	public void setIdusers(int idusers) {
//		this.idusers = idusers;
//	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


//	public List<Product> getProducts1() {
//		return this.products1;
//	}
//
//	public void setProducts1(List<Product> products1) {
//		this.products1 = products1;
//	}

//	public Product addProducts1(Product products1) {
//		getProducts1().add(products1);
//		products1.setUsuario(this);
//
//		return products1;
//	}
//
//	public Product removeProducts1(Product products1) {
//		getProducts1().remove(products1);
//		products1.setUsuario(null);
//
//		return products1;
//	}

//	public List<Purchase> getPurchases() {
//		return this.purchases;
//	}
//
//	public void setPurchases(List<Purchase> purchases) {
//		this.purchases = purchases;
//	}

//	public Purchase addPurchas(Purchase purchas) {
//		getPurchases().add(purchas);
//		purchas.setUsuario(this);
//
//		return purchas;
//	}
//
//	public Purchase removePurchas(Purchase purchas) {
//		getPurchases().remove(purchas);
//		purchas.setUsuario(null);
//
//		return purchas;
//	}

//	public List<ShoppingCart> getShoppingCarts() {
//		return this.shoppingCarts;
//	}
//
//	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
//		this.shoppingCarts = shoppingCarts;
//	}

//	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
//		getShoppingCarts().add(shoppingCart);
//		shoppingCart.setUsuario(this);
//
//		return shoppingCart;
//	}
//
//	public ShoppingCart removeShoppingCart(ShoppingCart shoppingCart) {
//		getShoppingCarts().remove(shoppingCart);
//		shoppingCart.setUsuario(null);
//
//		return shoppingCart;
//	}

//	public List<Product> getProducts2() {
//		return this.products2;
//	}
//
//	public void setProducts2(List<Product> products2) {
//		this.products2 = products2;
//	}
//
//	public List<Wishlist> getWishlists() {
//		return this.wishlists;
//	}
//
//	public void setWishlists(List<Wishlist> wishlists) {
//		this.wishlists = wishlists;
//	}

//	public Wishlist addWishlist(Wishlist wishlist) {
//		getWishlists().add(wishlist);
//		wishlist.setUsuario(this);
//
//		return wishlist;
//	}
//
//	public Wishlist removeWishlist(Wishlist wishlist) {
//		getWishlists().remove(wishlist);
//		wishlist.setUsuario(null);
//
//		return wishlist;
//	}

}