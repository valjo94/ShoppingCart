public class Product extends Item {
	double price;
	String producer;
	String productionDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Product(String name, String description, double price, String producer,
			String productionDate) {
		super(name, description);
		this.price = price;
		this.producer = producer;
		this.productionDate = productionDate;
	}

	@Override
	public void printItem() {
		System.out.print("[ Name: " + name + ", Description: " + description
				+ ", Price: " + price + ", Production date: " + productionDate
				+ "]");

	}

}
