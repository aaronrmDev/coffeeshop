package sysco.coffeeshop.products;

public class Product {

	private String image;
	private double price;
	private String description;
	private String id;
	private String name;
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n[image=" + image + ", +"
				+ "\nprice=" + price
				+ ", \ndescription=" + description + ", "
				+ "\nid=" + id + ", "
				+ "\nname=" + name + "]\n\n";
	}

	public Product(String name, double price, String image) {
		this.id = "";
		this.image = image;
		this.price = price;
		this.name = name;
	}

	public Product(String id, String name, double price, String image) {
		this.id = id;
		this.image = image;
		this.price = price;
		this.name = name;
	}

	public Product(String image, double price, String description, String id, String name) {
		this.image = image;
		this.price = price;
		this.description = description;
		this.id = id;
		this.name = name;
	}
	
	

}
